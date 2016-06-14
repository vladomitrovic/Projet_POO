package Contact;

import java.io.Serializable;

import Galerie.Photo;

public class Contact implements Serializable {
	private static final long serialVersionUID = 1928505403570541323L;

	private Photo photo = new Photo("PicturesElements/default_Contact.png");
	private String nom, prenom, tel;
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

	public Contact(String prenom, String nom, String tel, boolean favoris) {
		this.prenom = prenom;
		this.nom = nom;
		this.tel = tel;
		this.favoris = favoris;
	}

	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public String getNom() {
		return nom;
	}

	public String getPrenomNom() {
		if (prenom.equals("")) {
			return nom;
		}

		return prenom + " " + nom;
	}

	public String getNomPrenom() {
		return nom + " " + prenom;
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

	public void setPhoto(String path) {
		this.photo = new Photo(path);
	}

}
