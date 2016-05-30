package Frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicArrowButton;

import Elements.AddButton;
import Elements.BackButton;
import Elements.LayoutGalerieButton;
import Elements.PhotoButton;
import Galerie.Galerie;
import Galerie.Photo;

public class MainPanelGalerie extends JPanel {

	// for MainPanelGalerie
	public CardLayout c2 = new CardLayout();
	private JPanel galeriePanel = new JPanel(new BorderLayout());
	private OnePhotoPanel onePhotoPanel;

	// for galeriePanel
	private JPanel containerPhotos = new JPanel();
	private JPanel titlePanel = new JPanel();

	// for containerPhotos
	private ArrayList<PhotoButton> photoButtons = new ArrayList<PhotoButton>();
	private Image img;
	private Photo photo;
	private Galerie galerie = new Galerie();

	// for titlePanel
	private FlowLayout flTitle = new FlowLayout();
	private JPanel layoutGaleriePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private LayoutGalerieButton buttonLayout = new LayoutGalerieButton();
	private JPanel addPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel titleGaleriePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	private JLabel title = new JLabel("Galerie");
	private AddButton addButton = new AddButton();
	
	//Height and width photos


	public MainPanelGalerie() {
		// setMainPanel
		setPreferredSize(new Dimension(480, 1250));
		setLayout(new BorderLayout());

		// set containerPhotos
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setHgap(10);
		flowLayout.setVgap(10);
		containerPhotos.setLayout(flowLayout);

		// add images manually to gallery
		photoButtons = galerie.addButton(MainPanelGalerie.this, galerie.deserialize());

		// add containerPhoto and upPanel to galeriePanel
		galeriePanel.add(titlePanel, BorderLayout.NORTH);
		galeriePanel.add(containerPhotos);

		// set label title panel
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Arial", Font.PLAIN, 30));

		// add actionlistener for layoutButton
		buttonLayout.addActionListener(new Layout_Galerie());

		// set titlePanel
		layoutGaleriePanel.add(buttonLayout);
		layoutGaleriePanel.setBackground(Color.RED);
		addButton.addActionListener(new Add_Click());
		addPanel.add(addButton);
		addPanel.setBackground(Color.RED);
		titleGaleriePanel.add(title);
		titleGaleriePanel.setBackground(Color.RED);
		flTitle.setHgap(67);
		titlePanel.setBackground(Color.RED);
		titlePanel.setLayout(flTitle);
		titlePanel.add(buttonLayout);
		titlePanel.add(title);
		titlePanel.add(addPanel);

		// add panels to principal Panel
		setLayout(c2);
		add(galeriePanel, "galeriePanel");
		c2.show(MainPanelGalerie.this, "galeriePanel");

	}

	public void removePanel(JPanel panelRemove) {
		MainPanelGalerie.this.remove(panelRemove);
		MainPanelGalerie.this.revalidate();
		MainPanelGalerie.this.repaint();
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

	public JPanel getTitlePanel() {
		return titlePanel;
	}

	public void addActionListenerAndToPanel(ArrayList<PhotoButton> photoButtons, int index) {
		photoButtons.get(index).addActionListener(new Photo_Click());
		containerPhotos.removeAll();
		for (int i = 0; i < photoButtons.size(); i++) {
			containerPhotos.add(photoButtons.get(i));
			containerPhotos.revalidate();
			containerPhotos.repaint();
		}

	}

	public Photo createPhotoFit(Image img, Photo photo, String path) {
		try {
			img = ImageIO.read(new File(path));
			Image newimg = img.getScaledInstance(130, 100, Image.SCALE_SMOOTH);
			photo = new Photo(newimg);
			photo.widthPhoto = img.getWidth(this);
			photo.heightPhoto = img.getHeight(this);
			photo.setPath(path);
			return photo;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public void deletePhoto(ArrayList<Photo> photos, int index) {
		photos.remove(index);
		galerie.serialize();
		galerie.updateButtons(MainPanelGalerie.this, photos);
		galeriePanel.add(containerPhotos);
		c2.show(MainPanelGalerie.this, "galeriePanel");

	}

	class Layout_Galerie implements ActionListener {
		boolean flag = true;

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			flag = !flag;
			if (flag == false) {
				// modify size of buttons
				for (int i = 0; i < photoButtons.size(); i++) {
					photoButtons.get(i).setPreferredSize(new Dimension(90, 100));
					containerPhotos.add(photoButtons.get(i));
					containerPhotos.revalidate();
					containerPhotos.repaint();
				}
				galeriePanel.add(containerPhotos);
				add(galeriePanel, "galeriePanel");
				c2.show(MainPanelGalerie.this, "galeriePanel");
			} else {
				// modify size of buttons
				for (int i = 0; i < photoButtons.size(); i++) {
					photoButtons.get(i).setPreferredSize(new Dimension(122, 100));
					containerPhotos.add(photoButtons.get(i));
					containerPhotos.revalidate();
					containerPhotos.repaint();
				}
				galeriePanel.add(containerPhotos);
				add(galeriePanel, "galeriePanel");
				c2.show(MainPanelGalerie.this, "galeriePanel");
			}
		}
	}

	class Photo_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton button = (JButton) e.getSource();
			Photo photo = (Photo) button.getIcon();
			onePhotoPanel = new OnePhotoPanel(photo, MainPanelGalerie.this);
			add(onePhotoPanel, "onePhotoPanel");
			c2.show(MainPanelGalerie.this, "onePhotoPanel");
		}

	}

	class Add_Click implements ActionListener {

		@Override
		final public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			final JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, GIF, PNG, JPEG Images", "jpg", "gif",
					"png", "jpeg");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(getParent());
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				galerie.addPhoto(createPhotoFit(img, photo, chooser.getSelectedFile().getPath()));
				photoButtons = galerie.addButton(MainPanelGalerie.this, galerie.deserialize());
				galeriePanel.add(containerPhotos);
				c2.show(MainPanelGalerie.this, "galeriePanel");

			}
		}

	}

}
