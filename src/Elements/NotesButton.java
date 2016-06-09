package Elements;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;

import Galerie.Photo;

public class NotesButton extends TopBarButton {

	private Photo photo = new Photo("PicturesElements/note_background_1.png");

	public NotesButton(String text) {
		setText(text);
		setPreferredSize(new Dimension(190, 190));
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Image img = photo.getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

	}

}
