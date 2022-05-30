package com.group2022103.flightkiosk.page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.component.*;
import com.group2022103.flightkiosk.exception.UnboundPageException;
import com.group2022103.flightkiosk.view.FlightInfosView;
import com.group2022103.flightkiosk.view.FlightView;
import com.group2022103.flightkiosk.view.IntervalView;
import com.group2022103.flightkiosk.vo.FlightBack;
import com.group2022103.flightkiosk.vo.FlightInfosBack;
import com.group2022103.flightkiosk.vo.IntervalBack;

public class BackAllFlightFrm extends JFrame{
	private static final int DEFAULT_WIDTH = 965;
    private static final int DEFAULT_HEIGHT = 550;
    private JPanel contentPane;
    private JPanel buttonPane;
	private IntervalView intervalView = new IntervalView(new IntervalBack());
	private FlightView flightView = new FlightView(new FlightBack());
	private int NUM = flightView.getFlights().size();

	public BackAllFlightFrm() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        contentPane = new JPanel() {{
        	setLayout(null);
        	setBackground(Color.white);
        }};
        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        add(new JLabel("All Fights:") {{
        	setFont(new Font("Microsoft YaHei UI",Font.BOLD,25));
        	setBounds(43,28,530,40);
        }});
        
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
		int i = 0;
		for(var e: flightView.getFlights().entrySet()) {
			var intervals = intervalView.getAllIntervals().get(e.getKey());
			button[i] = new FlightBackButtonUI(e.getValue().getFlightNo(),intervals.get(0).getDepartureCity(),intervals.get(intervals.size() - 1).getDestCity(),Application.context.getAppConfig().getTimezone().format(intervals.get(0).getDepartureTime())) {{
				buttonLayout();
				setBounds(41,138,836,56);
			}};
			var id = e.getKey();
			button[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					var frame = new FlightListFrm(new FlightInfosView(new FlightInfosBack(){{setFlightId(id);}}));
        			frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				}
			});
			button[i].buttonLayout();
			button[i].setBorder(BorderFactory.createCompoundBorder(button[i].getBorder(), BorderFactory.createEmptyBorder(20, 20, 20, 20))); 
			buttonPane.add(button[i]);
			i++;
		}
		for(; i < (NUM > 5 ? NUM : 5); i++) {
			buttonPane.add(new JPanel() {{
				setPreferredSize(new Dimension(836, 56));
				setBackground(Color.WHITE);
			}});
		}
		i = 0;
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
					try {
						dispose();
						new WelcomeFrm();
						Application.context.getPageConfig().displayPage((Path.of("Welcome")));
					} catch (UnboundPageException e1) {
						e1.printStackTrace();
						return;
					}
				}
			});
		}});
	}
}
