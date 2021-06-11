package com.Service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Model.Commande;
import com.TD_Hibernate_git.HibernateUtil;

public class CommandeService implements Serializable {
	
	public boolean create(Commande c,Session s) 
	{
		s.save(c); //INSERT INTO Commande(nom,prenom) VALUES (c.getNom(),c.getPrenom())


		
		return true;
	}
	
	public void delete(Session s,int id) 
	{
		
		Commande c = s.get(Commande.class, id);
		
		s.delete(c);

	}
	
	public void update(Session s,int id) 
	{
		
		Commande c = s.get(Commande.class, id);
		s.update(c); // UPDATE Commande SET nom = c.getNom(), prenom= c.getPrenom() where id =id;

	}
	
	public Commande findById(Session s,int id) 
	{
		
		Commande c = s.get(Commande.class, id); //SELECT * FROM Commande where id = id;
		return c;
	}
	
	public List<Commande> findAll(Session s) 
	{
		Query q = s.createQuery("from Commande");
		List<Commande> listeCom  = q.list(); //SELECT * FROM Commande where id = id;
		return listeCom;
	}

}

