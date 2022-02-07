package it.unical.mat.ingswwebcomp22.spritesriver.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.mat.ingswwebcomp22.spritesriver.model.Gioco;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Password;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Utente;
import it.unical.mat.ingswwebcomp22.spritesriver.persistence.DBManager;

@Controller
public class LoginController {


	@PostMapping("doLogin")
	@ResponseBody
	public Boolean login(HttpSession session, @RequestParam String username, @RequestParam String password) {
		Utente utente = DBManager.getInstance().utenteDAO().findByUsername(username);
		if((utente != null) && Password.check(password, utente.getPassword())) {
			session.setAttribute("usernamelogged", username);
			session.setAttribute("nomeUtente", utente.getUser());
			session.setAttribute("idutente", utente.getID_Utente());
			session.setAttribute("email", utente.getEmail());
			return true;
		}
		return false;
	}
	
	
	@GetMapping("doLogout")
	public String logout(HttpSession session,Model model) {
		session.invalidate();
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
	
	@GetMapping("goToLogin")
	public String goTologin() {
		return "Login";
	}

}
