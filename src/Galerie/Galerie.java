package Galerie;

import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

import Elements.PhotoButton;
import Frame.MainPanelGalerie;

public class Galerie {

	private ArrayList<Photo> photos = new ArrayList<Photo>();
	private ArrayList<String> name = new ArrayList<String>();
	private ArrayList<PhotoButton> photoButtons = new ArrayList<PhotoButton>();

	public ArrayList<PhotoButton> createPhotoButtons(MainPanelGalerie panelGalerie) {
		setNamesFromDirectory();
		for (int i = 0; i < name.size(); i++) {
			photos.add(panelGalerie.createPhotoFit(name.get(i)));
			photoButtons.add(new PhotoButton(photos.get(i)));
			photoButtons.get(i).setButtonSize(panelGalerie.getDimension());
			panelGalerie.addActionListener(photoButtons, i);
			panelGalerie.addButtonsToPanel(photoButtons, i);
		}
		idPhotos();

		return photoButtons;

	}

	public ArrayList<PhotoButton> updateButtons(MainPanelGalerie panelGalerie) {
		photos.clear();
		name.clear();
		photoButtons.clear();
		setNamesFromDirectory();

		panelGalerie.getContainerPhotos().removeAll();
		
		for (int i = 0; i < name.size(); i++) {
			photos.add(panelGalerie.createPhotoFit(name.get(i)));
			photoButtons.add(new PhotoButton(photos.get(i)));
			photoButtons.get(i).setButtonSize(panelGalerie.getDimension());
			panelGalerie.addActionListener(photoButtons, i);
			panelGalerie.addButtonsToPanel(photoButtons, i);
		}
		idPhotos();

		return photoButtons;

	}

	public void deletePhoto(MainPanelGalerie panelGalerie, int index, String chemin) {
		// remove from all ArrayList
		photos.remove(index);
		name.remove(index);
		photoButtons.remove(index);

		// delete the file in the Pictures folder
		File file = new File(chemin);
		Path path = file.toPath();
		try {
			Files.delete(path);
		} catch (NoSuchFileException x) {
			System.err.format("%s: no such" + " file or directory%n", path);
		} catch (DirectoryNotEmptyException x) {
			System.err.format("%s not empty%n", path);
		} catch (IOException x) {
			// File permission problems are caught here.
			System.err.println(x);
		}

		// add the buttons to ContainerPhotos
		panelGalerie.getContainerPhotos().removeAll();

		for (int i = 0; i < name.size(); i++) {
			panelGalerie.addButtonsToPanel(photoButtons, i);
		}

	}

	public void setNamesFromDirectory() {
		File folder = new File("Pictures/");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile())
				if (listOfFiles[i].getName().endsWith(".jpeg") || listOfFiles[i].getName().endsWith(".jpg")
						|| listOfFiles[i].getName().endsWith(".png"))
					name.add("Pictures/" + listOfFiles[i].getName());
		}
	}

	public void idPhotos() {
		for (int i = 0; i < photos.size(); i++) {
			photos.get(i).setId(i);
		}
	}

	// public ArrayList<PhotoButton> updateButtons(MainPanelGalerie
	// panelGalerie, ArrayList<Photo> photos) {
	// idPhotos(photos);
	// if (photos.size() == 0) {
	// panelGalerie.getContainerPhotos().removeAll();
	// return null;
	// }
	//
	// panelGalerie.getContainerPhotos().removeAll();
	//
	// ArrayList<PhotoButton> buttons = new ArrayList<PhotoButton>();
	// for (int i = 0; i < photos.size(); i++) {
	// buttons.add(new PhotoButton(photos.get(i)));
	// buttons.get(i).setPreferredSize(new Dimension(122, 100));
	// panelGalerie.addButtonsToPanel(buttons, i);
	// }
	//
	// return buttons;
	// }

	// public ArrayList<PhotoButton> addButton(MainPanelGalerie panelGalerie,
	// ArrayList<Photo> photos) {
	//
	// idPhotos(photos);
	// for (int i = 0; i < photos.size(); i++) {
	// System.out.println(photos.get(i).getId());
	// }
	//
	// panelGalerie.getContainerPhotos().removeAll();
	//
	// ArrayList<PhotoButton> buttons = new ArrayList<PhotoButton>();
	// for (int i = 0; i < photos.size(); i++) {
	// buttons.add(new PhotoButton(photos.get(i)));
	// buttons.get(i).setPreferredSize(new Dimension(122, 100));
	// panelGalerie.addActionListener(buttons, i);
	// panelGalerie.addButtonsToPanel(buttons, i);
	// }
	//
	// return buttons;
	// }
	//
	// public void serialize() {
	// try {
	// FileOutputStream fos = new FileOutputStream("Galerie/Photos.serial");
	// ObjectOutputStream oos = new ObjectOutputStream(fos);
	// oos.writeObject(photos);
	// oos.flush();
	// oos.close();
	// fos.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// @SuppressWarnings("unchecked")
	// public ArrayList<Photo> deserialize() {
	// try {
	// FileInputStream in = new FileInputStream("Galerie/Photos.serial");
	// ObjectInputStream ois = new ObjectInputStream(in);
	// photos = (ArrayList<Photo>) ois.readObject();
	// ois.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// } catch (ClassNotFoundException e) {
	// e.printStackTrace();
	// }
	//
	// return photos;
	//
	// }

}
