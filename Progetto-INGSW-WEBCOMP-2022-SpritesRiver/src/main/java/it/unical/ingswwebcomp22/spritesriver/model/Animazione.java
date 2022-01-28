// ciao

package it.unical.ingswwebcomp22.spritesriver.model;

import java.io.File;

public class Animazione {
	
	private int Voto;
	
	private int ID_Animazione;
	
	private File File_GIF;
	
	private String NomeAzione;
	
	private String Personaggio;

	public int getVoto() {
		return Voto;
	}

	public void setVoto(int voto) {
		Voto = voto;
	}

	public int getID_Animazione() {
		return ID_Animazione;
	}

	public void setID_Animazione(int iD_Animazione) {
		ID_Animazione = iD_Animazione;
	}

	public File getFile_GIF() {
		return File_GIF;
	}

	public void setFile_GIF(File file_GIF) {
		File_GIF = file_GIF;
	}

	public String getNomeAzione() {
		return NomeAzione;
	}

	public void setNomeAzione(String nomeAzione) {
		NomeAzione = nomeAzione;
	}

	public String getPersonaggio() {
		return Personaggio;
	}

	public void setPersonaggio(String personaggio) {
		Personaggio = personaggio;
	}

}
