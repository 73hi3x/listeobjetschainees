package listeObjetsChainees;
/**
 * 
 * classe Personne
 * @author 73hi3x
 *
 */

	  public class Personne {
		  private String nom;
		  private String prenom;
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
		  public Personne() {
		  	super();
		  }
		  public Personne(String nom, String prenom) {
		  	super();
		  	this.nom = nom;
		  	this.prenom = prenom;
		  }
		  @Override
		  public String toString() {
		  	return  nom + " " + prenom;
		  }

		  }

