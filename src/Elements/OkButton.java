package Elements;

import Galerie.Photo;

public class OkButton extends TopBarButton {

	private Photo photo = new Photo("PicturesElements/ok.png");

	public OkButton() {
		setIcon(photo);
	}

}
