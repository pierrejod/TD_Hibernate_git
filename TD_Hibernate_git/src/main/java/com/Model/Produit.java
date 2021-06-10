package com.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="produit")
public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, unique =true)
	private int id;
	
	@Column(name="marque", nullable = true, unique=false, length=50)
	private String marque;
	
	@Column(name="reference", nullable = false, unique=false, length=50)
	private String reference;
	
	@Column(name="dateAchat", nullable = true, unique=false, length=50)
	private String dateAchat;
	
	@Column(name="prix", nullable = true, unique=false)
	private double prix;
	
	@Column(name="designation", nullable = true, unique=false, length=100)	
	private String designation;
	
	@ManyToOne
	private Client client;
	
	

	public Produit() {
		super();
	}


	public Produit(String marque, String reference, String dateAchat, double prix, String designation) {
		super();
		this.marque = marque;
		this.reference = reference;
		this.dateAchat = dateAchat;
		this.prix = prix;
		this.designation = designation;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(String dateAchat) {
		this.dateAchat = dateAchat;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	
	
	
	
	

}
