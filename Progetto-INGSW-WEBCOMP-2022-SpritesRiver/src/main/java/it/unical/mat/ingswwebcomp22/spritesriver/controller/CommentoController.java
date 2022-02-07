package it.unical.mat.ingswwebcomp22.spritesriver.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.mat.ingswwebcomp22.spritesriver.model.Commento;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Gioco;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Sprite;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Utente;
import it.unical.mat.ingswwebcomp22.spritesriver.persistence.DBManager;

@Controller
public class CommentoController {
	@PostMapping("doCommento")
	@ResponseBody
	public Commento commento( HttpSession session,String commento,int idsprite) {
		Commento c=new Commento();
		c.setCommento(commento);
		Date data=Date.valueOf(java.time.LocalDateTime.now().toLocalDate());
		c.setUser(session.getAttribute("nomeUtente").toString());
		c.setData(data);
		DBManager.getInstance().commentoDAO().save(c);
		Commento com=DBManager.getInstance().commentoDAO().findByData(data);
		Utente u=DBManager.getInstance().utenteDAO().findByPrimaryKey((int) session.getAttribute("idutente"));
		Sprite s=DBManager.getInstance().spriteDAO().findByPrimaryKey(idsprite);
		DBManager.getInstance().utenteDAO().addCommento(u,com );
		DBManager.getInstance().commentoDAO().addaSprite(s,com );
		System.out.println(c.getCommento());
		return c;
		
	} 
	@GetMapping("getCommenti")
	@ResponseBody
	public List<Commento> risultatigiochi(int idsprite)
	{
		Sprite s =DBManager.getInstance().spriteDAO().findByPrimaryKey(idsprite);
		DBManager.getInstance().spriteDAO().commenti(s);
		
		return s.getCommenti();
		
	}
}
