package it.unical.ingswwebcomp22.spritesriver.model;

public class Utente {
	private String username;
	
	private boolean moderatore;
	
	private String password;
	
	private String email;
	
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
}
