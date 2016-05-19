package Elements;

import java.awt.FlowLayout;

import javax.swing.JButton;

import Galerie.Photo;

public class AddButton extends JButton {
	
	private Photo addPhoto = new Photo("Pictures/plus-button.png") ;
	

	public AddButton(){
		setIcon(addPhoto);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
	
	}

}
