package it.unical.mat.ingswwebcomp22.spritesriver.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Gioco;
import it.unical.mat.ingswwebcomp22.spritesriver.persistence.DBManager;


@Controller
public class GiocoController {
	
	
	@PostMapping("doGioco")
	@ResponseBody
	public String gioco(HttpSession session ,String titolo,String genere,String piattaforma,String data,String descrizione,MultipartFile immagine) {
		Gioco gioco= new Gioco();
		gioco.setTitolo(titolo);;
		gioco.setDataRilascio(data);
		gioco.setGenere(genere);
		gioco.setPiattaforma(piattaforma);
		Path path=Paths.get("C:\\Users\\maste\\git\\Ingsw-Project-2022\\Progetto-INGSW-WEBCOMP-2022-SpritesRiver/src/main/webapp/images/GameImages\\",immagine.getOriginalFilename());
		gioco.setImagePath("images/GameImages/"+immagine.getOriginalFilename());
		gioco.setDescrizione(descrizione);
		Gioco g = DBManager.getInstance().giocoDAO().findByTitoloeData(titolo,data);
			if(g == null)
			{
				
				DBManager.getInstance().giocoDAO().save(gioco);
				
				try {
					byte[] file=immagine.getBytes();
					Files.write(path, file);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return "aggiunto";
				
			}
			else if(g!=null) {
				
				return "presente";
			}
				
			
			return "fallito";


	}
	
	@PostMapping("removeGioco")
	public Boolean removeGioco(HttpSession session, @RequestParam int id ) {
		Gioco gioco= new Gioco();
		gioco.setID_Gioco(id);
		if(DBManager.getInstance().giocoDAO().findByPrimaryKey(id)!=null) {
				DBManager.getInstance().giocoDAO().delete(gioco);
			return true;
		}
		return false;
	}
	
	@GetMapping("goToGameLoad")
	public String goToGameLoad() {
		
		return "GameLoadPage";
	}


}


