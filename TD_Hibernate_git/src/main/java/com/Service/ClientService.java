package com.Service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Model.Client;
import com.TD_Hibernate_git.HibernateUtil;

public class ClientService implements Serializable {
	
	public boolean create(Client c,Session s) 
	{
		
		s.save(c); //INSERT INTO client(nom,prenom) VALUES (c.getNom(),c.getPrenom())
		
		return true;
	}
	
	public void delete(Session s,int id) 
	{
		
		Client c = s.get(Client.class, id);
		
		s.delete(c);

	}
	
	public void update(Session s,int id) 
	{
		
		Client c = s.get(Client.class, id);
		c.setPrenom("Paul");
		s.update(c); // UPDATE client SET nom = c.getNom(), prenom= c.getPrenom() where id =id;

	}
	
	public Client findById(Session s,int id) 
	{
		
		Client c = s.get(Client.class, id); //SELECT * FROM client where id = id;
		return c;
	}
	
	public List<Client> findAll(Session s) 
	{
		Query q = s.createQuery("from Client");
		List<Client> listeC  = q.list(); //SELECT * FROM client where id = id;
		return listeC;
	}

}
