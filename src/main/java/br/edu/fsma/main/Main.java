package br.edu.fsma.main;

import java.io.IOException;

import javax.persistence.EntityManager;

import br.edu.fsma.conexao.JPAUtil;
import br.edu.fsma.servicos.EmpresaCsvProcessadorLinha;
import br.edu.fsma.servicos.Leitor;
import br.edu.fsma.servicos.UfProcessadorLinha;

public class Main {
	
	private static String arquivo ="C:\\Users\\Marcela\\workspaceams\\Arquivos\\1200-Empresas.csv"; 
	private static String arquivoUf ="C:\\Users\\Marcela\\workspaceams\\Arquivos\\estados.txt";
	public static void main(String[] args) throws IOException {
		System.out.println("Inicio Importação.........................");
		
		EntityManager em = JPAUtil.getEntityManager();
		
		Leitor leitor = new Leitor();
		leitor.executa(arquivoUf, new UfProcessadorLinha(em));
			
		leitor.executa(arquivo, new EmpresaCsvProcessadorLinha(em));
		
		System.out.println("Fim da importação.........................");
		System.exit(0);
	}

}
