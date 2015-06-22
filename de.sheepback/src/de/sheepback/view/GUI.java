package de.sheepback.view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import de.sheepback.main.Main;

@SuppressWarnings("serial")
public class GUI extends JFrame implements Main.Display {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewPassword;
	JComboBox<String> comboBox;
	GUI frame;

	/**
	 * Create the frame.
	 */
	public GUI() {
		setTitle("PasswordGenerator");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 148);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textField = new JTextField("Push the button...");
		textField.setBounds(52, 25, 207, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		btnNewPassword = new JButton("New Password");
		btnNewPassword.setBounds(89, 55, 121, 23);
		contentPane.add(btnNewPassword);

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
	public void setText(String text) {
		textField.setText(text);
	}

	@Override
	public void btn(ActionListener al) {
		btnNewPassword.addActionListener(al);
	}

	@Override
	public int getLength() {
		return Integer.valueOf(comboBox.getSelectedItem().toString());
	}
}
