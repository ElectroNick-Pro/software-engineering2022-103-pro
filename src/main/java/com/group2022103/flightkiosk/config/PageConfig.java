package com.group2022103.flightkiosk.config;

import java.nio.file.Path;
import java.util.*;

import javax.swing.JFrame;

import com.group2022103.flightkiosk.exception.UnboundPageException;
import com.group2022103.flightkiosk.page.WelcomeFrm;


public class PageConfig {

    private List<Path> pagePathStack = new ArrayList<>();
    private Path curPagePath = null;
    private Map<Path, JFrame> pagePathMap = new HashMap<>();

    public void bindPage(Path path, JFrame page) {
        pagePathMap.put(path, page);
    }

    public void displayPage(Path path) throws UnboundPageException {
        if(pagePathMap.getOrDefault(path, null) == null) {
            throw new UnboundPageException();
        }
        if(!pagePathStack.contains(path)) {
            pagePathStack.add(path);
        }
        if(curPagePath != null) {
            var page = pagePathMap.get(curPagePath);
            page.dispose();
        }
        curPagePath = path;
        pagePathMap.get(curPagePath).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pagePathMap.get(curPagePath).setLocationRelativeTo(null); 
        pagePathMap.get(curPagePath).setResizable(false);
        pagePathMap.get(curPagePath).setVisible(true);
    }

    public void goBack() throws UnboundPageException {
        int idx = pagePathStack.indexOf(curPagePath);
        if(idx <= 0) {
            return;
        }
        displayPage(pagePathStack.get(idx - 1));
    }

    public PageConfig() {
        try {
            pagePathMap.put(Path.of("Welcome"), new WelcomeFrm());
            displayPage(Path.of("Welcome"));
        } catch (UnboundPageException e) {
            e.printStackTrace();
        }
    }

}
