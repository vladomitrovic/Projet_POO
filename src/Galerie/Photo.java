package Galerie;

import java.awt.Image;
import java.io.Serializable;
import javax.swing.ImageIcon;

public class Photo extends ImageIcon implements Serializable {

	private static final long serialVersionUID = 1L;
	private String path;
	private int id = -1 ;

	public Photo(String path) {
		super(path);
		this.path = path;
	}

	public Photo(Image newimg) {
		super(newimg);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
