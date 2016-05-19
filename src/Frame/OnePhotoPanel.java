package Frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Galerie.Photo;

public class OnePhotoPanel extends JPanel {

	private Image photo;
	private Photo backPhoto = new Photo("Pictures/back.png");
	private JButton backButton = new JButton(backPhoto);
	private JPanel upPhotoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private MainPanelGalerie top;

	public OnePhotoPanel(Photo photo, MainPanelGalerie top) {
		this.top = top;
		setLayout(new BorderLayout());
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.setOpaque(false);
		backButton.addActionListener(new Back_PhotoClick());
		upPhotoPanel.add(backButton);
		upPhotoPanel.setOpaque(false);
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
}
