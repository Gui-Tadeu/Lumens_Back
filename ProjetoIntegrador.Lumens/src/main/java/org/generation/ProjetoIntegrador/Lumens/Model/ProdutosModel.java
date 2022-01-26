package org.generation.ProjetoIntegrador.Lumens.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_Produtos")

public class ProdutosModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(min = 5, max = 100, message = "O nome do produto deve conter no mínimo 5 e no máximo 100 caracteres")
	private String nomeProduto;

	@NotNull
	@Size(min = 5, max = 100, message = "A descrição do produto deve conter no mínimo 5 e no máximo 100 caracteres")
	private String descricaoProduto;

	@NotNull
	@Size(min = 5, max = 100, message = "O setor do produto deve conter no mínimo 5 e no máximo 100 caracteres")
	private String setorProduto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public String getSetorProduto() {
		return setorProduto;
	}

	public void setSetorProduto(String setorProduto) {
		this.setorProduto = setorProduto;
	}

}
