package Galerie;

import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JLabel;

import Frame.MainPanelGalerie;

public class Galerie {

	private Photo[] photos = new Photo[50];
	private int cpt;

	public void addPhoto(MainPanelGalerie panelGalerie, Photo photo, JButton[] buttons) {
		photos[cpt] = photo;
		buttons[cpt] = new JButton(photo);
		buttons[cpt].setBorderPainted(false);
		buttons[cpt].setContentAreaFilled(false);
		buttons[cpt].setFocusPainted(false);
		buttons[cpt].setOpaque(false);
		buttons[cpt].setPreferredSize(new Dimension(130, 100));
		panelGalerie.addActionListenerAndToPanel(buttons, cpt);
		cpt++;
		serialize();
	}
	
	public void serialize(){
		try{
			FileOutputStream fos = new FileOutputStream("Galerie/Photos.ser") ;
			ObjectOutputStream oos = new ObjectOutputStream(fos) ;
			oos.writeObject(photos);
			oos.flush();
			oos.close();
			fos.close();
		} catch(IOException e){
			e.printStackTrace();
		}
	}

	public void deserialize(JButton[] buttons){
		try{
			FileInputStream in = new FileInputStream("Galerie/Photos.ser") ;
			ObjectInputStream ois = new ObjectInputStream(in) ;
			buttons = (JButton[]) ois.readObject() ;
			ois.close();
		} catch(IOException e){
			e.printStackTrace();
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	
	}
	
	public Photo[] getPhotos() {
		return photos;
	}

}
