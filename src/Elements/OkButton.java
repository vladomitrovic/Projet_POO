package Elements;

import javax.swing.JButton;

import Galerie.Photo;


public class OkButton extends JButton {

	private Photo photo = new Photo("PicturesElements/ok.png");

	public OkButton() {
		setIcon(photo);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
	}

}
