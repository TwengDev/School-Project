import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Order_System extends JFrame implements ActionListener
{
    JLabel title;
    JPanel mainPanel, northPanel, southPanel, cntrPanel;
    JButton comboButton1, comboButton2, comboButton3, comboButton4, btnExit;
    JPanel comboPanel1, comboPanel2, comboPanel3, comboPanel4;
    JLabel comboLabel1, comboMenu1, comboLabel2, comboMenu2, comboLabel3, comboMenu3, comboLabel4, comboMenu4;
    ImageIcon comboImage1, comboImage2, comboImage3, comboImage4;
    double total = 0;
	final double vat = 0.12;
	int quantity = 0;
    public Order_System(JFrame frame)
    {
        super("Food Ordering System");
		mainPanel = new JPanel(new BorderLayout());
		northPanel = new JPanel();
        northPanel.setBackground(Color.DARK_GRAY); 
		title = new JLabel("SCHOOL COMBO MEALS MENU", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));  
        title.setForeground(Color.WHITE);
        northPanel.add(title);
		mainPanel.add(northPanel, BorderLayout.NORTH);
        
        southPanel = new JPanel();       
        southPanel.setBackground(Color.DARK_GRAY);           
        btnExit = new JButton("EXIT");
        btnExit.setPreferredSize(new Dimension(100,50));
        btnExit.setBackground(Color.orange);
        btnExit.addActionListener(this);

        southPanel.add(btnExit, BorderLayout.SOUTH);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        cntrPanel = new JPanel();
        cntrPanel.setLayout(new GridLayout(2,2,15,15));
        cntrPanel.setBorder(BorderFactory.createEmptyBorder(15,20,15,20));
        cntrPanel.setBackground(Color.DARK_GRAY);
        mainPanel.add(cntrPanel, BorderLayout.CENTER);
        
        comboPanel1 = setPanel();
        comboLabel1 = setLabel("COMBO 1",JLabel.CENTER, comboPanel1);
        comboMenu1 = setMenu("<html>Burger + Water<br>Php 35<html>", comboPanel1);

        comboPanel2 = setPanel();
        comboLabel2 = setLabel("COMBO 2",JLabel.CENTER, comboPanel2);
        comboMenu2 = setMenu("<html>Hotdog + Rice + Water<br>Php 30<html>", comboPanel2);

        comboPanel3 = setPanel();
        comboLabel3 = setLabel("COMBO 3",JLabel.CENTER, comboPanel3);
        comboMenu3 = setMenu("<html>Pastil + Rice + Water<br>Php 55</html>", comboPanel3);

        comboPanel4 = setPanel();
        comboLabel4 = setLabel("COMBO 4", JLabel.CENTER, comboPanel4);
        comboMenu4 = setMenu("<html>Pizza + Rice + Water<br>Php 55</html>", comboPanel4);
            
        comboImage1 = resizedImage("Images/combo1.png");
        comboImage2 = resizedImage("Images/combo2.png");
        comboImage3 = resizedImage("Images/combo3.png");
        comboImage4 = resizedImage("Images/combo4.png");   
        
        comboButton1 = setButton(comboImage1, comboPanel1);    
        comboButton2 = setButton(comboImage2, comboPanel2);
        comboButton3 = setButton(comboImage3, comboPanel3);
        comboButton4 = setButton(comboImage4, comboPanel4);
        
        setSize(400, 600);
		setLocationRelativeTo(null);		
    	this.add(mainPanel);
    	this.setVisible(true);
    }
    private ImageIcon resizedImage(String path)
    {
        ImageIcon image = new ImageIcon(path);
        Image resizedImage = image.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
    private JPanel setPanel()
    {
        JPanel template = new JPanel();
        template.setLayout(new BorderLayout());
        template.setBackground(Color.DARK_GRAY);
        cntrPanel.add(template, BorderLayout.CENTER);
        return template;
    }
    private JButton setButton(ImageIcon image, JPanel panel)
    {
        JButton template = new JButton(image);
        panel.add(template, BorderLayout.CENTER);
        template.addActionListener(this);
        return template;
    }
    private JLabel setLabel(String name, int alignment, JPanel panel)
    {
        JLabel template = new JLabel(name, alignment);
        template.setForeground(Color.YELLOW);
        panel.add(template, BorderLayout.NORTH);
        return template;
    }
    private JLabel setMenu(String name, JPanel panel)
    {
        JLabel template = new JLabel(name);
        template.setForeground(Color.WHITE);
        panel.add(template, BorderLayout.SOUTH);
        return template;
    }      
    private void handleOrder(String comboName, double price)
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
        if(ae.getSource() == comboButton1)  handleOrder("Combo 1", 35);
        else if(ae.getSource() == comboButton2)  handleOrder("Combo 2", 30);
        else if(ae.getSource() == comboButton3)  handleOrder("Combo 3", 55);
        else if(ae.getSource() == comboButton4)  handleOrder("Combo 4", 55);
        else if(ae.getSource() == btnExit)  dispose();
    }   
}