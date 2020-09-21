package br.edu.fsma.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.fsma.modelo.Produto;
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
	
	public Ramo busca (String nome){
		try {
			TypedQuery<Ramo> query = em.createQuery ("SELECT p FROM Ramo p WHERE p.nome = :nome", Ramo.class);
			query.setParameter("nome", nome);
			return query.getSingleResult();			
		}catch (NoResultException e) {
			return null;
		}
	}

}
