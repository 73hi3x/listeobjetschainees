package listeObjetsChainees;

/**
 * chainés des éléments  entre eux.
 * @author 73hi3x
 *
 */
public class Element {

	private Personne personne;
	private Element next;
	
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	public Element getNext() {
		return next;
	}
	public void setNext(Element next) {
		this.next = next;
	}

	public Element() {
		super();
	}

	public Element(Personne personne, Element next) {
		super();
		this.personne = personne;
		this.next = next;
	}
	@Override
	public String toString() {
		return personne + " " + next;
	}
	 
}
