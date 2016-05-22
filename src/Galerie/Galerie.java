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

import Frame.MainPanelGalerie;

public class Galerie {

	private ArrayList<Photo> photos = new ArrayList<Photo>();
	private int cpt;

	public void addPhoto(Photo photo) {
		System.out.println(cpt);
		photos.add(photo);
		serialize();
	}

	public void addButton(MainPanelGalerie panelGalerie, ArrayList<Photo> photos, ArrayList<JButton> buttons) {
		for (int i = 0; i < photos.size(); i++) {
			buttons.add(new JButton(photos.get(i)));
			buttons.get(i).setBorderPainted(false);
			buttons.get(i).setContentAreaFilled(false);
			buttons.get(i).setFocusPainted(false);
			buttons.get(i).setOpaque(false);
			buttons.get(i).setPreferredSize(new Dimension(130, 100));
			panelGalerie.addActionListenerAndToPanel(buttons, i);
		}
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

	public int getCpt() {
		return cpt;
	}


}
