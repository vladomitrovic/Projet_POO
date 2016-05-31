package Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import Contact.CarnetContact;
import Contact.Contact;
import Elements.AddButton;
import Elements.ContactButton;
import Elements.FavorisButton;
import Galerie.Photo;

public class Contact_Carnet extends JPanel {

	public CardLayout carnetCard = new CardLayout();
	private JPanel carnetPanel = new JPanel();
	private JPanel topPanel = new JPanel();
	private FlowLayout topLayout = new FlowLayout();
	private JLabel titleLbl = new JLabel("Contact");

	private JPanel listePanel = new JPanel();
	private JScrollPane listeScroll = new JScrollPane(listePanel);

	private Contact_Details contactDetails;
	private Contact_Add contactAdd;

	CarnetContact carnet = new CarnetContact();

	AddButton addButton = new AddButton();

	FavorisButton favButton = new FavorisButton();

	JLabel nbContact = new JLabel();

	public Contact_Carnet() {
		setPreferredSize(new Dimension(480, 800));
		setLayout(new BorderLayout());

		// Modification du titre
		titleLbl.setForeground(Color.WHITE);
		titleLbl.setFont(new Font("Arial", Font.PLAIN, 30));

		// Ajout des composant du topPanel
		topLayout.setHgap(67);
		topLayout.setVgap(10);
		topPanel.setBackground(Color.GRAY);
		topPanel.setLayout(topLayout);
		topPanel.add(favButton);
		topPanel.add(titleLbl);
		topPanel.add(addButton);
		addButton.addActionListener(new Add_Click());

		// Ajout du topPanel et de la liste des contacts au panel contact
		carnetPanel.setLayout(new BorderLayout());
		// add(topPanel, BorderLayout.NORTH);
		carnetPanel.add(topPanel, BorderLayout.NORTH);
		carnetPanel.add(listeScroll);

		// Ajout du contact panel au panel principal
		setLayout(carnetCard);
		add(carnetPanel, "carnetPanel");
		carnetCard.show(Contact_Carnet.this, "carnetPanel");

		GridLayout grid = new GridLayout(carnet.getCarnet().size(), 1);
		grid.setVgap(5);
		// FlowLayout scrollLayout =new FlowLayout();
		// scrollLayout.setHgap(10);
		listePanel.setLayout(grid);

		// listePanel.setOpaque(false);
		// listeScroll.setOpaque(false);
		listeScroll.setPreferredSize(new Dimension(425, 642));
		listeScroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		carnet.deseralize();
		creatContactButtons();
		
		nbContact.setText(carnet.getCarnet().size()+" contacts");
		nbContact.setPreferredSize(new Dimension(407, 50));
		nbContact.setHorizontalAlignment(SwingConstants.CENTER);
		listePanel.add(nbContact);
		
		System.out.println("------Contact_Carnet------");
	}

	class Add_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			contactAdd = new Contact_Add(Contact_Carnet.this);
			add(contactAdd, "contactAdd");
			carnetCard.show(Contact_Carnet.this, "contactAdd");
		}
	}

	class Details_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			for (int i = 0; i < carnet.getCarnet().size(); i++) {

				if (((JButton) e.getSource()).getName().equals(("C" + i))) {
					contactDetails = new Contact_Details(i, Contact_Carnet.this);
					add(contactDetails, "contactDetails");
					carnetCard.show(Contact_Carnet.this, "contactDetails");
				}
			}
		}
	}

//	 A VOIR
	public void creatContactButtons() {
		listePanel.removeAll();
		carnet.deseralize();

		// Cr�ation de tous les bouttons de contact avec prenom nom
		for (int i = 0; i < carnet.getCarnet().size(); i++) {
			Contact c = carnet.getCarnet().get(i);
			ContactButton temp = new ContactButton(c.getNom() + " " + c.getPrenom());

			temp.setName("C" + i);
			temp.addActionListener(new Details_Click());
			
			listePanel.add(temp);
		}
	}
	

}
