package Elements;

import javax.swing.JButton;

import Galerie.Photo;


public class ScreenShotButton extends JButton {

	private Photo homePhoto = new Photo("PicturesElements/screenShot.png");

	public ScreenShotButton() {
		setIcon(homePhoto);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
	}
}
