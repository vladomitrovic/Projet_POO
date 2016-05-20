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
import Elements.FavorisButton;
import Galerie.Photo;

public class Contact_Carnet extends JPanel {

	public CardLayout carnetCard =new CardLayout();
	private JPanel carnetPanel = new JPanel();
	private JPanel topPanel = new JPanel();
	private FlowLayout topLayout=new FlowLayout();
	private JLabel titleLbl=new JLabel("Contact");
	
	private JPanel listePanel = new JPanel();
	private JScrollPane listeScroll =new JScrollPane(listePanel);

	private Contact_Details contactDetails;
	private Contact_Add contactAdd;
	
//	----------------------------------------------------------------------
	CarnetContact carnet = new CarnetContact();
	Contact vlado = new Contact("Mitrovic", "Vlado", "079 439 22 26");
	Contact john = new Contact("Doe", "John", "079 123 45 67");
	Contact adam = new Contact("Adam", "Smith", "078 765 41 23");
	
	Contact vlado1 = new Contact("Mitrovic", "Vlado", "079 439 22 26");
	Contact john1 = new Contact("Doe", "John", "079 123 45 67");
	Contact adam1 = new Contact("Adam", "Smith", "078 765 41 23");
	Contact vlado2 = new Contact("Mitrovic", "Vlado", "079 439 22 26");
	Contact john2 = new Contact("Doe", "John", "079 123 45 67");
	Contact adam2 = new Contact("Adam", "Smith", "078 765 41 23");
	Contact vlado3 = new Contact("Mitrovic", "Vlado", "079 439 22 26");
	Contact john3 = new Contact("Doe", "John", "079 123 45 67");
	Contact adam3 = new Contact("Adam", "Smith", "078 765 41 23");
	Contact vlado4 = new Contact("Mitrovic", "Vlado", "079 439 22 26");
	Contact john4 = new Contact("Doe", "John", "079 123 45 67");
	Contact adam4 = new Contact("Adam", "Smith", "078 765 41 23");
//	----------------------------------------------------------------------

	
	
	AddButton addButton=new AddButton();
	
	FavorisButton favButton=new FavorisButton();

//	JLabel nbContact = new JLabel();


	
	
	public Contact_Carnet() {
		setPreferredSize(new Dimension(480, 800));
		setLayout(new BorderLayout());
		
		
//		Modification du titre
		titleLbl.setForeground(Color.WHITE);
		titleLbl.setFont(new Font("Arial", Font.PLAIN, 30));
		
//		Ajout des composant du topPanel
		topLayout.setHgap(67);
		topLayout.setVgap(10);
		topPanel.setBackground(Color.BLUE);
		topPanel.setLayout(topLayout);
		topPanel.add(favButton);
		topPanel.add(titleLbl);
		topPanel.add(addButton);
		addButton.addActionListener(new Add_Click());
		
//		Ajout du topPanel et de la liste des contacts au panel contact
		carnetPanel.setLayout(new BorderLayout());
		carnetPanel.add(topPanel, BorderLayout.NORTH);
		carnetPanel.add(listeScroll);

//		Ajout du contact panel au panel principal 
		setLayout(carnetCard);
		add(carnetPanel, "carnetPanel");
		carnetCard.show(Contact_Carnet.this, "carnetPanel");

		
		
		


		GridLayout grid = new GridLayout(10, 1);
		grid.setVgap(5);
		listePanel.setLayout(grid);
		
		listePanel.setOpaque(false);
		listeScroll.setOpaque(false);
		listeScroll.setPreferredSize(new Dimension(425, 642));
		listeScroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

//		----------------------------------------------------------------------
		carnet.getCarnet().add(adam);
		carnet.getCarnet().add(john);
		carnet.getCarnet().add(vlado);
		
//		carnet.getCarnet().add(adam1);
//		carnet.getCarnet().add(john1);
//		carnet.getCarnet().add(vlado1);
//		carnet.getCarnet().add(adam2);
//		carnet.getCarnet().add(john2);
//		carnet.getCarnet().add(vlado2);
//		carnet.getCarnet().add(adam3);
//		carnet.getCarnet().add(john3);
//		carnet.getCarnet().add(vlado3);
//		carnet.getCarnet().add(adam4);
//		carnet.getCarnet().add(john4);
//		carnet.getCarnet().add(vlado4);
//		----------------------------------------------------------------------


		// Création buttons contacts
		for (int i = 0; i < carnet.getCarnet().size(); i++) {
			Contact c = carnet.getCarnet().get(i);
			JButton temp = new JButton(c.getNom() + " " + c.getPrenom());

			temp.setName("C" + i);
			temp.setContentAreaFilled(false);
			temp.setBorderPainted(false);
			temp.addActionListener(new Details_Click());
			temp.setHorizontalAlignment(SwingConstants.LEFT);
			
			listePanel.add(temp);
		}

	}

	
	class ContactPanel extends JPanel {

		private Contact contact;
		private JPanel details = new JPanel(new GridLayout(10, 1));

		public ContactPanel(Contact contact) {
			this.contact = contact;
			details.add(new JLabel(contact.getNom()));
			details.add(new JLabel(contact.getPrenom()));
			details.add(new JLabel(contact.getTel()));

		}

	}

	

	class Add_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			contactAdd=new Contact_Add(carnetPanel);
			add(contactAdd, "contactAdd");
			carnetCard.show(Contact_Carnet.this, "contactAdd");
		}

	}

	class Details_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			


			for (int i = 0; i < carnet.getCarnet().size(); i++) {
				
				if (((JButton) e.getSource()).getName().equals(("C" + i))) {
					Contact c = carnet.getCarnet().get(i);
					contactDetails =new Contact_Details(c, carnetPanel);
					add(contactDetails,"contactDetails");
					carnetCard.show(Contact_Carnet.this, "contactDetails");
				
				}
			}

		
			
			
		}

	}

	
}
