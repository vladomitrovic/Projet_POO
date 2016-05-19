package Elements;

import javax.swing.JButton;
import Galerie.Photo;

public class BackButton extends JButton{
	
	private Photo backPhoto = new Photo("Pictures/back.png");
	
	public BackButton(){
		setIcon(backPhoto);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
	}

}
