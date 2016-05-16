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

public class MainFrmGalerie extends BasiqueFrame {

	private JPanel containerPhotos = new JPanel();
	private JPanel upPanel = new JPanel();

	private Galerie galerie = new Galerie();

	private ImageIcon photo1 = new Photo(
			new ImageIcon("Pictures/animal1.jpeg").getImage().getScaledInstance(123, 130, Image.SCALE_DEFAULT));

	private JButton[] buttons = new JButton[50];

	private ImageIcon photo2 = new Photo(
			new ImageIcon("Pictures/paysage1.jpeg").getImage().getScaledInstance(123, 130, Image.SCALE_DEFAULT));
	private ImageIcon photo3 = new Photo(
			new ImageIcon("Pictures/animal3.jpeg").getImage().getScaledInstance(123, 130, Image.SCALE_DEFAULT));
	private ImageIcon photo4 = new Photo(
			new ImageIcon("Pictures/paysage3.jpeg").getImage().getScaledInstance(123, 130, Image.SCALE_DEFAULT));
	private ImageIcon photo5 = new Photo(
			new ImageIcon("Pictures/animal2.jpg").getImage().getScaledInstance(123, 130, Image.SCALE_DEFAULT));
	private ImageIcon photo6 = new Photo(
			new ImageIcon("Pictures/paysage2.jpeg").getImage().getScaledInstance(123, 130, Image.SCALE_DEFAULT));
	private ImageIcon photo7 = new Photo(
			new ImageIcon("Pictures/ville1.jpeg").getImage().getScaledInstance(123, 130, Image.SCALE_DEFAULT));

	private BasicArrowButton backButton = new BasicArrowButton(BasicArrowButton.WEST);
	private JButton addButton = new JButton("+");

	public MainFrmGalerie() {

		// set Frame display
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// set containerPhotos
		FlowLayout flowLayout = new FlowLayout() ;
		flowLayout.setHgap(0);
		flowLayout.setVgap(0);
		containerPhotos.setLayout(flowLayout);
		
		// add images to gallery and to buttons
		galerie.addPhoto((Photo) photo1, buttons);
		galerie.addPhoto((Photo) photo2, buttons);
		galerie.addPhoto((Photo) photo3, buttons);
		galerie.addPhoto((Photo) photo4, buttons);
		galerie.addPhoto((Photo) photo5, buttons);
		galerie.addPhoto((Photo) photo6, buttons);
		galerie.addPhoto((Photo) photo7, buttons);

		// add listener to Jbuttons
		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i] != null)
				buttons[i].addActionListener(new Photo_Click());
		}

		// add buttons to photo's panel
		for (int i = 0; i < buttons.length; i++) {
			if (buttons[i] != null)
				containerPhotos.add(buttons[i]);
		}

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

	class PhotoFrame extends BasiqueFrame {

		private JLabel label = new JLabel();

		public PhotoFrame(Object source) {
		}

	}

	class Photo_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

}
