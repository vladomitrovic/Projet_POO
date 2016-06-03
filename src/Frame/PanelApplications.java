package Frame;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import Galerie.Photo;

public class PanelApplications extends JPanel {

	private FlowLayout fl = new FlowLayout(FlowLayout.LEFT, 7, 10);
	private Photo photo;

	public PanelApplications(Photo photo) {
		this.photo = photo;
		setLayout(fl);
	}

	public void setImage(Photo photo) {
		this.photo = photo;
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Image img = photo.getImage();
		g.drawImage(img, 0, 0, this);
	}

}
