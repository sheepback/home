package de.sheepback.main;

import de.sheepback.view.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
	
	public interface Display{
		String getText();
		void setText(String text);
		void btn(ActionListener al);
		int getLength();
		int getSelectedRadioBtn();
		
	}
	
	static final String A = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static final String ABC = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ!$&?ß#-";
	static final String ABCD = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!$&?ß#-";
	static Random rnd = new Random();
	
	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.run();
		gui.btn((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(gui.getSelectedRadioBtn()==1){
					gui.setText(myRandom(gui.getLength(), A));
				}
				else if(gui.getSelectedRadioBtn()==2){
					gui.setText(myRandom(gui.getLength(), AB));
				}
				else if(gui.getSelectedRadioBtn()==3){
					gui.setText(myRandom(gui.getLength(), ABC));
				}
				else if(gui.getSelectedRadioBtn()==4){
					gui.setText(myRandom(gui.getLength(), ABCD));
				}
				else if(gui.getSelectedRadioBtn()==0){
					gui.setText("ERROR 100! NO FIELD SELECTED!");
				}
			}
		}));
	}
	
	private static String myRandom(int length, String word){
		   StringBuilder sb = new StringBuilder( length );
		   for( int i = 0; i < length; i++ ) 
		      sb.append( word.charAt( rnd.nextInt(word.length()) ) );
		return sb.toString();
	}
}
