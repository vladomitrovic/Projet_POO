package Elements;

import Galerie.Photo;

public class AddButton extends TopBarButton {

	private Photo addPhoto = new Photo("PicturesElements/plus-button.png");

	public AddButton() {
		setIcon(addPhoto);
	}
}
