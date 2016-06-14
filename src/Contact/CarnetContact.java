package Contact;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class CarnetContact {
	private static final long serialVersionUID = 1L;

	private ArrayList<Contact> carnet = new ArrayList<Contact>();

	public void newContact(String prenom, String nom, String tel, boolean favoris) {
		this.carnet.add(new Contact(prenom, nom, tel, favoris));
		refreshId();
	}

	public void deleteContact(int id) {
		this.carnet.remove(id);
		refreshId();

	}

	public ArrayList<Contact> getCarnet() {
		return carnet;
	}

	public void serialize() {
		orderAbc();
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
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void refreshId() {
		/*
		 * Nous permets d'avoir les id à jours lors d'une suppression ou ajout
		 */
		for (int i = 0; i < carnet.size(); i++) {
			carnet.get(i).setId(i);
		}
	}

	public ArrayList<String> orderString() {
		/*
		 * On créer une ArrayList de String afin d'avoir les contacts sous forme
		 * de prenomnomid.
		 * 
		 * Ensuite nous trions afin d'avoir un ordre alphabétique.
		 */
		ArrayList<String> contactNames = new ArrayList<String>();
		for (int i = 0; i < carnet.size(); i++) {
			contactNames.add(carnet.get(i).getPrenom() + carnet.get(i).getNom() + carnet.get(i).getId());
		}
		Collections.sort(contactNames.subList(0, contactNames.size()));

		return contactNames;
	}

	public void orderAbc() {
		ArrayList<Contact> contactAbc = new ArrayList<Contact>();
		/*
		 * On compare nos contacts sous forme objet avec nos contacts sous forme
		 * String (ordrés ABC)
		 * 
		 * Lorsque le contact correspond, on lui attribut la même place dans la
		 * liste objet, ainsi on peut avoir nos contact objet dans le même ordre
		 * que les contact String triés auparavant.
		 */

		// création d'un tableau de contact vide de la bonne taille
		for (int i = 0; i < carnet.size(); i++) {
			contactAbc.add(new Contact());
		}

		// modification de l'ordre
		for (int i = 0; i < carnet.size(); i++) {
			String comparaison = carnet.get(i).getPrenom() + carnet.get(i).getNom() + carnet.get(i).getId();
			for (int j = 0; j < carnet.size(); j++) {
				if (comparaison.equals(orderString().get(j).toString())) {
					contactAbc.set(j, carnet.get(i));
					break;
				}
			}
		}
		carnet = contactAbc;
	}

}
