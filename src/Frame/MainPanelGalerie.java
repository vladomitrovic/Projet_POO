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

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicArrowButton;

import Galerie.Galerie;
import Galerie.Photo;

public class MainPanelGalerie extends JPanel {
	public CardLayout c2 = new CardLayout();
	private JPanel galeriePanel = new JPanel(new BorderLayout());
	private JPanel containerPhotos = new JPanel();
	private JPanel titlePanel = new JPanel();
	private FlowLayout flTitle = new FlowLayout();
	private JLabel title = new JLabel("Galerie");

	private Galerie galerie = new Galerie();
	private JButton[] photoButtons = new JButton[50];

	private Photo photo1 = new Photo("Pictures/animal1.jpeg");
	private Photo photo2 = new Photo("Pictures/paysage1.jpeg");
	private Photo photo3 = new Photo("Pictures/paysage3.jpeg");
	private Photo photo4 = new Photo("Pictures/paysage3.jpeg");
	private Photo photo5 = new Photo("Pictures/animal2.jpg");
	private Photo photo6 = new Photo("Pictures/paysage2.jpeg");
	private Photo photo7 = new Photo("Pictures/ville1.jpeg");

	private Photo addPhoto = new Photo("Pictures/plus-button.png");
	private JButton addButton = new JButton(addPhoto);
	private Photo backPhoto = new Photo("Pictures/back.png");
	private JButton backButton = new JButton(backPhoto);
	private OnePhotoPanel onePhotoPanel;

	public MainPanelGalerie() {
		
		// setMainPanel
		addButton.setLayout(new FlowLayout(new FlowLayout().RIGHT));
		addButton.setBackground(Color.BLACK);
		setPreferredSize(new Dimension(480, 800));
		setLayout(new BorderLayout());

		// set label title panel
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Serif", Font.PLAIN, 30));
		// title.setPreferredSize(new Dimension(20,35));

		// set titlePanel
		flTitle.setAlignment(FlowLayout.CENTER);
		titlePanel.setLayout(flTitle);
		titlePanel.setBackground(Color.RED);
		titlePanel.add(title);

		// set containerPhotos
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setHgap(10);
		flowLayout.setVgap(10);
		containerPhotos.setLayout(flowLayout);

		// add images to gallery and to buttons
		galerie.addPhoto((Photo) photo1, photoButtons);
		galerie.addPhoto((Photo) photo2, photoButtons);
		galerie.addPhoto((Photo) photo3, photoButtons);
		galerie.addPhoto((Photo) photo4, photoButtons);
		galerie.addPhoto((Photo) photo5, photoButtons);
		galerie.addPhoto((Photo) photo6, photoButtons);
		galerie.addPhoto((Photo) photo7, photoButtons);

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

		// set the buttons for upGaleriePanel
		addButton.setBorderPainted(false);
		addButton.setContentAreaFilled(false);
		addButton.setFocusPainted(false);
		addButton.setOpaque(false);

		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.setOpaque(false);

		// set the upGaleriePanel

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

	public JPanel getContainerPhotos() {
		return containerPhotos;
	}

	public JPanel getTitlePanel() {
		return titlePanel;
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
