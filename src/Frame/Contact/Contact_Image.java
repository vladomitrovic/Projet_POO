package Frame.Contact;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Elements.BackButton;
import Elements.PhotoButton;
import Elements.TopTitleBar;
import Elements.TrashButton;
import Elements.WrapLayout;
import Frame.Galerie.Galerie_Accueil;
import Galerie.Galerie;
import Galerie.Photo;

public class Contact_Image extends JPanel {

	private JPanel imagesPanel = new JPanel();
	private JScrollPane scrollPane = new JScrollPane(imagesPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private TopTitleBar topPanel = new TopTitleBar(new BackButton(), new Return_Click(), "", new TrashButton(),
			new Trash_Click(), new Color(128, 128, 255));
	private Galerie galerie = new Galerie();
	private Photo defaultPhoto = new Photo("PicturesElements/default_Contact.png");
	private Contact_Details top;
	private int id;

	public Contact_Image(int id, Contact_Details top) {
		this.id = id;
		this.top = top;
		setLayout(new BorderLayout());

		add(topPanel, BorderLayout.NORTH);
		add(scrollPane);
		topPanel.getRightButton().setToolTipText("Image par d�faut");

		imagesPanel.setLayout(new WrapLayout(FlowLayout.LEFT, 5, 5));

		// if already default, default button disabled
		if (top.getCarnet().getCarnet().get(id).getPhoto().getPath().equals("PicturesElements/default_Contact.png")) {
			topPanel.getRightButton().setEnabled(false);
		}

		galerie.createPhotoContact(Contact_Image.this, new Galerie_Accueil());

	}

	public void addButtonsToPanel(ArrayList<PhotoButton> photoButtons, int index) {
		/*
		 * M�thode utiliser par createPhotoContact afin de resortir toutes les
		 * images
		 */
		imagesPanel.add(photoButtons.get(index));
		photoButtons.get(index).addActionListener(new Choose_Click());

	}

	class Choose_Click implements ActionListener {
		/*
		 * Lors du choix de l'image, on r�cup�re la photo du boutton, puis on
		 * l'applique au contact. On s�rialise
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			Photo photo = (Photo) button.getIcon();
			top.getCarnet().getCarnet().get(id).setPhoto(photo.getPath());
			top.getCarnet().serialize();
			top.remove(Contact_Image.this);
			top.setPicture(photo.getPath());

		}

	}

	class Return_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			top.remove(Contact_Image.this);
		}

	}

	class Trash_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			top.getCarnet().getCarnet().get(id).setPhoto("PicturesElements/default_Contact.png");
			top.getCarnet().serialize();
			top.remove(Contact_Image.this);
			top.setPicture("PicturesElements/default_Contact.png");

		}

	}

}
