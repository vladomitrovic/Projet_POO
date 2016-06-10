package Frame.Contact;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Elements.BackButton;
import Elements.OkButton;
import Elements.TopTitleBar;

public class Contact_Add extends JPanel {

	public CardLayout carnetCard = new CardLayout();
	private JPanel contentPane = new JPanel();
	private JPanel newContactPanel = new JPanel();

	private JLabel lblNom = new JLabel("Nom");
	private JLabel lblPrenom = new JLabel("Prénom");
	private JLabel lblNumero = new JLabel("Numéro");

	private JTextField lblCName = new JTextField("");
	private JTextField lblCPname = new JTextField("");
	private JTextField lblCTel = new JTextField("");

	BackButton backButton = new BackButton();

	private FlowLayout detailsLayout = new FlowLayout();
	Dimension lblSize = new Dimension(280, 25);
	Dimension ClblSize = new Dimension(280, 30);
	Font lblFont = new Font("Arial", Font.BOLD, 22);
	Font cLblFont = new Font("Arial", Font.PLAIN, 20);

	Contact_Carnet top;

	private Contact_Carnet carnet = new Contact_Carnet();

	private JCheckBox favoris = new JCheckBox("Favoris");
	private TopTitleBar topPanel;

	public Contact_Add(Contact_Carnet top) {
		this.top = top;
		this.setLayout(new BorderLayout());

		contentPane.setLayout(new BorderLayout());

		// // Ajout des composant du topPanel
		// addButton.setContentAreaFilled(false);
		// addButton.setBorderPainted(false);
		// topLayout.setHgap(60);
		// topLayout.setVgap(10);
		// topPanel.setBackground(Color.GRAY);
		// topPanel.setLayout(topLayout);
		// topPanel.add(backButton);
		// topPanel.add(titleLbl);
		// topPanel.add(addButton);
		// backButton.addActionListener(new Return_Click());
		// addButton.addActionListener(new add_Click());
		// // Modification du titre
		// titleLbl.setForeground(Color.WHITE);
		// titleLbl.setFont(new Font("Arial", Font.PLAIN, 30));
		// addButton.setForeground(Color.WHITE);

		topPanel = new TopTitleBar(new BackButton(), new Return_Click(), "Contacts", new OkButton(), new Add_Click(),
				Color.GRAY);

		newContactPanel.setLayout(new BorderLayout());
		newContactPanel.add(topPanel, BorderLayout.NORTH);
		newContactPanel.add(contentPane);

		// Ajout du contact panel au panel principal
		setLayout(carnetCard);
		add(newContactPanel, "newContactPanel");
		carnetCard.show(Contact_Add.this, "newContactPanel");

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		detailsLayout.setVgap(25);
		detailsLayout.setHgap(10);
		panel.setLayout(detailsLayout);

		lblPrenom.setPreferredSize(lblSize);
		lblPrenom.setFont(lblFont);
		lblPrenom.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
		panel.add(lblPrenom);

		lblCPname.setPreferredSize(ClblSize);
		lblCPname.setFont(cLblFont);
		panel.add(lblCPname);

		lblNom.setPreferredSize(lblSize);
		lblNom.setFont(lblFont);
		lblNom.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
		panel.add(lblNom);

		lblCName.setPreferredSize(ClblSize);
		lblCName.setFont(cLblFont);
		panel.add(lblCName);

		lblNumero.setPreferredSize(lblSize);
		lblNumero.setFont(lblFont);
		lblNumero.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
		panel.add(lblNumero);

		lblCTel.setPreferredSize(ClblSize);
		lblCTel.setFont(cLblFont);
		panel.add(lblCTel);

		favoris.setPreferredSize(lblSize);
		// favoris.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(favoris);
	}

	class Return_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			top.remove(Contact_Add.this);
		}
	}

	class Add_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			top.getCarnetContact().newContact(lblCPname.getText(), lblCName.getText(), lblCTel.getText(), favoris.isSelected());
			top.getCarnetContact().serialize();
			top.creatContactButtons();
			top.remove(Contact_Add.this);

		}
	}

}
