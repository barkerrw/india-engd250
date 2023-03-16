import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class: AppViewer
 * 
 * @author barkerrw <br>
 * 			Purpose: Used to displays screen(s)
 *
 */
public class AppViewer {
	
	//set instance variables of screen size
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	public AppViewer() {
		JFrame frame = new JFrame("Start Screen");
		frame.setSize(WIDTH, HEIGHT);
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		
		panel.add(label);
		frame.add(panel, BorderLayout.SOUTH);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // AppViewer
} // end AppViewer
