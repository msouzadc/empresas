package br.edu.fsma.servicos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

public class EmpresaCsvProcessadorLinha implements ProcessadorLinha {
	
	private List<ArquivoEmpresaProcessador> processadores = new ArrayList<>();
	private EntityManager em;
	public EmpresaCsvProcessadorLinha (EntityManager em) {
		this.em=em;
		processadores.add(new CidadeProcessadorLinha(em));
		processadores.add(new BairroProcessadorLinha(em));
	}

	public void processa(String linha) {
		try {
			em.getTransaction().begin();
			EmpresaCsv empresaCsv = new EmpresaCsv(linha);
			for (ArquivoEmpresaProcessador processador : processadores) {
				processador.processa(empresaCsv);
			}	
			em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Erro na Transação \n" + e.getMessage());
			em.getTransaction().rollback();
		}	
	}	
}
