import java.awt.*;
import javax.swing.*;
public class Unit_Converter 
{

    public Unit_Converter()
    {
        JFrame frame = new JFrame("Lab Exercise 3");
		frame.setSize(350, 380);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel north_panel = new JPanel();
		north_panel.setBackground(Color.LIGHT_GRAY);
		north_panel.setOpaque(true);
		
		JTextField text_field = new JTextField(JTextField.CENTER);
		text_field.setPreferredSize(new Dimension(310,45));
		text_field.setFont(new Font("Arial",Font.BOLD,30));
		north_panel.add(text_field);
				
		JPanel main_panel = new JPanel(new GridLayout(4,2,5,5));
		main_panel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
		main_panel.setBackground(Color.LIGHT_GRAY);
		main_panel.setOpaque(true);
		
		JButton In_Cm = new JButton("Inches = Centimeter");
		
		In_Cm.addActionListener(e -> 
		{	
			
				//text_field.setFont(new Font("Arial",Font.BOLD,30));
				double value = Double.parseDouble(text_field.getText());
				double converted = value * 2.54;
				text_field.setText(String.valueOf(converted));
					
		});
		
		
		JButton Ft_M = new JButton("Feet = Meter");
		Ft_M.setBounds(170, 140, 155, 55);
		Ft_M.addActionListener(e ->
		{
				//text_field.setFont(new Font("Arial",Font.BOLD,30));
				double value = Double.parseDouble(text_field.getText());
				double converted = value * 0.3048;
				text_field.setText(String.valueOf(converted));
			
		});		
				
		JButton lb_Kg = new JButton("Pound = Kilogram");
		lb_Kg.setBounds(10, 200, 155, 55);
		lb_Kg.addActionListener(e ->
		{
			
				//text_field.setFont(new Font("Arial",Font.BOLD,30));
				double value = Double.parseDouble(text_field.getText());
				double converted = value * 0.453592;
				text_field.setText(String.valueOf(converted));
			
		});	
		
		JButton gal_L = new JButton("Gallon = Liter");
		
		gal_L.addActionListener(e ->
		{
				//text_field.setFont(new Font("Arial",Font.BOLD,30));
				double value = Double.parseDouble(text_field.getText());
				double converted = value * 3.78541;
				text_field.setText(String.valueOf(converted));
		});
		
		JButton F_C = new JButton("Fahrenheit = Celsius");
		F_C.addActionListener(e ->
		{
			
				//text_field.setFont(new Font("Arial",Font.BOLD,30));
				double value = Double.parseDouble(text_field.getText());
				double converted = (value - 32) * 5 / 9;
				text_field.setText(String.valueOf(converted));
		});
		
		JButton C_F = new JButton("Celsius = Fahrenheit");
		//C_F.setBounds(170, 260, 155, 55);
		C_F.addActionListener(e ->
		{
			
				//text_field.setFont(new Font("Arial",Font.BOLD,30));
				double value = Double.parseDouble(text_field.getText());
				double converted = (value * 9 / 5) + 32 ;
				text_field.setText(String.valueOf(converted));
		});
		
		JButton Clear = new JButton("Clear");
		Clear.setBounds(10, 320, 155, 55);
		Clear.addActionListener(e ->
		{
			text_field.setText("");
		});
		
		JButton Exit = new JButton("Exit");
		Exit.setBounds(170, 320, 155, 55);
		Exit.addActionListener(e ->
		{
			frame.dispose();
		});				
		
		
		main_panel.add(In_Cm);
		main_panel.add(Ft_M);
		main_panel.add(lb_Kg);
		main_panel.add(gal_L);
		main_panel.add(F_C);
		main_panel.add(C_F);
		main_panel.add(Clear);
		main_panel.add(Exit);
		
		frame.add(main_panel);
		frame.add(north_panel, BorderLayout.NORTH);
		
		frame.setVisible(true);	
    }
    
}
