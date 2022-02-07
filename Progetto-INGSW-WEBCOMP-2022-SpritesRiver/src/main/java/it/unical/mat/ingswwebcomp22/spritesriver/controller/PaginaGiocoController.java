 package it.unical.mat.ingswwebcomp22.spritesriver.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.unical.mat.ingswwebcomp22.spritesriver.model.Gioco;
import it.unical.mat.ingswwebcomp22.spritesriver.persistence.DBManager;



@Controller
public class PaginaGiocoController {
	@GetMapping("goToGamePageL")
	public String paginaGioco1(HttpSession session,Model model, @RequestParam  String titolo, @RequestParam String genere,@RequestParam String piattaforma,@RequestParam String descrizione,@RequestParam String data,@RequestParam String immagine ) {
		
		model.addAttribute("titolo",titolo);
		model.addAttribute("genere",genere);
		model.addAttribute("piattaforma",piattaforma);
		model.addAttribute("descrizione",descrizione);
		model.addAttribute("data",data);
		model.addAttribute("immagine",immagine);

		return "GamePage";
	}
	@GetMapping("goToGamePageS")
	public String paginaGioco3(HttpSession session,Model model,@RequestParam String titolo,@RequestParam String data)
	{
		Gioco g=DBManager.getInstance().giocoDAO().findByTitoloeData(titolo, data);
		DBManager.getInstance().giocoDAO().sprites(g);
		if(g.getSprites().size()>0) {
		model.addAttribute("sprites", g.getSprites());
		model.addAttribute("titolo",g.getTitolo());
		model.addAttribute("genere",g.getGenere());
		model.addAttribute("piattaforma",g.getPiattaforma());
		model.addAttribute("descrizione",g.getDescrizione());
		model.addAttribute("data",g.getDataRilascio());
		model.addAttribute("immagine",g.getImagePath());
		}
		return "GamePage";
	}
	@GetMapping("goToGamePage")
	public String paginaGioco2(HttpSession session,Model model,@RequestParam int idgioco)
	{
		Gioco g=DBManager.getInstance().giocoDAO().findByPrimaryKey(idgioco);
		DBManager.getInstance().giocoDAO().sprites(g);
		if(g.getSprites().size()>0)
			model.addAttribute("sprites", g.getSprites());
		model.addAttribute("titolo",g.getTitolo());
		model.addAttribute("genere",g.getGenere());
		model.addAttribute("piattaforma",g.getPiattaforma());
		model.addAttribute("descrizione",g.getDescrizione());
		model.addAttribute("data",g.getDataRilascio());
		model.addAttribute("immagine",g.getImagePath());
		
		return "GamePage";
	}
	
}
