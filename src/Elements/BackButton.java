package Elements;


import Galerie.Photo;

public class BackButton extends TopBarButton{
	
	private Photo backPhoto = new Photo("PicturesElements/back.png");
	
	public BackButton(){
		setIcon(backPhoto);
	}

}
