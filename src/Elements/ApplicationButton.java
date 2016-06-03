package Elements;

import javax.swing.JButton;

import Galerie.Photo;

public class ApplicationButton extends JButton {

	public ApplicationButton(Photo photo) {
		setIcon(photo);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
	}

}
