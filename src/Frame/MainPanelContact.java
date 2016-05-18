package Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Contact.Contact;

public class MainPanelContact extends JPanel{
	
	private JPanel contentPane =new JPanel();
	private JLabel lblNom = new JLabel("Nom");
	private JLabel lblPrenom = new JLabel("Prénom");
	private JLabel lblNumero = new JLabel("Numéro");
	
	private JLabel lblCName = new JLabel("");
	private JLabel lblCPname = new JLabel("");
	private JLabel lblCTel = new JLabel("");
	
	private JButton modif=new JButton("Modifier");

	
	private TopBarPanel topBar;
	private JPanel top;


	public MainPanelContact(Contact c, JPanel top) {
		this.setLayout(new BorderLayout());
		this.top=top;
		topBar = new TopBarPanel(MainPanelContact.this,top);
		add(topBar, BorderLayout.NORTH);

		setSize(480, 800);
		add(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		

		lblPrenom.setBounds(106, 171, 71, 63);
		panel.add(lblPrenom);
		
		lblCPname.setBounds(211, 171, 121, 63);
		panel.add(lblCPname);
		lblCPname.setText(c.getPrenom());
		

		lblNom.setBounds(106, 247, 87, 63);
		panel.add(lblNom);
		

		lblCPname.setBounds(211, 247, 105, 63);
		panel.add(lblCPname);
		lblCPname.setText(c.getNom());
		

		lblNumero.setBounds(106, 309, 71, 63);
		panel.add(lblNumero);
		

		lblCTel.setBounds(208, 309, 95, 63);
		panel.add(lblCTel);
		lblCTel.setText(c.getTel());
		
		
		
		add(modif, BorderLayout.SOUTH);
		modif.addActionListener(new Modif());
		
	

	}
	
	class Modif implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
		}
		
	}
	
	

}
