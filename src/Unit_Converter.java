import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Unit_Converter extends JFrame implements ActionListener
{
	JFrame mini_frame;
	JPanel main_panel, south_panel, mini_main_panel;
	JButton In_Cm, Ft_M, lb_Kg, gal_L, F_C, C_F, Exit;
	JButton convert, clear, exit;
	JTextField textfield;
	JLabel input, lblResult, output;
	double   input_converting, converted;
	
    public Unit_Converter(JFrame frame)
    {
        super ("Measurement Unit Converter");	
		setLayout(new BorderLayout());	
		
		south_panel = new JPanel();
		south_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		south_panel.setBackground(Color.GRAY);
		south_panel.setOpaque(true);
		add(south_panel, BorderLayout.SOUTH);
				
		main_panel = new JPanel(new GridLayout(3,2,2,2));
		main_panel.setBorder(BorderFactory.createEmptyBorder(20,20,0,20));
		main_panel.setBackground(Color.GRAY);
		main_panel.setOpaque(true);
		add(main_panel, BorderLayout.CENTER);
				
		In_Cm = new JButton("<html><center>Inches<br>=<br>Centimeter<center></html>");
		In_Cm.setBackground(new Color(44, 62, 80));
		In_Cm.setForeground( new Color(236, 240, 241));
		In_Cm.setFont(new Font("Segoe UI", Font.BOLD, 20));
		main_panel.add(In_Cm);
		In_Cm.addActionListener(this);

		Ft_M = new JButton("<html><center>Feet<br>=<br>Meter<center></html>");
		Ft_M.setBackground(new Color(44, 62, 80));
		Ft_M.setForeground( new Color(236, 240, 241));
		Ft_M.setFont(new Font("Segoe UI", Font.BOLD, 20));
		main_panel.add(Ft_M);
		Ft_M.addActionListener(this);	

		lb_Kg = new JButton("<html><center>Pound<br>=<br>Kilogram<center></html>");
		lb_Kg.setBackground(new Color(44, 62, 80));
		lb_Kg.setForeground( new Color(236, 240, 241));
		lb_Kg.setFont(new Font("Segoe UI", Font.BOLD, 20));
		main_panel.add(lb_Kg);
		lb_Kg.addActionListener(this);		

		gal_L = new JButton("<html><center>Gallon<br>=<br>Liter<center></html>");
		gal_L.setBackground(new Color(44, 62, 80));
		gal_L.setForeground( new Color(236, 240, 241));
		gal_L.setFont(new Font("Segoe UI", Font.BOLD, 20));
		main_panel.add(gal_L);
		gal_L.addActionListener(this);	

		F_C = new JButton("<html><center>Fahrenheit<br>=<br>Celsius<center></html>");
		F_C.setBackground(new Color(44, 62, 80));
		F_C.setForeground( new Color(236, 240, 241));
		F_C.setFont(new Font("Segoe UI", Font.BOLD, 20));
		main_panel.add(F_C);
		F_C.addActionListener(this);

		C_F = new JButton("<html><center>Celsius<br>=<br>Fahrenheit<center></html>");
		C_F.setBackground(new Color(44, 62, 80));
		C_F.setForeground( new Color(236, 240, 241));
		C_F.setFont(new Font("Segoe UI", Font.BOLD, 20));
		main_panel.add(C_F);
		C_F.addActionListener(this);	

		Exit = new JButton("Exit");
		Exit.setBackground(new Color(147, 27, 58));
		Exit.setForeground(Color.WHITE);
		Exit.setFont(new Font("Arial", Font.BOLD, 14));
		Exit.setPreferredSize(new Dimension(200,50));
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
		mini_frame.setLayout(null);

		mini_main_panel = new JPanel();
		mini_main_panel.setLayout(null);
		mini_main_panel.setBounds(0, 0, 285, 200);
		mini_main_panel.setBackground(Color.GRAY);
		mini_frame.add(mini_main_panel);
		
		input = new JLabel("Input    :");
		input.setBounds(10, 10, 200, 25);
		input.setForeground(new Color(245, 245, 245));
		input.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mini_main_panel.add(input);
		
		textfield = new JTextField();
		textfield.setHorizontalAlignment(JTextField.RIGHT);
		textfield.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textfield.setBounds(100, 12, 140, 25);
		mini_main_panel.add(textfield);
		textfield.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(textfield.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please enter a value.","Input required",JOptionPane.ERROR_MESSAGE);
					output.setText("");
					convert.setEnabled(false);
					textfield.requestFocusInWindow();
				}
				else
				{
					convert.setEnabled(true);
					convert.requestFocusInWindow();
				}
			}
		});
		
		lblResult = new JLabel("Result   :");
		lblResult.setBounds(10, 60, 100, 20);
		lblResult.setForeground(new Color(245, 245, 245));
		lblResult.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mini_main_panel.add(lblResult);
		
		output = new JLabel();
		output.setBounds(110, 60, 180,25 );
		output.setForeground(new Color(245, 245, 245));
		output.setFont(new Font("Segoe UI", Font.BOLD, 20));	
		mini_main_panel.add(output);

		convert = new JButton("Convert");
		convert.setBounds(10, 100, 80, 50);
		convert.setBackground(new Color(44, 62, 80));
		convert.setForeground(new Color(236, 240, 241));
		convert.setEnabled(false);
		mini_main_panel.add(convert);
		convert.addActionListener(new ActionListener()
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
					convert.setEnabled(false);
					textfield.requestFocusInWindow();
					return;
				}
				
			}
		});		
		
		clear = new JButton("Clear");
		clear.setBounds(95, 100, 80, 50);
		clear.setBackground(new Color(250, 240, 230) );
		clear.setForeground(new Color(80, 60, 50) );
		mini_main_panel.add(clear);
		clear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				output.setText("");
				textfield.setText("");
				convert.setEnabled(false);
				textfield.requestFocusInWindow();
			}
			
		});
				
		exit = new JButton("Exit");
		exit.setBounds(180, 100, 80, 50);
		exit.setBackground(new Color(147, 27, 58));
		exit.setForeground(Color.WHITE);
		mini_main_panel.add(exit);
		exit.addActionListener(this);
		
		mini_frame.setResizable(false);
		mini_frame.setSize(285,200);
		mini_frame.setLocationRelativeTo(null);
		mini_frame.setVisible(true);
	}
	public void inch_cm(String convertion_type)
	{
		input_converting = Double.parseDouble(textfield.getText());
		converted = input_converting * 2.54;
		output.setText(String.format("%.2f %s", converted, convertion_type));
	}
	public void ft_m(String convertion_type)
	{
		input_converting = Double.parseDouble(textfield.getText());
		converted = input_converting * 0.3048;
		output.setText(String.format("%.2f %s", converted, convertion_type));
	}
	public void lb_kg(String convertion_type)
	{
		input_converting = Double.parseDouble(textfield.getText());
		converted = input_converting * 0.45359237;
		output.setText(String.format("%.2f %s", converted, convertion_type));
	}
	public void gal_L(String convertion_type)
	{
		input_converting = Double.parseDouble(textfield.getText());
		converted = input_converting * 3.78541;
		output.setText(String.format("%.2f %s", converted, convertion_type));
	}
	public void F_C(String convertion_type)
	{
		input_converting = Double.parseDouble(textfield.getText());
		converted = (input_converting - 32) * 5/9;
		output.setText(String.format("%.2f %s", converted, convertion_type));
	}
	public void C_F(String convertion_type)
	{
		input_converting = Double.parseDouble(textfield.getText());
		converted = (input_converting * 9/5) + 32;
		output.setText(String.format("%.2f %s", converted, convertion_type));
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