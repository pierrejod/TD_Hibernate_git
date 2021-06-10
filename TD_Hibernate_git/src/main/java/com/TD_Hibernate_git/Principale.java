package com.TD_Hibernate_git;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.Model.Client;
import com.Model.Produit;
import com.Service.ClientService;

public class Principale {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		ClientService cs = new ClientService();
		
		Client c1 = new Client("Jean","Jacques");
		
		Produit p1 = new Produit("Samsung 20","S20","01/03/2021",899.99,"Smartphone Samsung");
		Produit p2 = new Produit("Samsung 19","S19","15/03/2021",799.99,"Smartphone Samsung");
		
		Set<Produit> listeP = new HashSet<Produit>();
		listeP.add(p1);
		listeP.add(p2);
		
		c1.setProduits(listeP);
		cs.delete(c1,session);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	
	}

}
