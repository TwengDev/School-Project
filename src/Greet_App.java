import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Greet_App extends JFrame implements ActionListener
{
	JFrame fr1;
	Container con;
	JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6;
	JTextField txt1;
	JButton btn1, btn2, btn3;
	
	public Greet_App(JFrame frame1)
	{
		super ("Greet Application");
		fr1 = frame1;
		con = getContentPane();
		con.setLayout(null);
		lbl1 = new JLabel("<------------GREET APP------------>");
		lbl1.setBounds(50,10,300,20);
		
		lbl2 = new JLabel("Hi! I am  AEDI");
		lbl2.setBounds(10,40,300,15);
		
		lbl3 = new JLabel("I want to be your friends with you.");
		lbl3.setBounds(10,60,300,15);
		
		lbl4 = new JLabel("Can i know your name?");						
		lbl4.setBounds(10,80,300,15);
		
		lbl5 = new JLabel("Your Name: ");
		lbl5.setBounds(10,105,80,15);
		
		txt1 = new JTextField();
		txt1.setBounds(90, 105, 120, 18);
		txt1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(txt1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Name is require.","Error",JOptionPane.ERROR_MESSAGE);
					txt1.requestFocusInWindow();
				}
				else
				{
					btn1.setEnabled(true);
					btn1.requestFocusInWindow();
				}
			}
		});
		
		lbl6 = new JLabel();
		lbl6.setBounds(10,125,320,15);
		
		btn1 = new JButton("Greet Me");
		btn1.setBounds(10,145,88,25);
		btn1.setEnabled(false);
		btn1.addActionListener(this);
		
		btn2 = new JButton("Clear");
		btn2.setBounds(101,145,88,25);
		btn2.addActionListener(this);
		
		btn3 = new JButton("Exit");
		btn3.setBounds(192,145,88,25);
		btn3.addActionListener(this);
		
		
		
		con.add(btn3);
		con.add(btn2);
		con.add(btn1);
		con.add(lbl6);
		con.add(txt1);
		con.add(lbl1);
		con.add(lbl2);
		con.add(lbl3);
		con.add(lbl4);
		con.add(lbl5);
		pack();
		setSize(305,230);
		setResizable(false);
		setLocationRelativeTo(null);
		
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()== btn1)
		{
			String name = txt1.getText();
			lbl6.setText("I am honored to be you friend, "+name);
			
		}
		else if(ae.getSource()== btn2)
		{
			txt1.setText("");
			lbl6.setText("");
			btn1.setEnabled(false);
			txt1.requestFocusInWindow();
			
		}
		else if(ae.getSource()==btn3)
		{
			this.dispose();
		}
		if(ae.getSource()== btn1)
		{			
			String name;
			name = txt1.getText();
			btn1.setEnabled(true);
			lbl6.setText("I am honored to be your friend, "+name);
			txt1.setText("");
			btn1.setEnabled(false);
		}
		
	}
	
}