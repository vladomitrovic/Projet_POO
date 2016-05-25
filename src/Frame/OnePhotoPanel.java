package Frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

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

		// add to OnePhotoPanel
		add(upPhotoPanel, BorderLayout.NORTH);
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
}
