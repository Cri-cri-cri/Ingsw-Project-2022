package it.unical.ingswwebcomp22.spritesriver.model.DAO;

import java.util.List;

import it.unical.ingswwebcomp22.spritesriver.model.Sprite;

public interface SpriteDAO {
	public void save(Sprite gd);  // Create
	public Sprite findByPrimaryKey(int idSprite);     // Retrieve
	public List<Sprite> findAll();       
	public void update(Sprite gd); //Update
	public void delete(Sprite gd); //Delete	

}
