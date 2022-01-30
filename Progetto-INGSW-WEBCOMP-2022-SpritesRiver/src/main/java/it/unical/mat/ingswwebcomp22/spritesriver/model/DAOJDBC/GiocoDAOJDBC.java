package it.unical.mat.ingswwebcomp22.spritesriver.model.DAOJDBC;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import it.unical.mat.ingswwebcomp22.spritesriver.model.Gioco;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Sprite;
import it.unical.mat.ingswwebcomp22.spritesriver.model.DAO.GiocoDAO;
import it.unical.mat.ingswwebcomp22.spritesriver.persistence.DBManager;
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
			String query = "INSERT INTO gioco(titolo,genere,piattaforma,descrizione,percorsoimmagine,datarilascio) VALUES(?, ?, ?, ?,?,?)";
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, g.getTitolo());
			st.setString(6,g.getDataRilascio());
			st.setString(2, g.getGenere());
			st.setString(3,g.getPiattaforma());
			st.setString(4,g.getDescrizione());
			st.setString(5,(g.getImagePath()));
			st.executeUpdate();
			conn.close();
		} catch (SQLException  e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Gioco findByPrimaryKey(int ID_Gioco) {
		Gioco g=null;
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM gioco WHERE iD_Gioco=?";
			PreparedStatement st = conn.prepareStatement(query);
			
			st.setInt(1, ID_Gioco);
		
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
			
				g = new Gioco();
				g.setID_Gioco(rs.getInt("iD_Gioco"));
				g.setTitolo(rs.getString("Titolo"));
				g.setDataRilascio(rs.getString("dataRilascio"));
				g.setGenere(rs.getString("Genere"));
				g.setPiattaforma(rs.getString("Piattaforma"));
				g.setImagePath(rs.getString("percorsoimmagine"));
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
				g.setDataRilascio(rs.getString("Datarilascio"));
				g.setGenere(rs.getString("genere"));
				g.setPiattaforma(rs.getString("piattaforma"));
				g.setImagePath(rs.getString("percorsoimmagine"));
				g.setDescrizione(rs.getString("descrizione"));
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
			st.setString(3,  g.getDataRilascio());
			st.setString(5, g.getGenere());
			st.setString(6,g.getPiattaforma());
			st.setString(7,g.getDescrizione());
			st.setString(8,g.getImagePath());
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
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

	@Override
	public Gioco findByTitoloeData(String titolo, String data ) {
		
		Gioco g=null;
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM Gioco WHERE Titolo= ? AND dataRilascio= ?";
			PreparedStatement st = conn.prepareStatement(query);
			
			st.setString(1, titolo);
			st.setString(2,  data);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
			
					g = new Gioco();
					g.setID_Gioco(rs.getInt("iD_Gioco"));
					g.setTitolo(rs.getString("Titolo"));
					g.setDataRilascio(rs.getString("DataRilascio"));
					g.setGenere(rs.getString("Genere"));
					g.setPiattaforma(rs.getString("Piattaforma"));;
					g.setImagePath(rs.getString("PercorsoImmagine"));
					g.setDescrizione(rs.getString("Descrizione"));
				
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
		
		
	}

	@Override
	public void addSpriteeGioco(Gioco gioco, Sprite sprite) {
		try {
			Connection conn = dbSource.getConnection();
			String query = "INSERT INTO relaz_gioco_sprite (id_gioco,id_sprite) VALUES(?,?)";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, gioco.getID_Gioco());
			st.setInt(2, sprite.getID_Sprite());	
			st.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void sprites(Gioco gioco) {
		List<Sprite> sprites= new ArrayList<Sprite>();
		
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM relaz_gioco_sprite WHERE id_gioco= ?";
			PreparedStatement st = conn.prepareStatement(query);
			st.setInt(1, gioco.getID_Gioco());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int idSprite = rs.getInt("id_sprite");
				Sprite s = DBManager.getInstance().spriteDAO().findByPrimaryKey(idSprite);
				System.out.println(s.getPersonaggio());
				sprites.add(s);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		gioco.setSprites(sprites);
	}

	@Override
	public Gioco findSprite(int idSprite) {
		Gioco g=null;
		try {
			Connection conn = dbSource.getConnection();
			String query = "SELECT * FROM relaz_gioco_sprite WHERE id_sprite= ?";
			PreparedStatement st = conn.prepareStatement(query);
			
			st.setInt(1, idSprite);
			
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
					int idGioco=rs.getInt("id_gioco");
					g=DBManager.getInstance().giocoDAO().findByPrimaryKey(idGioco);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}

	
	
	
	

}
