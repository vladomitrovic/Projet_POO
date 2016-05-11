package Frame;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Launcher extends JFrame{

	private JButton contact=new JButton("Contacts");
	private JButton galerie=new JButton("Galerie");
	private JButton inconnu=new JButton("inconnu");
	
	
	
	public Launcher(){

		//Affichage de la frame
		setPreferredSize(new Dimension(480, 800));
		setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		
		
		//Ajout des bouttons
		add(contact, BorderLayout.NORTH);
		add(galerie, BorderLayout.CENTER);
		add(inconnu, BorderLayout.SOUTH);
		
		
		contact.setPreferredSize(new Dimension(480, 266));
		galerie.setPreferredSize(new Dimension(480, 267));
		inconnu.setPreferredSize(new Dimension(480, 266));
		
		
		
	}
	
	
	
	
	
}
