package Frame.Contact;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import Contact.CarnetContact;
import Contact.Contact;
import Elements.BackButton;
import Elements.TopTitleBar;
import Elements.TrashButton;
import Galerie.Photo;

public class Contact_Details extends JPanel {

	public CardLayout carnetCard = new CardLayout();
	private JPanel contentPane = new JPanel();
	private JPanel detailsPanel = new JPanel();

	private JLabel lblNom = new JLabel("Nom");
	private JLabel lblPrenom = new JLabel("Prénom");
	private JLabel lblNumero = new JLabel("Numéro");

	private JLabel lblCName = new JLabel("");
	private JLabel lblCPname = new JLabel("");
	private JLabel lblCTel = new JLabel("");

	private JButton modifyButton = new JButton("Modifier");
	private JButton picture = new JButton();
	private FlowLayout detailsLayout = new FlowLayout();
	private Dimension lblSize = new Dimension(280, 25);
	private Dimension ClblSize = new Dimension(280, 25);
	private Font lblFont = new Font("Arial", Font.BOLD, 22);
	private Font cLblFont = new Font("Arial", Font.PLAIN, 20);
	private Border lblBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY);

	private Contact contactDetails;
	private CarnetContact carnet = new CarnetContact();
	private int id;
	private Contact_Carnet top;
	private TopTitleBar topPanel;
	private JPanel panel = new JPanel();

	public Contact_Details(int id, Contact_Carnet top) {
		this.id = id;

		carnet.deseralize();
		contactDetails = carnet.getCarnet().get(id);

		this.top = top;
		this.setLayout(new BorderLayout());

		contentPane.setLayout(new BorderLayout());

		// Configuration du topPanel
		topPanel = new TopTitleBar(new BackButton(), new Return_Click(), "Contacts", new TrashButton(),
				new Trash_Click(), Color.GRAY);

		detailsPanel.setLayout(new BorderLayout());
		detailsPanel.add(topPanel, BorderLayout.NORTH);
		detailsPanel.add(contentPane);

		// Ajout du contact panel au panel principal
		setLayout(carnetCard);
		add(detailsPanel, "detailsPanel");
		carnetCard.show(Contact_Details.this, "detailsPanel");

		contentPane.add(panel, BorderLayout.CENTER);
		detailsLayout.setVgap(25);
		detailsLayout.setHgap(10);
		panel.setLayout(detailsLayout);

		picture.setIcon(creatPhotoFit(carnet.getCarnet().get(id).getPhoto()));
		picture.setPreferredSize(new Dimension(150, 180));
		panel.add(picture);

		addLabels();

		modifyButton.setContentAreaFilled(false);
		modifyButton.setPreferredSize(ClblSize);
		modifyButton.setForeground(Color.BLACK);
		modifyButton.addActionListener(new Modif_Click());
		panel.add(modifyButton);

		System.out.println("------Contact_Details------");
	}

	private void addLabels() {
		lblPrenom.setPreferredSize(lblSize);
		lblPrenom.setFont(lblFont);
		lblPrenom.setBorder(lblBorder);
		panel.add(lblPrenom);

		lblCPname.setPreferredSize(ClblSize);
		lblCPname.setFont(cLblFont);
		panel.add(lblCPname);
		lblCPname.setText(contactDetails.getPrenom());

		lblNom.setPreferredSize(lblSize);
		lblNom.setFont(lblFont);
		lblNom.setBorder(lblBorder);
		panel.add(lblNom);

		lblCName.setPreferredSize(ClblSize);
		lblCName.setFont(cLblFont);
		panel.add(lblCName);
		lblCName.setText(contactDetails.getNom());

		lblNumero.setPreferredSize(lblSize);
		lblNumero.setFont(lblFont);
		lblNumero.setBorder(lblBorder);
		panel.add(lblNumero);

		lblCTel.setPreferredSize(ClblSize);
		lblCTel.setFont(cLblFont);
		panel.add(lblCTel);
		lblCTel.setText(contactDetails.getTel());
	}

	class Modif_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Contact_Modif modif = new Contact_Modif(id, Contact_Details.this);
			add(modif, "modif");
			carnetCard.show(Contact_Details.this, "modif");
		}
	}

	class Return_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			top.carnet.deseralize();
			top.creatContactButtons();
			top.remove(Contact_Details.this);
		}

	}

	class Trash_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			top.carnet.deleteContact(id);
			top.carnet.serialize();
			top.creatContactButtons();
			top.remove(Contact_Details.this);
		}
	}

	public void refresh() {
		carnet.deseralize();
		contactDetails = carnet.getCarnet().get(id);
		lblCPname.setText(contactDetails.getPrenom());
		lblCName.setText(contactDetails.getNom());
		lblCTel.setText(contactDetails.getTel());

	}

	public Photo creatPhotoFit(Photo photo) {

		Image img = photo.getImage();
		Image newImg = img.getScaledInstance(150, 180, Image.SCALE_SMOOTH);
		photo = new Photo(newImg);
		return photo;

	}

}
