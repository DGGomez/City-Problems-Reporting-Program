package cps406_iteration_3;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;


public class CYPRESS{
	  private static final int FRAME_WIDTH = 500;
	    private static final int FRAME_HEIGHT = 250;
	    
	public static void main(String[] args) {
		JFrame frame = new Frame(); 	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		frame.setTitle("CYPRESS") ;
		frame.pack() ; 
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT) ;
		frame.setVisible(true) ; 
	}
	public static class Frame extends JFrame
	{
		private JButton english;
		private JButton french;
	   /**
	      Constructs the frame.
	   */
	   public Frame()
	   {  
		    final langSelect lang = new langSelect() ;
			add(lang, BorderLayout.CENTER);
			final JPanel languageSelect = new JPanel() ;
			add(languageSelect, BorderLayout.SOUTH) ;
			english = new JButton("English") ;
			french = new JButton("French") ;
			languageSelect.add(english) ;
			languageSelect.add(french) ;
	     

			class englishListener implements ActionListener
			{
				public void actionPerformed(ActionEvent e)
			    {
					english.setVisible(false);
					french.setVisible(false);
					remove(lang);
					repaint();
				final main gui = new main();
				add(gui);
				}
			}
			english.addActionListener(new englishListener());

			class frenchListener implements ActionListener
			{
			    public void actionPerformed(ActionEvent event)
			    {
			    	english.setVisible(false);
					french.setVisible(false);
					remove(lang);
					repaint();
			    	final main gui = new main();
			    	add(gui);
				}
			}
			french.addActionListener(new frenchListener()) ;
	   }}

}
