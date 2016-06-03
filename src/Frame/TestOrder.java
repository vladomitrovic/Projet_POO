package Frame;

import java.util.ArrayList;
import java.util.Collections;

import Contact.CarnetContact;
import Contact.Contact;

public class TestOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		ArrayList<String> contactNames = new ArrayList<String>();
		
		CarnetContact carnet=new CarnetContact();
		carnet.deseralize();
		carnet.show();
		order(carnet.getCarnet(), contactNames);
		contacts = orderContacts(carnet.getCarnet(), contactNames);

	}

	public static void order(ArrayList<Contact> contacts, ArrayList<String> contactNames) {
//		contacts.add(new Contact("Hugo", "Rebelo", "0792490274", true));
//		contacts.add(new Contact("Salut", "Aleksandar", "0792490274", true));
//		contacts.add(new Contact("Mitrovic", "Vlado", "0792490274", true));
//		contacts.add(new Contact("Lazic", "Aleksandar", "0792490274", true));
//		contacts.add(new Contact("Louis", "Bonvin", "0792490274", true));

		for (int i = 0; i < contacts.size(); i++) {
			contactNames.add(contacts.get(i).getId() + contacts.get(i).getNomPrenom());
		}

		Collections.sort(contactNames.subList(0, contactNames.size()));

		System.out.println("ORDER OF STRING ARRAYLIST\n");

		for (int i = 0; i < contactNames.size(); i++) {
			System.out.println(contactNames.get(i).toString());
		}

	}

	public static ArrayList<Contact> orderContacts(ArrayList<Contact> contacts, ArrayList<String> contactNames) {
		ArrayList<Contact> contacts2 = contacts;
		for (int i = 0; i < contacts.size(); i++) {
			String comparaison = contacts.get(i).getId() + contacts.get(i).getNomPrenom();
			for (int j = 0; j < contacts.size(); j++) {
				if (comparaison.equals(contactNames.get(j))) {
					contacts2.set(j, contacts.get(i));
					break;
				}
			}
		}

		System.out.println("ORDER OF CONTACT ARRAYLIST\n");

		for (int i = 0; i < contacts2.size(); i++) {
			System.out.println(contacts2.get(i).getNomPrenom());
		}

		return contacts2;

	}
}
