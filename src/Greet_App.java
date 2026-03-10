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
		lbl1 = new JLabel("【 GREET APP 】");
		lbl1.setBounds(100,5,200,40);
		con.add(lbl1);
		
		lbl2 = new JLabel("Hi! I am  AEDI");
		lbl2.setBounds(10,50,300,15);
		con.add(lbl2);
		
		lbl3 = new JLabel("I want to be your friends with you.");
		lbl3.setBounds(10,70,300,15);
		con.add(lbl3);
		
		lbl4 = new JLabel("Can i know your name?");						
		lbl4.setBounds(10,90,300,15);
		con.add(lbl4);
		
		lbl5 = new JLabel("Your Name: ");
		lbl5.setBounds(10,110,80,15);
		con.add(lbl5);
		
		txt1 = new JTextField();
		txt1.setBounds(90, 106, 160, 22);
		con.add(txt1);
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
		lbl6.setBounds(10,130,320,15);
		con.add(lbl6);

		btn1 = new JButton("Greet Me");
		btn1.setBounds(10,155,88,30);
		btn1.setEnabled(false);
		con.add(btn1);
		btn1.addActionListener(this);
		
		btn2 = new JButton("Clear");
		btn2.setBounds(101,155,88,30);
		con.add(btn2);
		btn2.addActionListener(this);
		
		btn3 = new JButton("Exit");
		btn3.setBounds(192,155,88,30);
		con.add(btn3);
		btn3.addActionListener(this);
								
		pack();
		setSize(300,230);
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