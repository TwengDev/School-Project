import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyMain extends JFrame implements ActionListener
{
	JPanel panel1;
	CardLayout cl;
	JMenuBar menu_bar;
	JMenu menu1,menu2,menu3,menu4;
	JMenuItem menu_item1,menu_item3,menu_item4;
	JMenuItem menu_item2_1, menu_item2_2, menu_item2_3, menu_item2_4;
	JButton btn_exit = new JButton("X");
	Greet_App g_app;
	Font_Formatter f_app;
	Unit_Converter u_app;
	Order_System o_app;
	
	public MyMain()
	{
		
		super ("Main Menu");
		panel1 = new JPanel()
		{
			public Dimension getPreferredSize()
			{
				return new Dimension (1920,100);
			}
		};
		cl = new CardLayout();
		panel1.setLayout(cl);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing (WindowEvent we)
			{
				System.exit(0);
			}
		});
		setLayout (new BorderLayout());
		menu1 = new JMenu("File");
		menu_item1 = new JMenuItem("Exit");
		menu1.add(menu_item1);
		Action quit_App1 = new AbstractAction("Exit")
		{
			public void actionPerformed(ActionEvent ae)
			{
				
			}
		};
		quit_App1.putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_E,KeyEvent.CTRL_DOWN_MASK));
		menu_item1.setAction(quit_App1);
		menu_item1.addActionListener(this);
		
		
		menu2 = new JMenu("Exercises");
		menu_item2_1 = new JMenuItem("Lab Exercise 1");
		menu2.add(menu_item2_1);
		menu_item2_1.addActionListener(this);		
		
		menu_item2_2 = new JMenuItem("Lab Exercise 2");
		menu2.add(menu_item2_2);
		menu_item2_2.addActionListener(this);			
		
		menu_item2_3 = new JMenuItem("Lab Exercise 3");
		menu2.add(menu_item2_3);
		menu_item2_3.addActionListener(this);	
			
		menu_item2_4 = new JMenuItem("Lab Exercise 4");
		menu2.add(menu_item2_4);
		menu_item2_4.addActionListener(this);	
		
		menu3 = new JMenu("Exam");
		menu_item3 = new JMenuItem("Midterm");
		menu3.add(menu_item3);
				
		menu4 = new JMenu("About");
		menu_item4 = new JMenuItem("Programmer");
		menu4.add(menu_item4);
		Action quit_App4 = new AbstractAction("Programmer")
		{
			public void actionPerformed(ActionEvent ae)
			{
				
			}
		};
		quit_App4.putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_F,KeyEvent.CTRL_DOWN_MASK));
		menu_item4.setAction(quit_App4);
		menu_item4.addActionListener(this);
		
		add(panel1,BorderLayout.NORTH);
		menu_bar = new JMenuBar();
		menu_bar.add(menu1);
		menu_bar.add(menu2);
		menu_bar.add(menu3);
		menu_bar.add(menu4);
		setJMenuBar(menu_bar);
		JToolBar toolbar = new JToolBar();
		toolbar.setFloatable(false);
		toolbar.setRollover(true);		
		toolbar.add(btn_exit);
		btn_exit.setToolTipText("Quit Application");
		btn_exit.addActionListener(this);
				
		add(toolbar,BorderLayout.NORTH);
		setSize(1920,50);
		pack();
		setSize(1920,1080);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible (true);				
	}
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getSource()== menu_item1 ||ae.getSource()==btn_exit)  System.exit(0);
		else if (ae.getSource()== menu_item4)
		{
			JOptionPane.showMessageDialog(null, "Programmed by: Jake", "Developer", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (ae.getSource()== menu_item2_1)  g_app = new Greet_App(this);
		else if (ae.getSource()== menu_item2_2)  f_app = new Font_Formatter(this);
		else if (ae.getSource()== menu_item2_3)  u_app = new Unit_Converter(this);
		else if (ae.getSource()== menu_item2_4)  o_app = new Order_System(this);
	}
	public static void main(String[] args) 
	{
		new MyMain();
	}
}