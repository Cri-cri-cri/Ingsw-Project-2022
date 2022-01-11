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
	public void update(Utente g,Utente g1); //Update
	public void delete(Utente g); //Delete	
	public void addCommento(Utente utente, Commento commento);
	public void addSprite(Utente utente, Sprite sprite);
	public void spriteCaricati(Utente utente);
	public void commentiCaricati(Utente utente);
	public Boolean findSpriteCaricatoById(int idSprite);
 	public Boolean findSpriteCaricatoByUsernameAndId(int username, int idSprite);
 	public Boolean findCommentoById(int idCommento);
	public Boolean findCommentoByUsernameAndId(int ID_Utente, int idCommento);
	public void removeCommento(Utente utente, Commento commento);
	public void removeSprite(Utente utente, Sprite sprite);
	
	
}
