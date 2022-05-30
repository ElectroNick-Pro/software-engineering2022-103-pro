package com.group2022103.flightkiosk.page;

import javax.swing.*;

public class TestFrm extends PageFrm{
	public TestFrm(){
		super();
		setTitleName("Retrieve");
		setHintName("hhh111");
		setBackButton();
		setNextButton();
		setBackgroundImage(new ImageIcon(ClassLoader.getSystemResource("image/background0.png")));
	}
	
	public void setBackAction() {
		System.out.println("back");
	}
	
	public void setNextAction() {
		System.out.println("next");
	}
}
