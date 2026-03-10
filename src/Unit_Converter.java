import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Unit_Converter extends JFrame implements ActionListener
{
	JFrame mini_frame;
	JPanel main_panel, south_panel;
	JButton In_Cm, Ft_M, lb_Kg, gal_L, F_C, C_F, Exit;
	JButton convert, clear, exit;
	JTextField textfield;
	JLabel input, Result, result;
	double   input_converting, converted;
	
    public Unit_Converter(JFrame frame)
    {
        super ("Measurement Unit Converter");	
		setLayout(new BorderLayout());	
		
		south_panel = new JPanel();
		south_panel.setBackground(Color.BLUE);
		south_panel.setOpaque(true);
		add(south_panel, BorderLayout.SOUTH);
				
		main_panel = new JPanel(new GridLayout(3,2,5,5));
		main_panel.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));
		main_panel.setBackground(Color.blue);
		main_panel.setOpaque(true);
		add(main_panel, BorderLayout.CENTER);
				
		In_Cm = new JButton("Inches = Centimeter");
		main_panel.add(In_Cm);
	
		In_Cm.addActionListener(this);

		Ft_M = new JButton("Feet = Meter");
		main_panel.add(Ft_M);
		Ft_M.addActionListener(this);	

		lb_Kg = new JButton("Pound = Kilogram");
		main_panel.add(lb_Kg);
		lb_Kg.addActionListener(this);		

		gal_L = new JButton("Gallon = Liter");
		main_panel.add(gal_L);
		gal_L.addActionListener(this);	

		F_C = new JButton("Fahrenheit = Celsius");
		main_panel.add(F_C);
		F_C.addActionListener(this);

		C_F = new JButton("Celsius = Fahrenheit");
		main_panel.add(C_F);
		C_F.addActionListener(this);	

		Exit = new JButton("Exit");
		Exit.setBackground(new Color(233, 45, 22));
		Exit.setPreferredSize(new Dimension(280,50));
		south_panel.add(Exit, BorderLayout.CENTER);		
		Exit.addActionListener(this);	

		pack();
		setSize(350, 380);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);	
    }
	public void Convertion(int value)
	{
		mini_frame = new JFrame("Converting");
		mini_frame.setBackground(Color.LIGHT_GRAY);
		mini_frame.setLayout(null);
		
		input = new JLabel("Input:");
		input.setBounds(10, 10, 70, 25);
		input.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mini_frame.add(input);
		
		textfield = new JTextField();
		textfield.setHorizontalAlignment(JTextField.RIGHT);
		textfield.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textfield.setBounds(80, 10, 80, 25);
		mini_frame.add(textfield, BorderLayout.NORTH);
		textfield.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(textfield.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please enter a value.","Input required",JOptionPane.ERROR_MESSAGE);
					textfield.requestFocusInWindow();
				}
				else
				{
					convert.setEnabled(true);
					convert.requestFocusInWindow();
				}
			}
		});
		
		Result = new JLabel("Result:");
		Result.setBounds(10, 40, 100, 20);
		Result.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mini_frame.add(Result);
		
		result = new JLabel();
		result.setBounds(120, 40, 200,20 );
		result.setFont(new Font("Segoe UI", Font.BOLD, 20));	
		mini_frame.add(result);
		
		convert = new JButton("Convert");
		convert.setBounds(10, 100, 80, 50);
		convert.setEnabled(false);
		mini_frame.add(convert);
		convert.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				
				try
				{
					switch(value)
					{
					case 1:
						input_converting = Double.parseDouble(textfield.getText());
						converted = input_converting * 2.54;
						result.setText(String.valueOf(converted));
						break;
						
					case 2:
						input_converting = Double.parseDouble(textfield.getText());
						converted = input_converting * 0.3048;
						result.setText(String.valueOf(converted));
						break;
						
					case 3:
						input_converting = Double.parseDouble(textfield.getText());
						converted = input_converting * 0.453592;
						result.setText(String.valueOf(converted));
						break;
						
					case 4:
						input_converting = Double.parseDouble(textfield.getText());
						converted = input_converting * 3.78541;
						result.setText(String.valueOf(converted));
						break;
						
					case 5:
						input_converting = Double.parseDouble(textfield.getText());
						converted = (input_converting - 32) * 5 / 9;
						result.setText(String.valueOf(converted));
						break;
						
					case 6:
						input_converting = Double.parseDouble(textfield.getText());
						converted = (input_converting * 9 / 5) + 32 ;
						result.setText(String.valueOf(converted));
						break;
						
					}
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(null, "Numbers only!");
				}
				textfield.requestFocusInWindow();
			}
		});
		
		clear = new JButton("Clear");
		clear.setBounds(95, 100, 80, 50);
		mini_frame.add(clear);
		clear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				result.setText("");
				textfield.setText("");
				convert.setEnabled(false);
				textfield.requestFocusInWindow();
			}
			
		});
		
		
		exit = new JButton("Exit");
		exit.setBounds(180, 100, 80, 50);
		mini_frame.add(exit);
		exit.addActionListener(this);
		
		mini_frame.pack();
		mini_frame.setResizable(false);
		mini_frame.setSize(285,200);
		mini_frame.setLocationRelativeTo(null);
		mini_frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()== In_Cm)
		{
			Convertion(1);
		}
		else if (ae.getSource() == Ft_M)
		{
			Convertion(2);				
		}
		else if (ae.getSource() == lb_Kg)
		{
			Convertion(3);
		}
		else if (ae.getSource() == gal_L)
		{
			Convertion(4);
		}
		else if (ae.getSource() == F_C)
		{
			Convertion(5);
		}
		else if (ae.getSource() == C_F)
		{
			Convertion(6);
		}
		else if (ae.getSource() == Exit)
		{
			this.dispose();
		}
		else if(ae.getSource() == exit)
		{
			mini_frame.dispose();
		}
		
	}
    
}