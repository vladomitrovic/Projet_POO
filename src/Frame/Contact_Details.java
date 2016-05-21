package Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Contact.CarnetContact;
import Contact.Contact;
import Elements.AddButton;
import Elements.BackButton;
import Elements.FavorisButton;
import Frame.Contact_Carnet.Add_Click;

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

	private JPanel topPanel = new JPanel();
	private FlowLayout topLayout = new FlowLayout();
	private JLabel titleLbl = new JLabel("Contact");
	private JButton modifyButton = new JButton("Modifier");

	BackButton backButton = new BackButton();
	
	Contact_Carnet top;

	public Contact_Details(Contact c, Contact_Carnet top) {
		this.top=top;
		this.setLayout(new BorderLayout());

		contentPane.setLayout(new BorderLayout());

		// Ajout des composant du topPanel
		modifyButton.setContentAreaFilled(false);
		modifyButton.setBorderPainted(false);
		topLayout.setHgap(60);
		topLayout.setVgap(10);
		topPanel.setBackground(Color.BLUE);
		topPanel.setLayout(topLayout);
		topPanel.add(backButton);
		topPanel.add(titleLbl);
		topPanel.add(modifyButton);
		backButton.addActionListener(new Return_Click());
		modifyButton.addActionListener(new Modif_Click());
		// Modification du titre
		titleLbl.setForeground(Color.WHITE);
		titleLbl.setFont(new Font("Arial", Font.PLAIN, 30));
		modifyButton.setForeground(Color.WHITE);

		detailsPanel.setLayout(new BorderLayout());
		detailsPanel.add(topPanel, BorderLayout.NORTH);
		detailsPanel.add(contentPane);
		
		
		// Ajout du contact panel au panel principal
		setLayout(carnetCard);
		add(detailsPanel, "detailsPanel");
		carnetCard.show(Contact_Details.this, "detailsPanel");

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		lblPrenom.setBounds(106, 171, 71, 63);
		panel.add(lblPrenom);

		lblCPname.setBounds(211, 171, 121, 63);
		panel.add(lblCPname);
		lblCPname.setText(c.getPrenom());

		lblNom.setBounds(106, 247, 87, 63);
		panel.add(lblNom);

		lblCName.setBounds(211, 247, 105, 63);
		panel.add(lblCName);
		lblCName.setText(c.getNom());

		lblNumero.setBounds(106, 309, 71, 63);
		panel.add(lblNumero);

		lblCTel.setBounds(211, 309, 95, 63);
		panel.add(lblCTel);
		lblCTel.setText(c.getTel());

	}

	class Modif_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			contentPane.setVisible(false);

		}

	}

	class Return_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			top.remove(Contact_Details.this);
	

		}

	}

}
