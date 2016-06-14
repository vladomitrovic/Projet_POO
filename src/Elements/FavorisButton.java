package Elements;

import Galerie.Photo;

public class FavorisButton extends TopBarButton {

	private Photo favorisPhoto = new Photo("PicturesElements/favoris.png");

	public FavorisButton() {
		setIcon(favorisPhoto);
	}

}
