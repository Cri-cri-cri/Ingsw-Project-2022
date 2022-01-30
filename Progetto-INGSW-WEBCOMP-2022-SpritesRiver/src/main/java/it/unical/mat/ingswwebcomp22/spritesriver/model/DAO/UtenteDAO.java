package it.unical.mat.ingswwebcomp22.spritesriver.model.DAO;

import java.util.List;

import it.unical.mat.ingswwebcomp22.spritesriver.model.Commento;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Gioco;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Sprite;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Utente;



public interface UtenteDAO {

	public void save(Utente g);  // Create
	public Utente findByPrimaryKey(int idUtente);
	public Utente findByEmaileUsername(String email,String username);
	public Utente findByEmail(String email);
	public Utente findByUsername(String username);// Retrieve
	public List<Utente> findAll();       
	public void update(Utente g,Utente g1); //Update
	public void delete(Utente g); //Delete	
	public void addCommento(Utente utente, Commento commento);
	public void addSprite(Utente utente, Sprite sprite);
	public void spriteCaricati(Utente utente);
	public void commentiCaricati(Utente utente);
	public Utente findSpriteCaricatoById(int idSprite);
 	public Boolean findCommentoById(int idCommento);
	public Boolean findCommentoByUsernameAndId(int ID_Utente, int idCommento);
	public void removeCommento(Utente utente, Commento commento);
	public void removeSprite(Utente utente, Sprite sprite);
	
	
}
