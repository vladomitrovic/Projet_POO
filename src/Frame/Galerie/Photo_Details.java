package Frame.Galerie;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Elements.BackButton;
import Elements.TrashButton;
import Elements.WallpaperButton;
import Galerie.Photo;

public class Photo_Details extends JPanel {

	private Photo photo;

	// upPhotoPanel with buttons
	private JPanel upPhotoPanel = new JPanel(new GridLayout(1, 3));
	private BackButton backButton = new BackButton();
	private TrashButton trashButton = new TrashButton();
	private WallpaperButton wallpaperButton = new WallpaperButton();

	// for the diaporama
	private JPanel previousImagePanel = new JPanel(new BorderLayout());
	private JButton previousImage = new JButton(new Photo("PicturesElements/leftArrow.png"));
	private JPanel nextImagePanel = new JPanel(new BorderLayout());
	private JButton nextImage = new JButton(new Photo("PicturesElements/rightArrow.png"));

	// for the paintComponenent
	private BufferedImage buffImage;
	private Galerie_Accueil top;

	public Photo_Details(Photo photo, Galerie_Accueil top) {
		this.photo = photo;
		this.top = top;
		setLayout(new BorderLayout());

		// add listeners to buttons
		backButton.addActionListener(new Back_PhotoClick());
		trashButton.addActionListener(new Delete_Click());
		wallpaperButton.addActionListener(new Wallpaper_Click());

		// set buttons
		backButton.setHorizontalAlignment(SwingConstants.LEFT);
		trashButton.setHorizontalAlignment(SwingConstants.RIGHT);

		// add to upPhotoPanel
		upPhotoPanel.add(backButton);
		upPhotoPanel.add(wallpaperButton);
		upPhotoPanel.add(trashButton);
		upPhotoPanel.setOpaque(false);

		// set buttons for the diaporama
		previousImage.addActionListener(new PreviousImage_Click());
		nextImage.addActionListener(new NextImage_Click());
		previousImage.setVerticalAlignment(SwingConstants.CENTER);
		nextImage.setVerticalAlignment(SwingConstants.CENTER);
		setButtons(previousImage);
		setButtons(nextImage);

		if (photo.getId() == 0 && photo.getId() == (top.getPhotoButtons().size() - 1)) {
			previousImage.setEnabled(false);
			nextImage.setEnabled(false);
		} else if (photo.getId() == 0)
			previousImage.setEnabled(false);
		else if (photo.getId() == (top.getPhotoButtons().size() - 1))
			nextImage.setEnabled(false);

		// add buttons to diaporama panels
		previousImagePanel.add(previousImage);
		previousImagePanel.setOpaque(false);
		nextImagePanel.add(nextImage);
		nextImagePanel.setOpaque(false);

		// add to OnePhotoPanel
		add(upPhotoPanel, BorderLayout.NORTH);
		add(previousImagePanel, BorderLayout.WEST);
		add(nextImagePanel, BorderLayout.EAST);
		setBackground(Color.BLACK);

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);

		Photo newPhoto = new Photo(photo.getPath());
		Image img = newPhoto.getImage();

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

	public void setButtons(JButton button) {
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.setOpaque(false);
	}

	class Back_PhotoClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			top.removePanel(Photo_Details.this);
		}
	}

	class Delete_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			top.getGalerie().deletePhoto(top, photo.getId(), photo.getPath());
			top.removePanel(Photo_Details.this);
		}

	}

	class PreviousImage_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			top.remove(Photo_Details.this);
			Photo previousPhoto = (Photo) top.getPhotoButtons().get(photo.getId() - 1).getIcon();
			Photo_Details photo_Details = new Photo_Details(previousPhoto, top);
			top.add(photo_Details, "newPhotoPanel");
			top.getCardLayout().show(top, "newPhotoPanel");
		}

	}

	class NextImage_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			top.remove(Photo_Details.this);
			Photo previousPhoto = (Photo) top.getPhotoButtons().get(photo.getId() + 1).getIcon();
			Photo_Details photo_Details = new Photo_Details(previousPhoto, top);
			top.add(photo_Details, "newPhotoPanel");
			top.getCardLayout().show(top, "newPhotoPanel");
		}

	}

	class Wallpaper_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			top.setImagePanelApplication(new Photo(photo.getPath()));
			JOptionPane.showMessageDialog(null, "Le fond d'écran a été modifié");

		}
	}
}
