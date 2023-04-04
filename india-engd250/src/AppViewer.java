import java.awt.*;
import javax.swing.*;

/**
 * Class: AppViewer
 * 
 * @author barkerrw <br>
 * @author altschmn
 * 			Purpose: Used to displays screen(s)
 *
 */
public class AppViewer {
	
	//set instance variables of screen size
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	private ImageIcon map;
	
	int mapX;
	int mapY;
	
	public AppViewer() {
		JFrame frame = new JFrame("Start Screen");
		frame.setSize(WIDTH, HEIGHT);
//		frame.setLayout(null);
		
		JPanel panel = new JPanel();
		Dimension buttonSize = new Dimension(50,100);
//		rural.setPreferredSize(buttonSize);
//		urban.setPreferredSize(buttonSize);
//		panel.add(label, BorderLayout.NORTH);
		
		
		JLabel label = new JLabel("Where do you want to go?");
		label.setHorizontalAlignment(JLabel.CENTER);
		
		map = new ImageIcon("C:/Users/altschmn/git/india-engd250/india-engd250/src/pictures/RegionMap.jpg");
		
		JLabel mapHolder = new JLabel(map);
		
		
		frame.add(mapHolder, BorderLayout.CENTER);
		frame.add(label, BorderLayout.NORTH);
		
				
		
		
//		JButton north = new JButton("North");
//		JButton west = new JButton("West");
//		JButton south = new JButton("South");
//		JButton east = new JButton("East");
//		JButton northeast = new JButton("NorthEast");
//		JButton central = new JButton("Central");
//		
//		mapX = label.getX();
//		mapY = label.getY();
//
//		
//		north.setBounds(mapX, mapY, 50,100);
//		west.setBounds(mapX + 20, mapY + 20, 50,100);
//		east.setBounds(mapX + 50, mapY + 50, 50,100);
//		south.setBounds(mapX + 75, mapY + 75, 50,100);
//		northeast.setBounds(mapX + 100, mapY + 100, 50,100);
//		central.setBounds(mapX + 125, mapY + 125, 50,100);
//		
//		panel.add(north);
//		panel.add(south);
//		panel.add(east);
//		panel.add(west);
//		panel.add(northeast);
//		panel.add(central);
		
		
//		panel.repaint();
	
	
		
//		frame.add(panel);
		
		frame.repaint();
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	} // AppViewer
} // end AppViewer
