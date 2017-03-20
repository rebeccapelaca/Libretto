package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	
	private List<Esame> esami;
	
	public Model() {
		
		this.esami = new ArrayList<Esame>();
	}
	
	/**
	 * Aggiunge un nuovo esame all'elenco degli esami presenti,
	 * verificando che non ci sia già
	 * 
	 * @param e
	 * @return true se l'ha inserito, false se esisteva già e non l'ha potuto inserire
	 */
	public boolean addEsame(Esame e) {
		
		if(!esami.contains(e)){
			esami.add(e);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Ricerca se esiste un esame con il codice specificato.
	 * Se esiste lo restituisce, altrimenti restituisce null
	 * @param codice esame da cercare
	 * @return l'esame trovato o null se non l'ha trovato
	 */
	
	public Esame trovaEsame(String codice) {
		
		int posizione = this.esami.indexOf(new Esame(codice, null, null));
		
		if(posizione == -1)
			return null;
		else
			return esami.get(posizione);
	}

}
