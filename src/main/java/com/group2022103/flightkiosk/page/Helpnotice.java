package com.group2022103.flightkiosk.page;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import com.group2022103.flightkiosk.component.*;
import java.awt.event.ActionListener;

public class Helpnotice extends JFrame {
    private JPanel panel1 = new JPanel(null);
    private Box vBox = Box.createVerticalBox();
    private JScrollPane p = new JScrollPane(vBox);
    public  Helpnotice(){
        super();
        panel1 = new JPanel() {{
            setLayout(null);
            setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            setBackground(Color.WHITE);
        }};
        setContentPane(panel1);
    
        add(new JLabel("User Handbook"){{
            setFont(new Font(null, Font.PLAIN, 18));
            setBounds(26, 20, 436, 30);
        }});

        add(new RoundButtonUI("I have noticed",new Color(0,131,255), new Color(0,105,206)) {{
            setForeground(Color.WHITE);
            setBounds(25,520,180,30);
            setARC(15);
            setFont(new Font("Microsoft YaHei UI",Font.PLAIN,15));
            
            addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    dispose();
                }
            });
        }});

        add(new RoundButtonUI("Human Service",new Color(0,131,255), new Color(0,105,206)) {{
            setForeground(Color.WHITE);
            setBounds(300, 520, 160, 30);
            setBorderColor(new Color(30, 144, 255));
            setARC(15);
            setFont(new Font("Microsoft YaHei UI",Font.PLAIN,15));
            
            addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, "We have called human service for you, please wait for a moment.", "Hint", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
            });
        }});

        
        add(new JScrollPane(p, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER){{
            setBackground(Color.WHITE);
            setBounds(20, 50, 450, 450);
            getVerticalScrollBar().setUnitIncrement(10);
            vBox.add(new JLabel(){{
                ImageIcon n = new ImageIcon("src/main/resources/image/exit.png");
                n.setImage(n.getImage().getScaledInstance(30, 30, 1));
                setIcon(n);
                setText("To exit, please click this button");
                setFont(new Font(null, Font.PLAIN, 16));
                vBox.add(new Component(){{
                    Box.createVerticalStrut(1);}});
        
            }});

            String str31 = "?? After entering the system";
            String str32 = "Please choose the way you want to check in.";
            String   str3 = "<html><body>"+str31+"<br>"+str32+"<body></html>";
            vBox.add(new JLabel(str3){{
                setFont(new Font(null, Font.PLAIN, 16));
                vBox.add(new Component(){{
                    Box.createVerticalStrut(1);
                }});
            }}); 

            String str41 = " ?? If you want to scan the idcard, you should ";
            String str42 = "put it in the scanning area and the  click 'retrive'";
            String str4 = "<html><body>" + str41 + "<br>" + str42 + "<body></html>";
                
            vBox.add(new JLabel(str4){{
                    setFont(new Font(null, Font.PLAIN, 16));
                    vBox.add(new Component(){{
                        Box.createVerticalStrut(1);
                    }});
            }});
            
            vBox.add(new JLabel(){{
                setText(" ?? You could choose your seat and food in this system");
                setFont(new Font(null, Font.PLAIN, 16));
                vBox.add(new Component(){{
                    Box.createVerticalStrut(1);
                }});
        
            }});

            String str61 = "?? Pictures of the food are just symbol of their type  ";
            String str62 = "but not indicate what acturaly include.";
            String str6 = "<html><body>" + str61 + "<br>" + str62 + "<body></html>";

            vBox.add(new JLabel(str6){{
                setFont(new Font(null, Font.PLAIN, 16));
                vBox.add(new Component(){{
                    Box.createVerticalStrut(1);
                }});
            }});

            vBox.add(new JLabel(){{
                setText(" ?? You need to pay for extra bill after total choices");
                setFont(new Font(null, Font.PLAIN, 16));
                vBox.add(new Component(){{
                    Box.createVerticalStrut(10);
                }});
        
            }});

            String str81 = " ?? Don't forget to print your tickets in the end";
            String str82 = "These three tickets are important for you!";
            String str8 = "<html><body>" + str81 + "<br>" + str82 + "<body></html>";

            vBox.add(new JLabel(str8){{
                setFont(new Font(null, Font.PLAIN, 16));
                setForeground(Color.red);
                vBox.add(new Component(){{
                    Box.createVerticalStrut(1);
                }});
            }});

            String str91 = " ?? Attention!";
            String str92 = "Once you confirm and pay, money would never return!";
            String str9 = "<html><body>" + str91 + "<br>" + str92 + "<body></html>";

            vBox.add(new JLabel(str9){{
                setFont(new Font(null, Font.PLAIN, 16));
                setForeground(Color.red);
                vBox.add(new Component(){{
                    Box.createVerticalStrut(1);
                }});
            }});

            vBox.add(new JLabel(){{
                setText("After checking in, please exit the system for safety");
                setFont(new Font(null, Font.PLAIN, 16));
                vBox.add(new Component(){{
                    Box.createVerticalStrut(1);
                }});
        
            }});


            vBox.add(new JLabel(){{
                setText(" ?? The first ticket in the scroll panel is the recent one.");
                setFont(new Font(null, Font.PLAIN, 16));
                vBox.add(vBox.add(new Component(){{
                    Box.createVerticalStrut(1);
                }}));
        
            }});

            vBox.add(new JLabel(){{
                setText("Each button can straightly jump to that page");
                setFont(new Font(null, Font.PLAIN, 16));
                vBox.add(vBox.add(new Component(){{
                    Box.createVerticalStrut(1);
                }}));
        
            }});
        }});
    }
}