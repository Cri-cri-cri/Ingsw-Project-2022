package it.unical.mat.ingswwebcomp22.spritesriver.persistence;

import it.unical.ingswwebcomp22.spritesriver.model.DAO.CommentoDAO;
import it.unical.ingswwebcomp22.spritesriver.model.DAO.GiocoDAO;
import it.unical.ingswwebcomp22.spritesriver.model.DAO.SpriteDAO;
import it.unical.ingswwebcomp22.spritesriver.model.DAO.UtenteDAO;
import it.unical.ingswwebcomp22.spritesriver.model.DAOJDBC.CommentoDAOJDBC;
import it.unical.ingswwebcomp22.spritesriver.model.DAOJDBC.GiocoDAOJDBC;
import it.unical.ingswwebcomp22.spritesriver.model.DAOJDBC.UtenteDAOJDBC;

public class DBManager {
	
private static DBManager instance = null;
	
	static DBSource dataSource;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			//questi vanno messi in file di configurazione!!!	
			dataSource=new DBSource("jdbc:postgresql://localhost:5432/SpritesRiver","postgres","postgres");
		} 
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
	}
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	
	private DBManager() {}
	
	public static DBSource getDataSource() {
		return dataSource;
	}
	
	public GiocoDAO giocoDAO() {
		return new GiocoDAOJDBC(dataSource);
	}
	
	public UtenteDAO utenteDAO() {
		return new UtenteDAOJDBC(dataSource);
	}
	
	public SpriteDAO spriteDAO() {
		return new SpriteDAOJDBC(dataSource);
	}
	public CommentoDAO commentoDAO() {
		return new CommentoDAOJDBC(dataSource);
	}
	


}
