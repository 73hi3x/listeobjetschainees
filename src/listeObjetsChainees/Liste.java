package listeObjetsChainees;



public class Liste
{
  Element premier;
  Element dernier;
  Element courant;
  int nbElt;

  //constructeur d'une liste vide

  public Liste()
  {
  premier = null;
  dernier = null;
  courant = null;
  nbElt = 0;
  }

  //test de la liste vide

  public boolean listeVide()
  {
  /*if (nbElt==0)
  return true;
  else return false;*/
	  return (nbElt==0);
  }

  //renvoie le nombre d'éléments de la liste
  public int nbElement()
  {
  return nbElt;
  }


  //insère un objet en tête de liste

  public void insererEnTeteDeListe (Object objet)
  {
  Element nouveau = new Element() ;
  nbElt ++;
  nouveau.reference = objet;
  nouveau.suivant = premier;     //le nouveau pointe vers l'ancien premier
  //cela marche aussi au départ d'une liste vide : premier = null
  premier = nouveau;              // le nouveau devient premier
  if (dernier == null) dernier = nouveau; //liste à un élément
  }


  //insertion après précédent dans la liste

  public void insererApres (Element precedent, Object objet)
  {
	  //liste vide
  if (precedent == null){ insererEnTeteDeListe (objet);}
  
  else
       {
        Element nouveau = new Element();
        nbElt++;
        nouveau.reference = objet;
        nouveau.suivant = precedent.suivant;
        precedent.suivant = nouveau;
        //cas d'insertion en fin de liste
        if (precedent==dernier) dernier=nouveau;
       }
  }

  //insertion en fin de liste

  public void insererEnFinDeListe(Object objet)
  {
  insererApres (dernier, objet);
  }


  public Object extraireEnTeteDeListe()throws Exception
  {
  Element extrait = premier;
  if (!listeVide())
  {
   premier=premier.suivant;//le deuxième devient premier
   nbElt--;//la liste compte un élément en moins
   if (premier==null) dernier=null;//la liste est vide
  }
  
  if (extrait==null){throw new Exception("pas d'extraction possible, liste vide !");}
  else return extrait.reference;
 // return extrait!=null ? extrait.reference : null;
  //retourne l'objet extrait ou null
  }
  
  
  public Object extraireApres (Element precedent)
  {
	  Element extrait = precedent.suivant;
	  //element extrait est celui qui suit le paramètre donné
	  precedent.suivant = extrait.suivant;
	  //permet de refermer la chaine avec les références de suivant
	  this.nbElt--;
	  if (extrait==dernier)dernier=precedent;
	  //si l'extrait est le dernier de liste
	  return extrait.reference;
  }
  
  public Object extraireEnFinDeListe()
  {
	Object extrait;  
	if (listeVide())
	{extrait = null;}
	else if (premier==dernier)//cas de la liste avec 1 élément
	{extrait=premier.reference;
	premier=null;
	dernier=null;
	this.nbElt=0;}
	else
	{
		//il faut retrouver le pointeur du dernier
		//or, on ne possède que des références au suivant
		//il faut pointer en début de liste et tout regarder
		Element pointer = premier;
		while (pointer.suivant != dernier)pointer = pointer.suivant;
		 extrait = extraireApres(pointer);
		//return extrait;
	}
	return extrait;
  }


  public void listerListe (String separateur)
  {
  if (this.listeVide())
  {System.out.println ("la liste est vide");
  } else {ouvrirListe();
  	System.out.println ("nombre d'éléments dans la liste : "+ this.nbElement()+"\n");
    while (!this.finListe()) {
    Object ptc = elementCourant();//fournit l'objet courant et positionne
    //le pointeur vers le prochain objet de la liste
    System.out.print(ptc);
    if (!finListe())System.out.print(separateur);
    }
  }
  }
  public Object elementCourant()
      //fournit l'objet courant de la liste et positionne le pointeur
      //vers l'objet suivant qui deviendra courant
  {
  Element ptc = courant;
  if (courant != null) {
  courant = courant.suivant;}
  return  (ptc!=null ? ptc.reference : null);
  }


  public boolean finListe()
      //retourne true si je suis en fin de liste
  {
  if (courant == null)
    return true;
  else return false;
  }

  public void ouvrirListe()
      //pointe vers le premier élément de la liste
  {
  this.courant = premier;
  }


}
