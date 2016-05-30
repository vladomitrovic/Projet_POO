package Galerie;

import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import Elements.PhotoButton;
import Frame.MainPanelGalerie;

public class Galerie {

	private ArrayList<Photo> photos = new ArrayList<Photo>();
	private ArrayList<Photo> vignettes = new ArrayList<Photo>();
	private int cpt;

	public void addPhoto(Photo photo) {
		photos.add(photo);
		serialize();
	}

	public void idPhotos(ArrayList<Photo> photos) {
		for (int i = 0; i < photos.size(); i++) {
			photos.get(i).setId(i);
		}
	}

	public ArrayList<PhotoButton> updateButtons(MainPanelGalerie panelGalerie, ArrayList<Photo> photos) {
		idPhotos(photos);
		ArrayList<PhotoButton> buttons = new ArrayList<PhotoButton>();
		for (int i = 0; i < photos.size(); i++) {
			buttons.add(new PhotoButton(photos.get(i)));
			buttons.get(i).setPreferredSize(new Dimension(122, 100));
			panelGalerie.addActionListenerAndToPanel(buttons, i);
		}

		return buttons;
	}

	public ArrayList<PhotoButton> addButton(MainPanelGalerie panelGalerie, ArrayList<Photo> photos) {

		idPhotos(photos);
		ArrayList<PhotoButton> buttons = new ArrayList<PhotoButton>();
		for (int i = 0; i < photos.size(); i++) {
			buttons.add(new PhotoButton(photos.get(i)));
			buttons.get(i).setPreferredSize(new Dimension(122, 100));
			panelGalerie.addActionListenerAndToPanel(buttons, i);
		}

		return buttons;
	}

	public void serialize() {
		try {
			FileOutputStream fos = new FileOutputStream("Galerie/Photos.serial");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(photos);
			oos.flush();
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Photo> deserialize() {
		try {
			FileInputStream in = new FileInputStream("Galerie/Photos.serial");
			ObjectInputStream ois = new ObjectInputStream(in);
			photos = (ArrayList<Photo>) ois.readObject();
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return photos;

	}

}
