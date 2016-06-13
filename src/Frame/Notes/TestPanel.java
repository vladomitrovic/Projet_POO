package Frame.Notes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import Galerie.Photo;

public class TestPanel extends JPanel {

	private Photo photo;

	public TestPanel(Photo photo) {
		this.photo = photo;
		setPreferredSize(new Dimension(425,6422));
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Image img = photo.getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}

}
