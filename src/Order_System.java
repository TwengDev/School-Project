import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Order_System extends JFrame implements ActionListener
{
    JLabel title;
    JPanel main_panel, north_panel, south_panel, cntr_panel;
    JButton combo1_button, combo2_button, combo3_button, combo4_button, Exit;
    JPanel combo1_panel, combo2_panel, combo3_panel, combo4_panel;
    JLabel combo1_label, combo1_menu, combo2_label, combo2_menu, combo3_label, combo3_menu, combo4_label, combo4_menu;
    ImageIcon combo1_image, combo2_image, combo3_image, combo4_image;

    double price = 0, total = 0;
	final double vat = 0.12;
	int quantity = 0;

    public Order_System(JFrame frame)
    {
        super("Food Ordering System");
    	
		main_panel = new JPanel(new BorderLayout());

		north_panel = new JPanel();
        north_panel.setBackground(Color.DARK_GRAY);
        
		title = new JLabel("SCHOOL COMBO MEALS MENU", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));  
        title.setForeground(Color.WHITE);
        north_panel.add(title);
		main_panel.add(north_panel, BorderLayout.NORTH);
        
        south_panel = new JPanel();       
        south_panel.setBackground(Color.DARK_GRAY);           
        Exit = new JButton("EXIT");
        Exit.setPreferredSize(new Dimension(100,50));
		Exit.setFont(new Font("Arial", Font.BOLD, 18));
        Exit.setBackground(Color.orange);
        Exit.addActionListener(this);

        south_panel.add(Exit, BorderLayout.SOUTH);
        main_panel.add(south_panel, BorderLayout.SOUTH);

        cntr_panel = new JPanel();
        cntr_panel.setLayout(new GridLayout(2,2,15,15));
        cntr_panel.setBorder(BorderFactory.createEmptyBorder(15,20,15,20));
        cntr_panel.setBackground(Color.DARK_GRAY);
        main_panel.add(cntr_panel, BorderLayout.CENTER);
        
        combo1_panel = new JPanel();
        combo1_panel.setLayout(new BorderLayout());
        combo1_panel.setBackground(Color.DARK_GRAY);
        cntr_panel.add(combo1_panel);

        combo1_label = new JLabel("COMBO 1",JLabel.CENTER);
        combo1_label.setForeground(Color.YELLOW);
        combo1_panel.add(combo1_label, BorderLayout.NORTH);

        combo1_menu = new JLabel("<html>Burger + Water<br>Php 35<html>");
        combo1_menu.setForeground(Color.WHITE);            
        combo1_panel.add(combo1_menu, BorderLayout.SOUTH);

        combo2_panel = new JPanel();
        combo2_panel.setLayout(new BorderLayout());
        cntr_panel.add(combo2_panel);
        combo2_panel.setBackground(Color.DARK_GRAY);

        combo2_label = new JLabel("COMBO 2",JLabel.CENTER);
        combo2_label.setForeground(Color.YELLOW);
        combo2_panel.add(combo2_label, BorderLayout.NORTH);

        combo2_menu = new JLabel("<html>Hotdog + Rice + Water<br>Php 30<html>");
        combo2_menu.setForeground(Color.WHITE);      
        combo2_panel.add(combo2_menu, BorderLayout.SOUTH);

        combo3_panel = new JPanel();
        combo3_panel.setLayout(new BorderLayout());
        cntr_panel.add(combo3_panel);
        combo3_panel.setBackground(Color.DARK_GRAY);

        combo3_label = new JLabel("COMBO 3",JLabel.CENTER);
        combo3_label.setForeground(Color.YELLOW);
        combo3_panel.add(combo3_label, BorderLayout.NORTH);

        combo3_menu = new JLabel("<html>Pastil + Rice + Water<br>Php 55</html>");
        combo3_menu.setForeground(Color.WHITE);
        combo3_panel.add(combo3_menu, BorderLayout.SOUTH);

        combo4_panel = new JPanel();
        combo4_panel.setLayout(new BorderLayout());
        cntr_panel.add(combo4_panel);
        combo4_panel.setBackground(Color.DARK_GRAY);

        combo4_label = new JLabel("COMBO 4",JLabel.CENTER);
        combo4_label.setForeground(Color.YELLOW);
        combo4_panel.add(combo4_label, BorderLayout.NORTH);

        combo4_menu = new JLabel("<html>Pizza + Rice + Water<br>Php 55</html>");
        combo4_menu.setForeground(Color.WHITE);
        combo4_panel.add(combo4_menu, BorderLayout.SOUTH);
        
        
        combo1_image = new ImageIcon("Images/combo1.png");
        combo2_image = new ImageIcon("Images/combo2.png");
        combo3_image = new ImageIcon("Images/combo3.png");
        combo4_image = new ImageIcon("Images/combo4.png");
        
        Image resized_combo1_image = combo1_image.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
        Image resized_combo2_image = combo2_image.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
        Image resized_combo3_image = combo3_image.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
        Image resized_combo4_image = combo4_image.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
        
        ImageIcon last_combo1_image = new ImageIcon(resized_combo1_image);
        ImageIcon last_combo2_image = new ImageIcon(resized_combo2_image);
        ImageIcon last_combo3_image = new ImageIcon(resized_combo3_image);
        ImageIcon last_combo4_image = new ImageIcon(resized_combo4_image);    
        
        combo1_button = new JButton(last_combo1_image);
        combo1_panel.add(combo1_button, BorderLayout.CENTER);
        combo1_button.addActionListener(this);    
        combo2_button = new JButton(last_combo2_image);
        combo2_panel.add(combo2_button, BorderLayout.CENTER);      
        combo2_button.addActionListener(this);

        combo3_button = new JButton(last_combo3_image);
        combo3_panel.add(combo3_button, BorderLayout.CENTER);
        combo3_button.addActionListener(this);
        
        combo4_button = new JButton(last_combo4_image);
        combo4_panel.add(combo4_button, BorderLayout.CENTER);
        combo4_button.addActionListener(this);
        
        

        pack();
        setSize(400, 600);
		setLocationRelativeTo(null);		
    	this.add(main_panel);
    	
    	this.setVisible(true);
    }
    public void HandleOrder(String comboName, double price)
    {
        String quantity_input = JOptionPane.showInputDialog("Enter Quantity for " + comboName + " : ");
        if(quantity_input == null) return; 
        
        try 
        {
               int quantity = Integer.parseInt(quantity_input);
                total += price * quantity;
                   
                int orderMore = JOptionPane.showConfirmDialog(null, "Do you want to order more?", "Continue", JOptionPane.YES_NO_OPTION);

                if(orderMore == JOptionPane.NO_OPTION) 
                {
                    double vatable = total / (1 + vat);
                    double vatAmount = total - vatable;
                    double vatableRounded = Math.round(vatable * 100.0) / 100.0;
                    double vatRounded = Math.round(vatAmount * 100.0) / 100.0;
                    String message = "Total Bill: " + total + "\nVATable Amount: " + vatableRounded + "\nVAT (12%): " + vatRounded + "\n\nEnter Payment:";
                    boolean validPayment = false;
                    while(!validPayment)
                    {
                        String paymentInput = JOptionPane.showInputDialog(message);   
                        if(paymentInput == null) return;
                        try
                        {
                            double payment = Double.parseDouble(paymentInput);
                            if(payment < total)
                            {
                                JOptionPane.showMessageDialog(null, "Insufficient Payment!");
                            }
                            else
                            {
                                double change = payment - total;
                                double changeRounded = Math.round(change * 100.0) / 100.0;
                                JOptionPane.showMessageDialog(null, "Payment Successful!\nThank you for order!\nChange: " + changeRounded);
                                total = 0;
                                validPayment = true;
                            }
                        }
                        catch(NumberFormatException ex)
                        {
                            JOptionPane.showMessageDialog(null, "Numbers only!");
                        }
                    }
                }
        } 
        catch(NumberFormatException ex) 
        {
            JOptionPane.showMessageDialog(null, "Numbers only!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == combo1_button)
        {
            HandleOrder("Combo 1", 35);
        }
        else if(ae.getSource() == combo2_button)
        {
            HandleOrder("Combo 2", 30);
        }
        else if(ae.getSource() == combo3_button)
        {
            HandleOrder("Combo 3", 55);
        }
        else if(ae.getSource() == combo4_button)
        {
            HandleOrder("Combo 4", 55);
        }
        else if(ae.getSource() == Exit)
        {
            this.dispose();
        }
    }

    
}
