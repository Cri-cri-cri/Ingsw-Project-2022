package it.unical.ingswwebcomp22.spritesriver.model.DAOJDBC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.unical.ingswwebcomp22.spritesriver.model.Gioco;
import it.unical.ingswwebcomp22.spritesriver.model.DAO.GiocoDAO;
import it.unical.mat.ingswwebcomp22.spritesriver.persistence.DBSource;


public class GiocoDAOJDBC implements GiocoDAO {


	private DBSource dbSource;

	public GiocoDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}

	@Override
	public void save(Gioco g) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "INSERT INTO Gioco VALUES(?,?,?,?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, g.getID_Gioco());
			st.setString(4, g.getTitolo());
			st.setBinaryStream(2,new FileInputStream( g.getImage()));
			st.setDate(3, (Date) g.getDataRilascio());
			st.setString(5, g.getGenere());
			st.setString(6,g.getPiattaforma());
			st.setString(7,g.getDescrizione());
			st.setString(8,g.getImagePath());
			st.executeUpdate();
			conn.close();
		} catch (SQLException | FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Gioco findByPrimaryKey(int ID_Gioco) {
		Gioco g=null;
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM Gioco WHERE ID_Gioco=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, ID_Gioco);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				g = new Gioco();
				g.setID_Gioco(rs.getInt("ID_Gioco"));
				g.setTitolo(rs.getString("Titolo"));
				g.setDataRilascio(rs.getDate("Data Rilascio"));
				g.setGenere(rs.getString("Genere"));
				g.setPiattaforma(rs.getString("Piattaforma"));
				g.setImage((File) rs.getBlob("Immagine"));
				g.setImagePath(rs.getString("Percorso_Immagine"));
				g.setDescrizione(rs.getString("Descrizione"));
				
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
		
	}

	@Override
	public List<Gioco> findAll() {
		List<Gioco> giochi = new ArrayList<Gioco>();
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM Gioco";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Gioco g = new Gioco();
				g.setID_Gioco(rs.getInt("ID_Gioco"));
				g.setTitolo(rs.getString("Titolo"));
				g.setDataRilascio(rs.getDate("Data Rilascio"));
				g.setGenere(rs.getString("Genere"));
				g.setPiattaforma(rs.getString("Piattaforma"));
				g.setImage((File) rs.getBlob("Immagine"));
				g.setImagePath(rs.getString("Percorso_Immagine"));
				g.setDescrizione(rs.getString("Descrizione"));
				giochi.add(g);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return giochi;
	}

	@Override
	public void update(Gioco g) {
		try {
			Connection conn = dbSource.getConnection();
			String update = "UPDATE Gioco SET ID_Gioco = ?, Titolo= ?,Data Rilascio= ?,Genere= ?, Piattaforma= ?, Immagine= ?, Percorso_Immagine= ?, Descrizione= ? WHERE ID_Gioco = ?";
			PreparedStatement st = conn.prepareStatement(update);
			st.setInt(1, g.getID_Gioco());
			st.setString(4, g.getTitolo());
			st.setBinaryStream(2,new FileInputStream( g.getImage()));
			st.setDate(3, (Date) g.getDataRilascio());
			st.setString(5, g.getGenere());
			st.setString(6,g.getPiattaforma());
			st.setString(7,g.getDescrizione());
			st.setString(8,g.getImagePath());
			st.executeUpdate();
			conn.close();
		} catch (SQLException | FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Gioco g) {
		try {
			Connection conn = dbSource.getConnection();
			String delete = "DELETE FROM Gioco WHERE ID_Gioco = ? ";
			PreparedStatement st = conn.prepareStatement(delete);
			st.setLong(1, g.getID_Gioco());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
