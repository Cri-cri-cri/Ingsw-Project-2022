package it.unical.mat.ingswwebcomp22.spritesriver.persistence.Dao;

import java.util.List;

import it.unical.ingswwebcomp22.spritesriver.model.Utente;

public interface UtenteDAO {
	public void save(Utente utente);  // Create
	public Utente findByPrimaryKey(int idUtente);     // Retrieve
	public List<Utente> findAll();       
	public void update(Utente utente); //Update
	public void delete(Utente utente); //Delete	

}
