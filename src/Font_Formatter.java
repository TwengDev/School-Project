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
		TextField.setBounds(20, 27, 245, 30);
		TextField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		add(TextField);
		TextField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if(TextField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Enter any word","Error",JOptionPane.ERROR_MESSAGE);
					TextField.requestFocusInWindow();
				}
				else
				{
					BOLD.setEnabled(true);
					ITALIC.setEnabled(true);
					BOLD_ITALIC.setEnabled(true);
					text.requestFocusInWindow();
				}
			}
		});

		BOLD = new JButton("Bold");
		BOLD.setBackground(new Color(88,162,174));
		BOLD.setForeground(Color.white);
		BOLD.setBounds(20, 57, 75, 60);
		BOLD.setFont(new Font("Arial", Font.BOLD, 12));
		BOLD.setEnabled(false);
		BOLD.addActionListener(this);
		this.add(BOLD);
		
		ITALIC= new JButton("Italic");
		ITALIC.setBackground(new Color(88,162,174));
		ITALIC.setForeground(Color.white);
		ITALIC.setBounds(105, 57, 75, 60);
		ITALIC.setFont(new Font("Arial", Font.ITALIC, 12));	
		ITALIC.setEnabled(false);	
		ITALIC.addActionListener(this);
		add(ITALIC);

		BOLD_ITALIC = new JButton("Bold-Italic");
		BOLD_ITALIC.setBackground(new Color(88,162,174));
		BOLD_ITALIC.setForeground(Color.white);
		BOLD_ITALIC.setBounds(190, 57, 75, 60);
		BOLD_ITALIC.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		BOLD_ITALIC.setVerticalTextPosition(SwingConstants.TOP);
		BOLD_ITALIC.setHorizontalTextPosition(SwingConstants.CENTER);
		BOLD_ITALIC.setMargin(new Insets(5,5,5,5));
		BOLD_ITALIC.setEnabled(false);
		BOLD_ITALIC.addActionListener(this);
		add(BOLD_ITALIC);	
		
		Clear = new JButton("Clear");
		Clear.setBackground(Color.orange);
		Clear.setForeground(Color.white);
		Clear.setBounds(20, 130, 120, 38);
		Clear.setFont(new Font("Arial", Font.PLAIN, 16));		
		Clear.addActionListener(this);						
		add(Clear);	
		
		Exit = new JButton("Exit");
		Exit.setBackground(Color.red);
		Exit.setForeground(Color.white);
		Exit.setBounds(145, 130, 120, 38);
		Exit.setFont(new Font("Arial", Font.PLAIN, 16));	
		Exit.addActionListener(this);
		add(Exit);		
		
		pack();
		setSize(290, 210);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(new Color(43,77,107));
		setVisible(true);
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
			BOLD.setEnabled(false);
			ITALIC.setEnabled(false);
			BOLD_ITALIC.setEnabled(false);
			TextField.requestFocusInWindow();
		}
		else if (ae.getSource()== Exit)
		{
			this.dispose();
		}
	}
    
}