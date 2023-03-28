import java.awt.*;
import javax.swing.*;

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
		JLabel label = new JLabel("Where do you want to go?");
		JButton rural = new JButton("Rural");
		JButton urban = new JButton("Urban");
		
		
		Dimension buttonSize = new Dimension(150,200);
		
		JLabel label2 = new JLabel("Why is java so trash?");
		
		
		label.setHorizontalAlignment(JLabel.CENTER);
		
		panel.add(label2);
		
		rural.setPreferredSize(buttonSize);
		urban.setPreferredSize(buttonSize);
		
//		panel.add(label, BorderLayout.NORTH);
		
		panel.add(rural);
		panel.add(urban);
		
		
		frame.add(panel, BorderLayout.SOUTH);
		
		frame.add(label, BorderLayout.CENTER);
		
		
		

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	} // AppViewer
} // end AppViewer
