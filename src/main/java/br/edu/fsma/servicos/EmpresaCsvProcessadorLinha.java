package br.edu.fsma.servicos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

public class EmpresaCsvProcessadorLinha implements ProcessadorLinha {
	
	private List<ProcessadorLinha> processadoresLinha = new ArrayList<>();
	
	public EmpresaCsvProcessadorLinha (EntityManager em) {
		processadoresLinha.add(new CidadeProcessadorLinha(em));
		//processadoresLinha.add(new BairroProcessadorLinha(em));
	}

	public void processa(String linha) {
		for (ProcessadorLinha processador : processadoresLinha) {
			processador.processa(linha);
		}		
	}	
}
