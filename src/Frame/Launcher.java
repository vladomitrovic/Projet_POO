package Frame;

import java.awt.*;
import javax.swing.*;

public class Launcher extends JFrame{

	private JButton contact=new JButton("Contacts");
	private JButton galerie=new JButton("Galerie");
	private JButton inconnu=new JButton("inconnu");
	private JPanel panel=new JPanel();
	
	private ImageIcon wallPaper=new ImageIcon("C:/Users/Vlado/Desktop/wallpaper.JPEG");
	
	
	
	public Launcher(){

		//Affichage de la frame
		
		setPreferredSize(new Dimension(480, 800));
		setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		
		
		
		contact.setAlignmentX(Component.CENTER_ALIGNMENT);
		galerie.setAlignmentX(Component.CENTER_ALIGNMENT);
		inconnu.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(contact);
		panel.add(galerie);
		panel.add(inconnu);
		add(panel);
		
		
		
		
//		//Ajout des bouttons
//		add(contact, BorderLayout.NORTH);
//		add(galerie, BorderLayout.CENTER);
//		add(inconnu, BorderLayout.SOUTH);
//		
//		
//		contact.setPreferredSize(new Dimension(100, 50));
//		galerie.setPreferredSize(new Dimension(100, 50));
//		inconnu.setPreferredSize(new Dimension(100, 50));		
		
		
	}
	
	
	
	
	
}
