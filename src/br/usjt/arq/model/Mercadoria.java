package br.usjt.arq.model;

public class Mercadoria {
	
	private int codigo;
	private int tipo;
	private String descricao;
	private double preco;
	

	public Mercadoria(int codigo, int tipo, String descricao, double preco){
		this.codigo = codigo;
		this.tipo = tipo;
		this.descricao = descricao;
		this.preco = preco;
		
	}
	
	public Mercadoria() {
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

}
