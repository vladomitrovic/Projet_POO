package Galerie;

import java.awt.Dimension;

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
	}

	public int getCpt() {
		return cpt;
	}

	public Photo[] getPhotos() {
		return photos;
	}

}
