import java.awt.*;
import javax.swing.*;

public class Order_System 
{
    double price = 0, total = 0;
	final double vat = 0.12;
	int quantity = 0;

    public Order_System() 
    {
        JFrame frame = new JFrame("Lab Exercise 4");
    	frame.setSize(400, 600);
		frame.setLocationRelativeTo(null);
		//frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	
		JPanel main_panel = new JPanel(new BorderLayout());
		
		JPanel north_panel = new JPanel();
		
		JLabel title = new JLabel("SCHOOL COMBO MEALS MENU", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));  
        title.setForeground(Color.WHITE);
        north_panel.add(title);
		north_panel.setBackground(Color.DARK_GRAY);
        
        JPanel south_panel = new JPanel();
                
        JButton Exit = new JButton("EXIT");
        Exit.setPreferredSize(new Dimension(100,50));
		Exit.setFont(new Font("Arial", Font.BOLD, 18));
        south_panel.add(Exit, BorderLayout.SOUTH);
        south_panel.setBackground(Color.DARK_GRAY);
        //south_panel.setBackground(Color.lightGray);
        Exit.setBackground(Color.orange);
        
        JPanel cntr_panel = new JPanel();
        cntr_panel.setLayout(new GridLayout(2,2,15,15));
        cntr_panel.setBorder(BorderFactory.createEmptyBorder(15,20,15,20));
        cntr_panel.setBackground(Color.DARK_GRAY);
        
        JPanel combo1_panel = new JPanel();
        JPanel combo2_panel = new JPanel();
        JPanel combo3_panel = new JPanel();
        JPanel combo4_panel = new JPanel();
        
        combo1_panel.setBackground(Color.DARK_GRAY);
        combo2_panel.setBackground(Color.DARK_GRAY);
        combo3_panel.setBackground(Color.DARK_GRAY);
        combo4_panel.setBackground(Color.DARK_GRAY);
        
        combo1_panel.setLayout(new BorderLayout());
        combo2_panel.setLayout(new BorderLayout());
        combo3_panel.setLayout(new BorderLayout());
        combo4_panel.setLayout(new BorderLayout());
        
        ImageIcon combo1_image = new ImageIcon("Images/combo1.png");
        ImageIcon combo2_image = new ImageIcon("Images/combo2.png");
        ImageIcon combo3_image = new ImageIcon("Images/combo3.png");
        ImageIcon combo4_image = new ImageIcon("Images/combo4.png");
        
        Image resized_combo1_image = combo1_image.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
        Image resized_combo2_image = combo2_image.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
        Image resized_combo3_image = combo3_image.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
        Image resized_combo4_image = combo4_image.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
        
        ImageIcon last_combo1_image = new ImageIcon(resized_combo1_image);
        ImageIcon last_combo2_image = new ImageIcon(resized_combo2_image);
        ImageIcon last_combo3_image = new ImageIcon(resized_combo3_image);
        ImageIcon last_combo4_image = new ImageIcon(resized_combo4_image);
                
        JLabel combo1_label = new JLabel("COMBO 1",JLabel.CENTER);
        JLabel combo1_menu = new JLabel("<html>Burger + Water<br>Php 35<html>");
        combo1_label.setForeground(Color.YELLOW);
        combo1_menu.setForeground(Color.WHITE);
        
        JLabel combo2_label = new JLabel("COMBO 2",JLabel.CENTER);
        JLabel combo2_menu = new JLabel("<html>Hotdog + Rice + Water<br>Php 30<html>");
        combo2_label.setForeground(Color.YELLOW);
        combo2_menu.setForeground(Color.WHITE);
        
        JLabel combo3_label = new JLabel("COMBO 3",JLabel.CENTER);
        JLabel combo3_menu = new JLabel("<html>Pastil + Rice + Water<br>Php 55");
        combo3_label.setForeground(Color.YELLOW);
        combo3_menu.setForeground(Color.WHITE);
        
        JLabel combo4_label = new JLabel("COMBO 4",JLabel.CENTER);
        JLabel combo4_menu = new JLabel("<html>Fried chicken + Rice + Water<br>Php 55<html>"); 
        combo4_label.setForeground(Color.YELLOW);
        combo4_menu.setForeground(Color.WHITE);
        
        cntr_panel.add(combo1_panel);
        cntr_panel.add(combo2_panel);
        cntr_panel.add(combo3_panel);
        cntr_panel.add(combo4_panel);
        
        JButton combo1_button = new JButton(last_combo1_image);
        combo1_panel.add(combo1_label, BorderLayout.NORTH); 
        combo1_panel.add(combo1_menu, BorderLayout.SOUTH);
        combo1_panel.add(combo1_button, BorderLayout.CENTER);
        
        combo1_button.addActionListener(e -> 
        {
        	price = 35;
        	String quantity_input = JOptionPane.showInputDialog("Enter Quantity : ");
            if(quantity_input == null) return; 
            
            try 
            {
                   int quantity = Integer.parseInt(quantity_input);
                    total += price * quantity;                      
                    int orderMore = JOptionPane.showConfirmDialog(frame, "Do you want to order more?", "Continue", JOptionPane.YES_NO_OPTION);
                    if(orderMore == JOptionPane.NO_OPTION) 
                    {
                        double vatable = total / (1 + vat);
                        double vatAmount = total - vatable;
                        double vatableRounded = Math.round(vatable * 100.0) / 100.0;
                        double vatRounded = Math.round(vatAmount * 100.0) / 100.0;
                        String message = "Total Bill: " + total + "\nVATable Amount: " + vatableRounded + "\nVAT (12%): " + vatRounded + "\n\nEnter Payment:";
                        String paymentInput = JOptionPane.showInputDialog(message);
                        if(paymentInput == null) return;                        
                        double payment = Double.parseDouble(paymentInput);
                        if(payment < total) 
                        {
                            JOptionPane.showMessageDialog(frame, "Insufficient Payment!");
                        } 
                        else 
                        {
                            double change = payment - total;
                            double changeRounded = Math.round(change * 100.0) / 100.0;
                            JOptionPane.showMessageDialog(frame, "Payment Successful!\nThank you for order!\nChange: " + changeRounded);
                            total = 0;
                        }
                    }
            } 
            catch(NumberFormatException ex) 
            {
            	JOptionPane.showMessageDialog(frame, "Numbers only!", "ERROR", JOptionPane.INFORMATION_MESSAGE);        
            }     	
        });     
        JButton combo2_button = new JButton(last_combo2_image);
        combo2_panel.add(combo2_label, BorderLayout.NORTH);
        combo2_panel.add(combo2_menu, BorderLayout.SOUTH);
        combo2_panel.add(combo2_button, BorderLayout.CENTER);      
        combo2_button.addActionListener(e -> 
        {
        	price = 30;
        	String quantity_input = JOptionPane.showInputDialog("Enter Quantity : ");
            if(quantity_input == null) return; 
            
            try 
            {
                   int quantity = Integer.parseInt(quantity_input);
                    total += price * quantity;
                       
                    int orderMore = JOptionPane.showConfirmDialog(frame, "Do you want to order more?", "Continue", JOptionPane.YES_NO_OPTION);

                    if(orderMore == JOptionPane.NO_OPTION) 
                    {
                        double vatable = total / (1 + vat);
                        double vatAmount = total - vatable;
                        double vatableRounded = Math.round(vatable * 100.0) / 100.0;
                        double vatRounded = Math.round(vatAmount * 100.0) / 100.0;
                        String message = "Total Bill: " + total + "\nVATable Amount: " + vatableRounded + "\nVAT (12%): " + vatRounded + "\n\nEnter Payment:";
                        String paymentInput = JOptionPane.showInputDialog(message);
                        if(paymentInput == null) return;                        
                        double payment = Double.parseDouble(paymentInput);
                        if(payment < total) 
                        {
                            JOptionPane.showMessageDialog(frame, "Insufficient Payment!");
                        } 
                        else 
                        {
                            double change = payment - total;
                            double changeRounded = Math.round(change * 100.0) / 100.0;
                            JOptionPane.showMessageDialog(frame, "Payment Successful!\nThank you for order!\nChange: " + changeRounded);
                            total = 0;
                        }
                    }
            } 
            catch(NumberFormatException ex) 
            {
            	JOptionPane.showMessageDialog(frame, "Numbers only!", "ERROR", JOptionPane.INFORMATION_MESSAGE);        
            }     	
        });    
        JButton combo3_button = new JButton(last_combo3_image);  
        combo3_panel.add(combo3_label, BorderLayout.NORTH);
        combo3_panel.add(combo3_menu, BorderLayout.SOUTH);
        combo3_panel.add(combo3_button, BorderLayout.CENTER);
        combo3_button.addActionListener(e -> 
        {
        	price = 55;
        	String quantity_input = JOptionPane.showInputDialog("Enter Quantity : ");
            if(quantity_input == null) return; 
            
            try 
            {
                   int quantity = Integer.parseInt(quantity_input);
                    total += price * quantity;
                       
                    int orderMore = JOptionPane.showConfirmDialog(frame, "Do you want to order more?", "Continue", JOptionPane.YES_NO_OPTION);

                    if(orderMore == JOptionPane.NO_OPTION) 
                    {
                        double vatable = total / (1 + vat);
                        double vatAmount = total - vatable;
                        double vatableRounded = Math.round(vatable * 100.0) / 100.0;
                        double vatRounded = Math.round(vatAmount * 100.0) / 100.0;
                        String message = "Total Bill: " + total + "\nVATable Amount: " + vatableRounded + "\nVAT (12%): " + vatRounded + "\n\nEnter Payment:";
                        String paymentInput = JOptionPane.showInputDialog(message);
                        if(paymentInput == null) return;                        
                        double payment = Double.parseDouble(paymentInput);
                        if(payment < total) 
                        {
                            JOptionPane.showMessageDialog(frame, "Insufficient Payment!");
                        } 
                        else 
                        {
                            double change = payment - total;
                            double changeRounded = Math.round(change * 100.0) / 100.0;
                            JOptionPane.showMessageDialog(frame, "Payment Successful!\nThank you for order!\nChange: " + changeRounded);
                            total = 0;
                        }
                    }
            } 
            catch(NumberFormatException ex) 
            {
            	JOptionPane.showMessageDialog(frame, "Numbers only!", "ERROR", JOptionPane.INFORMATION_MESSAGE);        
            }
        });      
        JButton combo4_button = new JButton(last_combo4_image);
        combo4_panel.add(combo4_label, BorderLayout.NORTH);
        combo4_panel.add(combo4_menu, BorderLayout.SOUTH);
        combo4_panel.add(combo4_button, BorderLayout.CENTER);
        combo4_button.addActionListener(e -> 
        {
        	price = 55 ;
        	String quantity_input = JOptionPane.showInputDialog("Enter Quantity : ");
            if(quantity_input == null) return; 
            
            try 
            {
                   int quantity = Integer.parseInt(quantity_input);
                    total += price * quantity;
                       
                    int orderMore = JOptionPane.showConfirmDialog(frame, "Do you want to order more?", "Continue", JOptionPane.YES_NO_OPTION);

                    if(orderMore == JOptionPane.NO_OPTION) 
                    {
                        double vatable = total / (1 + vat);
                        double vatAmount = total - vatable;
                        double vatableRounded = Math.round(vatable * 100.0) / 100.0;
                        double vatRounded = Math.round(vatAmount * 100.0) / 100.0;
                        String message = "Total Bill: " + total + "\nVATable Amount: " + vatableRounded + "\nVAT (12%): " + vatRounded + "\n\nEnter Payment:";
                        String paymentInput = JOptionPane.showInputDialog(message);
                        if(paymentInput == null) return;                        
                        double payment = Double.parseDouble(paymentInput);
                        if(payment < total) 
                        {
                            JOptionPane.showMessageDialog(frame, "Insufficient Payment!");
                        } 
                        else 
                        {
                            double change = payment - total;
                            double changeRounded = Math.round(change * 100.0) / 100.0;
                            JOptionPane.showMessageDialog(frame, "Payment Successful!\nThank you for order!\nChange: " + changeRounded);
                            total = 0;
                        }
                    }
            } 
            catch(NumberFormatException ex) 
            {
            	JOptionPane.showMessageDialog(frame, "Numbers only!", "ERROR", JOptionPane.INFORMATION_MESSAGE);        
            }     	
        });
        
        Exit.addActionListener(e -> frame.dispose());
        
    	frame.add(main_panel);
    	main_panel.add(north_panel, BorderLayout.NORTH);
    	main_panel.add(south_panel, BorderLayout.SOUTH);
    	main_panel.add(cntr_panel, BorderLayout.CENTER);
    	frame.setVisible(true);
    }
    
}
