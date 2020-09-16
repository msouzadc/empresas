package br.edu.fsma.servicos;

import javax.persistence.EntityManager;

import br.edu.fsma.dao.CidadeDao;
import br.edu.fsma.dao.UfDao;
import br.edu.fsma.modelo.Cidade;
import br.edu.fsma.modelo.Uf;

public class CidadeProcessadorLinha implements ProcessadorLinha {
	private EntityManager em;
	private UfDao ufDao;	
	private CidadeDao cidadeDao;
		
	public CidadeProcessadorLinha (EntityManager em) {
		this.em=em;
		this.ufDao = new UfDao(em);
		this.cidadeDao = new CidadeDao (em);
	}

	public void processa (String linha) {
		EmpresaCsv csv = new EmpresaCsv(linha);
		
		try {
			em.getTransaction().begin();
			Uf uf = ufDao.buscarPorSigla(csv.getSiglaUf());
			
			if (uf == null) {
				System.out.println(csv.getSiglaUf());
				em.getTransaction().rollback();
				return;
			}
			Cidade cidade = cidadeDao.busca(uf, csv.getCidade());
			if (cidade == null) {
				cidade = new Cidade ();
				cidade.setUf(uf);
				cidade.setNome(csv.getCidade());
				cidadeDao.inserir(cidade);
				em.getTransaction().commit();	
			}
	
		}catch (Exception e){
			em.getTransaction().rollback();
			System.out.println(e.getMessage());		
		}
	}
}
