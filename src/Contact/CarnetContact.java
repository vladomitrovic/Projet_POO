package Contact;
import java.util.ArrayList;

public class CarnetContact {
	
	private String name;
	private ArrayList<Contact> carnet = new ArrayList<Contact>();
	
	
	public CarnetContact(){
		
	}
	
	
	public void newContact(String nom, String prenom, String tel){
			this.carnet.add(new Contact(nom, prenom, tel));					
	}
	
	public void delContact(Contact contact){
		this.carnet.remove(contact);
	}
	
	

}
