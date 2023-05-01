import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BackButton {

	private JFrame frame;

	public BackButton(JFrame frame) {
		this.frame = frame;
		JButton back = new JButton("Back");
		back.setBounds(50, 50, 50, 20);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});

		frame.add(back);
	}
}