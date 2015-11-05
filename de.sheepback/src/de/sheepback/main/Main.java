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
					gui.setText(myRandom1(gui.getLength()));
				}
				else if(gui.getSelectedRadioBtn()==2){
					gui.setText(myRandom2(gui.getLength()));
				}
				else if(gui.getSelectedRadioBtn()==3){
					gui.setText(myRandom3(gui.getLength()));
				}
				else if(gui.getSelectedRadioBtn()==4){
					gui.setText(myRandom4(gui.getLength()));
				}
				else if(gui.getSelectedRadioBtn()==0){
					gui.setText("ERROR 100! NO FIELD SELECTED!");
				}
			}
		}));
	}
	
	private static String myRandom1(int length){
		   StringBuilder sb = new StringBuilder( length );
		   for( int i = 0; i < length; i++ ) 
		      sb.append( A.charAt( rnd.nextInt(A.length()) ) );
		return sb.toString();
	}
	
	private static String myRandom2(int length){
		   StringBuilder sb = new StringBuilder( length );
		   for( int i = 0; i < length; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return sb.toString();
	}
	
	private static String myRandom3(int length){
		   StringBuilder sb = new StringBuilder( length );
		   for( int i = 0; i < length; i++ ) 
		      sb.append( ABC.charAt( rnd.nextInt(ABC.length()) ) );
		return sb.toString();
	}
	
	private static String myRandom4(int length){
		   StringBuilder sb = new StringBuilder( length );
		   for( int i = 0; i < length; i++ ) 
		      sb.append( ABCD.charAt( rnd.nextInt(ABCD.length()) ) );
		return sb.toString();
	}
}
