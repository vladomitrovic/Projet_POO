package Frame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

import Contact.CarnetContact;
import Contact.Contact;


public class MainPanelCarnet extends JPanel{
	
	JPanel liste =new JPanel();


	ArrayList<Contact> carnet = new ArrayList<Contact>();
	
	Contact vlado=new Contact ("Mitrovic", "Vlado", "079 439 22 26");
	Contact john=new Contact ("Doe", "John", "079 123 45 67");
	Contact adam=new Contact ("Adam", "Smith", "078 765 41 23");
	
	
	public MainPanelCarnet(){
		setPreferredSize(new Dimension(480, 800));

		liste.setLayout(new GridLayout(carnet.size(),1));
		add(liste, BorderLayout.CENTER);
		
		
		
//		afficher contact
		for(Contact c :carnet){
			liste.add(new JButton(c.getNom()+" "+c.getPrenom()));
		}
		
		
		
		
		

	
		
	}
	
	

}
