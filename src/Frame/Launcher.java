package Frame;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Elements.ApplicationButton;
import Elements.HomeButton;
import Elements.ScreenShotButton;
import Elements.TopBarPanel;
import Frame.Contact.Contact_Carnet;
import Frame.Galerie.Galerie_Accueil;
import Frame.Notes.Notes_Accueil;
import Galerie.Photo;

public class Launcher extends JFrame {

	// TopBarPanel
	private TopBarPanel topBar = new TopBarPanel();

	// pour le cadre (sud est west)
	private JPanel west = new JPanel();
	private JPanel est = new JPanel();
	private JPanel south = new JPanel();
	private FlowLayout flSouth = new FlowLayout();
	private HomeButton homeButton = new HomeButton();
	private ScreenShotButton screenShot = new ScreenShotButton();

	// Panel parent pour cardLayout
	public CardLayout c1 = new CardLayout();
	public JPanel mainContainer = new JPanel();

	// panel pour les applications
	private PanelApplications panelApplication = new PanelApplications();

	// Boutons pour applications
	private ApplicationButton btnContacts = new ApplicationButton(new Photo("PicturesElements/phone-book.png"));
	private ApplicationButton btnGalerie = new ApplicationButton(new Photo("PicturesElements/gallery.png"));
	private ApplicationButton btnNotes = new ApplicationButton(new Photo("PicturesElements/note.png"));

	private Galerie_Accueil galerie = new Galerie_Accueil(panelApplication);
	private Contact_Carnet carnet = new Contact_Carnet();
	private Notes_Accueil notes = new Notes_Accueil();

	public Launcher() {

		// Préferences de la frame principale
		setPreferredSize(new Dimension(480, 800));
		setSize(480, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		// setAlwaysOnTop(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// ajout des actionlistener sur les boutons
		btnGalerie.addActionListener(new Galerie_Click());
		btnContacts.addActionListener(new Contact_Click());
		btnNotes.addActionListener(new Notes_Click());

		// ajout des boutons à la frame
		panelApplication.add(btnContacts);
		panelApplication.add(btnGalerie);
		panelApplication.add(btnNotes);

		// create the border
		createBorder();

		// modification du bouton home et ajout au southLayout
		south.setLayout(new GridLayout(1, 3));
		homeButton.addActionListener(new Home_Click());
		screenShot.addActionListener(new ScreenShot());
		south.add(screenShot);
		south.add(homeButton);
		south.add(screenShot, BorderLayout.EAST);

		// ajout de mes panels pour cardLayout
		mainContainer.setLayout(c1);
		mainContainer.add(panelApplication, "panelApplications");
		c1.show(mainContainer, "panelLauncher");

		// ajout de tout mes panels à la frame
		add(topBar, BorderLayout.NORTH);
		add(est, BorderLayout.EAST);
		add(west, BorderLayout.WEST);
		add(south, BorderLayout.SOUTH);
		add(mainContainer);

		pack();

	}

	public void createBorder() {
		/**
		 * méthode utilisée pour créer les bordures noires du téléphone
		 **/

		west.setPreferredSize(new Dimension(25, 100));
		west.setBackground(Color.BLACK);

		est.setPreferredSize(new Dimension(25, 100));
		est.setBackground(Color.BLACK);

		south.setBackground(Color.BLACK);
		flSouth.setAlignment(flSouth.CENTER);
		south.setLayout(flSouth);
	}

	class Home_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			c1.show(mainContainer, "panelApplications");
		}

	}

	class Galerie_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mainContainer.add(galerie, "galerie");
			c1.show(mainContainer, "galerie");
		}

	}

	class Contact_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// carnet = new Contact_Carnet();
			mainContainer.add(carnet, "carnet");
			c1.show(mainContainer, "carnet");

		}
	}

	class Notes_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			mainContainer.add(notes, "notes");
			c1.show(mainContainer, "notes");
		}

	}

	class ScreenShot implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			Point pt = new Point(mainContainer.getLocation());
			SwingUtilities.convertPointToScreen(pt, topBar);

			String time = new SimpleDateFormat("ddMMyyHHmmss").format(Calendar.getInstance().getTime());

			Rectangle shotRectangle = new Rectangle(pt.x, pt.y, mainContainer.getWidth(), mainContainer.getHeight());

			Robot robot = null;
			try {
				robot = new Robot();
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			BufferedImage bufferedImage = robot.createScreenCapture(shotRectangle);

			try {
				File file = new File("Pictures/screenshot" + time + ".png");
				ImageIO.write(bufferedImage, "png", file);

			} catch (IOException ioe) {

			}
			galerie.refreshPhotoButton();

			JOptionPane.showMessageDialog(null, "Capture d'écran enregistrée");
		}
	}
}
