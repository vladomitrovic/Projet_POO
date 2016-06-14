package Frame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Galerie.Photo;

public class PanelApplications extends JPanel {

	private FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 7, 10);

	private Photo photo;

	public PanelApplications() {
		// preferences of panelApplications
		setLayout(fl);
		setBackground(Color.BLACK);
		setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.DARK_GRAY));

		// choose the picture in the wallpaper folder
		getPhotoWallpaper();
	}

	public void getPhotoWallpaper() {

		/**
		 * méthode qui va aller chercher la photo de fond d'écran dans le
		 * dossier wallpaper puis va aller la mettre dans un String qu'on
		 * utilisera pour générer la photo avec le chemin correspondant
		 */

		File folder = new File("./WallpaperApplication/");
		File[] image = folder.listFiles();
		String[] name = new String[image.length];
		name[0] = "./WallpaperApplication/" + image[0].getName();
		photo = new Photo(name[0]);

	}

	public void setImage(Photo photo) {

		/**
		 * méthode qui va modifier la photo dans le dossier wallpaper en cas de
		 * modification du fond d'écran
		 **/

		this.photo = photo;
		File from = new File(photo.getPath());
		File to = new File("WallpaperApplication/wallpaper.jpeg");
		try {
			Files.copy(from.toPath(), to.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub

		/**
		 * méthode qui va aller peindre le fond d'écran sur le panel en
		 * redimensionnant la photo à la taille du panel
		 **/

		super.paintComponent(g);
		Image img = photo.getImage();
		int frameWidth = this.getWidth();
		int frameHeight = this.getHeight();

		double imageWidth = img.getWidth(this);
		double imageHeight = img.getHeight(this);

		double newW = (imageWidth / imageHeight) * frameHeight;
		double newH = (imageHeight / imageWidth) * frameWidth;

		if (imageWidth > imageHeight) {
			double ratioWidth = imageWidth / frameWidth;
			imageWidth = frameWidth;
			imageHeight = (int) (imageHeight / ratioWidth);
			g.drawImage(img, (int) (frameWidth - imageWidth) / 2, (int) (frameHeight - imageHeight) / 2,
					(int) imageWidth, (int) newH, this);
		} else if (imageHeight > imageWidth) {
			double ratioHeight = imageHeight / frameHeight;
			imageHeight = frameHeight;
			imageWidth = (int) (imageWidth / ratioHeight);
			g.drawImage(img, (int) (frameWidth - imageWidth) / 2, (int) (frameHeight - imageHeight) / 2, (int) newW,
					(int) imageHeight, this);

		}
	}

}
