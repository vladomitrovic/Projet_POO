package Elements;

import javax.swing.JButton;

import Galerie.Photo;

public class LayoutGalerieButton extends JButton{
	
	private Photo layoutButton = new Photo("Pictures/justify.png") ;
	
	public LayoutGalerieButton(){
		setIcon(layoutButton);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
	}

}
