package it.unical.mat.ingswwebcomp22.spritesriver.model.DAOJDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.unical.mat.ingswwebcomp22.spritesriver.model.Commento;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Sprite;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Utente;
import it.unical.mat.ingswwebcomp22.spritesriver.model.DAO.CommentoDAO;
import it.unical.mat.ingswwebcomp22.spritesriver.persistence.DBSource;

public class CommentoDAOJDBC implements CommentoDAO{
	private DBSource dbSource;

	public CommentoDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}

	@Override
	public void save(Commento c) {
	try {	Connection conn = dbSource.getConnection();
		String query = "INSERT INTO commento(data,stringcommento,utente) VALUES(?,?,?)";
		PreparedStatement st = conn.prepareStatement(query);
		st.setString(2, c.getCommento());
		st.setDate(1, (Date) c.getData());
		st.setString(3, c.getUser());
		System.out.println("eccomi");
		st.executeUpdate();
		System.out.println("eccomi qui");
		conn.close();
	} catch (SQLException  e) {
		e.printStackTrace();
	}
	
	}

	@Override
	public Commento findByPrimaryKey(int idCommento) {
		Commento c=null;
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM Commento WHERE ID_Commento=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, idCommento);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				c = new Commento();
				c.setID_Commento(rs.getInt("ID_Commento"));
				c.setCommento(rs.getString("stringcommento"));
				c.setData(rs.getDate("Data"));
				c.setUser(rs.getString("utente"));
				
				
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public List<Commento> findAll() {
		List<Commento> commenti = new ArrayList<Commento>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM Commento";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Commento c = new Commento();
				c.setID_Commento(rs.getInt("ID_Commento"));
				c.setCommento(rs.getString("Commento"));
				c.setData(rs.getDate("Data"));
				c.setUser(rs.getString("utente"));
				commenti.add(c);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commenti;
	}

	@Override
	public void update(Commento c) {
		try {
			Connection conn = dbSource.getConnection();
			String update = "UPDATE Commento SET ID_Commento = ?, String Commento = ?,Data = ? WHERE ID_Commento = ?";
			PreparedStatement st = conn.prepareStatement(update);
		
			st.setInt(1, c.getID_Commento());
			st.setString(3, c.getCommento());
			st.setDate(2, (Date) c.getData());
			st.executeUpdate();
			conn.close();
		} catch (SQLException  e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Commento c) {
		try {
			Connection conn = dbSource.getConnection();
			String delete = "DELETE FROM Commento WHERE ID_Commento = ? ";
			PreparedStatement st = conn.prepareStatement(delete);
			st.setLong(1, c.getID_Commento());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Commento findByData(Date data) {
		Commento c=null;
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM Commento WHERE data=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setDate(1, data);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				c = new Commento();
				c.setID_Commento(rs.getInt("ID_Commento"));
				c.setCommento(rs.getString("stringcommento"));
				c.setData(rs.getDate("Data"));
				
				
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public void addaSprite(Sprite s, Commento c) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "INSERT INTO relaz_commento_sprite (id_commento,id_sprite) VALUES(?,?)";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, c.getID_Commento());
			st.setInt(2, s.getID_Sprite());	
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}