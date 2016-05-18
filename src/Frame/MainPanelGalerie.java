package Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
	private JPanel containerPhotos = new JPanel();
	private Galerie galerie = new Galerie();
	private JButton[] photoButtons = new JButton[50];

	private Photo photo1 = new Photo("Pictures/animal1.jpeg");
	private Photo photo2 = new Photo("Pictures/paysage1.jpeg");
	private Photo photo3 = new Photo("Pictures/paysage3.jpeg");
	private Photo photo4 = new Photo("Pictures/paysage3.jpeg");
	private Photo photo5 = new Photo("Pictures/animal2.jpg");
	private Photo photo6 = new Photo("Pictures/paysage2.jpeg");
	private Photo photo7 = new Photo("Pictures/ville1.jpeg");
	private TopBarPanel topBar = new TopBarPanel();
	private JPanel top;
	private JPanel photoPanel;

	public MainPanelGalerie(JPanel top) {
		this.top = top;
		// setMainPanel
		setPreferredSize(new Dimension(480, 800));
		setLayout(new BorderLayout());

		// set containerPhotos
		FlowLayout flowLayout = new FlowLayout();
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

		// add panels to principal Panel
		add(topBar, BorderLayout.NORTH);
		add(containerPhotos);

	}

	class TopBarPanel extends JPanel {
		private JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		private JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		private Photo backPhoto = new Photo("Pictures/back.png");
		private JButton backButton = new JButton(backPhoto);
		private Photo addPhoto = new Photo("Pictures/plus-button.png");
		private JButton addButton = new JButton(addPhoto);

		public TopBarPanel() {
			setLayout(new GridLayout(1, 2));
			leftPanel.setBackground(Color.DARK_GRAY);
			rightPanel.setBackground(Color.DARK_GRAY);

			// set backButton
			backButton.setBorderPainted(false);
			backButton.setContentAreaFilled(false);
			backButton.setFocusPainted(false);
			backButton.setOpaque(false);
			backButton.addActionListener(new BackDesktop_Click());
			backButton.setPreferredSize(new Dimension(24, 24));

			// set addButton
			addButton.setBorderPainted(false);
			addButton.setContentAreaFilled(false);
			addButton.setFocusPainted(false);
			addButton.setOpaque(false);
			addButton.setPreferredSize(new Dimension(24, 24));
			// addButton.addActionListener(new Back_Click());

			// addButons to leftPanel

			leftPanel.add(backButton, FlowLayout.LEFT);
			rightPanel.add(addButton);

			// add to TopBarPanel
			add(leftPanel);
			add(rightPanel);

		}
	}

	class BackDesktop_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			MainPanelGalerie.this.setVisible(false);
			top.setVisible(true);

		}

	}

	class PhotoPanel extends JPanel {

		private Image photo;
		private Photo backPhoto = new Photo("Pictures/back.png");
		private JButton backButton = new JButton(backPhoto);
		private JPanel upPanel = new JPanel();
		private JPanel top;

		public PhotoPanel(Photo photo) {
			this.top = top;
			setLayout(new BorderLayout());
			backButton.setBorderPainted(false);
			backButton.setContentAreaFilled(false);
			backButton.setFocusPainted(false);
			backButton.setOpaque(false);
			backButton.addActionListener(new Back_PhotoClick());
			upPanel.add(backButton);
			add(upPanel, BorderLayout.NORTH);
			this.photo = photo.getImage();

		}

		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			g.drawImage(photo, 0, 0, getWidth(), getHeight(), this);
		}

		class Back_PhotoClick implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainPanelGalerie.this.remove(photoPanel);
				containerPhotos.setVisible(true);
				topBar.setVisible(true);
			}

		}
	}

	class Photo_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			containerPhotos.setVisible(false);
			topBar.setVisible(false);
			JButton button = (JButton) e.getSource();
			Photo photo = (Photo) button.getIcon();
			photoPanel = new PhotoPanel(photo);
			add(photoPanel);
		}

	}

}
