package it.unical.mat.ingswwebcomp22.spritesriver.model.DAOJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.unical.mat.ingswwebcomp22.spritesriver.model.Commento;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Password;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Sprite;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Utente;
import it.unical.mat.ingswwebcomp22.spritesriver.model.DAO.UtenteDAO;
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
			String query = "INSERT INTO utente(email,username,password,moderatore) VALUES(?, ?, ?, ?)";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, u.getEmail());
			st.setString(3, Password.encrypt(u.getPassword()));
			st.setString(2, u.getUser());
			st.setBoolean(4, false);
			
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
			String query = "SELECT * FROM utente WHERE id_utente = ?";
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
			String query = "SELECT * FROM utente";
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
			String update = "UPDATE utente SET Username = ?, Password = ?, Email = ? WHERE id_utente = "+g2.getID_Utente();
			PreparedStatement st = conn.prepareStatement(update);
			System.out.println(g1.getUser()+" "+g2.getUser());
				st.setString(1, g1.getUser());
				st.setString(2, Password.encrypt(g1.getPassword()));
				st.setString(3, g1.getEmail());
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
			String delete = "DELETE FROM utente WHERE ID_Utente = ? ";
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
			String query = "INSERT INTO relaz_utente_Commento (id_utente,id_commento) VALUES(?,?)";
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
			String query = "INSERT INTO relaz_Utente_Sprite (utente,sprite) VALUES(?,?)";
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
	public Boolean findCommentoByUsernameAndId(int ID_Utente, int idCommento) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM relaz_Utente_Commento WHERE ID_Utente = ? AND ID_Commento = ?";
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
			String delete = "DELETE FROM relaz_Utente_Commento WHERE ID_Utente = ? AND ID_Commento = ?";
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
			String delete = "DELETE FROM relaz_Utente_Sprite WHERE ID_Utente = ? AND ID_Sprite = ?";
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
	public Utente findSpriteCaricatoById(int idSprite) {
		Utente u=null;
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM relaz_utente_sprite WHERE id_sprite = ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, idSprite);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				u=DBManager.getInstance().utenteDAO().findByPrimaryKey(rs.getInt("id_utente"));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
		
	}


	@Override
	public Boolean findCommentoById(int idCommento) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM relaz_Utente_Commento WHERE ID_Commento = ?";
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
			String query = "SELECT * FROM relaz_utente_sprite WHERE id_utente = ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, utente.getID_Utente());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int idSprite = rs.getInt("id_sprite");
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
			String query = "SELECT * FROM relaz_Utente_Commento WHERE ID_Utente = ?";
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


	@Override
	public Utente findByEmaileUsername(String email, String username) {
		Utente utente = null;
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM utente WHERE Email = ? AND Username= ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, email);
			st.setString(2, username);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				utente = new Utente();
				utente.setID_Utente(rs.getInt("id_utente"));
				utente.setUser(rs.getString("Username"));
				utente.setPassword(rs.getString("Password"));
				utente.setEmail(rs.getString("Email"));

			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utente;
	}


	@Override
	public Utente findByEmail(String email) {
		Utente utente = null;
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM utente WHERE Email = ? ";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, email);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				utente = new Utente();
				utente.setUser(rs.getString("Username"));
				utente.setPassword(rs.getString("Password"));
				utente.setEmail(rs.getString("Email"));

			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utente;
	}


	@Override
	public Utente findByUsername(String username) {
		Utente utente = null;
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM utente WHERE Username= ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				utente = new Utente();
				utente.setID_Utente(rs.getInt("id_utente"));
				utente.setUser(rs.getString("Username"));
				utente.setPassword(rs.getString("Password"));
				utente.setEmail(rs.getString("Email"));

			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utente;
	}
}


