package Elements;

import javax.swing.JButton;

import Galerie.Photo;

public class ApplicationButton extends TopBarButton {

	public ApplicationButton(Photo photo) {
		setIcon(photo);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
	}

}
