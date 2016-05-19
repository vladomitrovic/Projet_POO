package Elements;

import java.awt.FlowLayout;

import javax.swing.JButton;

import Galerie.Photo;

public class FavorisButton extends JButton {
	
	private Photo favorisPhoto = new Photo("Pictures/favoris.png") ;
	

	public FavorisButton(){
		setIcon(favorisPhoto);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
	}

}
