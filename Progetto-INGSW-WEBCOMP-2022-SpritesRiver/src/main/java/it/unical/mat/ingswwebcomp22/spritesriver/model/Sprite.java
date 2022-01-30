package it.unical.mat.ingswwebcomp22.spritesriver.model;

import java.io.File;
import java.util.List;

public class Sprite {
	
	
	private int ID_Sprite;
	
	private List<Commento> commenti;
	
	private String SpriteSheet;
	
	private String ImmaginePersonaggio;
	
	private String Personaggio;


	public int getID_Sprite() {
		return ID_Sprite;
	}

	public void setID_Sprite(int iD_Sprite) {
		ID_Sprite = iD_Sprite;
	}	

	public String getPersonaggio() {
		return Personaggio;
	}

	public void setPersonaggio(String personaggio) {
		Personaggio = personaggio;
	}

	public String getSpriteSheet() {
		return SpriteSheet;
	}

	public void setSpriteSheet(String spriteSheet) {
		SpriteSheet = spriteSheet;
	}

	public String getImmaginePersonaggio() {
		return ImmaginePersonaggio;
	}

	public void setImmaginePersonaggio(String immaginePersonaggio) {
		ImmaginePersonaggio = immaginePersonaggio;
	}

	public List<Commento> getCommenti() {
		return commenti;
	}

	public void setCommenti(List<Commento> commenti) {
		this.commenti = commenti;
	}

}
