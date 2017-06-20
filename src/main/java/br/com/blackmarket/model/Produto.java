package br.com.blackmarket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
public class Produto {
	
	@GeneratedValue @Id
	private Long id;
	
	@NotNull(message="NÃO PODE SER EM BRANCO")
	private String nome;
	
	@NotNull(message="NÃO PODE SER EM BRANCO")
	private String descricao;

	@NotNull(message="NÃO PODE SER EM BRANCO")
	@Min(value = 0, message="NÃO PODE SER MENOR QUE 0")
	private Integer quantidade;
	
	@NotNull(message="NÃO PODE SER EM BRANCO")
	@Min(value = 0, message="NÃO PODE SER MENOR QUE 0")
	private Double valor;
	
	@NotNull(message="NÃO PODE SER EM BRANCO")
	@Min(value = 0, message="NÃO PODE SER MENOR QUE 0")
	private Double valorFrete;
	
	@Deprecated
	public Produto() {
		this(null, null, null, null, null);
	}
	
	public Produto(String nome, String descricao, Integer quantidade , Double valor, Double valorFrete) {
		this.nome = nome;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valor = valor;
		this.valorFrete = valorFrete;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}