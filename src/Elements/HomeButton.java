package Elements;

import javax.swing.JButton;

import Galerie.Photo;

public class HomeButton extends JButton {

	private Photo homePhoto = new Photo("PicturesElements/home.png");

	public HomeButton() {
		setIcon(homePhoto);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
	}

}
