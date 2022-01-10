package it.unical.ingswwebcomp22.spritesriver.model.DAO;

import java.util.List;

import it.unical.ingswwebcomp22.spritesriver.model.Gioco;

public interface GiocoDAO {

	public void save(Gioco g);  // Create
	public Gioco findByPrimaryKey(int idGioco);     // Retrieve
	public List<Gioco> findAll();       
	public void update(Gioco g); //Update
	public void delete(Gioco g); //Delete	
	
}
