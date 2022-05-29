package com.group2022103.flightkiosk.page;

import com.group2022103.flightkiosk.application.Application;
import com.group2022103.flightkiosk.component.*;
import com.group2022103.flightkiosk.exception.UnboundPageException;
import com.group2022103.flightkiosk.model.Customer;
import com.group2022103.flightkiosk.view.CustomerView;
import com.group2022103.flightkiosk.view.TicketView;
import com.group2022103.flightkiosk.vo.CustomerBack;
import com.group2022103.flightkiosk.vo.TicketBack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.file.Path;
import java.util.*;

public class RetrieveFrm extends PageFrm{
	private JPanel contentPane,panel1,panel2,panel3;
	private JTextField bookingIdField,surnameField,customerIdField;
	private Path path = Path.of("/Retrieve");
	private TicketView ticketView;
	private CustomerView customerView;
	public RetrieveFrm(){
		super();
		setTitleName("Retrieve");
		addExitButton();
		addHelpButton();
		setBackgroundImage(new ImageIcon(ClassLoader.getSystemResource("image/travel.png")));
		Application.context.getPageConfig().bindPage(this.path, this);
		Application.context.getContext().put("curPath",this.path);

		add(new BreadCrumbUI(path){{
			setBounds(80,25,800,25);
		}});
		
		add(new RoundButtonUI("Retrieve",new Color(0,131,255), new Color(0,105,206)){{
			setBounds(45,370,435,38);
			setForeground(Color.WHITE);
			addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    RetrieveAction();
                }
            });
		}});

		add(panel1 = new JPanel() {{
			setBounds(45,195,435,134);
			setLayout(null);
			setBackground(Color.WHITE);
			setVisible(true);
			add(new JLabel("Please enter your booking ID:") {{
				setFont(new Font("Microsoft YaHei UI",Font.LAYOUT_LEFT_TO_RIGHT,18));
				setBounds(0,0,435,70);
			}});
			add(bookingIdField = new JTextField() {{
				setBounds(1,95,435,38);
			}});
		}});
		
		add(panel2 = new JPanel() {{
			setBounds(45,150,435,193);
			setLayout(null);
			setBackground(Color.WHITE);
			setVisible(false);
			add(new JLabel("Please enter your surname:") {{
				setFont(new Font("Microsoft YaHei UI",Font.LAYOUT_LEFT_TO_RIGHT,18));
				setBounds(0,0,435,70);
			}});
			add(surnameField = new JTextField() {{
				setBounds(1,63,435,38);
			}});
			add(new JLabel("Please enter your ID number:") {{
				setFont(new Font("Microsoft YaHei UI",Font.LAYOUT_LEFT_TO_RIGHT,18));
				setBounds(0,90,435,70);
			}});
			add(customerIdField = new JTextField() {{
				setBounds(1,155,435,38);
			}});
		}});
		
		add(panel3 = new JPanel() {{
			setBounds(45,150,341,191);
			setLayout(null);
			setVisible(false);
			setBackground(Color.WHITE);
			add(new JLabel("Please scan your ID document:") {{
				setFont(new Font("Microsoft YaHei UI",Font.LAYOUT_LEFT_TO_RIGHT,18));
				setBounds(0,0,341,70);
			}});
			add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("image/scanIDcard.png")) {{
				setImage(this.getImage().getScaledInstance(276,126,Image.SCALE_DEFAULT));
			}}) {{
				setBackground(Color.WHITE);
				setBounds(65,65,276,126);
			}});
		}});
		
		add(new RoundButtonUI("Booking ID",Color.WHITE,new Color(226,226,226)) {{
			setForeground(Color.BLACK);
			setBorderColor(Color.BLACK);
			setARC(15);
			setFont(new Font("Microsoft YaHei UI",Font.PLAIN,15));
			setBounds(45,435,125,38);
			addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent event){
	                panel2.setVisible(false);
	                panel3.setVisible(false);
					panel1.setVisible(true);
	            }
	        });
		}});
		
		add(new RoundButtonUI("Surname and ID",Color.WHITE,new Color(226,226,226)) {{
			setForeground(Color.BLACK);
			setBorderColor(Color.BLACK);
			setARC(15);
			setFont(new Font("Microsoft YaHei UI",Font.PLAIN,15));
			setBounds(195,435,165,38);
			addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent event){
	                panel1.setVisible(false);
	                panel3.setVisible(false);
					panel2.setVisible(true);
	            }
	        });
		}});
		
		add(new RoundButtonUI("Scan ID",Color.WHITE,new Color(226,226,226)) {{
			setForeground(Color.BLACK);
			setBorderColor(Color.BLACK);
			setARC(15);
			setFont(new Font("Microsoft YaHei UI",Font.PLAIN,15));
			setBounds(385,435,95,38);
			addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent event){
	                panel2.setVisible(false);
	                panel1.setVisible(false);
					panel3.setVisible(true);
	            }
	        });
		}});
	}

	public void RetrieveAction(){
		String bookingID = bookingIdField.getText();
		String surname = surnameField.getText();
		String customerID = customerIdField.getText();
		if(panel1.isVisible()){
			if(bookingID.equals("")){
				JOptionPane.showMessageDialog(null, "Please enter your bookingID.", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				ticketView = new TicketView(new TicketBack(){{
					setBookingID(bookingID);
				}});
				if(ticketView.getTicketNumber() == 0){
					JOptionPane.showMessageDialog(null, "This bookingID does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					customerView = new CustomerView(new CustomerBack(){{
						setBookingID(bookingID);
					}});
					navigateTo(bookingID,customerView.getCustomer());
				}
			}
		}else if(panel2.isVisible()){
			if(surname.equals("") || (customerID.equals(""))){
				JOptionPane.showMessageDialog(null,"Please enter your surname and ID number.","Error",JOptionPane.ERROR_MESSAGE);
			}else{
				customerView = new CustomerView(new CustomerBack(){{
					setCustomerID(customerID);
				}});
				if(customerView.getCustomerFront() == null){
					JOptionPane.showMessageDialog(null, "The ID number you entered does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
				}else if(!surname.equals(customerView.getCustomer().getSurname())){
					JOptionPane.showMessageDialog(null, "Your surname and ID number does not match!", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					ticketView = new TicketView(new TicketBack(){{
						setDocumentID(customerID);
					}});
					if(ticketView.getTicketNumber() == 0){
						JOptionPane.showMessageDialog(null, "This bookingID does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
					}else{
						navigateTo(bookingID,customerView.getCustomer());
					}
				}
			}
		}else{
			customerView = new CustomerView(new CustomerBack(){{
				setCustomerID("123456789012345678");
			}});
			navigateTo(bookingID,customerView.getCustomer());
		}
	}

	public void navigateTo(String bookingID,Customer customer){
		bookingIdField.setText("");
		surnameField.setText("");
		customerIdField.setText("");
		Application.context.getContext().remove("bookingID");
		Application.context.getContext().remove("customer");
		Application.context.getContext().put("bookingID",bookingID);
		Application.context.getContext().put("customer",customer);

		try {
			new FlightInfoFrm();
			Application.context.getPageConfig().displayPage(path.resolve(Path.of("/Retrieve/Flight Information")));
		} catch (UnboundPageException e1) {
			e1.printStackTrace();
			return;
		}
	}

	public static void main(String args[]) {
		Application.run();
		RetrieveFrm f = new RetrieveFrm();
		f.setVisible(true);
	}
}
