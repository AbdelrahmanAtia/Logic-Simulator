package LogSim;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

public class Circuit implements DragGestureListener
{
	private JFrame frame;
	private JPanel  panel0;
	private JPanel  panel1;        //west panel
	private JButton button1;       // And gate
	private JButton button2;      // OR gate
	private JButton button3;      // NOT gate
	private JButton button4;     // NAND gate
	private JButton button5;    // XOR gate
	private JButton button6;   //input source
	private JButton button7;   //output source
	
	private JPanel      leftPanel;
	private JTabbedPane tabbedPane;
	
	private JMenuBar menuBar;

	public Circuit()
	{
		 creatFrame();
		 creatTabbedPane();
		 creatMenuBar();
		 creatButtons();
	}
	public class ExitItemListener implements ActionListener{
			public void actionPerformed(ActionEvent event){
				System.exit(0);
			}
		}
	public class newItemListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			frame.setVisible(false);
			new Circuit();
		}
	}
	
public void creatTabbedPane() {
	    tabbedPane=new JTabbedPane ();
		panel0 = new JPanel();
		panel1 = new JPanel();

		panel0.setLayout(new GridLayout(5,1));
		panel1.setLayout(new GridLayout(7,1));

		tabbedPane.addTab("Gates",null , panel0,"Does nothing");
		tabbedPane.addTab("Sources",null , panel1,"Does nothing");	

		frame.setVisible(true);
	}
	private void creatButtons() {
	
		DragSource ds = new DragSource();
		
		button1=new JButton("AND");
		button2=new JButton("OR");
		button3=new JButton("NOT");
		button4=new JButton("NAND");
		button5=new JButton("XOR");
		button6=new JButton("Input Source");
		button7=new JButton("LED");
	
		URL url1 = System.class.getResource("/imgs/and.gif");
		ImageIcon icon1 = new ImageIcon(url1);
		
		URL url2 = System.class.getResource("/imgs/or.gif");
		ImageIcon icon2 = new ImageIcon(url2);
		
		URL url3 = System.class.getResource("/imgs/not.gif");
		ImageIcon icon3 = new ImageIcon(url3);
		
		URL url4 = System.class.getResource("/imgs/nand.gif");
		ImageIcon icon4 = new ImageIcon(url4);
		
		URL url5 = System.class.getResource("/imgs/xor.gif");
		ImageIcon icon5 = new ImageIcon(url5);
		
		URL url6 = System.class.getResource("/imgs/source.png");
		ImageIcon icon6 = new ImageIcon(url6);

		URL url7 = System.class.getResource("/imgs/led.png");
		ImageIcon icon7 = new ImageIcon(url7);
		
		button1.setIcon(icon1);
		button2.setIcon(icon2);
		button3.setIcon(icon3);
		button4.setIcon(icon4);
		button5.setIcon(icon5);
		button6.setIcon(icon6);
		button7.setIcon(icon7);
		

		ds.createDefaultDragGestureRecognizer(button1, DnDConstants.ACTION_COPY, this);
		ds.createDefaultDragGestureRecognizer(button2, DnDConstants.ACTION_COPY, this);
		ds.createDefaultDragGestureRecognizer(button3, DnDConstants.ACTION_COPY, this);
		ds.createDefaultDragGestureRecognizer(button4, DnDConstants.ACTION_COPY, this);
		ds.createDefaultDragGestureRecognizer(button5, DnDConstants.ACTION_COPY, this);
		ds.createDefaultDragGestureRecognizer(button6, DnDConstants.ACTION_COPY, this);
		ds.createDefaultDragGestureRecognizer(button7, DnDConstants.ACTION_COPY, this);

		button1.setBackground(Color.WHITE);
		button2.setBackground(Color.WHITE);
		button3.setBackground(Color.WHITE);
		button4.setBackground(Color.WHITE);
		button5.setBackground(Color.WHITE);
		button6.setBackground(Color.WHITE);
		button7.setBackground(Color.WHITE);
		
		panel0.add(button1);
		panel0.add(button2);
		panel0.add(button3);
		panel0.add(button4);
		panel0.add(button5);
		panel1.add(button6);
		panel1.add(button7);
		
		leftPanel=new JPanel();
		leftPanel.setLayout(new BorderLayout());
		leftPanel.add(tabbedPane);

		frame.add(leftPanel,BorderLayout.WEST);	
		
		frame.setVisible(true);

	}
	private void creatMenuBar() {
		menuBar=new JMenuBar();
	
		JMenu fileMenu=new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");		
		JMenuItem newItem = new JMenuItem("New");
		
		fileMenu.add(newItem);
		fileMenu.add(exitItem);
		
		ActionListener listener=new ExitItemListener();
		exitItem.addActionListener(listener);
		ActionListener listener1=new newItemListener();
		newItem.addActionListener(listener1);
		
		
		// shortcut for new in file menu
		KeyStroke keyStrokeToNew = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
		newItem.setAccelerator(keyStrokeToNew);		
		Action newAction = new AbstractAction("new") {
		    public void actionPerformed(ActionEvent e) {
		    	frame.setVisible(false);
				new Circuit();
		    }
		};
		newAction.putValue(Action.ACCELERATOR_KEY,
		        KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
		newItem.setAction(newAction);
		
		//shortcut for exit in file menu
		
		KeyStroke keyStrokeToExit = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
		exitItem.setAccelerator(keyStrokeToExit);		
		Action exitAction = new AbstractAction("exit") {
		    public void actionPerformed(ActionEvent e) {
		    	frame.setVisible(false);
				new Circuit();
		    }
		};
		exitAction.putValue(Action.ACCELERATOR_KEY,
		        KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
		exitItem.setAction(exitAction);
		
		
		JMenu viewMenu=new JMenu("View");
		JMenu toolsMenu=new JMenu("Tools");
		JMenu editMenu=new JMenu("Edit");
		JMenu helpMenu=new JMenu("Help");
		
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(viewMenu);
		menuBar.add(toolsMenu);
		menuBar.add(helpMenu);
		frame.add(menuBar , BorderLayout.NORTH);
	}

	
	private void creatFrame() {
		frame=new JFrame("Logic Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(1000, 700);
		frame.setLayout(new BorderLayout());
		frame.getContentPane().setBackground(Color.GRAY);	
		new MyDropTargetListner(frame);
	}

	public void dragGestureRecognized(DragGestureEvent ev) {
		Cursor cursor = null;
		if(ev.getDragAction() == DnDConstants.ACTION_COPY)
			cursor = DragSource.DefaultCopyDrop;
		
		JButton button = (JButton) ev.getComponent();
		
		ev.startDrag(cursor, new TransferableString(button.getActionCommand()));
	}
}