package br.edu.fsma.servicos;

import javax.persistence.EntityManager;

import br.edu.fsma.dao.ProdutoDao;
import br.edu.fsma.modelo.Produto;

public class ProdutoProcessadorLinha implements ArquivoEmpresaProcessador {
	private ProdutoDao produtoDao;	

	public ProdutoProcessadorLinha (EntityManager em) {
		this.produtoDao=new ProdutoDao(em);
	}
	
	@Override
	public void processa(EmpresaCsv empresaCsv) {
		if (empresaCsv.isNaoValido()) {
			return;
		}
		
		Produto produto = produtoDao.busca(empresaCsv.getProduto());
			if (produto == null) {
				produto = new Produto();
				produto.setNome(empresaCsv.getProduto());
				produtoDao.inserir(produto);
			}
			
	}
}
