package it.polito.tdp.libretto.model;

import java.time.LocalDate;

/**
 * Oggetto semplice che contiene i dati relativi ad un singolo esame
 * POJO - Plain Old Java Object
 * 
 * Oggetto che ha all'interno:
 * 
 * dati privati (propriet�)
 * costruttore
 * metodi get/set 
 * metodi di servizio (equals(), toString(), hashCode(), [compareTo()])
 * 
 * @author Rebecca
 *
 */
public class Esame {
	
	private String codice;
	private String titolo;
	private String docente;
	private boolean superato;
	private int voto;
	private LocalDate dataSuperamento;
	
	/**
	 * Nuovo esame, non ancora superato
	 * @param codice codice dell'esame
	 * @param titolo denominazione del corso
	 * @param docente cognome e nome del docente titolare
	 */
	public Esame(String codice, String titolo, String docente) {
		super();
		this.codice = codice;
		this.titolo = titolo;
		this.docente = docente;
		
		this.superato = false;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public boolean isSuperato() {
		return superato;
	}

	private void setSuperato(boolean superato) {
		this.superato = superato;
	}

	/**
	 * Restituisce il voto solo se l'esame
	 * � stato superato, altrimenti eccezione.
	 * @return
	 */
	public int getVoto() {
		if(this.superato)
			return voto;
		else
			throw new IllegalStateException("Esame " + this.codice + "non ancora superato");
	}

	private void setVoto(int voto) {
		this.voto = voto;
	}

	public LocalDate getDataSuperamento() {
		if(this.superato)
			return dataSuperamento;
		else
			throw new IllegalStateException("Esame " + this.codice + "non ancora superato");
	}

	private void setDataSuperamento(LocalDate dataSuperamento) {
		this.dataSuperamento = dataSuperamento;
	}

	@Override
	public String toString() {
		return "Esame [codice=" + codice + ", titolo=" + titolo + ", docente=" + docente + ", superato=" + superato
				+ ", voto=" + voto + ", dataSuperamento=" + dataSuperamento + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}
	
	/**
	 * Se l'esame non � ancora superato, lo considera superato 
	 * con il voto e la data specificati.
	 * Se l'esame � gi� stato superato, genera eccezione.
	 * 
	 * @param voto
	 * @param data
	 */
	
	public void supera(int voto, LocalDate data) {
		
		if(!this.superato) {
			
			this.superato = true;
			this.voto = voto;
			this.dataSuperamento = data;
		}
		else
			throw new IllegalStateException("Esame " + this.codice + "gi� superato");
	}	
}
