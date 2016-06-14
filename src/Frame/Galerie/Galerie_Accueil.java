package Frame.Galerie;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Elements.AddButton;
import Elements.LayoutGalerieButton;
import Elements.PhotoButton;
import Elements.TopTitleBar;
import Elements.WrapLayout;
import Frame.PanelApplications;
import Galerie.Galerie;
import Galerie.Photo;

public class Galerie_Accueil extends JPanel {

	// for MainPanelGalerie
	public CardLayout c2 = new CardLayout();
	private JPanel galeriePanel = new JPanel(new BorderLayout());
	private Photo_Details photo_Details;

	// for galeriePanel
	private JPanel containerPhotos = new JPanel();
	private TopTitleBar titlePanel = new TopTitleBar(new LayoutGalerieButton(), new Layout_Galerie(), "Galerie",
			new AddButton(), new Add_Click(), Color.RED);

	// for containerPhotos
	private ArrayList<PhotoButton> photoButtons = new ArrayList<PhotoButton>();
	private JScrollPane scroll = new JScrollPane(containerPhotos, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private Galerie galerie = new Galerie();

	private int width = 128;
	private int height = 115;
	private Dimension dimension = new Dimension(width, height);

	private PanelApplications top;

	public Galerie_Accueil(PanelApplications top) {
		this.top = top;

		// set containerPhotos
		WrapLayout flowLayout = new WrapLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setHgap(5);
		flowLayout.setVgap(5);
		containerPhotos.setLayout(flowLayout);

		// add photoButtons to gallery
		photoButtons = galerie.createPhotoButtons(Galerie_Accueil.this);

		// add containerPhoto and upPanel to galeriePanel
		galeriePanel.add(titlePanel, BorderLayout.NORTH);
		galeriePanel.add(scroll);

		// add panels to MainPanelGalerie
		setLayout(c2);
		add(galeriePanel, "galeriePanel");
		c2.show(Galerie_Accueil.this, "galeriePanel");

	}

	public Galerie_Accueil() {

	}

	public void removePanel(JPanel panelRemove) {
		/**
		 * m�thode qui va aller supprimer le panel mis en param�tre
		 */
		Galerie_Accueil.this.remove(panelRemove);
		Galerie_Accueil.this.revalidate();
		Galerie_Accueil.this.repaint();
	}

	public void setImagePanelApplication(Photo photo) {
		/**
		 * m�thode qui va modifier le fond d'�cran du panelApplications
		 */
		top.setImage(photo);
	}

	public Dimension getDimension() {
		return dimension;
	}

	public Galerie getGalerie() {
		return galerie;
	}

	public ArrayList<PhotoButton> getPhotoButtons() {
		return photoButtons;
	}

	public JPanel getContainerPhotos() {
		return containerPhotos;
	}

	public CardLayout getCardLayout() {
		return c2;
	}

	public void addActionListener(ArrayList<PhotoButton> photoButtons, int index) {
		// ajout des actionlistener au boutons photos
		photoButtons.get(index).addActionListener(new Photo_Click());

	}

	public void addButtonsToPanel(ArrayList<PhotoButton> photoButtons, int index) {
		// ajout des photo boutons au panel contenant toutes les photos
		containerPhotos.add(photoButtons.get(index));
		containerPhotos.revalidate();
		containerPhotos.repaint();
	}

	public Photo createPhotoFit(String path) {
		/**
		 * Cr�ation d'une photo qui va se redimensionner � la taille des
		 * boutons, afin que l'image ne soit pas coup�e lors de la cr�ation des
		 * toutes nos photos dans la galerie
		 **/
		Photo photo = new Photo(path);
		Image img = photo.getImage();
		Image newimg = img.getScaledInstance(width, height, Image.SCALE_FAST);
		photo = new Photo(newimg);
		photo.setPath(path);
		return photo;

	}

	class Layout_Galerie implements ActionListener {
		/**
		 * Modification du layout de la galerie, une premi�re fois en 3 photos
		 * par Colonne puis en deuxi�me temps en 4 photos par colonne
		 **/
		boolean flag = true;

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			flag = !flag;
			if (flag == false) {
				// modify size of buttons
				for (int i = 0; i < photoButtons.size(); i++) {
					width = 93;
					height = 108;
					dimension.width = width;
					dimension.height = height;
					photoButtons.get(i).setButtonSize(dimension);
				}
				containerPhotos.revalidate();
				containerPhotos.repaint();
			} else {
				// modify size of buttons
				for (int i = 0; i < photoButtons.size(); i++) {
					width = 128;
					height = 115;
					dimension.width = width;
					dimension.height = height;
					photoButtons.get(i).setButtonSize(dimension);
				}
				containerPhotos.revalidate();
				containerPhotos.repaint();
			}
		}
	}

	class Photo_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton button = (JButton) e.getSource();
			Photo photo = (Photo) button.getIcon();
			photo_Details = new Photo_Details(photo, Galerie_Accueil.this);
			add(photo_Details, "onePhotoPanel");
			c2.show(Galerie_Accueil.this, "onePhotoPanel");
		}

	}

	private static void copyFile(File source, File dest) {
		try {
			Files.copy(source.toPath(), dest.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class Add_Click implements ActionListener {

		@Override
		final public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			final JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, GIF, PNG, JPEG Images", "jpg", "gif",
					"png", "jpeg", "PNG");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(getParent());
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File source = new File(chooser.getSelectedFile().getAbsolutePath());
				File dest = new File("Pictures/" + chooser.getSelectedFile().getName());
				copyFile(source, dest);
				galerie.updateButtons(Galerie_Accueil.this);
			}
		}

	}
	
	public void refreshPhotoButton(){
		galerie.updateButtons(Galerie_Accueil.this);

	}

}
