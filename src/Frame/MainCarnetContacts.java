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


public class MainCarnetContacts extends JPanel{
	
	JPanel liste =new JPanel();
	private ArrayList<JButton> buttons= new ArrayList<JButton>();

	CarnetContact carnet=new  CarnetContact();
	
	Contact vlado=new Contact ("Mitrovic", "Vlado", "079 439 22 26");
	Contact john=new Contact ("Doe", "John", "079 123 45 67");
	
	
	public MainCarnetContacts(){
		setPreferredSize(new Dimension(480, 800));
		setLayout(new BorderLayout());
		GridLayout grid=new GridLayout(1,10);
		
		liste.setLayout(grid);
		
		carnet.newContact(vlado);
		carnet.newContact(vlado);
		
		
		
		
		
		
		

	
		
	}
	
	

}
