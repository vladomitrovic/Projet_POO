package Galerie;

public abstract class Galerie {
	
	private Photo[] photos = new Photo[50] ;
	private int cpt ;
	
	public void addPhoto(Photo photo){
		photos[cpt] = photo ;
		cpt ++ ;		
	}

}
