package it.unical.mat.ingswwebcomp22.spritesriver.model.DAO;

import java.util.List;

import it.unical.mat.ingswwebcomp22.spritesriver.model.Commento;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Sprite;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Utente;

public interface SpriteDAO {
	public void save(Sprite gd);  // Create
	public Sprite findByPrimaryKey(int idSprite);     // Retrieve
	public List<Sprite> findAll();       
	public Sprite findByPath(String Path);
	public void commenti(Sprite s);
	public void addSpriteaUtente(Sprite sprite,Utente utente);
	public void update(Sprite gd); //Update
	public void delete(Sprite gd); //Delete	

}
