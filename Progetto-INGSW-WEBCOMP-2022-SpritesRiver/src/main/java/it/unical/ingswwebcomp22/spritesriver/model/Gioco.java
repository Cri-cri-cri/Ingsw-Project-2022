package it.unical.ingswwebcomp22.spritesriver.model;
import java.io.File;
import java.util.Date;
import java.util.Date;

public class Gioco {
	
	private int ID_Gioco;
	
	private File Image;
	
	private String ImagePath;
	
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

	
	public int getID_Gioco() {
		return ID_Gioco;
	}

	public void setID_Gioco(int iD_Gioco) {
		ID_Gioco = iD_Gioco;
	}

	public File getImage() {
		return Image;
	}

	public void setImage(File image) {
		Image = image;
	}

	public String getImagePath() {
		return ImagePath;
	}

	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}
	

}
