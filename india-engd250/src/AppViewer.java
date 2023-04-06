import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		
		JLayeredPane panel = frame.getLayeredPane();
		
		JLabel label = new JLabel("Where do you want to go?");
		label.setHorizontalAlignment(JLabel.CENTER);
		
		map = new ImageIcon("src/pictures/RegionMap.jpg");
		
		JLabel mapHolder = new JLabel(map);

		frame.add(mapHolder, BorderLayout.CENTER);
		frame.add(label, BorderLayout.NORTH);
				
		JButton north = new JButton("North");
		JButton west = new JButton("West");
		JButton south = new JButton("South");
		JButton east = new JButton("East");
		JButton northeast = new JButton("NorthEast");
		JButton central = new JButton("Central");
		
		mapX = WIDTH/2;
		mapY = HEIGHT/2;

		north.setBounds(mapX - 75, mapY - 100, 75,20);
		west.setBounds(mapX - 110, mapY + 30, 75,20);
		east.setBounds(mapX + 35, mapY, 75,20);
		south.setBounds(mapX - 90, mapY + 120, 75,20);
		northeast.setBounds(mapX + 120, mapY - 60, 100,20);
		central.setBounds(mapX - 65, mapY - 10, 85,20);
		
		panel.add(north,1);
		panel.add(south,1);
		panel.add(east,1);
		panel.add(west,1);
		panel.add(northeast,1);
		panel.add(central,1);

	
		panel.repaint();
		panel.setOpaque(true);
		frame.repaint();
		
		north.addActionListener(new ActionListener() {
		/**
		 * 
		 */
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		south.addActionListener(new ActionListener() {
			/**
			 * 
			 */
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		east.addActionListener(new ActionListener() {
			/**
			 * 
			 */
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		west.addActionListener(new ActionListener() {
			/**
			 * 
			 */
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		northeast.addActionListener(new ActionListener() {
			/**
			 * 
			 */
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		central.addActionListener(new ActionListener() {
			/**
			 * 
			 */
				@Override
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // AppViewer
} // end AppViewer
