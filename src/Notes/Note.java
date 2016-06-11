package Notes;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Note implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String texte;
	private String timeStamp="-";

	public Note(String texte) {
		this.texte = texte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
		this.timeStamp=new SimpleDateFormat("dd.MM.yy - HH:mm").format(Calendar.getInstance().getTime());;
	}

	public String getDate() {
		return timeStamp;
	}



}
