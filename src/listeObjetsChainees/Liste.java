package listeObjetsChainees;



public class Liste {
	
	private Element premier;
	private Element dernier;
	private Element courant;
	
	int nbElt;
	
	public Element getPremier() 
	{
		return premier;
	}
	
	public void setPremier(Element premier) 
	{
		this.premier = premier;
	}
	
	public Element getDernier()
	{
		return dernier;
	}
	public void setDernier(Element dernier)
	{
		this.dernier = dernier;
	}
	
	public Element getCourant()
	{
		return courant;
	}
	
	public void setCourant(Element courant)
	{
		this.courant = courant;
	}
	
	public int getNbElt() 
	{
		return nbElt;
	}
	
	public void setNbElt(int nbElt) 
	{
		this.nbElt = nbElt;
	}
	
	public Liste() 
	{
		super();
		premier=null;
		dernier=null;
		courant=null;
		nbElt=0;
	}
	/**
	 * verifie si liste est vide
	 * @return true
	 * sinon return false
	 */
	public  boolean listeVide()
	{
		if (premier==null){
		return true;}
		else{
			return false;
		}
	}
	
	public int nbElement()
	{

		return nbElt;

		
	} 
	
	/**
	 * insere un element en tete de liste
	 * @param personne
	 */
	public void insererEnTeteDeListe(Personne personne) {
		Element ancienPremier= premier;
		premier= new Element(personne,ancienPremier);
		  nbElt ++;
	}
	/**
	 *  insère l’élément nouveau après l’élément précédent de la liste.
	 * @param precedent
	 * @param nouveau
	 */
	public void insererApres (Element precedent, Personne personne){
		Element ancienPrecedent= precedent;
		precedent= new Element(personne,ancienPrecedent);
	} 
	/**
	 *  insère l’objet en fin de liste
	
	 * @param objet
	 */
	
	public void insererEnFinDeListe(Personne personne ){
	
			if (listeVide()) {
			premier= new Element(personne,null);
			} else {
			
			Element dernier = getDernier();

			dernier.setNext(dernier);
			dernier.setPersonne(personne);
			}
			}
			/**
			*Trouve le dernier élément d’une liste non vide.
			*Lance une {@link NullPointerException} pour une liste vide.
			*@return le dernier élément d’une liste
			*@throws une NullPointerException si la liste est vide
			*/
			private Element setDernier() {
			Element dernier= premier;
			while (dernier.getNext() != null) {
			dernier= dernier.getNext();
			}
			return dernier;
			}

	 
	/**
	 * 	fournit une référence sur l’objet extrait en tête de liste
	 * @return
	 */
	public  Object extraireEnTeteDeListe(){
		return courant;}
/**
 *  fournit une référence sur l’élément extrait de la liste après l’élément precedent
	
 * @param precedent
 * @return
 */
	public Object extraireApres(Element precedent){
		return precedent;
		
	} 
	/**
	 *  fournit une référence sur l’objet extrait en fin de liste
	 * @return
	 */
	public Object extraireEnFinDeListe(){
		return true;
	}
/**
 * ; se positionne sur le premier objet de la liste
 */
public void ouvrirListe(){
	
} 
/**
 * ; indique si on a parcouru toute la liste.

 * @return
 */
public boolean finListe(){
	return true;
} 
public Object elementCourant(){
	return courant;}
public void listerListe(String separateur) {}
@Override
public String toString() {
	return "Liste [premier=" + premier + ", dernier=" + dernier + ", courant="
			+ courant + ", nbElt=" + nbElt + "]";
}

}
