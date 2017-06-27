package br.com.blackmarket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
public class Aluno {
	
	@GeneratedValue @Id
	private Long id;
	
	@NotNull(message="NÃO PODE SER EM BRANCO")
	private Long matricula;
	
	@NotNull(message="NÃO PODE SER EM BRANCO")
	private String nome;
	
	@NotNull(message="NÃO PODE SER EM BRANCO")
	private String endereco;
	
	@NotNull(message="NÃO PODE SER EM BRANCO")
	@Min(value = 0, message="NÃO PODE SER MENOR QUE 0")
	private Long telefone;

	
	@Deprecated
	public Aluno() {
		this(null, null, null, null);
	}
	
	public Aluno(Long matricula, String nome, String endereco, Long telefone) {
		this.matricula = matricula;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
}
	