package it.unical.ingswwebcomp22.spritesriver.model.DAO;

import java.util.List;

import it.unical.ingswwebcomp22.spritesriver.model.Sprite;

public interface SpriteDAO {
	public void save(SpriteDAO gd);  // Create
	public SpriteDAO findByPrimaryKey(int idSprite);     // Retrieve
	public List<SpriteDAO> findAll();       
	public void update(SpriteDAO gd); //Update
	public void delete(SpriteDAO gd); //Delete	

}
