package com.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="compte")
public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, unique =true)
	private int id;
	
	@Column(name="email", nullable = true, unique=false, length=50)
	private String email;
	
	@Column(name="mdp", nullable = true, unique=false, length=50)
	private String mdp;
	
	@OneToOne(mappedBy="compte")
	private Client client;

	public Compte() {
		super();
	}

	public Compte(String email, String mdp) {
		super();
		this.email = email;
		this.mdp = mdp;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	

}

