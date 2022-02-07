package it.unical.mat.ingswwebcomp22.spritesriver.model.DAO;

import java.sql.Date;
import java.util.List;

import it.unical.mat.ingswwebcomp22.spritesriver.model.Commento;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Sprite;

public interface CommentoDAO {
	public void save(Commento gd);  // Create
	public Commento findByPrimaryKey(int idCommento);     // Retrieve
	public List<Commento> findAll();
	public Commento findByData(Date data);
	public void addaSprite(Sprite s,Commento c);
	public void update(Commento gd); //Update
	public void delete(Commento gd); //Delete	
}
