package Frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainPanelContact extends JPanel{
	
	private JPanel contentPane =new JPanel();
	private JLabel lblContact = new JLabel("Contact");
	private JLabel lblNom = new JLabel("Nom");
	private JLabel lblPrnom = new JLabel("Prénom");
	private JLabel lblNumro = new JLabel("Numéro");
	
	private JLabel lblVlado = new JLabel("Vlado");
	private JLabel label = new JLabel("Mitrovic");
	private JLabel label_1 = new JLabel("079 432 22 26");
	
	private JButton modif=new JButton("Modifier");



	public MainPanelContact() {
		

		setSize(480, 800);
		add(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		

		lblPrnom.setBounds(106, 171, 71, 63);
		panel.add(lblPrnom);
		lblVlado.setBounds(211, 171, 121, 63);
		panel.add(lblVlado);
		

		lblNom.setBounds(106, 247, 87, 63);
		panel.add(lblNom);
		

		label.setBounds(211, 247, 105, 63);
		panel.add(label);
		

		lblNumro.setBounds(106, 309, 71, 63);
		panel.add(lblNumro);
		

		label_1.setBounds(208, 309, 95, 63);
		panel.add(label_1);
		
		
		add(modif, BorderLayout.SOUTH);
		modif.addActionListener(new Modif());
		
	
		contentPane.add(lblContact, BorderLayout.NORTH);
	}
	
	class Modif implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			
		}
		
	}
	
	

}
