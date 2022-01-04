package it.unical.ingswwebcomp22.spritesriver.model;
import java.util.Date;

public class Gioco {
	
	private long ID_Gioco;
	
	private Date DataRilascio;
	
	private String Titolo;
	
	private String Genere;
	
	private String Piattaforma;
	
	private String Descrizione;

	
	public Date getDataRilascio() {
		return DataRilascio;
	}

	public void setDataRilascio(Date dataRilascio) {
		DataRilascio = dataRilascio;
	}

	public String getTitolo() {
		return Titolo;
	}

	public void setTitolo(String titolo) {
		Titolo = titolo;
	}

	public String getGenere() {
		return Genere;
	}

	public void setGenere(String genere) {
		Genere = genere;
	}

	public String getPiattaforma() {
		return Piattaforma;
	}

	public void setPiattaforma(String piattaforma) {
		Piattaforma = piattaforma;
	}

	public String getDescrizione() {
		return Descrizione;
	}

	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}

	
	public long getID_Gioco() {
		return ID_Gioco;
	}

	public void setID_Gioco(long l) {
		ID_Gioco = l;
	}
	

}
