package br.com.blackmarket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {

	@GeneratedValue @Id
	private Long id;
	
	@NotNull (message="NÃO PODE SER EM BRANCO")
	@Min(value = 0, message="NÃO PODE SER MENOR QUE 3")
	private String nome;
	
	@NotNull (message="NÃO PODE SER EM BRANCO")
	@Min(value = 6, message="NÃO PODE SER MENOR QUE 6")
	private String senha;

	@Deprecated
	public Usuario() {
		this(null, null);
	}
	
	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}