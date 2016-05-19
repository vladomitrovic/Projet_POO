package Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import Contact.CarnetContact;
import Contact.Contact;
import Galerie.Photo;

public class Contact_Main extends JPanel {

	JPanel mainCarnet = new JPanel();

	CarnetContact carnet = new CarnetContact();

	Contact vlado = new Contact("Mitrovic", "Vlado", "079 439 22 26");
	Contact john = new Contact("Doe", "John", "079 123 45 67");
	Contact adam = new Contact("Adam", "Smith", "078 765 41 23");

	JButton add = new JButton("Nouveau contact");

	JLabel noContact = new JLabel();

	private TopBarPanel topBar;
	private JPanel top;

	public Contact_Main(JPanel top) {
		this.setLayout(new BorderLayout());
		this.top = top;
		topBar = new TopBarPanel(Contact_Main.this, top);
		add(topBar, BorderLayout.NORTH);
		setPreferredSize(new Dimension(480, 800));

		mainCarnet.add(add);
		add.addActionListener(new Add_Click());

		GridLayout grid = new GridLayout(10, 1);
		grid.setVgap(10);
		mainCarnet.setLayout(grid);
		add(mainCarnet);

		carnet.getCarnet().add(adam);
		carnet.getCarnet().add(john);
		carnet.getCarnet().add(vlado);

		// afficher contact
		for (int i = 0; i < carnet.getCarnet().size(); i++) {
			Contact c = carnet.getCarnet().get(i);
			JButton temp = new JButton(c.getNom() + " " + c.getPrenom());

			temp.setName("C" + i);
			temp.setContentAreaFilled(false);
			temp.addActionListener(new Details_Click());

			mainCarnet.add(temp);
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

	class AddContact extends JPanel {

		private JPanel contentPane = new JPanel();

		private JLabel lblNom = new JLabel("Nom");
		private JLabel lblPrenom = new JLabel("Prénom");
		private JLabel lblNumero = new JLabel("Numéro");

		private JTextField lblCName = new JTextField("");
		private JTextField lblCPname = new JTextField("");
		private JTextField lblCTel = new JTextField("");
		
		JButton add = new JButton("Ajouter");
		
		private TopBarPanel topBar;
		private JPanel top;

		public AddContact(JPanel top) {
			this.setLayout(new BorderLayout());
			this.top = top;
			topBar = new TopBarPanel(Contact_Main.this, top);
			add(topBar, BorderLayout.NORTH);

			add(contentPane);
			contentPane.setLayout(new BorderLayout());

			contentPane.add(add);
			
			JPanel panel = new JPanel();
			contentPane.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);

			lblPrenom.setBounds(106, 171, 71, 63);
			panel.add(lblPrenom);

			lblCPname.setBounds(211, 171, 121, 63);
			panel.add(lblCPname);

			lblNom.setBounds(106, 247, 87, 63);
			panel.add(lblNom);

			lblCName.setBounds(211, 247, 105, 63);
			panel.add(lblCName);

			lblNumero.setBounds(106, 309, 71, 63);
			panel.add(lblNumero);

			lblCTel.setBounds(211, 309, 95, 63);
			panel.add(lblCTel);

		}

	}

	class Add_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			mainCarnet.setVisible(false);
			topBar.setVisible(false);
			Contact_Main.this.add(new AddContact(mainCarnet));

		}

	}

	class Details_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			mainCarnet.setVisible(false);
			topBar.setVisible(false);

			for (int i = 0; i < carnet.getCarnet().size(); i++) {
				if (((JButton) e.getSource()).getName().equals(("C" + i))) {
					Contact c = carnet.getCarnet().get(i);
					Contact_Main.this.add(new Contact_Details(c, mainCarnet));
					return;
				}
			}


		}

	}

}
