package br.unibh.loja.entidades;

public enum Estado {

	RO(11,"Rond�nia"),
	AC(12,"Acre"),
	AM(13,"Amazonas"),
	RR(14,"Roraima"),
	PA(15,"Par�"),
	AP(16,"Amap�"),
	TO(17,"Tocantins"),
	MA(21,"Maranh�o"),
	PI(22,"Piau�"),
	CE(23,"Cear�"),
	RN(24,"Rio Grande do Norte"),
	PB(25,"Para�ba"),
	PE(26,"Pernambuco"),
	AL(27,"Alagoas"),
	SE(28,"Sergipe"),
	BA(29,"Bahia"),
	MG(31,"Minas Gerais"),
	ES(32,"Esp�rito Santo"),
	RJ(33,"Rio de Janeiro"),
	SP(35,"S�o Paulo"),
	PR(41,"Paran�"),
	SC(42,"Santa Catarina"),
	RS(43,"Rio Grande do Sul"),
	MS(50,"Mato Grosso do Sul"),
	MT(51,"Mato Grosso"),
	GO(52,"Goi�s"),
	DF(53,"Distrito Federal");

	private final int codigoIbge;
	private final String nome;

	private Estado(int codigoIbge, String nome) {
		this.codigoIbge = codigoIbge;
		this.nome = nome;
	}
	
	public String getCodigo() {
		return Integer.toString(codigoIbge);
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getCodigoIbge(){
		return codigoIbge;
	}
}