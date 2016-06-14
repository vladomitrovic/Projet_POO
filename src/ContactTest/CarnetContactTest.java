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
		 * Ce test unitaire consiste à vérifier que notre méthode newContact()
		 * ajoute bien un contact à l'ArrayList de contact. C'est pourquoi nous
		 * avons créé une arraylist vide, nous y ajoutons le nombre d'éléments
		 * que contient l'ArrayList des contacts. Celles-ci ont donc la même
		 * taille avant d'appeler la méthode newContact qui devrait ajouter un
		 * élément à notre ArrayList de contacts et donc augmenter sa taille
		 * Après l'ajout nous vérifions donc que la taille de notre ArrayList de
		 * test est égal à la taille de l'ArrayList de contacts -1
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
