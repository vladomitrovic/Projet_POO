package Frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Elements.BackButton;

public class Contact_Add extends JPanel {

	private JPanel contentPane = new JPanel();

	private JLabel lblNom = new JLabel("Nom");
	private JLabel lblPrenom = new JLabel("Prénom");
	private JLabel lblNumero = new JLabel("Numéro");

	private JTextField lblCName = new JTextField("");
	private JTextField lblCPname = new JTextField("");
	private JTextField lblCTel = new JTextField("");
	
	JButton add = new JButton("Ajouter");
	
	private JPanel topPanel = new JPanel();
	private FlowLayout topLayout = new FlowLayout();
	private JLabel titleLbl = new JLabel("Contact");
	private JButton modifyButton = new JButton("Modifier");

	BackButton backButton = new BackButton();

	public Contact_Add(JPanel top) {
		this.setLayout(new BorderLayout());



		add(contentPane);
		contentPane.setLayout(new FlowLayout());

		contentPane.add(add);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		lblPrenom.setBounds(106, 171, 71, 35);
		panel.add(lblPrenom);

		lblCPname.setBounds(211, 171, 121, 35);
		panel.add(lblCPname);

		lblNom.setBounds(106, 247, 87, 35);
		panel.add(lblNom);

		lblCName.setBounds(211, 247, 105, 35);
		panel.add(lblCName);

		lblNumero.setBounds(106, 309, 71, 35);
		panel.add(lblNumero);

		lblCTel.setBounds(211, 309, 95, 35);
		panel.add(lblCTel);

	}

}
