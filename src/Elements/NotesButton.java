package Elements;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import Galerie.Photo;

public class NotesButton extends TopBarButton {

	private Photo photo = new Photo("PicturesElements/note_background.png");

	public NotesButton(String text) {
		setText(text);
		setPreferredSize(new Dimension(190, 230));
		setVerticalTextPosition(0);
		setVerticalAlignment(SwingConstants.TOP);
		setHorizontalAlignment(SwingConstants.CENTER);
		setMargin(new Insets(10, 10, 10, 10));
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Image img = photo.getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

	}

}
