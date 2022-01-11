package it.unical.ingswwebcomp22.spritesriver.model.DAO;

import java.util.List;

import it.unical.ingswwebcomp22.spritesriver.model.Commento;

public interface CommentoDAO {
	public void save(Commento gd);  // Create
	public Commento findByPrimaryKey(int idCommento);     // Retrieve
	public List<Commento> findAll();       
	public void update(Commento gd); //Update
	public void delete(Commento gd); //Delete	
}
