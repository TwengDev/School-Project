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
        Exit.setBackground(Color.orange);
        Exit.addActionListener(this);

        south_panel.add(Exit, BorderLayout.SOUTH);
        main_panel.add(south_panel, BorderLayout.SOUTH);

        cntr_panel = new JPanel();
        cntr_panel.setLayout(new GridLayout(2,2,15,15));
        cntr_panel.setBorder(BorderFactory.createEmptyBorder(15,20,15,20));
        cntr_panel.setBackground(Color.DARK_GRAY);
        main_panel.add(cntr_panel, BorderLayout.CENTER);
        
        combo1_panel = setpanel();
        combo1_label = setlabel("COMBO 1",JLabel.CENTER, combo1_panel);
        combo1_menu = setmenu("<html>Burger + Water<br>Php 35<html>", combo1_panel);

        combo2_panel = setpanel();
        combo2_label = setlabel("COMBO 2",JLabel.CENTER, combo2_panel);
        combo2_menu = setmenu("<html>Hotdog + Rice + Water<br>Php 30<html>", combo2_panel);

        combo3_panel = setpanel();
        combo3_label = setlabel("COMBO 3",JLabel.CENTER, combo3_panel);
        combo3_menu = setmenu("<html>Pastil + Rice + Water<br>Php 55</html>", combo3_panel);

        combo4_panel = setpanel();
        combo4_label = setlabel("COMBO 4", JLabel.CENTER, combo4_panel);
        combo4_menu = setmenu("<html>Pizza + Rice + Water<br>Php 55</html>", combo4_panel);
            
        combo1_image = ResizedImage("Images/combo1.png");
        combo2_image = ResizedImage("Images/combo2.png");
        combo3_image = ResizedImage("Images/combo3.png");
        combo4_image = ResizedImage("Images/combo4.png");   
        
        combo1_button = setbutton("COMBO 1", combo1_image, combo1_panel);    
        combo2_button = setbutton("COMBO 2", combo2_image, combo2_panel);
        combo3_button = setbutton("COMBO 3", combo3_image, combo3_panel);
        combo4_button = setbutton("COMBO 4", combo4_image, combo4_panel);
        
        setSize(400, 600);
		setLocationRelativeTo(null);		
    	this.add(main_panel);
    	this.setVisible(true);
    }
    private ImageIcon ResizedImage(String path)
    {
        ImageIcon image = new ImageIcon(path);
        Image resizedImage = image.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
    private JPanel setpanel()
    {
        JPanel template = new JPanel();
        template.setLayout(new BorderLayout());
        template.setBackground(Color.DARK_GRAY);
        cntr_panel.add(template, BorderLayout.CENTER);
        return template;
    }
    private JButton setbutton(String name, ImageIcon image, JPanel panel)
    {
        JButton template = new JButton(name, image);
        panel.add(template, BorderLayout.CENTER);
        template.addActionListener(this);
        return template;
    }
    private JLabel setlabel(String name, int alignment, JPanel panel)
    {
        JLabel template = new JLabel(name, alignment);
        template.setForeground(Color.YELLOW);
        panel.add(template, BorderLayout.NORTH);
        return template;
    }
    private JLabel setmenu(String name, JPanel panel)
    {
        JLabel template = new JLabel(name);
        template.setForeground(Color.WHITE);
        panel.add(template, BorderLayout.SOUTH);
        return template;
    }      
    private void HandleOrder(String comboName, double price)
    {
        String quantity_input = JOptionPane.showInputDialog("Enter Quantity for " + comboName + " : ");
        if(quantity_input == null) return; 
        try 
        {
               quantity = Integer.parseInt(quantity_input);
                total += price * quantity;               
                int orderMore = JOptionPane.showConfirmDialog(null, "Do you want to order more?", "Continue", JOptionPane.YES_NO_OPTION);
                if(orderMore == JOptionPane.NO_OPTION) 
                {
                    double vatable = total / (1 + vat);
                    double vatAmount = total - vatable;
                    double vatableRounded = Math.round(vatable * 100.0) / 100.0;
                    double vatRounded = Math.round(vatAmount * 100.0) / 100.0;
                    String message = "Total Bill          :     ₱ " + total + "\n\nVATable Amount :     ₱ " + vatableRounded + "\n\nVAT (12%)           :     ₱ " + vatRounded + "\n\nEnter Payment:";
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
                                JOptionPane.showMessageDialog(null, "Payment Successful!\n\nThank you for order!\n\nChange: ₱" + changeRounded);
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
        if(ae.getSource() == combo1_button)  HandleOrder("Combo 1", 35);
        else if(ae.getSource() == combo2_button)  HandleOrder("Combo 2", 30);
        else if(ae.getSource() == combo3_button)  HandleOrder("Combo 3", 55);
        else if(ae.getSource() == combo4_button)  HandleOrder("Combo 4", 55);
        else if(ae.getSource() == Exit)  dispose();
    }   
}