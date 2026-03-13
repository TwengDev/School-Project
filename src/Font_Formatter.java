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
		BOLD = setButtonsStats("<html><b>BOLD</b></html>",new Color(88,162,174), Color.white, new Font("Arial", Font.BOLD, 13), 20, 57, 85, 60, false);
		ITALIC = setButtonsStats("<html><i>ITALIC</i></html>", new Color(88,162,174), Color.white, new Font("Arial", Font.ITALIC, 13), 110, 57, 85, 60, false);
		BOLD_ITALIC = setButtonsStats("<html><b><i>BOLD-ITALIC</i></b></html>", new Color(88,162,174), Color.white, new Font("Arial", Font.BOLD | Font.ITALIC, 13), 200, 57, 85, 60, false);
		Clear = setButtonsStats("Clear", Color.orange, new Color(80, 70, 50), new Font("Arial", Font.PLAIN, 18), 20, 130, 130, 38, true);
		Exit = setButtonsStats("Exit", Color.red, new Color(80, 70, 50), new Font("Arial", Font.PLAIN, 18), 155, 130, 130, 38, true);

		setSize(310, 210);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(new Color(43,77,107));
		setVisible(true);
    }
	private JButton setButtonsStats(String name, Color bg, Color fg, Font font,  int x, int y, int width, int height, boolean enabled)
	{
		JButton template = new JButton(name);
		template.setBackground(bg);
		template.setForeground(fg);
		template.setFont(font);
		template.setBounds(x, y, width, height);
		template.addActionListener(this);
		template.setEnabled(enabled);
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