package Elements;

import javax.swing.SwingConstants;

import Galerie.Photo;

public class TrashButton extends TopBarButton {

	private Photo photo = new Photo("PicturesElements/trash.png");

	public TrashButton() {
		setIcon(photo);
	}

}
