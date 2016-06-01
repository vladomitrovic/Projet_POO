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
import Elements.TrashButton;
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
	private TrashButton trash=new TrashButton();
	
	BackButton backButton = new BackButton();
	
	private FlowLayout detailsLayout = new FlowLayout();
	Dimension lblSize=new Dimension(280, 25);
	Dimension ClblSize=new Dimension(280, 25);
	Font lblFont=new Font("Arial", Font.BOLD, 22);
	Font cLblFont=new Font("Arial", Font.PLAIN, 20);
	
	private Contact contactDetails;
	
	CarnetContact carnet=new CarnetContact();
	
	int id;
	
	Contact_Carnet top;

	public Contact_Details(int id, Contact_Carnet top) {
		this.id=id;
		
		carnet.deseralize();
		contactDetails= carnet.getCarnet().get(id);
		
		this.top=top;
		this.setLayout(new BorderLayout());

		contentPane.setLayout(new BorderLayout());

		// Ajout des composant du topPanel

		topLayout.setHgap(60);
		topLayout.setVgap(10);
		topPanel.setBackground(Color.GRAY);
		topPanel.setLayout(topLayout);
		topPanel.add(backButton);
		topPanel.add(titleLbl);
		topPanel.add(trash);
		trash.addActionListener(new Trash_Click());
		backButton.addActionListener(new Return_Click());
		// Modification du titre
		titleLbl.setForeground(Color.WHITE);
		titleLbl.setFont(new Font("Arial", Font.PLAIN, 30));

		detailsPanel.setLayout(new BorderLayout());
		detailsPanel.add(topPanel, BorderLayout.NORTH);
		detailsPanel.add(contentPane);
		
		
		
		// Ajout du contact panel au panel principal
		setLayout(carnetCard);
		add(detailsPanel, "detailsPanel");
		carnetCard.show(Contact_Details.this, "detailsPanel");

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
		lblCPname.setText(contactDetails.getPrenom());

		lblNom.setPreferredSize(lblSize);
		lblNom.setFont(lblFont);
		lblNom.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
		panel.add(lblNom);

		lblCName.setPreferredSize(ClblSize);
		lblCName.setFont(cLblFont);
		panel.add(lblCName);
		lblCName.setText(contactDetails.getNom());

		lblNumero.setPreferredSize(lblSize);
		lblNumero.setFont(lblFont);
		lblNumero.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
		panel.add(lblNumero);

		lblCTel.setPreferredSize(ClblSize);
		lblCTel.setFont(cLblFont);
		panel.add(lblCTel);
		lblCTel.setText(contactDetails.getTel());
		
		modifyButton.setContentAreaFilled(false);
		modifyButton.setPreferredSize(ClblSize);
		modifyButton.setForeground(Color.BLACK);
		modifyButton.addActionListener(new Modif_Click());

		panel.add(modifyButton);
		System.out.println("------Contact_Details------");
	}

	class Modif_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
//			top.remove(Contact_Details.this);
			Contact_Modif modif=new Contact_Modif(id, Contact_Details.this);
			add(modif, "modif");
			carnetCard.show(Contact_Details.this, "modif");
		}
	}

	class Return_Click implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			top.carnet.deseralize();
			top.creatContactButtons();
			top.remove(Contact_Details.this);
		}

	}

	class Trash_Click implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			top.carnet.deleteContact(id);
			carnet.serialize();
			top.creatContactButtons();
			top.remove(Contact_Details.this);	
		}
	}
	
	public void refresh(){
		carnet.deseralize();
		contactDetails= carnet.getCarnet().get(id);
		lblCPname.setText(contactDetails.getPrenom());
		lblCName.setText(contactDetails.getNom());
		lblCTel.setText(contactDetails.getTel());

	}
}
