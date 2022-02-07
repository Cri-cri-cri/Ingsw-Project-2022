package it.unical.mat.ingswwebcomp22.spritesriver.controller;

import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Gioco;
import it.unical.mat.ingswwebcomp22.spritesriver.persistence.DBManager;

@Controller
public class HomeController {	
	
	@GetMapping("/")
	public String home(Model model) {
		Random rand=new Random();
		List<Gioco> giochi=DBManager.getInstance().giocoDAO().findAll();
		int idrandom=rand.nextInt(giochi.size());
		Gioco g=giochi.get(idrandom);
		DBManager.getInstance().giocoDAO().sprites(g);
		model.addAttribute("titolo",g.getTitolo());
		model.addAttribute("immagine", g.getImagePath());
		model.addAttribute("data", g.getDataRilascio());
		model.addAttribute("piattaforma",g.getPiattaforma());
		model.addAttribute("genere", g.getGenere());
		model.addAttribute("descrizione", g.getDescrizione());
		model.addAttribute("sprites",g.getSprites());
		return "index";
	}
	

}