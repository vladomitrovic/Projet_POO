package Elements;

import javax.swing.JButton;
import Galerie.Photo;

public class TrashButton extends JButton {

	private Photo photo = new Photo("PicturesElements/trash.png");

	public TrashButton() {
		setIcon(photo);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
	}

}
