package Notes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class BlocNotes {

	private ArrayList<Note> blocNotes = new ArrayList<Note>();



	public void addNote(Note n) {
		blocNotes.add(n);
		orderOnUpdate((blocNotes.size()-1));
		refreshId();
	}

//	public String displayInButton(String texte) {
//		String returnText = "<html>";
//		for (int i = 0; i < texte.length(); i++) {
//
//			if (i == 55)
//				return returnText;
//
//			if (i % 11 == 0 && i != 0) {
//				returnText += "<br/>" + texte.charAt(i);
//			} else {
//				returnText += texte.charAt(i);
//			}
//
//		}
//		returnText += "</html>";
//		return returnText;
//
//	}

	public void deleteNote(int id) {
		blocNotes.remove(id);
		refreshId();
	}

	public ArrayList<Note> getBlocNotes() {
		return blocNotes;
	}

	public void serialize() {
		try {
			FileOutputStream fos = new FileOutputStream("Bloc-Notes/Bloc-Notes.serial");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(blocNotes);
			oos.flush();
			oos.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deserialize() {
		try {
			FileInputStream fis = new FileInputStream("Bloc-Notes/Bloc-Notes.serial");
			ObjectInputStream ois = new ObjectInputStream(fis);
			blocNotes = (ArrayList<Note>) ois.readObject();
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void refreshId() {

		for (int i = 0; i < blocNotes.size(); i++) {
			blocNotes.get(i).setId(i);
		}
	}

	
	public void orderOnUpdate(int updated) {

		Note temp = new Note(null);
		temp = blocNotes.get(0);
		blocNotes.set(0, blocNotes.get(updated));

		for (int i = updated; i > 1; i--) {
			System.out.println("i = " + i);
			blocNotes.set(i, blocNotes.get((i - 1)));
		}

		blocNotes.set(1, temp);


	}
}
