package br.edu.fsma.servicos;

import javax.persistence.EntityManager;

import br.edu.fsma.dao.BairroDao;
import br.edu.fsma.dao.CidadeDao;
import br.edu.fsma.dao.UfDao;
import br.edu.fsma.modelo.Bairro;
import br.edu.fsma.modelo.Cidade;
import br.edu.fsma.modelo.Uf;

public class BairroProcessadorLinha implements ProcessadorLinha {
	private EntityManager em;
	private UfDao ufDao;	
	private CidadeDao cidadeDao;
	private BairroDao bairroDao;
	
	public BairroProcessadorLinha (EntityManager em) {
		this.ufDao = new UfDao(em);
		this.cidadeDao = new CidadeDao (em);
		this.bairroDao = new BairroDao(em);
	}
	
	@Override
	public void processa(String linha) {
		EmpresaCsv csv = new EmpresaCsv(linha);
		
		try {
			em.getTransaction().begin();
			Uf uf = ufDao.buscarPorSigla(csv.getSiglaUf());
			
			if (uf == null) {
				em.getTransaction().rollback();
				return;
			}
						
			Cidade cidade = cidadeDao.busca(uf, csv.getCidade());
			if (cidade == null) {
				em.getTransaction().rollback();
				return;				
			}
			
			Bairro bairro = bairroDao.busca(cidade, csv.getBairro());
			if (bairro == null) {
				bairro = new Bairro();
				bairro.setCidade(cidade);
				bairro.setNome(csv.getBairro());
				bairroDao.inserir(bairro);
			}
			em.getTransaction().commit();
		}catch (Exception e){
			em.getTransaction().rollback();
			System.out.println(e.getMessage());
		}
	}
}
