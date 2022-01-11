package it.unical.ingswwebcomp22.spritesriver.model.DAOJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import it.unical.ingswwebcomp22.spritesriver.model.Commento;
import it.unical.ingswwebcomp22.spritesriver.model.Password;
import it.unical.ingswwebcomp22.spritesriver.model.Sprite;
import it.unical.ingswwebcomp22.spritesriver.model.Utente;
import it.unical.ingswwebcomp22.spritesriver.model.DAO.UtenteDAO;
import it.unical.mat.ingswwebcomp22.spritesriver.persistence.DBManager;
import it.unical.mat.ingswwebcomp22.spritesriver.persistence.DBSource;



public class UtenteDAOJDBC implements UtenteDAO{
	
	private DBSource dbSource;

	public UtenteDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}


	@Override
	public void save(Utente u) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "INSERT INTO Utente VALUES(?, ?, ?, ?,?)";
			PreparedStatement st = conn.prepareStatement(query);
			Utente.ID_Utente_Globale++;
			u.setID_Utente(Utente.ID_Utente_Globale);
			st.setInt(1, u.getID_Utente());
			st.setString(2, u.getEmail());
			st.setString(4, Password.encrypt(u.getPassword()));
			st.setString(3, u.getUser());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Utente findByPrimaryKey(int idUtente) {
		Utente utente = null;
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM Utente WHERE username = ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, idUtente);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				utente = new Utente();
				utente.setID_Utente(rs.getInt("ID_Utente"));
				utente.setPassword(rs.getString("Password"));
				utente.setEmail(rs.getString("Email"));
				utente.setUser(rs.getString("Username"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utente;
	}

	@Override
	public List<Utente> findAll() {
		List<Utente> utenti = new ArrayList<Utente>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM Utente";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
			Utente utente = new Utente();
			utente.setID_Utente(rs.getInt("ID_Utente"));
			utente.setPassword(rs.getString("Password"));
			utente.setEmail(rs.getString("Email"));
			utente.setUser(rs.getString("Username"));
				utenti.add(utente);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utenti;
	}

	@Override
	public void update(Utente g1, Utente g2) {
		try {
			Connection conn = dbSource.getConnection();
			String update = "UPDATE Utente SET Username = ?, Password = ?, Email = ? WHERE ID_Utente = ?";
			PreparedStatement st = conn.prepareStatement(update);
			if(!g2.getUser().equals(""))
				st.setString(3, g2.getUser());
			else
				st.setString(3, g1.getUser());
			
			if(!g2.getPassword().equals(""))
				st.setString(4, Password.encrypt(g2.getPassword()));
			else {
				st.setString(4, g1.getPassword());
			}
			
			if(!g2.getEmail().equals(""))
				st.setString(2, g2.getEmail());
			else
				st.setString(2, g1.getEmail());
			st.setString(3, g1.getUser());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public void delete(Utente g) {
		try {
			Connection conn = dbSource.getConnection();
			String delete = "DELETE FROM Utente WHERE ID_Utente = ? ";
			PreparedStatement st = conn.prepareStatement(delete);
			st.setInt(1, g.getID_Utente());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void addCommento(Utente utente, Commento commento) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "INSERT INTO Relaz_Utente_Commento (utente,gioco) VALUES(?,?)";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, utente.getID_Utente());
			st.setInt(2, commento.getID_Commento());	
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void addSprite(Utente utente, Sprite sprite) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "INSERT INTO Relaz_Utente_Sprite (utente,gioco) VALUES(?,?)";
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
	public Boolean findSpriteCaricatoByUsernameAndId(int ID_Utente, int idSprite) {
			
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM Relaz_Utente_Sprite WHERE ID_Utente = ? AND ID_Sprite = ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, ID_Utente);
			st.setInt(2, idSprite);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				conn.close();
				return true;
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public Boolean findCommentoByUsernameAndId(int ID_Utente, int idCommento) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM Relaz_Utente_Commento WHERE ID_Utente = ? AND ID_Commento = ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, ID_Utente);
			st.setInt(2, idCommento);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				conn.close();
				return true;
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	

	@Override
	public void removeCommento(Utente utente, Commento commento) {
		try {
			Connection conn = dbSource.getConnection();
			String delete = "DELETE FROM Relaz_Utente_Commento WHERE ID_Utente = ? AND ID_Commento = ?";
			PreparedStatement st = conn.prepareStatement(delete);
			st.setInt(1, utente.getID_Utente());
			st.setInt(2, commento.getID_Commento());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void removeSprite(Utente utente, Sprite sprite) {
		try {
			Connection conn = dbSource.getConnection();
			String delete = "DELETE FROM Relaz_Utente_Sprite WHERE ID_Utente = ? AND ID_Sprite = ?";
			PreparedStatement st = conn.prepareStatement(delete);
			st.setInt(1, utente.getID_Utente());
			st.setInt(2, sprite.getID_Sprite());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public Boolean findSpriteCaricatoById(int idSprite) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM Relaz_Utente_Sprite WHERE ID_Sprite = ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setLong(1, idSprite);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				conn.close();
				return true;
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}


	@Override
	public Boolean findCommentoById(int idCommento) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM Relaz_Utente_Commento WHERE ID_Commento = ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setLong(1, idCommento);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				conn.close();
				return true;
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public void spriteCaricati(Utente utente) {
		List<Sprite> spriteCaricati = new ArrayList<Sprite>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM Relaz_Utente_Sprite WHERE ID_Utente = ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, utente.getID_Utente());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int idSprite = rs.getInt("ID_Sprite");
				Sprite s = DBManager.getInstance().spriteDAO().findByPrimaryKey(idSprite);
				spriteCaricati.add(s);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		utente.setSprites(spriteCaricati);
		
	}


	@Override
	public void commentiCaricati(Utente utente) {
		List<Commento> commentiCaricati = new ArrayList<Commento>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM Relaz_Utente_Commento WHERE ID_Utente = ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, utente.getID_Utente());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int idCommento = rs.getInt("ID_Commento");
				Commento c = DBManager.getInstance().commentoDAO().findByPrimaryKey(idCommento);
				commentiCaricati.add(c);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		utente.setCommenti(commentiCaricati);
		
	}

}
