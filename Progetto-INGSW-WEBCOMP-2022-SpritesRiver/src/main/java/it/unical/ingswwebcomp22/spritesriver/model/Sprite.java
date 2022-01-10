package it.unical.ingswwebcomp22.spritesriver.model;

import java.io.File;

public class Sprite {
	
	
	private int ID_Sprite;
	
	private File SpriteSheet;
	
	
	private String Personaggio;


	public int getID_Animazione() {
		return ID_Sprite;
	}

	public void setID_Animazione(int iD_Animazione) {
		ID_Sprite = iD_Animazione;
	}	

	public String getPersonaggio() {
		return Personaggio;
	}

	public void setPersonaggio(String personaggio) {
		Personaggio = personaggio;
	}

	public File getSpriteSheet() {
		return SpriteSheet;
	}

	public void setSpriteSheet(File spriteSheet) {
		SpriteSheet = spriteSheet;
	}

}
