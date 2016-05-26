package Frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Elements.BackButton;
import Elements.TrashButton;
import Galerie.Photo;

public class OnePhotoPanel extends JPanel {

	private Image photo;
	private Photo photo1;
	private BackButton backButton = new BackButton();
	private JPanel upPhotoPanel = new JPanel(new GridLayout(1, 2));
	private JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel trashPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	private TrashButton trashButton = new TrashButton();

	// for the diaporama
	private JPanel previousImagePanel = new JPanel(new BorderLayout());
	private JButton previousImage = new JButton(new Photo("Pictures/leftArrow.png"));
	private JPanel nextImagePanel = new JPanel(new BorderLayout());
	private JButton nextImage = new JButton(new Photo("Pictures/rightArrow.png"));

	private MainPanelGalerie top;

	public OnePhotoPanel(Photo photo, MainPanelGalerie top) {
		photo1 = photo;
		this.top = top;
		setLayout(new BorderLayout());

		// add listeners to buttons
		backButton.addActionListener(new Back_PhotoClick());
		trashButton.addActionListener(new Delete_Click());

		// set backPanel
		backPanel.add(backButton);
		backPanel.setOpaque(false);

		// set trashPanel
		trashPanel.add(trashButton);
		trashPanel.setOpaque(false);

		// add to upPhotoPanel
		upPhotoPanel.add(backPanel);
		upPhotoPanel.add(trashPanel);
		upPhotoPanel.setOpaque(false);

		// set buttons for the diaporama
		previousImage.addActionListener(new PreviousImage_Click());
		nextImage.addActionListener(new NextImage_Click());
		previousImage.setVerticalAlignment(SwingConstants.CENTER);
		nextImage.setVerticalAlignment(SwingConstants.CENTER);
		setButtons(previousImage);
		setButtons(nextImage);

		if (photo1.getId() == 0)
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

		// set the img for the paintComponent
		this.photo = photo.getImage();

	}

	public void setButtons(JButton button) {
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setFocusPainted(false);
		button.setOpaque(false);
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
			top.removePanel(OnePhotoPanel.this);
		}

	}

	class Delete_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			top.deletePhoto(top.getGalerie().deserialize(), photo1.getId());
			top.removePanel(OnePhotoPanel.this);

		}

	}

	class PreviousImage_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			OnePhotoPanel.this.removeAll();
		}

	}

	class NextImage_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
}
