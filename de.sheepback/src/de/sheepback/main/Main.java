package de.sheepback.main;

import de.sheepback.view.GUI;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class Main {
	
	public interface Display{
		String getText();
		void setText(String text);
		void btn(ActionListener al);
		int getLength();
		int getSelectedRadioBtn();
		void btnSave(ActionListener al);
		void openSave(ActionListener al);
		void setStatus(String status);
		
	}	
	
	static final String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789%§)=}[]\\(!$&?ß#-";
	static Random rnd = new Random();
	
	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.run();
		gui.btn((new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(gui.getSelectedRadioBtn()==1){
					gui.setText(myRandom(gui.getLength(), letters.substring(0, 25)));
				}
				else if(gui.getSelectedRadioBtn()==2){
					gui.setText(myRandom(gui.getLength(), letters.substring(0, 51)));
				}
				else if(gui.getSelectedRadioBtn()==3){
					gui.setText(myRandom(gui.getLength(), letters.substring(0,61)));
				}
				else if(gui.getSelectedRadioBtn()==4){
					gui.setText(myRandom(gui.getLength(), letters.substring(0, 68)));
				}
				else if(gui.getSelectedRadioBtn()==0){
					gui.setText("ERROR 100! NO FIELD SELECTED!");
				}
				gui.setStatus("Generated Password!");
			}
		}));
		
		gui.btnSave((new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!gui.getText().equals("")&&!gui.getText().equals("Push the button...")){
					String applicationName = enterName();
					if(applicationName==null || applicationName.equals("") || applicationName.trim().equals("")){
						gui.setStatus("Password not saved: canceled or name was empty!");
						return;
					}
					List<String> lines = Arrays.asList("Application: "+applicationName+" Password: "+gui.getText());
					Path path = Paths.get("Passwords.txt");
					try {
						Files.write(path, lines, Charset.forName("UTF-8"), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
						gui.setStatus("Password saved!");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}));
	
	
	gui.openSave((new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				File file = new File("Passwords.txt");
				Desktop.getDesktop().open(file);
				gui.setStatus("Password File opened!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}));
}
	
	private static String enterName(){
		return JOptionPane.showInputDialog("Enter the Name the Password will be used for:");
	}
	
	private static String myRandom(int length, String word){
		   StringBuilder sb = new StringBuilder( length );
		   for( int i = 0; i < length; i++ ) 
		      sb.append( word.charAt( rnd.nextInt(word.length()) ) );
		return sb.toString();
	}
}
