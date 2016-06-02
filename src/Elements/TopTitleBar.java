package Elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TopTitleBar extends JPanel {

	private JLabel label;

	public TopTitleBar(JButton leftButton, ActionListener leftAction, String title, JButton rightButton,
			ActionListener rightAction, Color coloBackground) {
		setLayout(new BorderLayout());
		setBackground(coloBackground);
		setPreferredSize(new Dimension(480, 60));

		// set the jlabel
		label = new JLabel(title);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.PLAIN, 35));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);

		// add actionListener
		leftButton.addActionListener(leftAction);
		rightButton.addActionListener(rightAction);

		add(leftButton, BorderLayout.WEST);
		add(label, BorderLayout.CENTER);
		add(rightButton, BorderLayout.EAST);
	}

}
