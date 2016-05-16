package Galerie;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Galerie {
	
	private Photo[] photos = new Photo[50] ;
	private int cpt ;
	
	public void addPhoto(Photo photo, JButton[] buttons){
		photos[cpt] = photo ;
		buttons[cpt] = new JButton(photo) ;
        buttons[cpt].setBorderPainted(false); 
        buttons[cpt].setContentAreaFilled(false); 
        buttons[cpt].setFocusPainted(false); 
        buttons[cpt].setOpaque(false);
		cpt ++ ;		
	}
	
	public int getCpt(){
		return cpt ;
	}
	
	public Photo[] getPhotos(){
		return photos ;
	}

}
