package br.unibh.loja.entidades;

public class Cliente extends Pessoa {

	private String cpf;
	private String perfil;
	
	
	public Cliente(Long id, String nome, String endereco, String email, String telefone, String cpf, String perfil) {
		super(id, nome, endereco, email, telefone);
		this.cpf = cpf;
		this.perfil = perfil;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
		
	
}
