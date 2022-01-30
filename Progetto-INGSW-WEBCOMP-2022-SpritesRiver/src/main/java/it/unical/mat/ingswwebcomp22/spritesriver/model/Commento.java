package it.unical.mat.ingswwebcomp22.spritesriver.model;

import java.sql.Date;

public class Commento {

private int ID_Commento;

private Date Data;

private String user;

private String Commento;

public int getID_Commento() {
	return ID_Commento;
}

public void setID_Commento(int iD_Commento) {
	ID_Commento = iD_Commento;
}

public String getCommento() {
	return Commento;
}

public void setCommento(String commento) {
	Commento = commento;
}

public Date getData() {
	return Data;
}

public void setData(Date dataRilascio) {
	Data = dataRilascio;
}

public String getUser() {
	return user;
}

public void setUser(String user) {
	this.user = user;
}
	
}
