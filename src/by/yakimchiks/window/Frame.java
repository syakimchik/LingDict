package by.yakimchiks.window;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
import javax.swing.table.TableColumn;


/*
 * Contain interface of application
 * @author Yakimchik Sergei
 * @version 1.0
 */

public class Frame extends JFrame{

	/**
	 * @serial default auto generate ID
	 */
	private static final long serialVersionUID = 1L;

	/** Contain content pane of frame */
	private Container content;
	
	/** Menu bar in frame */
	private JMenuBar menuBar;
	
	/** table with data */
	private JTable table;
	
	private JLabel status;
	
	public Frame(){
		super("Linguistic dictionary");
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		setSize(600, 600);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		int w = this.getSize().width;
		int h = this.getSize().height;
		
		int x = (dim.width-w)/2;
		int y = (dim.height-h)/2;
		
		setLocation(x, y);
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent event) {
				// TODO Auto-generated method stub
				Object[] options = {"Yes", "No"};
				if(JOptionPane.showOptionDialog(event.getWindow(), "Close the application?", 
						"Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, options, options[0])==JOptionPane.YES_OPTION){
					event.getWindow().setVisible(false);
					System.exit(0);
				}
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		content = getContentPane();
		
		menuBar = new JMenuBar();
		menuBar.add(createFileMenu());
		menuBar.add(createEditMenu());
		menuBar.add(createHelpMenu());
		
		String[] columnNames = {
			"#", "World", "Code"	
		};
		
		String[][] data = {
				{"1", " ", " "}	
		};
		
		table = new JTable(data, columnNames);
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		status = new JLabel("Readdy");
		status.setBorder(BorderFactory.createEmptyBorder());
		
		content.add(scrollPane);
		content.add(status, BorderLayout.SOUTH);
		
		setJMenuBar(menuBar);
		
		setVisible(true);
	}
	
	/*
	 * Menu file
	 * @return Return file menu with items.
	 */
	private JMenu createFileMenu(){
		JMenu file = new JMenu("File");
		JMenuItem exitItem = new JMenuItem(new AbstractAction() {
			
			/**
			 * @serial default auto generate ID
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Object[] options = {"Yes", "No"};
				if(JOptionPane.showOptionDialog(getWindows()[0], "Close the application?", 
						"Warning", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
						null, options, options[0])==JOptionPane.YES_OPTION){
					setVisible(false);
					System.exit(0);
				}
			}
		});
		
		exitItem.setText("Exit");
		
		file.add(exitItem);
		
		return file;
	}
	
	private JMenu createHelpMenu(){
		JMenu help = new JMenu("Help");
		JMenuItem aboutApp = new JMenuItem("About application");
		JMenuItem aboutAuthor = new JMenuItem("About author");
		help.add(aboutApp);
		help.add(aboutAuthor);
		return help;
	}
	
	private JMenu createEditMenu(){
		JMenu edit = new JMenu("Edit");
		JMenuItem addRecord = new JMenuItem("Add record");
		JMenuItem deleteRecord = new JMenuItem("Delete record");
		JMenuItem searchRecord = new JMenuItem("Search records");
		JMenuItem sortRecord = new JMenuItem("Sorting records");
		edit.add(addRecord);
		edit.add(deleteRecord);
		edit.addSeparator();
		edit.add(searchRecord);
		edit.add(sortRecord);
		return edit;
	}
}
