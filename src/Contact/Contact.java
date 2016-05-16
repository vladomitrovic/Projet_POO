package Contact;
import Galerie.Photo;


public class Contact {

	private String nom, prenom, tel;
	private Photo photo;
	
	public Contact(String nom, String prenom, String tel){
		this.nom=nom;
		this.prenom=prenom;
		this.tel=tel;
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
