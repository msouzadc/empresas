package br.edu.fsma.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import br.edu.fsma.modelo.Produto;

public class ProdutoDao implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	public void inserir(Produto produto) {
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
	}

}
