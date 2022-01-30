package it.unical.mat.ingswwebcomp22.spritesriver.controller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import it.unical.mat.ingswwebcomp22.spritesriver.model.Gioco;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Sprite;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Utente;
import it.unical.mat.ingswwebcomp22.spritesriver.persistence.DBManager;

@Controller
public class SpriteController {
	@PostMapping("doSprite")
	@ResponseBody
	public Boolean sprite(HttpSession session,  MultipartFile spritesheet ,MultipartFile  immaginepersonaggio,  String nomepersonaggio,  String nomegioco,   String data) {
		Gioco g=DBManager.getInstance().giocoDAO().findByTitoloeData(nomegioco,data);
		
		if(g!=null) {
			
			
			Sprite sprite= new Sprite();
			sprite.setPersonaggio(nomepersonaggio.toLowerCase());
			Path path1=Paths.get("C:\\Users\\maste\\git\\Ingsw-Project-2022\\Progetto-INGSW-WEBCOMP-2022-SpritesRiver/src/main/webapp/images/Sprite\\",spritesheet.getOriginalFilename());
			Path path2=Paths.get("C:\\Users\\maste\\git\\Ingsw-Project-2022\\Progetto-INGSW-WEBCOMP-2022-SpritesRiver/src/main/webapp/images/Character\\",immaginepersonaggio.getOriginalFilename());
			sprite.setSpriteSheet("images/Sprite/"+spritesheet.getOriginalFilename());
			sprite.setImmaginePersonaggio("images/Character/"+immaginepersonaggio.getOriginalFilename());
			DBManager.getInstance().spriteDAO().save(sprite);
			Sprite s=DBManager.getInstance().spriteDAO().findByPath("images/Sprite/"+spritesheet.getOriginalFilename());
			Utente u=DBManager.getInstance().utenteDAO().findByUsername(session.getAttribute("nomeUtente").toString());
			DBManager.getInstance().giocoDAO().addSpriteeGioco(g, s);
			DBManager.getInstance().spriteDAO().addSpriteaUtente(s, u);
			try {
				byte[] file1=spritesheet.getBytes();
				Files.write(path1, file1);
				} 
			catch (IOException e) {
			// TODO Auto-generated catch block
					e.printStackTrace();
				}
			try {
				byte[] file2=immaginepersonaggio.getBytes();
				Files.write(path2, file2);
			
				} catch (IOException e) {
			// TODO Auto-generated catch block
					e.printStackTrace();
					}
			return true;
		}
		
		return false;	

	}
	
	@GetMapping("goToSpriteLoad")
	public String goToSpriteLoad() {
		return "SpriteLoadPage";
	}
}
