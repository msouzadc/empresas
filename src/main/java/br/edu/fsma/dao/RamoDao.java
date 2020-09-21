package br.edu.fsma.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import br.edu.fsma.modelo.Ramo;

public class RamoDao implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private EntityManager em;

	public RamoDao(EntityManager em) {
		this.em = em;
	}

	public void inserir(Ramo ramo) {
		em.persist(ramo);
	}

}
