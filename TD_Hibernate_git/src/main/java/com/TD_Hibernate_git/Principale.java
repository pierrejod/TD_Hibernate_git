package com.TD_Hibernate_git;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.Model.Client;
import com.Model.Commande;
import com.Model.Compte;
import com.Model.Produit;
import com.Service.ClientService;
import com.Service.CommandeService;
import com.Service.ProduitService;

public class Principale {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		ClientService cs = new ClientService();
		ProduitService ps = new ProduitService();
		CommandeService coms = new CommandeService();
		
		Client c1 = new Client("Jean","Jacques");
		
		Produit p1 = new Produit("Samsung 20","S20","01/03/2021",899.99,"Smartphone Samsung");
		Produit p2 = new Produit("Samsung 19","S19","15/03/2021",799.99,"Smartphone Samsung");
		
		Commande com1 = new Commande("Commande de Monsieur Jacques","7V45Z");
		
		Set<Produit> listeP = new HashSet<Produit>();
		listeP.add(p1);
		listeP.add(p2);
		
		Set<Commande> listecom = new HashSet<Commande>();
		listecom.add(com1);
		c1.setCommandes(listecom);
		
		c1.setProduits(listeP);
		//cs.create(c1,session);
		
		//cs.update(session, 2);
		//ps.update(session, 2);
		
		//Client c2 = cs.findById(session, 2);
		
		//System.out.println("Nom :"+ c2.getNom() +" Prenom : "+ c2.getPrenom() +" Vos produits : "+c2.getProduits().toString());
		
		
		//List<Client>listeC = cs.findAll(session);
		
		//for(Client cli : listeC) 
		//{
			//System.out.println("Nom :"+ cli.getNom() +" Prenom : "+ cli.getPrenom());
		//}
		
		Produit prod1= ps.findById(session, 1);
		System.out.println("Ref :"+ prod1.getReference() +" Prix: "+ prod1.getPrix()+" € ");
		
		List<Produit> listeprod = ps.findAll(session);
		
		for(Produit pro : listeprod) 
		{
			System.out.println("Ref :"+ pro.getReference() +" Prix: "+ pro.getPrix()+" € ");
		}
		
		List<Commande> listec = coms.findAll(session);
		
		for(Commande com : listec) 
		{
			System.out.println("Nom Commande :"+ com.getNom_commande() +" Numéro de commande: "+com.getReference());
		}
		
		Compte cpt1 = new Compte("test@test.com","test");
		Client c2 = new Client("Sophie","Marie");
		session.saveOrUpdate(cpt1);
		c2.setCompte(cpt1);
		session.saveOrUpdate(c2);
		
		
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	
	}

}
