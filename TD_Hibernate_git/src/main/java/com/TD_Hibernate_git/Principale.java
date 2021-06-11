package com.TD_Hibernate_git;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.Model.Client;
import com.Model.Produit;
import com.Service.ClientService;
import com.Service.ProduitService;

public class Principale {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		ClientService cs = new ClientService();
		ProduitService ps = new ProduitService();
		
		Client c1 = new Client("Jean","Jacques");
		
		Produit p1 = new Produit("Samsung 20","S20","01/03/2021",899.99,"Smartphone Samsung");
		Produit p2 = new Produit("Samsung 19","S19","15/03/2021",799.99,"Smartphone Samsung");
		
		Set<Produit> listeP = new HashSet<Produit>();
		listeP.add(p1);
		listeP.add(p2);
		
		c1.setProduits(listeP);
		//cs.delete(session,3);
		
		//cs.update(session, 2);
		ps.update(session, 2);
		
		Client c2 = cs.findById(session, 2);
		
		System.out.println("Nom :"+ c2.getNom() +" Prenom : "+ c2.getPrenom() +" Vos produits : "+c2.getProduits().toString());
		
		
		List<Client>listeC = cs.findAll(session);
		
		for(Client cli : listeC) 
		{
			System.out.println("Nom :"+ cli.getNom() +" Prenom : "+ cli.getPrenom());
		}
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	
	}

}
