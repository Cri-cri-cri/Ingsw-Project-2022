package it.unical.mat.ingswwebcomp22.spritesriver.model;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;

public class Gioco {
	
	
	private int ID_Gioco;
	
	private Path ImagePath;
	
	private String DataRilascio;
	
	private String Titolo;
	
	private String Genere;
	
	private String Piattaforma;
	
	private String Descrizione;

	private List<Sprite> sprites;
	
	public String getDataRilascio() {
		return DataRilascio;
	}

	public void setDataRilascio(String date) {
		DataRilascio = date;
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
	
	public String getImagePath() {
		return ImagePath.toString();
	}

	public void setImagePath(String path) {
		ImagePath = Paths.get(path);
	}

	public List<Sprite> getSprites() {
		return sprites;
	}

	public void setSprites(List<Sprite> sprites) {
		this.sprites = sprites;
	}
	

}
