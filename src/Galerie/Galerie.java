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
import Frame.Contact.Contact_Image;
import Frame.Galerie.Galerie_Accueil;

public class Galerie<Contact_image> {

	private ArrayList<Photo> photos = new ArrayList<Photo>();
	private ArrayList<String> name = new ArrayList<String>();
	private ArrayList<PhotoButton> photoButtons = new ArrayList<PhotoButton>();

	public ArrayList<PhotoButton> createPhotoButtons(Galerie_Accueil panelGalerie) {
		/**
		 * méthode qui va aller chercher le "path" des photos grâce à la méthode
		 * setNamesFromDirectory(); puis qui va créér une arraylist de photo et
		 * de photoboutons en les ajoutant directement au bon Panel et en y
		 * ajoutant les actionListener
		 **/
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

	public ArrayList<PhotoButton> createPhotoContact(Contact_Image listImage, Galerie_Accueil galerie) {
		/**
		 * méthode similaire à la précédente sauf utilisée pour le choix des
		 * images pour un contact
		 **/
		setNamesFromDirectory();
		for (int i = 0; i < name.size(); i++) {
			photos.add(galerie.createPhotoFit(name.get(i)));
			photoButtons.add(new PhotoButton(photos.get(i)));
			photoButtons.get(i).setButtonSize(galerie.getDimension());
			listImage.addButtonsToPanel(photoButtons, i);

		}
		idPhotos();

		return photoButtons;

	}

	public ArrayList<PhotoButton> updateButtons(Galerie_Accueil panelGalerie) {
		/**
		 * méthode qui va mettre à jour les boutons lors de la suppression d'une
		 * photo afin de remettre à jour tous les index etc
		 **/
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

	public void deletePhoto(Galerie_Accueil panelGalerie, int index, String chemin) {
		/** méthode qui va aller supprimer la photo du dossier **/

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

		idPhotos();

		// add the buttons to ContainerPhotos
		panelGalerie.getContainerPhotos().removeAll();

		for (int i = 0; i < name.size(); i++) {
			panelGalerie.addButtonsToPanel(photoButtons, i);
		}

	}

	public void setNamesFromDirectory() {
		/**
		 * méthode qui va aller chercher le nom de toutes les photos contenus
		 * dans le dossier Pictuers puis mettra le chemin dans une arraylist de
		 * String qu'on réutilisera lors de la création des photos
		 **/
		File folder = new File("Pictures/");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile())
				if (listOfFiles[i].getName().endsWith(".jpeg") 
						|| listOfFiles[i].getName().endsWith(".jpg")
						|| listOfFiles[i].getName().endsWith(".png") || listOfFiles[i].getName().endsWith(".PNG")
						|| listOfFiles[i].getName().endsWith(".gif"))
					name.add("Pictures/" + listOfFiles[i].getName());
		}
	}

	public void idPhotos() {
		for (int i = 0; i < photos.size(); i++) {
			photos.get(i).setId(i);
		}
	}

}
