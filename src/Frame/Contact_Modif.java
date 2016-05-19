package Frame;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Contact.Contact;


public class Contact_Modif extends JPanel{
	
	private JPanel contentPane =new JPanel();
	
	private JLabel lblNom = new JLabel("Nom");
	private JLabel lblPrenom = new JLabel("Prénom");
	private JLabel lblNumero = new JLabel("Numéro");
	
	private JTextField fieldName = new JTextField("");
	private JTextField fieldPname = new JTextField("");
	private JTextField fieldTel = new JTextField("");
	
	private TopBarPanel topBar;
	private JPanel top;
	
	
	public Contact_Modif(Contact c){
		
		this.setLayout(new BorderLayout());
		this.top=top;
		topBar = new TopBarPanel(Contact_Modif.this,top);
		add(topBar, BorderLayout.NORTH);
		
		
		add(contentPane);
		contentPane.setLayout(new BorderLayout());

		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		

		lblPrenom.setBounds(106, 171, 71, 63);
		panel.add(lblPrenom);
		
		fieldPname.setBounds(211, 171, 121, 63);
		panel.add(fieldPname);
		fieldPname.setText(c.getPrenom());
		

		lblNom.setBounds(106, 247, 87, 63);
		panel.add(lblNom);
		

		fieldName.setBounds(211, 247, 105, 63);
		panel.add(fieldName);
		fieldName.setText(c.getNom());
		

		lblNumero.setBounds(106, 309, 71, 63);
		panel.add(lblNumero);
		

		fieldTel.setBounds(211, 309, 95, 63);
		panel.add(fieldTel);
		fieldTel.setText(c.getTel());
		
		
	
		
		
		
	}
	
	
}
