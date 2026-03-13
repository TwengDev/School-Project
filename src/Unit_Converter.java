import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Unit_Converter extends JFrame implements ActionListener
{
	JPanel mainPanel, southPanel;
	JButton btnIn_Cm, btnFt_M, btnlb_Kg, btngal_L, btnF_C, btnC_F, btnExit;
	JButton btnconvert, btnclear, btnExit;
	JTextField textField;
	JLabel output;
	
    public Unit_Converter(JFrame frame)
    {
        super ("Measurement Unit Converter");	
		setLayout(new BorderLayout());	
		
		southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		southPanel.setBackground(Color.GRAY);
		southPanel.setOpaque(true);
		add(southPanel, BorderLayout.SOUTH);
				
		mainPanel = new JPanel(new GridLayout(3,2,2,2));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));
		mainPanel.setBackground(Color.GRAY);
		mainPanel.setOpaque(true);
		add(mainPanel, BorderLayout.CENTER);
				
		btnIn_Cm = createButton("<html><center>Inches<br>=<br>Centimeter<center></html>");
		btnFt_M = createButton("<html><center>Feet<br>=<br>Meter<center></html>");
		btnlb_Kg = createButton("<html><center>Pound<br>=<br>Kilogram<center></html>");
		btngal_L = createButton("<html><center>Gallon<br>=<br>Liter<center></html>");
		btnF_C = createButton("<html><center>Fahrenheit<br>=<br>Celsius<center></html>");
		btnC_F = createButton("<html><center>Celsius<br>=<br>Fahrenheit<center></html>");
			
		btnExit = setbutton2("Exit");
		btnExit.setPreferredSize(new Dimension(200,50));
		southPanel.add(btnExit);			

		setSize(350, 380);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);	
    }
	private JButton createButton(String name)
	{
		JButton template = new JButton(name);
		template.setBackground(new Color(44, 62, 80));
		template.setForeground(new Color(236, 240, 241));
		template.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mainPanel.add(template);
		template.addActionListener(this);
		return template;
	}
	private JButton createButton2(String name)
	{	
		JButton template = new JButton(name);
		template.setBackground(new Color(147, 27, 58));
		template.setForeground(Color.WHITE);
		template.setFont(new Font("Segoe UI", Font.BOLD, 14));
		template.addActionListener(this);
		return template;
	}
	private String getConvertionType(int value)
	{
		switch(value)
		{
			case 1: return "Inches to Centimeter";
			case 2: return "Feet to Meter";
			case 3: return "Pound to Kilogram";
			case 4: return "Gallon to Liter";
			case 5: return "Fahrenheit to Celsius";
			case 6: return "Celsius to Fahrenheit";
			default: return "Error";
		}
		
	}
	private void convertion(int value)
	{
		JFrame mini_frame = new JFrame(getConvertionType(value));
		mini_frame.setLayout(null);
		
		JLabel input = new JLabel("Input    :");
		input.setBounds(10, 10, 200, 25);
		input.setForeground(new Color(245, 245, 245));
		input.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mini_frame.add(input);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(JTextField.RIGHT);
		textField.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textField.setBounds(100, 12, 140, 25);
		mini_frame.add(textField);
		textField.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent ke)
			{
				if(textField.getText().trim().equals(""))
				{
					output.setText("");
					btnconvert.setEnabled(false);
				}
				else
				{
					btnconvert.setEnabled(true);
				}
			}
		});		
		JLabel lblResult = new JLabel("Result   :");
		lblResult.setBounds(10, 60, 100, 20);
		lblResult.setForeground(new Color(245, 245, 245));
		lblResult.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mini_frame.add(lblResult);
		
		output = new JLabel();
		output.setBounds(110, 60, 180,25 );
		output.setForeground(new Color(245, 245, 245));
		output.setFont(new Font("Segoe UI", Font.BOLD, 20));	
		mini_frame.add(output);

		btnconvert = new JButton("Convert");
		btnconvert.setBounds(10, 100, 80, 50);
		btnconvert.setBackground(new Color(44, 62, 80));
		btnconvert.setForeground(new Color(236, 240, 241));
		btnconvert.setEnabled(false);
		mini_frame.add(btnconvert);
		btnconvert.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					switch(value)
					{
						case 1: inch_cm("cm"); break;
						case 2: ft_m("m"); break;
						case 3: lb_kg("kg"); break;
						case 4: gal_L("L"); break;
						case 5: F_C("°C"); break;
						case 6: C_F("°F"); break;
					}
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.","Error",JOptionPane.ERROR_MESSAGE);
					output.setText("");
					textfield.setText("");
					btnconvert.setEnabled(false);
					textfield.requestFocusInWindow();
				}				
			}
		});				
		btnclear = new JButton("Clear");
		btnclear.setBounds(95, 100, 80, 50);
		btnclear.setBackground(new Color(250, 240, 230) );
		btnclear.setForeground(new Color(80, 60, 50));
		mini_frame.add(btnclear);
		btnclear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				output.setText("");
				textfield.setText("");
				btnconvert.setEnabled(false);
				textfield.requestFocusInWindow();
			}			
		});			
		btnExit = setbutton2("Exit");
		btnExit.setBounds(180, 100, 80, 50);
		mini_frame.add(btnExit);
		btnExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				mini_frame.dispose();
			}			
		});
		mini_frame.setResizable(false);
		mini_frame.setSize(285,200);
		mini_frame.setLocationRelativeTo(null);
		mini_frame.getContentPane().setBackground(Color.GRAY);
		mini_frame.setVisible(true);
	}
	private void inch_cm(String convertion_type)
	{
		double input_converting = Double.parseDouble(textfield.getText());
		double converted = input_converting * 2.54;
		output.setText(String.format("%.2f %s", converted, convertion_type));
	}
	private void ft_m(String convertion_type)
	{
		double input_converting = Double.parseDouble(textfield.getText());
		double converted = input_converting * 0.3048;
		output.setText(String.format("%.2f %s", converted, convertion_type));
	}
	private  void lb_kg(String convertion_type)
	{
		double input_converting = Double.parseDouble(textfield.getText());
		double converted = input_converting * 0.45359237;
		output.setText(String.format("%.2f %s", converted, convertion_type));
	}
	private void gal_L(String convertion_type)
	{
		double input_converting = Double.parseDouble(textfield.getText());
		double converted = input_converting * 3.78541;
		output.setText(String.format("%.2f %s", converted, convertion_type));
	}
	private void F_C(String convertion_type)
	{
		double input_converting = Double.parseDouble(textfield.getText());
		double converted = (input_converting - 32) * 5/9;
		output.setText(String.format("%.2f %s", converted, convertion_type));
	}
	private void C_F(String convertion_type)
	{
		double input_converting = Double.parseDouble(textfield.getText());
		double converted = (input_converting * 9/5) + 32;
		output.setText(String.format("%.2f %s", converted, convertion_type));
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()== btnIn_Cm)  Convertion(1);			
		else if (ae.getSource() == btnFt_M)  Convertion(2);					
		else if (ae.getSource() == btnlb_Kg)  Convertion(3);		
		else if (ae.getSource() == btngal_L)  Convertion(4);			
		else if (ae.getSource() == btnF_C)  Convertion(5);		
		else if (ae.getSource() == btnC_F)  Convertion(6);			
		else if (ae.getSource() == btnExit) dispose();
	}   
}