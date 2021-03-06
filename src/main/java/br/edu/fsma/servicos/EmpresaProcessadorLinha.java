package br.edu.fsma.servicos;

import javax.persistence.EntityManager;

import br.edu.fsma.dao.BairroDao;
import br.edu.fsma.dao.CidadeDao;
import br.edu.fsma.dao.EmpresaDao;
import br.edu.fsma.dao.RamoDao;
import br.edu.fsma.dao.UfDao;
import br.edu.fsma.modelo.Bairro;
import br.edu.fsma.modelo.Cidade;
import br.edu.fsma.modelo.Empresa;
import br.edu.fsma.modelo.Ramo;
import br.edu.fsma.modelo.Uf;

public class EmpresaProcessadorLinha implements ArquivoEmpresaProcessador {
	
	private UfDao ufDao;	
	private CidadeDao cidadeDao;
	private BairroDao bairroDao;
	private EmpresaDao empresaDao;
	private RamoDao ramoDao;
	
	public EmpresaProcessadorLinha (EntityManager em) {
		this.ufDao = new UfDao(em);
		this.cidadeDao = new CidadeDao (em);
		this.bairroDao = new BairroDao(em);
		this.empresaDao = new EmpresaDao(em);
		this.ramoDao = new RamoDao(em);
	}

	public void processa(EmpresaCsv empresaCsv) {

//		if (empresaCsv.isNaoValido()) {
//			return;
//		}
		
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
			return;
		}
			
		Ramo ramo = ramoDao.busca(empresaCsv.getRamo());
		if (ramo == null) {
			return;
		}
		
		Empresa empresa = empresaDao.busca(empresaCsv.getRazaoSocial());
		if (empresa == null) {
			empresa = new Empresa();
			empresa.setUf(uf);
			empresa.setCidade(cidade);
			empresa.setBairro(bairro);
			empresa.setRazaoSocial(empresaCsv.getRazaoSocial());
			empresa.setCep(empresaCsv.getCep());
			empresa.setEmail(empresaCsv.getEmail());
			empresa.setFuncionario(empresaCsv.getFuncionario());
			empresa.setFax(empresaCsv.getFax());
			empresa.setTelefone(empresaCsv.getTelefone());
			empresa.setLogradouro(empresaCsv.getLogradouro());
			empresa.setRamo(ramo);
			empresaDao.inserir(empresa);
		}

	}	
}
