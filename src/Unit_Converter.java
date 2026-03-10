import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Unit_Converter extends JFrame implements ActionListener
{
	JPanel main_panel, north_panel;
	JTextField text_field;
	JButton In_Cm, Ft_M, lb_Kg, gal_L, F_C, C_F;
	JButton Clear, Exit;

    public Unit_Converter(JFrame frame)
    {
        super ("Lab Exercise 3");	
		setLayout(new BorderLayout());	
		
		north_panel = new JPanel();
		north_panel.setBackground(Color.LIGHT_GRAY);
		north_panel.setOpaque(true);
		this.add(north_panel, BorderLayout.NORTH);

		text_field = new JTextField(JTextField.CENTER);
		text_field.setPreferredSize(new Dimension(310,45));
		text_field.setFont(new Font("Arial",Font.BOLD,30));
		north_panel.add(text_field);
				
		main_panel = new JPanel(new GridLayout(4,2,5,5));
		main_panel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
		main_panel.setBackground(Color.LIGHT_GRAY);
		main_panel.setOpaque(true);
		this.add(main_panel);
				
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

		Clear = new JButton("Clear");
		main_panel.add(Clear);	
		Clear.addActionListener(this);	

		Exit = new JButton("Exit");
		Exit.setBounds(170, 320, 155, 55);
		main_panel.add(Exit);		
		Exit.addActionListener(this);	

		pack();
		setSize(350, 380);
		setLocationRelativeTo(null);
		this.setVisible(true);	
    }
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()== In_Cm)
		{
				double value = Double.parseDouble(text_field.getText());
				double converted = value * 2.54;
				text_field.setText(String.valueOf(converted));
		}
		else if (ae.getSource() == Ft_M)
		{
				double value = Double.parseDouble(text_field.getText());
				double converted = value * 0.3048;
				text_field.setText(String.valueOf(converted));
		}
		else if (ae.getSource() == lb_Kg)
		{
				double value = Double.parseDouble(text_field.getText());
				double converted = value * 0.453592;
				text_field.setText(String.valueOf(converted));
		}
		else if (ae.getSource() == gal_L)
		{
				double value = Double.parseDouble(text_field.getText());
				double converted = value * 3.78541;
				text_field.setText(String.valueOf(converted));
		}
		else if (ae.getSource() == F_C)
		{
				double value = Double.parseDouble(text_field.getText());
				double converted = (value - 32) * 5 / 9;
				text_field.setText(String.valueOf(converted));
		}
		else if (ae.getSource() == C_F)
		{
				double value = Double.parseDouble(text_field.getText());
				double converted = (value * 9 / 5) + 32 ;
				text_field.setText(String.valueOf(converted));
		}
		else if(ae.getSource()== Clear)
		{
				text_field.setText("");
		}
		else if (ae.getSource() == Exit)
		{
			this.dispose();
		}
	}
    
}