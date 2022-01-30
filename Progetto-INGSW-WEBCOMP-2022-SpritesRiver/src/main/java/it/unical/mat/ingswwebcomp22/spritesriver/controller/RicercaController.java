package it.unical.mat.ingswwebcomp22.spritesriver.controller;

import java.util.ArrayList;
import java.util.List;

import it.unical.mat.ingswwebcomp22.spritesriver.model.Commento;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Gioco;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Sprite;
import it.unical.mat.ingswwebcomp22.spritesriver.model.Utente;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.mat.ingswwebcomp22.spritesriver.persistence.DBManager;


@Controller
public class RicercaController {
	@PostMapping("doRicercaGiochi")
	@ResponseBody
	public List<Object> risultatigiochi(@RequestParam String testo)
	{
		List<Gioco> giochi=DBManager.getInstance().giocoDAO().findAll();
		List<Object> risultati=new ArrayList();
		for(int i=0;i<giochi.size();i++)
		{
			if(giochi.get(i).getTitolo().contains(testo))
			{
				risultati.add(giochi.get(i));
			}
			
		}
		return risultati;
		
	}
	@PostMapping("doRicercaSpriteUtente")
	@ResponseBody
	public List<Sprite> risultatisprite(@RequestParam int idaccount)
	{
		Utente u=DBManager.getInstance().utenteDAO().findByPrimaryKey(idaccount);
		DBManager.getInstance().utenteDAO().spriteCaricati(u);
		List<Sprite> sprite= u.getSprites();
		
		return sprite;
	}
	@PostMapping("doRicercaSprite")
	@ResponseBody
	public List<Object> risultatisprite(@RequestParam String testo)
	{
		
		List<Sprite> sprite= DBManager.getInstance().spriteDAO().findAll();
		List<Object> risultati=new ArrayList();
		for (int i=0;i<sprite.size();i++)
		{
			if(sprite.get(i).getPersonaggio().contains(testo))
			{
				risultati.add(sprite.get(i));
			}
		}
		return risultati;
		
	}
}
