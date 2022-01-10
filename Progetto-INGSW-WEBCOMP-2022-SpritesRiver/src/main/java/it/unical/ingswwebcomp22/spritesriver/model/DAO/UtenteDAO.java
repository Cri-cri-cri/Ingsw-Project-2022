package it.unical.ingswwebcomp22.spritesriver.model.DAO;

import java.util.List;

import it.unical.ingswwebcomp22.spritesriver.model.Commento;
import it.unical.ingswwebcomp22.spritesriver.model.Gioco;
import it.unical.ingswwebcomp22.spritesriver.model.Sprite;
import it.unical.ingswwebcomp22.spritesriver.model.Utente;



public interface UtenteDAO {

	public void save(Utente g);  // Create
	public Utente findByPrimaryKey(int idUtente);     // Retrieve
	public List<Utente> findAll();       
	public void update(Utente g); //Update
	public void delete(Utente g); //Delete	
	public void addGiochi(Utente utente, Gioco gioco);
	public void addCommento(Utente utente, Commento commento);
	public void addSprite(Utente utente, Sprite sprite);
	public Boolean findSpriteCaricatoByUsernameAndId(String username, int idSprite);
	public Boolean findCommentoByUsernameAndId(String username, int idCommento);
	public void removeGiochi(Utente utente, Gioco gioco);
	public void removeCommento(Utente utente, Commento commento);
	public void removeSprite(Utente utente, Sprite sprite);
	
	
}
