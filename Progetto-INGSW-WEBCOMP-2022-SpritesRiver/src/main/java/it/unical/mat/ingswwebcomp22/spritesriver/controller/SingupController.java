package it.unical.mat.ingswwebcomp22.spritesriver.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.mat.ingswwebcomp22.spritesriver.model.Utente;
import it.unical.mat.ingswwebcomp22.spritesriver.persistence.DBManager;

@Controller
public class SingupController {
	@PostMapping("doRegistrazione")
	@ResponseBody
	public String registrazione(HttpSession session,@RequestParam String username, @RequestParam String password, @RequestParam String email) {

		Utente utenteUsername = DBManager.getInstance().utenteDAO().findByUsername(username);
		Utente utenteEmail = DBManager.getInstance().utenteDAO().findByEmail(email);
		if(utenteUsername != null && utenteEmail != null)
			return "Username ed email gia' esistenti";
		if(utenteUsername != null && utenteEmail == null)
			return "Username gia' esistente";
		if(utenteUsername == null && utenteEmail != null)
			return "Email gia' esistente";
		Utente nuovoUtente = new Utente();
		nuovoUtente.setUser(username);
		nuovoUtente.setPassword(password);
		nuovoUtente.setEmail(email);
		
		DBManager.getInstance().utenteDAO().save(nuovoUtente);
		return "Registrazione effettuata con successo";
	} 
	
	@GetMapping("goToRegistrazione")
	public String registrazione() {
		
		return "SingUpPage";
	}

}
