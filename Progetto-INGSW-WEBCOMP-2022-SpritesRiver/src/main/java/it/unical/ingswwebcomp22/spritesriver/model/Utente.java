package it.unical.ingswwebcomp22.spritesriver.model;

import java.util.List;




public class Utente {
	
	public static int ID_Utente_Globale;
	
	private int ID_Utente;
	
	private String username;
	
	private boolean moderatore;
	
	private String password;
	
	private String email;
	
	
	private List<Commento> commenti;
	
	private List<Sprite> sprites;
	
	public void setUser(String username) {
		this.username = username;
	}

	public String getUser() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isModeratore() {
		return moderatore;
	}

	public void setModeratore(boolean moderatore) {
		this.moderatore = moderatore;
	}

	public void setID_Utente(int idutente) {
		this.ID_Utente= idutente;
	}
	
	public int getID_Utente() {
		return ID_Utente;
	}


	public List<Commento> getCommenti() {
		return commenti;
	}

	public void setCommenti(List<Commento> commenti) {
		this.commenti = commenti;
	}

	public List<Sprite> getSprites() {
		return sprites;
	}

	public void setSprites(List<Sprite> sprites) {
		this.sprites = sprites;
	}
}
