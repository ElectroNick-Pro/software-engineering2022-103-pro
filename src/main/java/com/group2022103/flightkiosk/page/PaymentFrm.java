package com.group2022103.flightkiosk.page;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.component.*;
import com.group2022103.flightkiosk.exception.UnboundPageException;
import com.group2022103.flightkiosk.model.FoodPurchase;
import com.group2022103.flightkiosk.model.Seat;
import com.group2022103.flightkiosk.view.*;
import com.group2022103.flightkiosk.vo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;
import java.util.List;

public class PaymentFrm extends JFrame{
    private JPanel contentPane;
    private JPanel panel1,panel2;
    private JTextField creditId;
    private JPasswordField password;
    private List<FoodPurchase> allFoodPurchases;
    private ConfirmPayView confirmPayView = new ConfirmPayView();
    public PaymentFrm(){
    	allFoodPurchases = confirmPayView.getAllFoodPurchases();
        contentPane = new JPanel() {{
			setLayout(null);
			setBackground(Color.WHITE);
		}};
		setContentPane(contentPane);
        setSize(520, 400);
        setResizable(false);
        setTitle("Payment");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new JLabel("Pay your budget"){{
            setBounds(35, 10, 350, 50);
            setFont(new Font("Microsoft YaHei", Font.BOLD, 25));
        }});

        add(new JLabel("You can click the buttons to change the way of payment."){{
            setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
            setBounds(35, 50, 450, 40);
        }});

        add(panel1 = new JPanel(){{
            setBackground(Color.WHITE);
            setLayout(null);
            setBounds(35, 100, 455, 200);
            setVisible(true);
            add(new JLabel("Please enter your credit card number:"){{
                setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
                setBounds(0, 10, 420, 35);
            }});
            add(new JLabel("Please enter your password:"){{
                setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
                setBounds(0, 105, 420, 35);
            }});
            add(creditId = new JTextField(10){{
                setBounds(0, 55, 420, 35);
                setBorder(BorderFactory.createLineBorder(new Color(0, 131, 255)));
            }});
            add(password = new JPasswordField(10){{
                setBounds(0, 140, 420, 35);
                setBorder(BorderFactory.createLineBorder(new Color(0, 131, 255)));
            }});
        }});

        add(panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10)){{
            setBackground(Color.WHITE);
            setVisible(false);
            setBounds(5, 100, 500, 180);setBounds(5, 100, 500, 180);
            add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("image/code.png")){{
                setImage(this.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
            }}));
        }});

        add(new RoundButtonUI("QR code", Color.WHITE, new Color(226, 226, 226)){{
            setForeground(Color.BLACK);
            setBorderColor(Color.BLACK);
            setARC(15);
            setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
            setBounds(205, 300, 100, 30);
            addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    panel1.setVisible(false);
                    panel2.setVisible(true);
                }
            });
        }});

        add(new RoundButtonUI("credit card", Color.WHITE, new Color(226, 226, 226)){{
            setForeground(Color.BLACK);
            setBorderColor(Color.BLACK);
            setARC(15);
            setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
            setBounds(35, 300, 115, 30);
            addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    panel2.setVisible(false);
                    panel1.setVisible(true);
                }
            });
        }});

        add(new RoundButtonUI("OK", new Color(0, 131, 255), new Color(0, 105, 206)){{
            setForeground(Color.WHITE);
            setBounds(355, 300, 100, 30);
            addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    OKAction();
                }
            });
        }});
    }

    public void OKAction(){
        if(panel2.isVisible()){
            dispose();
            try {
                new CheckInFrm();
                Application.context.getPageConfig().displayPage(Path.of("/Retrieve/Flight Information/Choose Seat/Choose Food/Extra Food/Confirm and Pay/Check in"));
            } catch (UnboundPageException e1) {
                e1.printStackTrace();
            }
        }else{
            new CustomerView(new CustomerBack(){{
                String customerID = ((FlightInfoView)Application.context.getContext().get("flightInfo")).getUserID();
                setCustomerID(customerID);
            }}){{
                if(isValid(creditId.getText(),password.getText())){
                    dispose();
                    try {
                        new CheckInFrm();
                        Application.context.getPageConfig().displayPage(Path.of("/Retrieve/Flight Information/Choose Seat/Choose Food/Extra Food/Confirm and Pay/Check in"));
                    } catch (UnboundPageException e1) {
                        e1.printStackTrace();
                    }
                }else{
                    creditId.setText("");
                    password.setText("");
                    creditId.setBorder(BorderFactory.createLineBorder(new Color(226,37,37)));
                    password.setBorder(BorderFactory.createLineBorder(new Color(226,37,37)));
                }
            }};
        }
    }
    public static void main(String[] args){
        PaymentFrm f = new PaymentFrm();
        f.setTitle("Check-In Kiosk");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
	    f.setSize(520,400);
		f.setVisible(true);
    }
}
