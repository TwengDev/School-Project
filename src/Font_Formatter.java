import java.awt.*;
import javax.swing.*;

public class Font_Formatter extends JFrame
{

    public Font_Formatter()  
    {
        JFrame frame = new JFrame("Lab Exercise 2");
		frame.setSize(300, 200);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		JLabel text = new JLabel("<html>Hi! Please enter a word below: </html>");
		text.setBounds(20, 20, 250, 20);
		text.setFont(new Font("Arial", Font.PLAIN, 18));
		text.setForeground(Color.black);
		frame.add(text);

		JTextField TextField = new JTextField();
		TextField.setBounds(20, 40, 245, 25);
		TextField.setFont(new Font("Arial", Font.PLAIN, 18));
		frame.add(TextField);

		JButton BOLD = new JButton("Bold");
		BOLD.setBounds(20, 70, 75, 38);
		BOLD.setFont(new Font("Arial", Font.BOLD, 16));
		
		BOLD.addActionListener(e -> {
		//String name = TextField.getText();
		TextField.setFont(new Font("Arial", Font.BOLD,18));
		});
		frame.add(BOLD);
		
		JButton ITALIC= new JButton("Italic");
		ITALIC.setBounds(105, 70, 75, 38);
		ITALIC.setFont(new Font("Arial", Font.ITALIC, 16));
		
		ITALIC.addActionListener(e -> 
		{
		//String name = lab_TextField.getText();
		TextField.setFont(new Font("Arial", Font.ITALIC,18));
		});		
		frame.add(ITALIC);
		JButton BOLD_ITALIC = new JButton("<html>Bold-<br>Italic<html>");
		BOLD_ITALIC.setBounds(190, 70, 75, 38);
		BOLD_ITALIC.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		
		BOLD_ITALIC.addActionListener(e -> 
		{
		//String name = lab_TextField.getText();
		TextField.setFont(new Font("Arial", Font.BOLD | Font.ITALIC,18));
		});
		frame.add(BOLD_ITALIC);	
		
		JButton Clear= new JButton("Clear");
		Clear.setBounds(60, 113, 75, 38);
		Clear.setFont(new Font("Arial", Font.PLAIN, 16));
		
		Clear.addActionListener(e -> 
		{
		TextField.setText("");
		TextField.setFont(new Font("Arial", Font.PLAIN,18));
		});				
		frame.add(Clear);	
		
		JButton Exit = new JButton("Exit");
		Exit.setBounds(155, 113, 75, 38);
		Exit.setFont(new Font("Arial", Font.PLAIN, 16));
		
		Exit.addActionListener(e -> frame.dispose());
		frame.add(Exit);		
		frame.setVisible(true);
    }
    
}
