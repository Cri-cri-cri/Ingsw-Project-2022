package it.unical.mat.ingswwebcomp22.spritesriver.dao;
import java.util.List;

import it.unical.ingswwebcomp22.spritesriver.model.Gioco;

public interface GiocoDAO {

	public void save(Gioco g);
	public Gioco findByPrimaryKey(long idGioco);
	public List<Gioco> findAll();       
	public void update(Gioco g);
	public void delete(Gioco g);
}
