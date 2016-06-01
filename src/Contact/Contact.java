package Contact;
import java.io.Serializable;
import java.util.Collections;

import Galerie.Photo;


public class Contact implements Serializable {
	private static final long serialVersionUID = 1928505403570541323L;
	
	private String nom, prenom, tel;
	private Photo photo;
	private int id;
	private boolean favoris;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isFavoris() {
		return favoris;
	}

	public void setFavoris(boolean favoris) {
		this.favoris = favoris;
	}

	public Contact(String nom, String prenom, String tel, boolean favoris){
		this.nom=nom;
		this.prenom=prenom;
		this.tel=tel;
		this.favoris=favoris;
	}
	
	public String getNomPrenom() {
		return prenom+" "+nom;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	
	


	
	
	
	
	
}
