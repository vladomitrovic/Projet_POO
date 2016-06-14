package Elements;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import Galerie.Photo;

public class NotesButton extends TopBarButton {

	private Photo photo = new Photo("PicturesElements/post-it.png");
	private JTextArea textArea = new JTextArea();

	public NotesButton(String text) {
		// set Button preferences
		setText(text);
		setPreferredSize(new Dimension(190, 230));
		setVerticalTextPosition(0);
		setVerticalAlignment(SwingConstants.TOP);
		setHorizontalAlignment(SwingConstants.LEFT);
		setMargin(new Insets(15, 15, 15, 15));
		setOpaque(false);

		// set textArea preferences
		textArea.setFont(new Font("Lucida Handwriting", Font.PLAIN, 15));
		textArea.setText(text);
		textArea.setOpaque(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);

		// add textArea to the Button
		add(textArea);

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Image img = photo.getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}

	public JTextArea getTextArea() {
		return textArea;
	}

}
