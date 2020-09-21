package br.edu.fsma.servicos;

import javax.persistence.EntityManager;

import br.edu.fsma.dao.BairroDao;
import br.edu.fsma.dao.CidadeDao;
import br.edu.fsma.dao.UfDao;
import br.edu.fsma.modelo.Bairro;
import br.edu.fsma.modelo.Cidade;
import br.edu.fsma.modelo.Uf;

public class BairroProcessadorLinha implements ArquivoEmpresaProcessador {
	private UfDao ufDao;	
	private CidadeDao cidadeDao;
	private BairroDao bairroDao;
	
	public BairroProcessadorLinha (EntityManager em) {
		this.ufDao = new UfDao(em);
		this.cidadeDao = new CidadeDao (em);
		this.bairroDao = new BairroDao(em);
	}
	
	@Override
	public void processa(EmpresaCsv empresaCsv) {
		if (empresaCsv.isNaoValido()) {
			return;
		}
		
		Uf uf = ufDao.buscarPorSigla(empresaCsv.getSiglaUf());
		if (uf == null) {
			return;
		}
						
		Cidade cidade = cidadeDao.busca(uf, empresaCsv.getCidade());
		if (cidade == null) {
			return;				
		}
			
		Bairro bairro = bairroDao.busca(cidade, empresaCsv.getBairro());
		if (bairro == null) {
			bairro = new Bairro();
			bairro.setCidade(cidade);
			bairro.setNome(empresaCsv.getBairro());
			bairroDao.inserir(bairro);
			}
	}
}
