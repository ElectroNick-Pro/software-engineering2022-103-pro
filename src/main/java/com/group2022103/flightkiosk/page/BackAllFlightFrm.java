package com.group2022103.flightkiosk.page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.group2022103.flightkiosk.component.*;
import com.group2022103.flightkiosk.view.FlightInfoView;

public class BackAllFlightFrm extends JFrame{
	private static final int DEFAULT_WIDTH = 965;
    private static final int DEFAULT_HEIGHT = 550;
    private int NUM = 3;
    private JPanel contentPane;
    private JPanel buttonPane;
	public BackAllFlightFrm() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        contentPane = new JPanel() {{
        	setLayout(null);
        	setBackground(Color.white);
        }};
        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTextField textField=new JTextField() {{
        	ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("image/search .png"));// background picture
    		image.setImage(image.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));// setSize
    		JLabel picture=new JLabel(image);
    		picture.setBounds(480,0,45,45);
    		add(picture);
    		setBorder(new RoundBorderUI(Color.gray)); 
    		setBounds(43,28,530,40);
        }}; 
        textField.addFocusListener(new JTextFieldHintListener(textField,"      Search FlightNo......."));
        add(textField);
        
        add(new JLabel("FlightNo") {{
        	setFont(new Font("Microsoft YaHei UI",Font.PLAIN,16));
        	setForeground(Color.GRAY);
        	setBounds(55,80,100,56);
        }});
        add(new JLabel("Departure Place") {{
        	setFont(new Font("Microsoft YaHei UI",Font.PLAIN,16));
        	setForeground(Color.GRAY);
        	setBounds(223,80,200,56);
        }});
        add(new JLabel("Destination") {{
        	setFont(new Font("Microsoft YaHei UI",Font.PLAIN,16));
        	setForeground(Color.GRAY);
        	setBounds(503,80,150,56);
        }});
        add(new JLabel("Date") {{
        	setFont(new Font("Microsoft YaHei UI",Font.PLAIN,16));
        	setForeground(Color.GRAY);
        	setBounds(755,80,150,56);
        }});
        
        buttonPane = new JPanel() {{
        	setBackground(Color.white);
        	setBorder(new RoundBorderUI());
        	setLayout(new GridLayout(Math.max(NUM,5),1) {{
        		setVgap(10);
        	}});
        }};
        FlightBackButtonUI[] button = new FlightBackButtonUI[NUM];
        for(int i = 0; i < Math.max(NUM,5); i++) {
        	if(i < NUM) {
        		button[i] = new FlightBackButtonUI("BK1001","ShangHai-China","Beijing-China","2022-01-01") {{
    	        	buttonLayout();
    	        	setBounds(41,138,836,56);
    	        }};
                button[i].buttonLayout();
                button[i].setBorder(BorderFactory.createCompoundBorder(button[i].getBorder(), BorderFactory.createEmptyBorder(20, 20, 20, 20))); 
                buttonPane.add(button[i]);
        	}else{
            	buttonPane.add(new JPanel() {{
            		setPreferredSize(new Dimension(836, 56));
            		setBackground(Color.WHITE);
            	}});
            }
        }
        add(new JScrollPane(buttonPane) {{
        	setBackground(Color.white);
        	setBounds(41,138,850,300);
        	getVerticalScrollBar().setUI(new DemoScrollBarUI());
        }});
        
        add(new RoundButtonUI("Exit", new Color(0,131,255), new Color(0,105,206)) {{
			setForeground(Color.WHITE);
			setBounds(730,38,90,30);
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					setBackAction();
				}
			});
		}});
	}
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BackAllFlightFrm frame = new BackAllFlightFrm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
