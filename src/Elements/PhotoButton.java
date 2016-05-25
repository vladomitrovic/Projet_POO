package Elements;

import javax.swing.JButton;

import Galerie.Photo;

public class PhotoButton extends JButton{

	public PhotoButton(Photo photo) {
		setIcon(photo);
	}
}
