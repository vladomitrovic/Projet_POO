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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import Contact.CarnetContact;
import Contact.Contact;
import Elements.BackButton;
import Elements.LabelContact;
import Elements.LabelDetails;
import Elements.TopTitleBar;
import Elements.TrashButton;
import Galerie.Photo;

public class Contact_Details extends JPanel {

	public CardLayout carnetCard = new CardLayout();
	private JPanel contentPane = new JPanel();
	private JPanel detailsPanel = new JPanel();

	private LabelDetails lblNom = new LabelDetails("Nom");
	private LabelDetails lblPrenom = new LabelDetails("Prénom");
	private LabelDetails lblNumero = new LabelDetails("Numéro");

	private LabelContact lblCName = new LabelContact();
	private LabelContact lblCPname = new LabelContact();
	private LabelContact lblCTel = new LabelContact();
	
	private JCheckBox favoris = new JCheckBox("Favoris ");

	private JButton modifyButton = new JButton("Modifier");
	
	private JButton picture = new JButton();
	private FlowLayout detailsLayout = new FlowLayout();

	private Contact contactDetails;
	private Contact_Image contactImage; 
	


	private int id;
	private Contact_Carnet top;
	private TopTitleBar topPanel;
	private JPanel panel = new JPanel();

	public Contact_Details(int id, Contact_Carnet top) {
		this.id = id;
	;
		contactDetails = top.getCarnetContact().getCarnet().get(id);

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

		//Configuration de l'image du contact
		picture.setIcon(creatPhotoFit(top.getCarnetContact().getCarnet().get(id).getPhoto()));
		picture.setPreferredSize(new Dimension(150, 180));
		picture.addActionListener(new Picture_Click());
		panel.add(picture);

		//Ajout des labels et des détails du contacts
		addLabels();

		//Configuration du boutton mondifier
		modifyButton.setContentAreaFilled(false);
		modifyButton.setPreferredSize(new Dimension(280, 25));
		modifyButton.setForeground(Color.BLACK);
		modifyButton.addActionListener(new Modif_Click());
		panel.add(modifyButton);
		

	}



	private void addLabels() {
		
		panel.add(lblPrenom);
		panel.add(lblCPname);
		lblCPname.setText(contactDetails.getPrenom());

		panel.add(lblNom);
		panel.add(lblCName);
		lblCName.setText(contactDetails.getNom());

		panel.add(lblNumero);
		panel.add(lblCTel);
		lblCTel.setText(contactDetails.getTel());

		
		panel.add(favoris);
		favoris.setFont(new Font("Arial", Font.BOLD, 22));
		favoris.setHorizontalTextPosition(SwingConstants.LEFT);
		favoris.setEnabled(false);
		favoris.setPreferredSize(new Dimension (280, 25));
		favoris.setSelected(contactDetails.isFavoris());
	}

	class Modif_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			lblCPname.setEditable(true);
			lblCName.setEditable(true);
			lblCTel.setEditable(true);
			favoris.setEnabled(true);
			
			

			modifyButton.setText("Enregistrer");
			modifyButton.removeActionListener(this);
			modifyButton.addActionListener(new Enregistrer_Click());

		}
	}
	
	class Enregistrer_Click implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			lblCPname.setEditable(false);
			lblCName.setEditable(false);
			lblCTel.setEditable(false);
			favoris.setEnabled(false);

			
			modifyButton.setText("Modifier");
			modifyButton.removeActionListener(this);
			modifyButton.addActionListener(new Modif_Click());
			
			top.getCarnetContact().getCarnet().get(id).setPrenom(lblCPname.getText());
			top.getCarnetContact().getCarnet().get(id).setNom(lblCName.getText());
			top.getCarnetContact().getCarnet().get(id).setTel(lblCTel.getText());
			top.getCarnetContact().getCarnet().get(id).setFavoris(favoris.isSelected());
			top.getCarnetContact().serialize();
		}
		
	}

	class Return_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			top.getCarnetContact().deseralize();
			top.creatContactButtons();
			top.remove(Contact_Details.this);
		}

	}

	class Trash_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			top.getCarnetContact().deleteContact(id);
			top.getCarnetContact().serialize();
			top.creatContactButtons();
			top.remove(Contact_Details.this);
		}
	}

	class Picture_Click implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			contactImage = new Contact_Image(id, Contact_Details.this);
			add(contactImage, "contactImage");
			carnetCard.show(Contact_Details.this, "contactImage");
		}
		
	}


	public Photo creatPhotoFit(Photo photo) {

		Image img = photo.getImage();
		Image newImg = img.getScaledInstance(150, 180, Image.SCALE_SMOOTH);
		photo = new Photo(newImg);
		return photo;

	}
	
	public CarnetContact getCarnet() {
		return top.getCarnetContact();
	}
	
	public void setPicture(String path) {
		this.picture.setIcon(new Photo(path));
		picture.setIcon(creatPhotoFit(top.getCarnetContact().getCarnet().get(id).getPhoto()));
		picture.setPreferredSize(new Dimension(150, 180));
	}



	public JButton getModifyButton() {
		return modifyButton;
	}
	
	

}
