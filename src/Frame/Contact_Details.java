package Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Contact.Contact;

 public class Contact_Details extends JPanel{
	
	private JPanel contentPane =new JPanel();
	
	private JLabel lblNom = new JLabel("Nom");
	private JLabel lblPrenom = new JLabel("Prénom");
	private JLabel lblNumero = new JLabel("Numéro");
	
	private JLabel lblCName = new JLabel("");
	private JLabel lblCPname = new JLabel("");
	private JLabel lblCTel = new JLabel("");
	
	private JButton modif=new JButton("Modifier");

	



	public Contact_Details(Contact c) {
		this.setLayout(new BorderLayout());

		
		
		add(contentPane);
		contentPane.setLayout(new BorderLayout());

		
		
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
		
		
		
		add(modif, BorderLayout.SOUTH);
		modif.addActionListener(new Modif_Click());
		
	

	}
	
	class Modif_Click implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			contentPane.setVisible(false);
			
//			Contact c=carnet.getCarnet().get(index);
			
			
//			MainPanelContact.this.add(new ModifContact(c));
			
		}
		
	}
	
	
	
	

}
