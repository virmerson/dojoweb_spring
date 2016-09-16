package br.com.fabricadeprogramador.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private String senha;
	
	@ManyToMany
	private List<Autorizacao> autorizacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Autorizacao> getAutorizacao() {
		return autorizacao;
	}

	public void setAutorizacao(List<Autorizacao> autorizacao) {
		this.autorizacao = autorizacao;
	}
	
}
