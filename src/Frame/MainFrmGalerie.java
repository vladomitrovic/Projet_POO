package Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

public class MainFrmGalerie extends BasiqueFrame {

	private JPanel containerPhotos = new JPanel();
	private JPanel upPanel = new JPanel();

	private JLabel label1 = new JLabel();
	private JLabel label2 = new JLabel();
	private JLabel label3 = new JLabel();
	private JLabel label4 = new JLabel();
	private JLabel label5 = new JLabel();
	private JLabel label6 = new JLabel();
	private JLabel label7 = new JLabel();

	private Galerie galerie = new Galerie();

	private ImageIcon photo1 = new Photo(
			new ImageIcon("Pictures/animal1.jpeg").getImage().getScaledInstance(150, 130, Image.SCALE_DEFAULT));
	private ImageIcon photo2 = new Photo(
			new ImageIcon("Pictures/paysage1.jpeg").getImage().getScaledInstance(150, 130, Image.SCALE_DEFAULT));
	private ImageIcon photo3 = new Photo(
			new ImageIcon("Pictures/animal3.jpeg").getImage().getScaledInstance(150, 130, Image.SCALE_DEFAULT));
	private ImageIcon photo4 = new Photo(
			new ImageIcon("Pictures/paysage3.jpeg").getImage().getScaledInstance(150, 130, Image.SCALE_DEFAULT));
	private ImageIcon photo5 = new Photo(
			new ImageIcon("Pictures/animal2.jpg").getImage().getScaledInstance(150, 130, Image.SCALE_DEFAULT));
	private ImageIcon photo6 = new Photo(
			new ImageIcon("Pictures/paysage2.jpeg").getImage().getScaledInstance(150, 130, Image.SCALE_DEFAULT));
	private ImageIcon photo7 = new Photo(
			new ImageIcon("Pictures/ville1.jpeg").getImage().getScaledInstance(150, 130, Image.SCALE_DEFAULT));

	private BasicArrowButton backButton = new BasicArrowButton(BasicArrowButton.WEST);
	private JButton addButton = new JButton("+");

	public MainFrmGalerie() {

		// set Frame display
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// set containerPhotos

		// add images to gallery
		galerie.addPhoto((Photo) photo1);
		galerie.addPhoto((Photo) photo2);
		galerie.addPhoto((Photo) photo3);
		galerie.addPhoto((Photo) photo4);

		// add the images to jLabel
		label1.setIcon(photo1);
		label2.setIcon(photo2);
		label3.setIcon(photo3);
		label4.setIcon(photo4);
		label5.setIcon(photo5);
		label6.setIcon(photo6);
		label7.setIcon(photo7);

		//add listener to jLabels
		label1.addMouseListener(new Mouse_Click());

		// add labels to photo's panel
		containerPhotos.add(label1);
		containerPhotos.add(label2);
		containerPhotos.add(label3);
		containerPhotos.add(label4);
		containerPhotos.add(label5);
		containerPhotos.add(label6);
		containerPhotos.add(label7);

		// modify buttons for upPanel
		backButton.setAlignmentY(LEFT_ALIGNMENT);
		backButton.setAlignmentY(RIGHT_ALIGNMENT);
		backButton.addActionListener(new Back_Click());

		// modify the upPanel
		upPanel.add(backButton);
		upPanel.add(addButton);

		// add panels to frame
		add(upPanel, BorderLayout.NORTH);
		add(containerPhotos);

		pack();

	}

	class Back_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			setVisible(false);
			Launcher launcher = new Launcher();
			launcher.setVisible(true);
		}

	}

	class Mouse_Click extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {

		}
	}

}
