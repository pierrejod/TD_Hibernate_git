package com.Service;

import java.io.Serializable;

import org.hibernate.Session;

import com.Model.Client;
import com.TD_Hibernate_git.HibernateUtil;

public class ClientService implements Serializable {
	
	public boolean create(Client c) 
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.save(c); //INSERT INTO client(nom,prenom) VALUES (c.getNom(),c.getPrenom())

		HibernateUtil.shutdown();
		
		return true;
	}

}
