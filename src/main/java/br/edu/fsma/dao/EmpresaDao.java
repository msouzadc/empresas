package br.edu.fsma.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.edu.fsma.modelo.Empresa;


public class EmpresaDao {
	private EntityManager em;

	public EmpresaDao(EntityManager em) {
		this.em = em;
	}

	public void inserir(Empresa empresa) {
		em.getTransaction().begin();
		em.persist(empresa);
		em.getTransaction().commit();
	}
	
	public Empresa busca(String razaoSocial) {
		try {
			TypedQuery<Empresa> query = em.createQuery(
					"SELECT e FROM Empresa e WHERE e.razaoSocial = :razaoSocial  ", Empresa.class);
			query.setParameter("razaoSocial", razaoSocial);
			return  query.getSingleResult();
			 
		} catch (NoResultException e) {
			return null;
		}
	}
}
