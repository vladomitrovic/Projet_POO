package Elements;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;


import javax.swing.SwingConstants;

import Galerie.Photo;

public class NotesButton extends TopBarButton {

	private Photo photo = new Photo("PicturesElements/post-it.png");

	
	public NotesButton(String text) {
		setText(text);
		setFont(new Font("Lucida Handwriting", Font.PLAIN, 20));
		setPreferredSize(new Dimension(190, 230));
		setVerticalTextPosition(0);
		setVerticalAlignment(SwingConstants.TOP);
		setHorizontalAlignment(SwingConstants.LEFT);
		setMargin(new Insets(15, 15, 15, 15));
		setOpaque(false);
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Image img = photo.getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
	


}
