package br.edu.fsma.servicos;

import javax.persistence.EntityManager;

import br.edu.fsma.dao.RamoDao;
import br.edu.fsma.modelo.Ramo;

public class RamoProcessadorLinha implements ArquivoEmpresaProcessador {
	private RamoDao ramoDao;

	public RamoProcessadorLinha (EntityManager em) {
		this.ramoDao =new RamoDao(em);
	}
	
	@Override
	public void processa(EmpresaCsv empresaCsv) {
		if (empresaCsv.isNaoValido()) {
			return;
		}
		
		Ramo ramo = ramoDao.busca(empresaCsv.getRamo());
		if (ramo == null) {
			ramo = new Ramo();
			ramo.setNome(empresaCsv.getRamo());
			ramoDao.inserir(ramo);
		}	

	}
}
