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

		CarnetContact carnet = new CarnetContact();
		carnet.deseralize();
		for (int i = 0; i < carnet.getCarnet().size(); i++) {
			System.out.println(carnet.getCarnet().get(i).getNomPrenom());
		}
		System.out.println();
		System.out.println();
		System.out.println("--------------------");

		order(carnet.getCarnet(), contactNames);
		contacts = orderContacts(carnet.getCarnet(), contactNames);

	}

	public static void order(ArrayList<Contact> contacts, ArrayList<String> contactNames) {

		for (int i = 0; i < contacts.size(); i++) {
			contactNames.add(contacts.get(i).getNomPrenom() + contacts.get(i).getId());

		}

		Collections.sort(contactNames.subList(0, contactNames.size()));

		System.out.println("ORDER OF STRING ARRAYLIST\n");

		for (int i = 0; i < contactNames.size(); i++) {
			System.out.println(contactNames.get(i).toString());
		}

		System.out.println("-----------------------------");

	}

	public static ArrayList<Contact> orderContacts(ArrayList<Contact> contacts, ArrayList<String> contactNames) {
		ArrayList<Contact> contacts2 = new ArrayList<Contact>();

		// création d'un tableau de contact vide de la bonne taille
		for (int i = 0; i < contacts.size(); i++) {
			contacts2.add(new Contact());
		}

		//modification de l'ordre
		for (int i = 0; i < contacts.size(); i++) {
			String comparaison = contacts.get(i).getNomPrenom() + contacts.get(i).getId();
			System.out.println("index: " + i);
			System.out.println("Comparaison de : " + comparaison);
			for (int j = 0; j < contacts.size(); j++) {
				System.out.println("avec : " + contactNames.get(j).toString() + "\n---------");
				if (comparaison.equals(contactNames.get(j).toString())) {
					contacts2.set(j, contacts.get(i));
					System.out.println("OK" + j + "\n--------------------------");
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
