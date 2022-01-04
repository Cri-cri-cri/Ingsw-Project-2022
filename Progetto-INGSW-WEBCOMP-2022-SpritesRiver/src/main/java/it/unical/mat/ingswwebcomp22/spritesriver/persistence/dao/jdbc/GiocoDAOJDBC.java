package it.unical.mat.ingswwebcomp22.spritesriver.persistence.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.unical.ingswwebcomp22.spritesriver.model.Gioco;
import it.unical.mat.ingswwebcomp22.spritesriver.dao.GiocoDAO;
import it.unical.mat.ingswwebcomp22.spritesriver.persistence.DBSource;

public class GiocoDAOJDBC implements GiocoDAO{

	//COLUMNS
	private static final String ID="ID_Gioco";
	private static final String DATA="Data_Rilascio";
	private static final String TITOLO="Titolo";
	private static final String GENERE="Genere";
	private static final String PIATTAFORMA="Piattaforma";
	private static final String DESCRIZIONE="Descrizione";
	
	
	private DBSource dbSource;
	
	public GiocoDAOJDBC(DBSource dbSource) {
		this.dbSource = dbSource;
	}
	
	@Override
	public void save(Gioco g) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "INSERT INTO Gioco VALUES(?,?,?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(query);
			st.setLong(1, g.getID_Gioco());
			st.setDate(2, (Date) g.getDataRilascio());
			st.setString(3, g.getTitolo());
			st.setString(4, g.getGenere());
			st.setString(5, g.getPiattaforma());
			st.setString(6, g.getDescrizione());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Gioco findByPrimaryKey(long idGioco) {
		Gioco g = null;
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM Gioco WHERE ID_Gioco=?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setLong(1, idGioco);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				g = new Gioco();
				g.setID_Gioco(rs.getLong(ID));
				g.setTitolo(rs.getString(TITOLO));
				g.setDataRilascio(rs.getDate(DATA));
				g.setDescrizione(rs.getString(DESCRIZIONE));
				g.setPiattaforma(rs.getString(PIATTAFORMA));
				g.setGenere(rs.getString(GENERE));
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
				g.setID_Gioco(rs.getLong(ID));
				g.setTitolo(rs.getString(TITOLO));
				g.setDataRilascio(rs.getDate(DATA));
				g.setDescrizione(rs.getString(DESCRIZIONE));
				g.setPiattaforma(rs.getString(PIATTAFORMA));
				g.setGenere(rs.getString(GENERE));
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
