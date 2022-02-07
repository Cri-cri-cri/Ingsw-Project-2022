package it.unical.mat.ingswwebcomp22.spritesriver.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.mat.ingswwebcomp22.spritesriver.model.Gioco;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Sprite;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Utente;
import it.unical.mat.ingswwebcomp22.spritesriver.persistence.DBManager;

@Controller
public class PaginaSpriteController {
	
	@GetMapping("goToSpritePage")
	public String paginaGioco2(Model model,@RequestParam int idsprite)
	{
		Sprite s=DBManager.getInstance().spriteDAO().findByPrimaryKey(idsprite);
		Gioco g=DBManager.getInstance().giocoDAO().findSprite(idsprite);
		Utente u=DBManager.getInstance().utenteDAO().findSpriteCaricatoById(idsprite);
		model.addAttribute("nomesprite",s.getPersonaggio());
		model.addAttribute("spritesheet",s.getSpriteSheet());
		model.addAttribute("gioco",g.getTitolo());
		model.addAttribute("piattaforma", g.getPiattaforma());
		model.addAttribute("genere", g.getGenere());
		model.addAttribute("data",g.getDataRilascio());
		model.addAttribute("utente",u.getUser());
		model.addAttribute("idsprite",idsprite);
		
		
		
		
		return "SpritePage";
	}
	
}
