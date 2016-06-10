package Frame.Contact;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import Contact.CarnetContact;
import Contact.Contact;
import Elements.AddButton;
import Elements.BackButton;
import Elements.ContactButton;
import Elements.FavorisButton;
import Elements.TopTitleBar;
import Elements.WrapLayout;

public class Contact_Carnet extends JPanel {

	public CardLayout carnetCard = new CardLayout();
	private JPanel carnetPanel = new JPanel();
	private JPanel searchList = new JPanel();
	public JPanel listePanel = new JPanel();
	private JScrollPane listeScroll = new JScrollPane(listePanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	private Contact_Details contactDetails;
	private TopTitleBar topPanel;
	private JLabel nbContact = new JLabel();
	private JTextField recherche=new JTextField();
//	private JButton search=new JButton("Rechercher");
	private CarnetContact carnetContact = new CarnetContact();

	public Contact_Carnet() {
	
		//Création TopTitleBar
		topPanel=new TopTitleBar(new FavorisButton(), new Favoris_Click(), "Contacts", new AddButton(), new Add_Click(), Color.GRAY);


		// Ajout du topPanel et de la liste des contacts au panel contact
		carnetPanel.setLayout(new BorderLayout());
		carnetPanel.add(topPanel, BorderLayout.NORTH);
		carnetPanel.add(searchList);
		
		recherche.setPreferredSize(new Dimension(425, 30));
		recherche.addKeyListener(new SearchListener());
		
		searchList.add(recherche, BorderLayout.NORTH);
		searchList.add(listeScroll);

		// Ajout du contact panel au panel principal
		setLayout(carnetCard);
		add(carnetPanel, "carnetPanel");
		carnetCard.show(Contact_Carnet.this, "carnetPanel");

		
//		GridLayout grid = new GridLayout(carnet.getCarnet().size(), 1);
//		grid.setVgap(5);
		WrapLayout wrap=  new WrapLayout();
		wrap.setVgap(5);
		listePanel.setLayout(wrap);
		listeScroll.setPreferredSize(new Dimension(425, 602));
		listeScroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

		carnetContact.deseralize();

		creatContactButtons();

		System.out.println("------Contact_Carnet------");
	}

	class Add_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			carnetContact.newContact("", "", "", false);
			carnetContact.orderAbc();
			contactDetails = new Contact_Details(0, Contact_Carnet.this);
			contactDetails.getModifyButton().doClick();
			add(contactDetails, "contactDetails");
			carnetCard.show(Contact_Carnet.this, "contactDetails");
		}
	}

	class Details_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			for (int i = 0; i < carnetContact.getCarnet().size(); i++) {
				if (((JButton) e.getSource()).getName().equals(("C" + i))) {
					contactDetails = new Contact_Details(i, Contact_Carnet.this);
					add(contactDetails, "contactDetails");
					carnetCard.show(Contact_Carnet.this, "contactDetails");
					return;
				}
			}
		}
	}

	class Favoris_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			creatFavorisButtons();
			topPanel.setLeftButton(new BackButton(), new ReturnFavoris_Click());
		}
	}
	
	class ReturnFavoris_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			creatContactButtons();
			topPanel.setLeftButton(new FavorisButton(), new Favoris_Click());
			topPanel.setLabelText("Contact");
		}
		
	}
	
	class SearchListener extends KeyAdapter{
		@Override
		public void keyReleased(KeyEvent e) {
			research(recherche.getText().toLowerCase());
		}	
	}
	
	public void creatContactButtons() {
		listePanel.removeAll();
		recherche.setVisible(true);
		carnetContact.refreshId();
		for (int i = 0; i < carnetContact.getCarnet().size(); i++) {
			Contact c = carnetContact.getCarnet().get(i);
			ContactButton temp = new ContactButton(c.getPrenom() + " " + c.getNom());
			temp.setName("C" + i);
			temp.addActionListener(new Details_Click());
			
			listePanel.add(temp);
		}
		nbContact.setText(carnetContact.getCarnet().size() + " contacts");
		nbContact.setPreferredSize(new Dimension(407, 50));
		nbContact.setHorizontalAlignment(SwingConstants.CENTER);
		listePanel.add(nbContact);
	}

	
	public void creatFavorisButtons() {
		listePanel.removeAll();
		recherche.setVisible(false);
		int cpt=0;
		for (int i = 0; i < carnetContact.getCarnet().size(); i++) {
			Contact c = carnetContact.getCarnet().get(i);
			if (c.isFavoris()) {
				cpt++;
				ContactButton temp = new ContactButton(c.getPrenom() + " " + c.getNom());
				temp.setName("C" + i);
				temp.addActionListener(new Details_Click());
				listePanel.add(temp);
			}
		}	
		topPanel.setLabelText("Favoris");
		
		nbContact.setText(cpt+" / "+carnetContact.getCarnet().size() + " contacts");
		nbContact.setPreferredSize(new Dimension(407, 50));
		nbContact.setHorizontalAlignment(SwingConstants.CENTER);
		listePanel.add(nbContact);
	}
	
	public void research(String search){
		listePanel.removeAll();
	
		int cpt=0;
		for (int i = 0; i < carnetContact.getCarnet().size(); i++) {
			Contact c = carnetContact.getCarnet().get(i);
			
			if (c.getPrenom().toLowerCase().startsWith(search) || c.getNom().toLowerCase().startsWith(search) 
				 || c.getNomPrenom().toLowerCase().startsWith(search) || c.getPrenomNom().toLowerCase().startsWith(search)) {

				cpt++;
				ContactButton temp = new ContactButton(" "+c.getPrenom() + " " + c.getNom());
				temp.setName("C" + i);
				temp.addActionListener(new Details_Click());
				listePanel.add(temp);
			}
		}
		
		nbContact.setText(cpt+" / "+carnetContact.getCarnet().size() + " contacts");
		nbContact.setPreferredSize(new Dimension(407, 50));
		nbContact.setHorizontalAlignment(SwingConstants.CENTER);
		listePanel.add(nbContact);
		
	}


	public CarnetContact getCarnetContact() {
		return carnetContact;
	}
	

	
}
