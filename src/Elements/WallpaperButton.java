package Elements;

import Galerie.Photo;

public class WallpaperButton extends TopBarButton{
	
	private Photo photo = new Photo("PicturesElements/wallpaperButton.png") ;
	
	public WallpaperButton(){
		setIcon(photo);
		setToolTipText("Modifier le fond d'écran");
	}

}
