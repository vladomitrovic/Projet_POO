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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Contact.CarnetContact;
import Contact.Contact;
import Elements.AddButton;
import Elements.BackButton;
import Elements.FavorisButton;
import Elements.TopTitleBar;
import Elements.TrashButton;
import Frame.Contact_Carnet.Add_Click;
import Frame.Contact_Carnet.Favoris_Click;
import Frame.Contact_Details.Modif_Click;
import Frame.Contact_Details.Return_Click;
import Frame.Contact_Details.Trash_Click;

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


	private FlowLayout detailsLayout = new FlowLayout();
	private Dimension lblSize = new Dimension(280, 25);
	private Dimension ClblSize = new Dimension(280, 25);
	private Font lblFont = new Font("Arial", Font.BOLD, 22);
	private Font cLblFont = new Font("Arial", Font.PLAIN, 20);

	private JButton modifyButton = new JButton("Enregistrer");
	private Contact contactModif;
	private JCheckBox favoris=new JCheckBox ("Favoris");
	private int id;
	private Contact_Details top;
	private TopTitleBar topPanel;
	private CarnetContact carnet=new CarnetContact();

	public Contact_Modif(int id, Contact_Details top ) {
		
		this.id=id;
		carnet.deseralize();
		contactModif=carnet.getCarnet().get(id);
		
		this.setLayout(new BorderLayout());
		this.top = top;

		
		contentPane.setLayout(new BorderLayout());

	
		modifyButton.addActionListener(new Modif_Click());
		
		topPanel=new TopTitleBar(new BackButton(), new Return_Click(), "Contacts", Color.GRAY);
	
		modifyButton.setForeground(Color.BLACK);

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

		favoris.setPreferredSize(lblSize);
		favoris.setSelected(carnet.getCarnet().get(id).isFavoris());
		panel.add(favoris);
		
		modifyButton.setPreferredSize(lblSize);
		modifyButton.setContentAreaFilled(false);
		panel.add(modifyButton);


		
		System.out.println("------Contact_Modif------");

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
			carnet.getCarnet().get(id).setNom(fieldName.getText());
			carnet.getCarnet().get(id).setPrenom(fieldPname.getText());
			carnet.getCarnet().get(id).setTel(fieldTel.getText());
			carnet.getCarnet().get(id).setFavoris(favoris.isSelected());
			carnet.serialize();
			top.refresh();
			top.remove(Contact_Modif.this);

		}
	}
	


}
