package br.edu.fsma.servicos;

public class UfCsv {

	private String campo[];
	
	public UfCsv(String linha) {
		campo = linha.split(",");
	}
	public String getSigla() {
			return campo[1].trim();
	}
	public String getNome() {
		return campo[0];
	}

}
