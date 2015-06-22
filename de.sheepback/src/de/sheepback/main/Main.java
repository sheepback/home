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
	}
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static Random rnd = new Random();
	
	public static void main(String[] args) {
		GUI gui = new GUI();
		gui.run();
		gui.btn((new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.setText(myRandom(gui.getLength()));
			}
		}));
	}
	
	private static String myRandom(int len){
		   StringBuilder sb = new StringBuilder( len );
		   for( int i = 0; i < len; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return sb.toString();
	}
}
