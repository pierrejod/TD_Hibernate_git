package com.TD_Hibernate_git;

import com.Model.Client;
import com.Service.ClientService;

public class Principale {

	public static void main(String[] args) {
		
		
		ClientService cs = new ClientService();
		
		Client c1 = new Client("Dupont","Pierre");
		
		cs.create(c1);
	
	}

}
