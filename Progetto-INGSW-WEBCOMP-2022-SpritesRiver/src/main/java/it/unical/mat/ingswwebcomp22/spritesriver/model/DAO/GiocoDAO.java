package it.unical.mat.ingswwebcomp22.spritesriver.model.DAO;

import java.util.List;

import it.unical.mat.ingswwebcomp22.spritesriver.model.Gioco;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Sprite;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Utente;

import java.sql.Date;

public interface GiocoDAO {

	public void save(Gioco g);  // Create
	public Gioco findByPrimaryKey(int idGioco);     // Retrieve
	public Gioco findByTitoloeData (String titolo, String datagioco);     // Retrieve
	public List<Gioco> findAll();   
	public void sprites(Gioco gioco);
	public Gioco findSprite(int idSprite);
	public void addSpriteeGioco(Gioco gioco, Sprite sprite);
	public void update(Gioco g); //Update
	public void delete(Gioco g); //Delete	
	
}
