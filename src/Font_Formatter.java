import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Font_Formatter extends JFrame implements ActionListener
{
	JButton BOLD, ITALIC, BOLD_ITALIC;
	JButton Clear, Exit;
	JLabel text;
	JTextField TextField;

    public Font_Formatter(JFrame frame)  
    {
        super ("Lab Exercise 2");
		setLayout(null);		
		
		text = new JLabel("Enter a word below:");
		text.setBounds(20, 20, 250, 20);
		text.setFont(new Font("Arial", Font.PLAIN, 18));
		text.setForeground(Color.black);
		this.add(text);

		TextField = new JTextField();
		TextField.setBounds(20, 40, 245, 25);
		TextField.setFont(new Font("Arial", Font.PLAIN, 18));
		this.add(TextField);

		BOLD = new JButton("Bold");
		BOLD.setBounds(20, 70, 75, 38);
		BOLD.setFont(new Font("Arial", Font.BOLD, 16));	
		BOLD.addActionListener(this);
		this.add(BOLD);
		
		ITALIC= new JButton("Italic");
		ITALIC.setBounds(105, 70, 75, 38);
		ITALIC.setFont(new Font("Arial", Font.ITALIC, 16));		
		ITALIC.addActionListener(this);
			
		this.add(ITALIC);
		BOLD_ITALIC = new JButton("<html>Bold-<br>Italic<html>");
		BOLD_ITALIC.setBounds(190, 70, 75, 38);
		BOLD_ITALIC.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));	
		BOLD_ITALIC.addActionListener(this);
		this.add(BOLD_ITALIC);	
		
		Clear = new JButton("Clear");
		Clear.setBounds(20, 113, 120, 38);
		Clear.setFont(new Font("Arial", Font.PLAIN, 16));		
		Clear.addActionListener(this);						
		this.add(Clear);	
		
		Exit = new JButton("Exit");
		Exit.setBounds(145, 113, 120, 38);
		Exit.setFont(new Font("Arial", Font.PLAIN, 16));	
		Exit.addActionListener(this);
		this.add(Exit);		

		pack();
		setSize(300, 200);
		setLocationRelativeTo(null);
		setResizable(false);

		this.setVisible(true);
    }
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource()== BOLD)
		{
			TextField.setFont(new Font("Arial", Font.BOLD,18));
			TextField.requestFocusInWindow();
		}
		else if (ae.getSource()== ITALIC)
		{
			TextField.setFont(new Font("Arial", Font.ITALIC,18));
			TextField.requestFocusInWindow();
		}
		else if (ae.getSource()== BOLD_ITALIC)
		{
			TextField.setFont(new Font("Arial", Font.BOLD | Font.ITALIC,18));
			TextField.requestFocusInWindow();
		}
		else if (ae.getSource()== Clear)
		{
			TextField.setText("");
			TextField.setFont(new Font("Arial", Font.PLAIN,18));
			TextField.requestFocusInWindow();
		}
		else if (ae.getSource()== Exit)
		{
			this.dispose();
		}
	}
    
}
