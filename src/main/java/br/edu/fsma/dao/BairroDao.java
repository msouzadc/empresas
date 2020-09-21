package br.edu.fsma.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.fsma.modelo.Bairro;
import br.edu.fsma.modelo.Cidade;

public class BairroDao implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private EntityManager em;

	public BairroDao(EntityManager em) {
		this.em = em;
	}

	public void inserir(Bairro bairro) {
		em.persist(bairro);
	}
	
	public Bairro busca (Cidade cidade, String nomeBairro) {
		try {
			TypedQuery<Bairro> query = em.createQuery("SELECT b FROM Bairro b WHERE b.nome = :Bairro and b.cidade = :cidade", Bairro.class);
			query.setParameter("Bairro", nomeBairro);
			query.setParameter("cidade", cidade);
			return  query.getSingleResult();
			 
		} catch (NoResultException e) {
			return null;
		}	
	}
	
}
