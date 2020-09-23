package br.edu.fsma.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_empresa")
public class Empresa implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 100)
	private String razaoSocial;
	@Column(length = 100)
	private String logradouro;
	@Column(length = 10)
	private String cep;
	@Column(length = 30)
	private String telefone;
	@Column(nullable = true)
	private Integer funcionario;
	@Column(length = 80)
	private String site; 
	@Column(length = 30)
	private String email;
	@Column(length = 30)
	private String fax;
	@ManyToOne
	@JoinColumn(name = "uf_id")
	private Uf uf;
	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;
	@ManyToOne
	@JoinColumn(name = "id_bairro")
	private Bairro bairro;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Produto> produtos =  new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "id_ramo")
	private Ramo ramo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Integer getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Integer funcionario) {
		this.funcionario = funcionario;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public Ramo getRamo() {
		return ramo;
	}
	public void setRamo(Ramo ramo) {
		this.ramo = ramo;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", razaoSocial=" + razaoSocial + ", logradouro=" + logradouro + ", cep=" + cep
				+ ", telefone=" + telefone + ", funcionario=" + funcionario + ", site=" + site + ", email=" + email
				+ ", fax=" + fax + ", uf=" + uf + ", cidade=" + cidade + ", bairro=" + bairro + ", produtos=" + produtos
				+ ", ramo=" + ramo + "]";
	}

}
