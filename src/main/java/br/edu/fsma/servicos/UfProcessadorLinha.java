package br.edu.fsma.servicos;

import javax.persistence.EntityManager;

import br.edu.fsma.dao.UfDao;
import br.edu.fsma.modelo.Uf;

public class UfProcessadorLinha implements ProcessadorLinha {
	private EntityManager em;
	private UfDao ufDao;
	
	public UfProcessadorLinha(EntityManager em) {
		this.em=em;
		ufDao = new UfDao(em);
	}
	
	@Override
	public void processa(String linha) {
		try {
			em.getTransaction().begin();
			UfCsv csv = new UfCsv(linha);
			Uf uf = new Uf();
			uf.setNome(csv.getNome());
			uf.setSigla(csv.getSigla());
			
			ufDao.inserir(uf);
			
			em.getTransaction().commit();
		
		}catch (Exception ex){
			System.out.println(ex.getMessage());
			
		}

	}
	
}
