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

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicArrowButton;

import Elements.AddButton;
import Elements.BackButton;
import Elements.LayoutGalerieButton;
import Galerie.Galerie;
import Galerie.Photo;

public class MainPanelGalerie extends JPanel {
	public CardLayout c2 = new CardLayout();
	private JPanel galeriePanel = new JPanel(new BorderLayout());
	private JPanel containerPhotos = new JPanel();
	private JPanel titlePanel = new JPanel();
	private FlowLayout flTitle = new FlowLayout();
	private JPanel layoutGaleriePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPopupMenu menu = new JPopupMenu();
	private LayoutGalerieButton buttonLayout = new LayoutGalerieButton();
	private JPanel addPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel titleGaleriePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	private JLabel title = new JLabel("Galerie");

	private Galerie galerie = new Galerie();
	private JButton[] photoButtons = new JButton[50];
	private Photo photo1;
	private Photo photo2;
	private Photo photo3;
	private Photo photo4;

	private OnePhotoPanel onePhotoPanel;

	private Image img;

	public MainPanelGalerie() {

		// setMainPanel
		setPreferredSize(new Dimension(480, 800));
		setLayout(new BorderLayout());

		// set label title panel
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Arial", Font.PLAIN, 30));
		// title.setPreferredSize(new Dimension(20,35));

		// set the popup for the layoutGalerie
		menu.add("2 : 3");
		menu.add("4 : 3");

		// add actionlistener for layoutButton
		buttonLayout.addMouseListener(new Galerie_Layout());

		// set titlePanel
		layoutGaleriePanel.add(buttonLayout);
		layoutGaleriePanel.setBackground(Color.RED);
		addPanel.add(new AddButton());
		addPanel.setBackground(Color.RED);
		titleGaleriePanel.add(title);
		titleGaleriePanel.setBackground(Color.RED);
		flTitle.setHgap(67);
		titlePanel.setBackground(Color.RED);
		titlePanel.setLayout(flTitle);
		titlePanel.add(new LayoutGalerieButton());
		titlePanel.add(title);
		titlePanel.add(addPanel);

		// set containerPhotos
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setHgap(10);
		flowLayout.setVgap(10);
		containerPhotos.setLayout(flowLayout);

		// add images to gallery and to buttons
		galerie.addPhoto(createPhotoFit(img, photo1, "Pictures/animal1.jpeg"), photoButtons);
		galerie.addPhoto(createPhotoFit(img, photo2, "Pictures/animal2.jpg"), photoButtons);
		galerie.addPhoto(createPhotoFit(img, photo3, "Pictures/ville1.jpeg"), photoButtons);
		galerie.addPhoto(createPhotoFit(img, photo4, "Pictures/paysage3.jpeg"), photoButtons);

		// modify size of buttons
		for (int i = 0; i < photoButtons.length; i++) {
			if (photoButtons[i] != null)
				photoButtons[i].setPreferredSize(new Dimension(130, 100));
		}

		// add listener to Jbuttons
		for (int i = 0; i < photoButtons.length; i++) {
			if (photoButtons[i] != null)
				photoButtons[i].addActionListener(new Photo_Click());
		}

		// add buttons to photo's panel
		for (int i = 0; i < photoButtons.length; i++) {
			if (photoButtons[i] != null)
				containerPhotos.add(photoButtons[i]);
		}


		// add containerPhoto and upPanel to galeriePanel
		galeriePanel.add(titlePanel, BorderLayout.NORTH);
		galeriePanel.add(containerPhotos);

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

	public void createPhotos() {

	}

	public JPanel getContainerPhotos() {
		return containerPhotos;
	}

	public JPanel getTitlePanel() {
		return titlePanel;
	}

	public Photo createPhotoFit(Image img, Photo photo, String path) {
		try {
			img = ImageIO.read(new File(path));
			Image newimg = img.getScaledInstance(130, 100, Image.SCALE_SMOOTH);
			photo = new Photo(newimg);
			photo.setPath(path);
			return photo;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	class Galerie_Layout extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			menu.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	class Layout_Galerie implements ActionListener {
		boolean flag = true;

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			flag = !flag;
			if (flag == true) {
				for (int i = 0; i < photoButtons.length; i++) {
					if (photoButtons[i] != null)
						photoButtons[i].setPreferredSize(new Dimension(130, 100));
				}

				for (int i = 0; i < photoButtons.length; i++) {
					if (photoButtons[i] != null)
						containerPhotos.add(photoButtons[i]);
				}
				galeriePanel.add(containerPhotos);

			} else {
				for (int i = 0; i < photoButtons.length; i++) {
					if (photoButtons[i] != null)
						photoButtons[i].setPreferredSize(new Dimension(80, 80));

				}

				for (int i = 0; i < photoButtons.length; i++) {
					if (photoButtons[i] != null)
						containerPhotos.add(photoButtons[i]);
				}
				galeriePanel.add(containerPhotos);

				

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
}
