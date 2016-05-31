package Frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Contact.CarnetContact;
import Contact.Contact;
import Elements.BackButton;
import Frame.Contact_Details.Modif_Click;
import Frame.Contact_Details.Return_Click;

public class Contact_Modif extends JPanel {

	public CardLayout carnetCard = new CardLayout();
	private JPanel contentPane = new JPanel();
	private JPanel modifPanel = new JPanel();

	private JLabel lblNom = new JLabel("Nom");
	private JLabel lblPrenom = new JLabel("Prénom");
	private JLabel lblNumero = new JLabel("Numéro");

	private JTextField fieldName = new JTextField("");
	private JTextField fieldPname = new JTextField("");
	private JTextField fieldTel = new JTextField("");

	private JPanel topPanel = new JPanel();
	private FlowLayout topLayout = new FlowLayout();
	private JLabel titleLbl = new JLabel("Contact");
	private JButton modifyButton = new JButton("Enreg.");

	BackButton backButton = new BackButton();

	private FlowLayout detailsLayout = new FlowLayout();
	Dimension lblSize = new Dimension(280, 25);
	Dimension ClblSize = new Dimension(280, 25);
	Font lblFont = new Font("Arial", Font.BOLD, 22);
	Font cLblFont = new Font("Arial", Font.PLAIN, 20);

	JButton supprimer = new JButton("Supprimer");
	CarnetContact carnet=new CarnetContact();


	private Contact contactModif;

	Contact_Details top;

	public Contact_Modif(int id, Contact_Details top ) {
		
		carnet.deseralize();
		contactModif=carnet.getCarnet().get(id);
		
		this.setLayout(new BorderLayout());
		this.top = top;

	
		contentPane.setLayout(new BorderLayout());

		// Ajout des composant du topPanel
		modifyButton.setContentAreaFilled(false);
		modifyButton.setBorderPainted(false);
		topLayout.setHgap(60);
		topLayout.setVgap(10);
		topPanel.setBackground(Color.GRAY);
		topPanel.setLayout(topLayout);
		topPanel.add(backButton);
		topPanel.add(titleLbl);
		topPanel.add(modifyButton);
		backButton.addActionListener(new Return_Click());
		
 		modifyButton.addActionListener(new Modif_Click());
 		supprimer.addActionListener(new Delete_Click());
		
		
		// Modification du titre
		titleLbl.setForeground(Color.WHITE);
		titleLbl.setFont(new Font("Arial", Font.PLAIN, 30));
		modifyButton.setForeground(Color.WHITE);

		modifPanel.setLayout(new BorderLayout());
		modifPanel.add(topPanel, BorderLayout.NORTH);
		modifPanel.add(contentPane);

		// Ajout du contact panel au panel principal
		setLayout(carnetCard);
		add(modifPanel, "modifPanel");
		carnetCard.show(Contact_Modif.this, "ModifPanel");

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		detailsLayout.setVgap(25);
		detailsLayout.setHgap(10);
		panel.setLayout(detailsLayout);

		lblPrenom.setPreferredSize(lblSize);
		lblPrenom.setFont(lblFont);
		lblPrenom.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
		panel.add(lblPrenom);

		fieldPname.setPreferredSize(ClblSize);
		fieldPname.setFont(cLblFont);
		panel.add(fieldPname);
		fieldPname.setText(contactModif.getPrenom());

		lblNom.setPreferredSize(lblSize);
		lblNom.setFont(lblFont);
		lblNom.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
		panel.add(lblNom);

		fieldName.setPreferredSize(ClblSize);
		fieldName.setFont(cLblFont);
		panel.add(fieldName);
		fieldName.setText(contactModif.getNom());

		lblNumero.setPreferredSize(lblSize);
		lblNumero.setFont(lblFont);
		lblNumero.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
		panel.add(lblNumero);

		fieldTel.setPreferredSize(ClblSize);
		fieldTel.setFont(cLblFont);
		panel.add(fieldTel);
		fieldTel.setText(contactModif.getTel());

		supprimer.setPreferredSize(lblSize);
		supprimer.setContentAreaFilled(false);
		panel.add(supprimer);

		System.out.println("------Contact_Details------");

	}

	class Return_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			top.remove(Contact_Modif.this);
		}
	}
	
	class Modif_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			carnet.getCarnet().get(contactModif.getId()).setNom(fieldName.getText());
			carnet.getCarnet().get(contactModif.getId()).setPrenom(fieldPname.getText());
			carnet.getCarnet().get(contactModif.getId()).setTel(fieldTel.getText());
			carnet.serialize();
			top.remove(Contact_Modif.this);

		}
	}
	
	class Delete_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			carnet.getCarnet().remove(contactModif.getId());
			carnet.serialize();
		}
	}

}
