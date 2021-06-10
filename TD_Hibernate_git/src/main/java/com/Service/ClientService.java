package com.Service;

import java.io.Serializable;

import org.hibernate.Session;

import com.Model.Client;
import com.TD_Hibernate_git.HibernateUtil;

public class ClientService implements Serializable {
	
	public boolean create(Client c,Session s) 
	{
		
		s.save(c); //INSERT INTO client(nom,prenom) VALUES (c.getNom(),c.getPrenom())

		s.getTransaction().commit();
		HibernateUtil.shutdown();
		
		return true;
	}
	
	public void delete(Client c,Session s) 
	{
		
		c = s.get(Client.class, 4);
		
		s.delete(c);

	}

}
