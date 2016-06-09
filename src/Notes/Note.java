package Notes;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String texte;
	private Date date;

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
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
