package ContactTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Contact.CarnetContact;
import Contact.Contact;

public class CarnetContactTest {

	@Test
	public void newContact() {
		/*
		 * Ce test unitaire consiste � v�rifier que notre m�thode newContact()
		 * ajoute bien un contact � l'ArrayList de contact. C'est pourquoi nous
		 * avons cr�� une arraylist vide, nous y ajoutons le nombre d'�l�ments
		 * que contient l'ArrayList des contacts. Celles-ci ont donc la m�me
		 * taille avant d'appeler la m�thode newContact qui devrait ajouter un
		 * �l�ment � notre ArrayList de contacts et donc augmenter sa taille
		 * Apr�s l'ajout nous v�rifions donc que la taille de notre ArrayList de
		 * test est �gal � la taille de l'ArrayList de contacts -1
		 * 
		 */
		CarnetContact carnetContact = new CarnetContact();
		carnetContact.deseralize();
		ArrayList<Contact> carnetTest = new ArrayList<Contact>();

		for (int i = 0; i < carnetContact.getCarnet().size(); i++) {
			carnetTest.add(null);
		}

		System.out.println(carnetTest.size());
		System.out.println(carnetContact.getCarnet().size());

		carnetContact.newContact("TEST", "junit", "01", false);

		int sizeA = carnetTest.size();
		System.out.println(sizeA);
		int sizeB = carnetContact.getCarnet().size();
		System.out.println(sizeB);

		assertEquals(sizeA, sizeB - 1, 0.00);

	}

}
