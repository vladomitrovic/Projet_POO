package Galerie;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Photo extends ImageIcon {

	private String name;
	private String path;

	public Photo(String path) {
		super(path);
		this.path = path;
	}

	public Photo(Image scaledInstance) {
		// TODO Auto-generated constructor stub
		super(scaledInstance);
	}

}
