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
	private JLabel lblPrenom = new JLabel("Pr�nom");
	private JLabel lblNumero = new JLabel("Num�ro");
	
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
		modif.addActionListener(new Modif());
		
	

	}
	
	class Modif implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			contentPane.setVisible(false);
			
//			Contact c=carnet.getCarnet().get(index);
			
			
//			MainPanelContact.this.add(new ModifContact(c));
			
		}
		
	}
	
	
	class ModifContact extends JPanel{
		
		private JPanel contentPane =new JPanel();
		
		private JLabel lblNom = new JLabel("Nom");
		private JLabel lblPrenom = new JLabel("Pr�nom");
		private JLabel lblNumero = new JLabel("Num�ro");
		
		private JTextField fieldName = new JTextField("");
		private JTextField fieldPname = new JTextField("");
		private JTextField fieldTel = new JTextField("");
		
		private TopBarPanel topBar;
		private JPanel top;
		
		
		public ModifContact(Contact c){
			
			this.setLayout(new BorderLayout());
			this.top=top;
			topBar = new TopBarPanel(ModifContact.this,top);
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
	
	

}
