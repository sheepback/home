package de.sheepback.view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.UIManager;

import de.sheepback.main.Main;

@SuppressWarnings("serial")
public class GUI extends JFrame implements Main.Display {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewPassword;
	private JButton btnSavePassword;
	private JButton btnOpenPasswords;
	private JLabel status;
	private JRadioButton jRadioButton1;
	private JRadioButton jRadioButton2;
	private JRadioButton jRadioButton3;
	private JRadioButton jRadioButton4;
	private ButtonGroup group;
	
	JComboBox<String> comboBox;
	GUI frame;

	/**
	 * Create the frame.
	 */
	public GUI() {
		setTitle("PasswordGenerator");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		addMenu();
		addContentPane();
		addTextField();
		addPasswordButton();
		addOpenPasswordsButton();
		addComboBox();
		addRadioButtons();
		addSavePasswordButton();
		addStatus();
		Image icon = new ImageIcon("pics/icon.gif").getImage();
		this.setIconImage(icon);
		this.setLocationRelativeTo(null);
		try {
			  UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
			} catch( Exception e ) { e.printStackTrace(); }
		this.frame = GUI.this;
	}


	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public String getText() {
		return textField.getText();
	}
	
	@Override
	public void setStatus(String text) {
		status.setText("Status: "+text);
	}

	@Override
	public void setText(String text) {
		textField.setText(text);
	}

	@Override
	public void btn(ActionListener al) {
		btnNewPassword.addActionListener(al);
	}
	
	@Override
	public void btnSave(ActionListener al){
		btnSavePassword.addActionListener(al);
	}
	
	@Override
	public void openSave(ActionListener al){
		btnOpenPasswords.addActionListener(al);
	}

	@Override
	public int getLength() {
		return Integer.valueOf(comboBox.getSelectedItem().toString());
	}
	
	@Override
	public int getSelectedRadioBtn(){
		if(jRadioButton1.isSelected()){
			return 1;
		}
		else if(jRadioButton2.isSelected()){
			return 2;
		}
		else if(jRadioButton3.isSelected()){
			return 3;
		}
		else if(jRadioButton4.isSelected()){
			return 4;
		}
		else{
			return 0;
		}
	}
	
	private void addContentPane(){
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
	
	private void addMenu(){
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		JMenuItem mntmInfo = new JMenuItem("Info");
		mntmInfo.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Password Generator\n\nAlexander Thomas"
						+ "\nVersion: 1.1\nDate: 03.06.2016");
			}
		}));
		mnMenu.add(mntmInfo);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		}));
		mnMenu.add(mntmExit);
	}
	
	private void addStatus(){
		status = new JLabel("Status: N/A");
		status.setBounds(10, 130, 350, 30);
		contentPane.add(status);
	}
	
	private void addComboBox(){
		comboBox = new JComboBox<String>();
		comboBox.setBounds(269, 25, 41, 20);
		comboBox.addItem("6");
		comboBox.addItem("7");
		comboBox.addItem("8");
		comboBox.addItem("9");
		comboBox.addItem("10");
		comboBox.addItem("11");
		comboBox.addItem("12");
		comboBox.addItem("13");
		comboBox.addItem("14");
		comboBox.addItem("15");
		comboBox.addItem("16");
		contentPane.add(comboBox);
	}
	
	private void addPasswordButton() {
		btnNewPassword = new JButton("New Password");
		btnNewPassword.setBounds(20, 55, 121, 23);
		contentPane.add(btnNewPassword);
	}
	
	private void addSavePasswordButton(){
		btnSavePassword = new JButton("Save Password");
		btnSavePassword.setBounds(150, 55, 131, 23);
		contentPane.add(btnSavePassword);
	}
	
	private void addOpenPasswordsButton(){
		btnOpenPasswords = new JButton("OpenPasswords");
		btnOpenPasswords.setBounds(290, 55, 131, 23);
		contentPane.add(btnOpenPasswords);
	}
	
	private void addTextField() {
		textField = new JTextField("Push the button...");
		textField.setBounds(52, 25, 207, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	
	private void addRadioButtons(){
		jRadioButton1 = new JRadioButton("Default");
		jRadioButton1.setBounds(20, 100, 80, 20);
		jRadioButton1.setSelected(true);
		jRadioButton2 = new JRadioButton("+Lower");
		jRadioButton2.setBounds(100, 100, 80, 20);
		jRadioButton3 = new JRadioButton("+Numbers");
		jRadioButton3.setBounds(180, 100, 100, 20);
		jRadioButton4 = new JRadioButton("+Special");
		jRadioButton4.setBounds(280, 100, 150, 20);
		
		group = new ButtonGroup();
		group.add(jRadioButton1);
		group.add(jRadioButton2);
		group.add(jRadioButton3);
		group.add(jRadioButton4);
		
		contentPane.add(jRadioButton1);
		contentPane.add(jRadioButton2);
		contentPane.add(jRadioButton3);
		contentPane.add(jRadioButton4);
		
	}
}
