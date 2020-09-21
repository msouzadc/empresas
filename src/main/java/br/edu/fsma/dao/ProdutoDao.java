package br.edu.fsma.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.fsma.modelo.Produto;
import br.edu.fsma.modelo.Uf;

public class ProdutoDao implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public void inserir(Produto produto) {
		em.persist(produto);
	}
	
	public Produto busca (String nome){
		try {
			TypedQuery<Produto> query = em.createQuery ("SELECT p FROM Produto p WHERE p.nome = :nome", Produto.class);
			query.setParameter("nome", nome);
			return query.getSingleResult();			
		}catch (NoResultException e) {
			return null;
		}
	}


}
