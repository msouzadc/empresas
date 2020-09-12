package br.edu.fsma.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.fsma.modelo.Cidade;
import br.edu.fsma.modelo.Uf;

public class CidadeDao implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private EntityManager em;

	public CidadeDao(EntityManager em) {
		this.em = em;
	}

	public void inserir(Cidade cidade) {
		em.persist(cidade);
	}

	public Cidade busca(Uf uf, String nomeCidade) {
		String jpql = "select c from Cidade c where c.uf = :pUf and c.nome = :pNome";
		TypedQuery<Cidade> query = em.createQuery (jpql, Cidade.class);
		query.setParameter("pUf", uf);
		query.setParameter("pNome", nomeCidade);
		try {
			return query.getSingleResult();			
		}catch (NoResultException e) {
			return null;
		}
	}

}
