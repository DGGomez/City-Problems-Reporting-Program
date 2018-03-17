package cps406_iteration_3;
import java.awt.* ;
import javax.swing.* ;

public class langSelect extends JPanel{
	 public static final int PANEL_W = 300, PANEL_H = 400 ;
	 public static final int DEFAULT_SIZE = 30 ;
	private static int size;
	 private Image img;
	public langSelect(){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		setPreferredSize(new Dimension(PANEL_W, PANEL_H)) ;
		size = DEFAULT_SIZE ;
		img=toolkit.getImage("C:/Users/Daniel/Desktop/City of Toronto.gif");
	

	}
	 public void paintComponent(Graphics g)
	 {
		super.paintComponent(g) ;
		Graphics2D g2 = (Graphics2D) g ;
		g2.setFont(new Font("Helvetica", Font.BOLD, size)) ;
		g2.drawString("CYPRESS", getWidth()/3, getHeight()/2) ;
		g2.drawImage(img, getWidth()/3, 20+getHeight()/2, this);
		g2.setFont(new Font("Helvetica", Font.BOLD, size/2)) ;
		g2.drawString("City of Toronto", getWidth()/3, 40+getHeight()/2) ;
	 }
	
}
