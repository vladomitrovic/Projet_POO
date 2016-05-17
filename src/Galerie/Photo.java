package Galerie;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Photo extends ImageIcon {

	private String path;

	public Photo(String path) {
		super(path);
		this.path = path;
	}

	public String getPath() {
		return path;
	}

}
