package br.edu.fsma.servicos;

public class EmpresaCsv {

	private String campos[];
	
	private boolean valido;

	public EmpresaCsv(String linha) {
		valido = false;
		if (linha == null) {
			return;
		}
		campos = linha.split(";");
		if (getBairro().equals(" ")) {
			return;
		}
		valido= true;
	}
	
	private String retirarAspas(String str) {  
		return str.replaceAll("\"", "");
	}
	
	public String getRamo() {
		return campos[0];
	}
	
	public String getRazaoSocial() {
		return campos[1];
	}
	
	public String getLogradouro() {
		return campos[2];
	}
	
	public String getBairro() {
		return  retirarAspas(campos[3].trim());
	}
	
	public String getCep() {
		return campos[4];
	}
	
	public String getCidade() {
		return retirarAspas(campos[5]).trim().toUpperCase();
	}
	
	public String getSiglaUf() {
		return retirarAspas(campos[6]).trim().toUpperCase();
	}
	
	public String getContato() {
		return campos[7];
	}
	
	public Integer getFuncionario () {
		try {
			return Integer.parseInt(campos[8]);
		} catch(Exception e) {
			return null;	
		}
	}
		
	public String getTelefone() {
		return campos[9];
	}
	
	public String getFax() {
		return campos[10];
	}
	
	public String getSite() {
		return campos[11];
	}
	
	public String getEmail() {
		return campos[12];
	}
	
	public String getProduto() {
		return retirarAspas(campos[13]);
	}

	public int getColunasDisponiveis() {
		return campos.length;
	}
	
	public boolean isNaoValido() {
		return !valido;
	}


}
