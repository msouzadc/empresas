package br.edu.fsma.servicos;

import javax.persistence.EntityManager;

import br.edu.fsma.dao.CidadeDao;
import br.edu.fsma.dao.UfDao;
import br.edu.fsma.modelo.Cidade;
import br.edu.fsma.modelo.Uf;

public class CidadeProcessadorLinha implements ArquivoEmpresaProcessador {
	private UfDao ufDao;	
	private CidadeDao cidadeDao;
		
	public CidadeProcessadorLinha (EntityManager em) {
		this.ufDao = new UfDao(em);
		this.cidadeDao = new CidadeDao (em);
	}

	public void processa (EmpresaCsv empresaCsv) {
		Uf uf = ufDao.buscarPorSigla(empresaCsv.getSiglaUf());
		if (uf == null) {
			return;
		}
		Cidade cidade = cidadeDao.busca(uf, empresaCsv.getCidade());
		if (cidade == null) {
			cidade = new Cidade ();
			cidade.setUf(uf);
			cidade.setNome(empresaCsv.getCidade());
			cidadeDao.inserir(cidade);
		}
	}

}
