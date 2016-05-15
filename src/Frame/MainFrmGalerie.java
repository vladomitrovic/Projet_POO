package Frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Galerie.Photo;

public class MainFrmGalerie extends BasiqueFrame {

	private JPanel containerPhotos = new JPanel();

	private JPanel upPanel = new JPanel();
	private JLabel label1 = new JLabel();
	private JLabel label2 = new JLabel();
	private JLabel label3 = new JLabel();
	private JLabel label4 = new JLabel();

	private Photo photo1 = new Photo("C:/Users/Aleksandar/Desktop/PhotosSmartphone/animal1.jpeg",
			"Photo d'un bébé porcinet...");
	private Photo photo2 = new Photo("C:/Users/Aleksandar/Desktop/PhotosSmartphone/paysage1.jpeg",
			"Cervin en arrière plan...");
	private Photo photo3 = new Photo("C:/Users/Aleksandar/Desktop/PhotosSmartphone/animal3.jpeg",
			"Singe faisant une grimace...");
	private Photo photo4 = new Photo("C:/Users/Aleksandar/Desktop/PhotosSmartphone/paysage3.jpeg",
			"Paysage paradisiaque...");

	public MainFrmGalerie() {

		// set Frame display
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		upPanel.setLayout(new GridLayout(2,3));

		// add the images to jLabel
		label1.setIcon(photo1);
		label2.setIcon(photo2);
		label3.setIcon(photo3);
		label4.setIcon(photo4);
		
		//modify size of labels
		label1.setPreferredSize(new Dimension(130,130));
		label2.setPreferredSize(new Dimension(130,130));
		label3.setPreferredSize(new Dimension(130,130));
		label4.setPreferredSize(new Dimension(130,130));

		// add labels to panel
		containerPhotos.add(label1);
		containerPhotos.add(label2);
		containerPhotos.add(label3);
		containerPhotos.add(label4);

		// add panels to frame
		add(upPanel, BorderLayout.SOUTH);
		add(containerPhotos);

		pack();

	}
}
