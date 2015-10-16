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

  //renvoie le nombre d'�l�ments de la liste
  public int nbElement()
  {
  return nbElt;
  }


  //ins�re un objet en t�te de liste

  public void insererEnTeteDeListe (Object objet)
  {
  Element nouveau = new Element() ;
  nbElt ++;
  nouveau.reference = objet;
  nouveau.suivant = premier;     //le nouveau pointe vers l'ancien premier
  //cela marche aussi au d�part d'une liste vide : premier = null
  premier = nouveau;              // le nouveau devient premier
  if (dernier == null) dernier = nouveau; //liste � un �l�ment
  }


  //insertion apr�s pr�c�dent dans la liste

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
   premier=premier.suivant;//le deuxi�me devient premier
   nbElt--;//la liste compte un �l�ment en moins
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
	  //element extrait est celui qui suit le param�tre donn�
	  precedent.suivant = extrait.suivant;
	  //permet de refermer la chaine avec les r�f�rences de suivant
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
	else if (premier==dernier)//cas de la liste avec 1 �l�ment
	{extrait=premier.reference;
	premier=null;
	dernier=null;
	this.nbElt=0;}
	else
	{
		//il faut retrouver le pointeur du dernier
		//or, on ne poss�de que des r�f�rences au suivant
		//il faut pointer en d�but de liste et tout regarder
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
  	System.out.println ("nombre d'�l�ments dans la liste : "+ this.nbElement()+"\n");
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
      //pointe vers le premier �l�ment de la liste
  {
  this.courant = premier;
  }


}
