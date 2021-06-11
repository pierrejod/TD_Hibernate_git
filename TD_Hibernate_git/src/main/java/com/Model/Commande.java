package com.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="commande")
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, unique =true)
	private int id;
	
	@Column(name="nom_commande", nullable = true, unique=false, length=50)
	private String nom_commande;
	
	@Column(name="reference", nullable = true, unique=false, length=50)
	private String reference;
	
	@ManyToOne
	private Client client;

	public Commande() {
		super();
	}

	public Commande(String nom_commande, String reference) {
		super();
		this.nom_commande = nom_commande;
		this.reference = reference;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_commande() {
		return nom_commande;
	}

	public void setNom_commande(String nom_commande) {
		this.nom_commande = nom_commande;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}
	
	
	

}
