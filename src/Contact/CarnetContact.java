package Contact;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;

public class CarnetContact {
	

	private ArrayList<Contact> carnet = new ArrayList<Contact>();
	
	
	public CarnetContact(){
		
	}
	
	
	public void newContact(String nom, String prenom, String tel){
			this.carnet.add(new Contact(nom, prenom, tel));					
	}
	
	public void newContact(Contact contact){
		this.carnet.add(contact);			
}
	
	public void delContact(Contact contact){
		this.carnet.remove(contact);
	}


	public ArrayList<Contact> getCarnet() {
		return carnet;
	}
	
	public void serialize(){
		
		try {

		FileOutputStream fos = new FileOutputStream("C:/Users/Vlado/Desktop/personne.serial");

		ObjectOutputStream oos=new ObjectOutputStream(fos);
		
//		oos.writeObject(p1);
		
		oos.flush();
		
		oos.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
