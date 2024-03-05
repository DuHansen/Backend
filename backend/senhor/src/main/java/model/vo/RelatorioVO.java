package model.vo;

public abstract class RelatorioVO {
	
	private String descricao;
	private double valor;
	private double somatorioTransacoes;
	private int mes;
	
	public RelatorioVO(String descricao, double valor) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getSomatorioTransacoes() {
		return somatorioTransacoes;
	}
	public void setSomatorioTransacoes(double somatorioTransacoes) {
		this.somatorioTransacoes = somatorioTransacoes;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	@Override
	public String toString() {
		return "RelatorioVO [descricao=" + descricao + ", valor=" + valor + ", somatorioTransacoes="
				+ somatorioTransacoes + ", mes=" + mes + "]";
	}
}