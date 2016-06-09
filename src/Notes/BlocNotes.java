package Notes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BlocNotes {

	private ArrayList<Note> blocNotes = new ArrayList<Note>();

	public void newNote(String texte) {
		blocNotes.add(new Note(texte));
		refreshId();
	}

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

}
