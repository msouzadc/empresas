package br.edu.fsma.main;

import java.io.IOException;

import javax.persistence.EntityManager;

import br.edu.fsma.conexao.JPAUtil;
import br.edu.fsma.servicos.CidadeProcessadorLinha;
import br.edu.fsma.servicos.EmpresaProcessadorLinha;
import br.edu.fsma.servicos.Leitor;
import br.edu.fsma.servicos.UfProcessadorLinha;

public class Main {
	
	private static String arquivo ="C:\\Users\\Marcela\\workspaceams\\Arquivos\\1200-Empresas - Teste.csv"; 
	private static String arquivoUf ="C:\\Users\\Marcela\\workspaceams\\Arquivos\\estados.txt";
	public static void main(String[] args) throws IOException {
		System.out.println("Inicio Importação.........................");
		
		EntityManager em = JPAUtil.getEntityManager();
		
		Leitor leitor = new Leitor();
		leitor.executa(arquivoUf, new UfProcessadorLinha(em));
		
		
		leitor.executa(arquivo, new CidadeProcessadorLinha(em));
	//	leitor.executa(arquivo, new BairroProcessadorLinha(em));
		//leitor.executa(arquivo, new ProdutoProcessadorLinha(em));
	//	leitor.executa(arquivo, new RamooProcessadorLinha(em));
	//	leitor.executa(arquivo, new EmpresaProcessadorLinha(em));
		
		System.out.println("Fim da importação.........................");
		System.exit(0);
	}

}
