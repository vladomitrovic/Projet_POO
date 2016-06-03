package Frame;

import java.util.ArrayList;
import java.util.Collections;

import Contact.CarnetContact;
import Contact.Contact;

public class TestOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	

		CarnetContact carnet = new CarnetContact();
		carnet.deseralize();
	
		carnet.newContact("Vlado", "Mitrovic", "079 439 22 26", true);
		carnet.newContact("Aleks", "Lazic", "079 741 85 96", true);
		carnet.newContact("Fargas", "Clerc", "077 852 22 26", false);
		carnet.newContact("Adam", "Smith", "078 456 52 63", false);
		carnet.newContact("Robert", "Seligman", "074 456 78 96", true);
		carnet.newContact("Hugo", "Rebelo", "079 478 45 26", true);
		carnet.newContact("Natalija", "Mitrovic", "078 456 22 26", true);
		carnet.newContact("Dragan", "Mitrovic", "079 375 22 26", true);
		carnet.newContact("Milica", "Mitrovic", "079 478 22 45", true);
		carnet.newContact("Pero", "Lazic", "079 456 47 26", false);
		carnet.newContact("Dan", "De Girolamo", "079 654 25 26", true);
		carnet.newContact("Jean", "Martin", "079 478 45 85", false);
		carnet.newContact("Paul", "Dupont", "074 456 25 68", false);

		carnet.serialize();

	}



}
