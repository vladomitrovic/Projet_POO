package Contact;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;

public class CarnetContact {
	private static final long serialVersionUID = 1L;

	private ArrayList<Contact> carnet = new ArrayList<Contact>();

	public CarnetContact() {

	}

	public void newContact(String nom, String prenom, String tel, boolean favoris) {
		this.carnet.add(new Contact(nom, prenom, tel, favoris));
	}

	public void newContact(Contact contact) {
		this.carnet.add(contact);
	}

	public void deleteContact(int id) {
		this.carnet.remove(id);
		refreshId();

	}

	public ArrayList<Contact> getCarnet() {
		return carnet;
	}

	public void serialize() {

		try {

			FileOutputStream fos = new FileOutputStream("Contacts/CarnetContact.serial");

			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(this.carnet);

			oos.flush();

			oos.close();
			
			fos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void deseralize() {
		try {
			FileInputStream fis = new FileInputStream("Contacts/CarnetContact.serial");
			ObjectInputStream ois = new ObjectInputStream(fis);
			this.carnet = (ArrayList<Contact>) ois.readObject();

			ois.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void refreshId() {

		for (int i = 0; i > carnet.size(); i++) {
			carnet.get(i).setId(i);
		}

	}

	public void show() {
		String temp = "CarnetContact : \n";

		for (int i = 0; i < carnet.size(); i++) {

			temp += carnet.get(i).getNom() + "\n";

		}

		System.out.println(temp);

	}

	public void sortAbc() {

	}

}
