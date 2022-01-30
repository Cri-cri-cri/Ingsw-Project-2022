package it.unical.mat.ingswwebcomp22.spritesriver.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.unical.mat.ingswwebcomp22.spritesriver.model.Utente;
import it.unical.mat.ingswwebcomp22.spritesriver.persistence.DBManager;

@Controller
public class AccountController {
	@GetMapping("doAccount")
	public String account(HttpSession session, Model model) {

		Utente utente = DBManager.getInstance().utenteDAO().findByPrimaryKey((int)session.getAttribute("idutente"));
		DBManager.getInstance().utenteDAO().commentiCaricati(utente);
		DBManager.getInstance().utenteDAO().spriteCaricati(utente);
		model.addAttribute("username",utente.getUser());
		model.addAttribute("idutente",utente.getID_Utente());
		model.addAttribute("commenti",utente.getCommenti());
		model.addAttribute("sprite",utente.getSprites());
		
		return "Account";
	}
}
