package Galerie;

import javax.swing.ImageIcon;

public class Photo extends ImageIcon{
	
	private String name ;
	private String path ;
	
	public Photo(String path, String description){
		super(path, description) ;
	}
	

}
