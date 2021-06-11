package com.Service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Model.Produit;
import com.TD_Hibernate_git.HibernateUtil;

public class ProduitService implements Serializable {
	
	public boolean create(Produit c,Session s) 
	{
		
		s.save(c); //INSERT INTO Produit(nom,prenom) VALUES (c.getNom(),c.getPrenom())

		s.getTransaction().commit();
		HibernateUtil.shutdown();
		
		return true;
	}
	
	public void delete(Session s,int id) 
	{
		
		Produit c = s.get(Produit.class, id);
		
		s.delete(c);

	}
	
	public void update(Session s,int id) 
	{
		
		Produit c = s.get(Produit.class, id);
		c.setPrix(599);
		s.update(c); // UPDATE Produit SET nom = c.getNom(), prenom= c.getPrenom() where id =id;

	}
	
	public Produit findById(Session s,int id) 
	{
		
		Produit c = s.get(Produit.class, id); //SELECT * FROM Produit where id = id;
		return c;
	}
	
	public List<Produit> findAll(Session s) 
	{
		Query q = s.createQuery("from Produit");
		List<Produit> listeC  = q.list(); //SELECT * FROM Produit where id = id;
		return listeC;
	}

}
