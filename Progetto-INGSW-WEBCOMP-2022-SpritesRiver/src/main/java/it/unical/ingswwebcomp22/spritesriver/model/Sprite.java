package it.unical.ingswwebcomp22.spritesriver.model;

import java.io.File;

public class Sprite {
	
	
	private int ID_Sprite;
	
	private File SpriteSheet;
	
	private File ImmaginePersonaggio;
	
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

	public File getSpriteSheet() {
		return SpriteSheet;
	}

	public void setSpriteSheet(File spriteSheet) {
		SpriteSheet = spriteSheet;
	}

	public File getImmaginePersonaggio() {
		return ImmaginePersonaggio;
	}

	public void setImmaginePersonaggio(File immaginePersonaggio) {
		ImmaginePersonaggio = immaginePersonaggio;
	}

}
