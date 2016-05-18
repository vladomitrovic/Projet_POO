package Galerie;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Photo extends ImageIcon {

	private String path;

	public Photo(String path) {
		super(path);
		this.path = path;
	}

	public Photo(String string, Image scaledInstance) {
		super(scaledInstance);
		this.path = string;
	}

	public String getPath() {
		return path;
	}

}
