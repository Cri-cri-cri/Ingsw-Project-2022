package it.unical.mat.ingswwebcomp22.spritesriver.model.DAOJDBC;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.unical.mat.ingswwebcomp22.spritesriver.model.Commento;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Sprite;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Utente;
import it.unical.mat.ingswwebcomp22.spritesriver.model.DAO.SpriteDAO;
import it.unical.mat.ingswwebcomp22.spritesriver.persistence.DBManager;
import it.unical.mat.ingswwebcomp22.spritesriver.persistence.DBSource;

public class SpriteDAOJDBC implements SpriteDAO{

	private DBSource dbSource;

	public SpriteDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}
	
	@Override
	public void save(Sprite s) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "INSERT INTO sprite(spritesheet,nomepersonaggio,immaginepersonaggio) VALUES(?,?,?)";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1,s.getSpriteSheet());
			st.setString(2,  s.getPersonaggio());
			st.setString(3, s.getImmaginePersonaggio());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Sprite findByPrimaryKey(int idSprite) {
		Sprite s=null;
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM sprite WHERE id_sprite=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, idSprite);
			System.out.println(st);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				System.out.println("AIUTO");
				s = new Sprite();
				s.setID_Sprite(rs.getInt("id_sprite"));
				s.setPersonaggio(rs.getString("nomepersonaggio"));
				s.setSpriteSheet(rs.getString("spritesheet"));
				s.setImmaginePersonaggio(rs.getString("immaginepersonaggio"));		
				
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public List<Sprite> findAll() {
		List<Sprite> sprite = new ArrayList<Sprite>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM sprite";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Sprite s = new Sprite();
				s.setID_Sprite(rs.getInt("id_sprite"));
				s.setPersonaggio(rs.getString("nomepersonaggio"));
				s.setSpriteSheet( rs.getString("spritesheet"));
				s.setImmaginePersonaggio( rs.getString("Immaginepersonaggio"));
				sprite.add(s);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sprite;
	}

	@Override
	public void update(Sprite s) {
		try {
			Connection conn = dbSource.getConnection();
			String update = "UPDATE Sprite SET id_sprite = ?, spritesheet= ?,nomepersonaggio= ?,immaginepersonaggio= ? WHERE id_sprite = ?";
			PreparedStatement st = conn.prepareStatement(update);
			st.setInt(1, s.getID_Sprite());
			st.setBinaryStream(2,new FileInputStream( s.getSpriteSheet()));
			st.setString(3,  s.getPersonaggio());
			st.setBinaryStream(4, new FileInputStream(s.getImmaginePersonaggio()));
			st.executeUpdate();
			conn.close();
		} catch (SQLException | FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(Sprite s) {
		try {
			Connection conn = dbSource.getConnection();
			String delete = "DELETE FROM Sprite WHERE iD_Sprite = ? ";
			PreparedStatement st = conn.prepareStatement(delete);
			st.setInt(1, s.getID_Sprite());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Sprite findByPath(String Path) {
		Sprite s=null;
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM sprite WHERE spritesheet=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, Path);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				s = new Sprite();
				s.setID_Sprite(rs.getInt("id_sprite"));
				s.setPersonaggio(rs.getString("nomepersonaggio"));
				s.setSpriteSheet(rs.getString("spritesheet"));
				s.setImmaginePersonaggio(rs.getString("immaginepersonaggio"));		
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public void addSpriteaUtente(Sprite sprite, Utente utente) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "INSERT INTO relaz_utente_sprite (id_utente,id_sprite) VALUES(?,?)";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, utente.getID_Utente());
			st.setInt(2, sprite.getID_Sprite());	
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void commenti(Sprite s)  {
		List<Commento> commenti= new ArrayList<Commento>();
		
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM relaz_commento_sprite WHERE id_sprite= ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, s.getID_Sprite());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int idCommento = rs.getInt("id_commento");
				Commento c = DBManager.getInstance().commentoDAO().findByPrimaryKey(idCommento);
				
				commenti.add(c);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		s.setCommenti(commenti);
		
	}
		
	}


