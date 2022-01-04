package it.unical.mat.ingswwebcomp22.spritesriver.persistence.Dao;

import java.util.List;

import it.unical.ingswwebcomp22.spritesriver.model.Gioco;

public interface GiocoDAO {
	public void save(Gioco gioco);  // Create
	public Gioco findByPrimaryKey(int idGioco);     // Retrieve
	public List<Gioco> findAll();       
	public void update(Gioco gioco); //Update
	public void delete(Gioco gioco); //Delete	
}
