package org.CidnelsonJounin.CursoME.Form;

import java.util.Date;

import org.CidnelsonJounin.CursoME.entity.CursoME;
import org.CidnelsonJounin.CursoME.repository.CursoMERepository;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AtualizaCursoMEForm {
	private int id;
	private String nome;
	private String descricao;
	private String ementa;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataCadastro;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataInicio;
	private float valor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadatro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public CursoME atualizar(int id, CursoMERepository repositorio) {
		CursoME produto = repositorio.getOne(id);
		produto.setNome(this.nome);
		produto.setDescricao(this.descricao);
		produto.setEmenta(this.ementa);
		produto.setDataCadastro(this.dataCadastro);
		produto.setDataInicio(this.dataInicio);
		produto.setValor(this.valor);
		return produto;
	}
}
