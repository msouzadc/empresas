package br.edu.fsma.servicos;

import java.io.BufferedReader;
import java.io.FileReader;

public class Leitor {
	public void executa(String arquivo, ProcessadorLinha processador){
		String linha ="";
		BufferedReader conteudoCsv = null;
		
		try {
			conteudoCsv = new BufferedReader(new FileReader(arquivo));
			while ((linha = conteudoCsv.readLine()) != null){
				processador.processa(linha);
			}
		}catch (Exception e) {
				System.out.println(e);
				System.exit(0);
		}
	}
}
