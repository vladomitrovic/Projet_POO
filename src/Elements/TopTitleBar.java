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
	private JPanel emptyPanel = new JPanel();
	private JButton leftButton;
	private JButton rightButton;

	// With leftButton, title, rightButton
	public TopTitleBar(JButton leftButton, ActionListener leftAction, String title, JButton rightButton,
			ActionListener rightAction, Color coloBackground) {
		this.leftButton = leftButton;
		this.rightButton = rightButton;
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

	// Without rightButton
	public TopTitleBar(JButton leftButton, ActionListener leftAction, String title, Color coloBackground) {
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

		emptyPanel.setPreferredSize(new Dimension(58, 34));
		emptyPanel.setBackground(coloBackground);
		add(emptyPanel, BorderLayout.EAST);
		add(leftButton, BorderLayout.WEST);
		add(label, BorderLayout.CENTER);

	}

	// Without leftButton
	public TopTitleBar(String title, int r, int g, int b, JButton rightButton, ActionListener rightAction) {
		setLayout(new BorderLayout());
		Color color = new Color(r,g,b);
		setBackground(color);
		setPreferredSize(new Dimension(480, 60));

		// set the jlabel
		label = new JLabel(title);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.PLAIN, 35));
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);

		// add actionListener
		rightButton.addActionListener(rightAction);

		emptyPanel.setPreferredSize(new Dimension(58, 34));
		emptyPanel.setBackground(color);
		add(emptyPanel, BorderLayout.WEST);
		add(rightButton, BorderLayout.EAST);
		add(label, BorderLayout.CENTER);

	}

	public void setLabelText(String label) {
		this.label.setText(label);
	}

	public void setLeftButton(JButton leftButton, ActionListener leftAction) {
		remove(this.leftButton);
		this.leftButton = leftButton;
		leftButton.addActionListener(leftAction);
		add(leftButton, BorderLayout.WEST);
		revalidate();
		repaint();
	}
	
	public JButton getRightButton() {
		return rightButton;
	}
}
