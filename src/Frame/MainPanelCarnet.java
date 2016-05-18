package Frame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicArrowButton;

import Contact.CarnetContact;
import Contact.Contact;
import Frame.MainPanelGalerie.PhotoPanel;
import Galerie.Photo;

public class MainPanelCarnet extends JPanel {

	JPanel liste = new JPanel();

	ArrayList<Contact> carnet = new ArrayList<Contact>();

	Contact vlado = new Contact("Mitrovic", "Vlado", "079 439 22 26");
	Contact john = new Contact("Doe", "John", "079 123 45 67");
	Contact adam = new Contact("Adam", "Smith", "078 765 41 23");

	JLabel noContact = new JLabel();

	public MainPanelCarnet() {
		setPreferredSize(new Dimension(480, 800));

		liste.setLayout(new GridLayout(10, 1));
		add(liste);

		// ajout contact dans l'array
		carnet.add(vlado);
		carnet.add(john);
		carnet.add(adam);

		// afficher contact
		for (Contact c : carnet) {
			liste.add(new JButton(c.getNom() + " " + c.getPrenom()));
		}

		add(noContact, BorderLayout.SOUTH);
		noContact.setText(carnet.size() + " contacts");

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

	class Details_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			liste.setVisible(false);
			JButton button = (JButton) e.getSource();
			// Contact contact = (Contact) button.;
			// add(new ContactPanel(contact));

		}

	}

}
