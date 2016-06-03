package Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Contact.CarnetContact;
import Contact.Contact;
import Elements.AddButton;
import Elements.ContactButton;
import Elements.FavorisButton;
import Elements.TopTitleBar;

public class Contact_Carnet extends JPanel {

	public CardLayout carnetCard = new CardLayout();
	private JPanel carnetPanel = new JPanel();
	private JPanel listePanel = new JPanel();
	private JScrollPane listeScroll = new JScrollPane(listePanel);
	private Contact_Details contactDetails;
	private Contact_Add contactAdd;
	private TopTitleBar topPanel;
	private JLabel nbContact = new JLabel();
	CarnetContact carnet = new CarnetContact();

	public Contact_Carnet() {
	
		//Création TopTitleBar
		topPanel=new TopTitleBar(new FavorisButton(), new Favoris_Click(), "Contacts", new AddButton(), new Add_Click(), Color.GRAY);


		// Ajout du topPanel et de la liste des contacts au panel contact
		carnetPanel.setLayout(new BorderLayout());
		carnetPanel.add(topPanel, BorderLayout.NORTH);
		carnetPanel.add(listeScroll);

		// Ajout du contact panel au panel principal
		setLayout(carnetCard);
		add(carnetPanel, "carnetPanel");
		carnetCard.show(Contact_Carnet.this, "carnetPanel");

		
		GridLayout grid = new GridLayout(carnet.getCarnet().size(), 1);
		grid.setVgap(5);
		listePanel.setLayout(grid);
		listeScroll.setPreferredSize(new Dimension(425, 642));
		listeScroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		carnet.deseralize();

		creatContactButtons();

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

	class Favoris_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			creatFavorisButtons();
		}
	}
	
	public void creatContactButtons() {
		listePanel.removeAll();
		System.out.println("Removing all buttons");
		carnet.refreshId();
		for (int i = 0; i < carnet.getCarnet().size(); i++) {
			Contact c = carnet.getCarnet().get(i);
			ContactButton temp = new ContactButton(" "+c.getPrenom() + " " + c.getNom());
			temp.setName("C" + i);
			temp.addActionListener(new Details_Click());
			
			listePanel.add(temp);
			System.out.println("Add " + i);
		}

		nbContact.setText(carnet.getCarnet().size() + " contacts");
		nbContact.setPreferredSize(new Dimension(407, 50));
		nbContact.setHorizontalAlignment(SwingConstants.CENTER);
		listePanel.add(nbContact);
	}

	public void creatFavorisButtons() {
		listePanel.removeAll();
		System.out.println("Removing all buttons");
		int cpt=0;
		for (int i = 0; i < carnet.getCarnet().size(); i++) {
			Contact c = carnet.getCarnet().get(i);
			if (c.isFavoris()) {
				cpt++;
				ContactButton temp = new ContactButton(" "+c.getPrenom() + " " + c.getNom());
				temp.setName("C" + i);
				temp.addActionListener(new Details_Click());
				listePanel.add(temp);
				System.out.println("Add " + i);
			}
		}	
		topPanel.setLabelText("Favoris");
		
		nbContact.setText(cpt+" / "+carnet.getCarnet().size() + " contacts");
		nbContact.setPreferredSize(new Dimension(407, 50));
		nbContact.setHorizontalAlignment(SwingConstants.CENTER);
		listePanel.add(nbContact);
	}

}
