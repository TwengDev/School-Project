import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Font_Formatter extends JFrame implements ActionListener
{
	JButton BOLD, ITALIC, BOLD_ITALIC;
	JButton Clear, Exit;
	JLabel text;
	JTextField TextField;
	JPanel panel1;

    public Font_Formatter(JFrame frame)  
    {
        super ("Basic Font Formatter");
		setLayout(null);		
		
		text = new JLabel("Enter a word below:");
		text.setForeground(Color.WHITE);
		text.setBounds(20, 5, 250, 20);
		text.setFont(new Font("Arial", Font.PLAIN, 18));
		add(text);

		TextField = new JTextField();	
		TextField.setBounds(20, 27, 265, 25);
		TextField.setFont(new Font("Arial", Font.PLAIN, 18));
		add(TextField);
		TextField.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent ke)
			{
				if(TextField.getText().trim().equals(""))
				{
					BOLD.setEnabled(false);
					ITALIC.setEnabled(false);
					BOLD_ITALIC.setEnabled(false);
				}
				else
				{
					BOLD.setEnabled(true);
					ITALIC.setEnabled(true);
					BOLD_ITALIC.setEnabled(true);		
					TextField.requestFocusInWindow();			
				}
			}
		});
		BOLD = setStylesAEEAdd("<html><b>Bold</b></html>", 20, 57, 85, 60);		
		ITALIC= setStylesAEEAdd("<html><i>Italic</i></html>", 110, 57, 85, 60);
		BOLD_ITALIC = setStylesAEEAdd("<html><b><i>Bold-Italic</i></b></html>", 200, 57, 85, 60);		
		Clear = setStylesAEAdd("Clear", Color.orange, 20, 130, 130, 38);		
		Exit = setStylesAEAdd("Exit", Color.red, 155, 130, 130, 38);

		setSize(310, 210);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(new Color(43,77,107));
		setVisible(true);
    }
	private JButton setStylesAEEAdd(String name, int x, int y, int width, int height)
	{
		JButton template = new JButton(name);
		template.setBackground(new Color(88,162,174));
		template.setForeground(Color.white);
		template.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		template.setBounds(x, y, width, height);
		template.addActionListener(this);
		template.setEnabled(false);
		add(template);
		return template;
	}
	private JButton setStylesAEAdd(String name, Color bg, int x, int y, int width, int height)
	{
		JButton template = new JButton(name);
		template.setBackground(bg);
		template.setForeground(new Color(80, 70, 50));
		template.setFont(new Font("Arial", Font.PLAIN, 16));
		template.setBounds(x, y, width, height);
		template.addActionListener(this);
		add(template);
		return template;
	}
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource()== BOLD) setFont(Font.BOLD);
		else if (ae.getSource()== ITALIC) setFont(Font.ITALIC);
		else if (ae.getSource()== BOLD_ITALIC) setFont(Font.BOLD | Font.ITALIC);
		else if (ae.getSource()== Clear) 
		{  
			TextField.setText("");  
			setFont(Font.PLAIN);  
			BOLD.setEnabled(false);  
			ITALIC.setEnabled(false);  
			BOLD_ITALIC.setEnabled(false); 
		}
		else if (ae.getSource()== Exit) dispose();
	}
	private void setFont(int font)
	{
		TextField.setFont(new Font("Arial", font, 18));
		TextField.requestFocusInWindow();
	} 
}