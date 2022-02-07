package it.unical.mat.ingswwebcomp22.spritesriver.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.mat.ingswwebcomp22.spritesriver.model.Password;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Utente;
import it.unical.mat.ingswwebcomp22.spritesriver.persistence.DBManager;

@Controller
public class SettingController {
	@PostMapping("doModificheAccount")
	@ResponseBody
	public String modificheAccount(HttpSession session, @RequestParam String username,  @RequestParam String password, 
								   @RequestParam String email) {

		String olduser=null;
		String oldemail=null;
		if(session.getAttribute("usernamelogged")!=null)
		{
			olduser = session.getAttribute("nomeUtente").toString();
			oldemail=session.getAttribute("email").toString();

		}
		Utente utenteUsername = DBManager.getInstance().utenteDAO().findByUsername( username);
		Utente utenteEmail=DBManager.getInstance().utenteDAO().findByEmail(email);
		
		if(utenteUsername != null && utenteEmail != null)
			return "Email e username gia' esistenti";
		if(utenteUsername != null && utenteEmail == null)
			return "Username gia' esistente";
		if(utenteUsername == null && utenteEmail != null)
			return "Email gia' esistente";
		
		Utente utenteAttuale = DBManager.getInstance().utenteDAO().findByEmaileUsername(oldemail,olduser);
		if(Password.check(password, utenteAttuale.getPassword()))
			return "La nuova password e' uguale a quella precedente";
		Utente utenteAggiornato = new Utente();
		utenteAggiornato.setUser(username);
		utenteAggiornato.setPassword(password);
		utenteAggiornato.setEmail(email);
		DBManager.getInstance().utenteDAO().update(utenteAggiornato, utenteAttuale);
		if(!username.equals(""))
			session.setAttribute("usernamelogged", username);
			session.setAttribute("nomeUtente", username);
		return "Modifiche effettuate con successo";
	}
	
	@GetMapping("doImpostazioni")
	public String impostazioni(){
		return "Settings";
	}

}


