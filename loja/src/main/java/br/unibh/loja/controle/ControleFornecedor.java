package br.unibh.loja.controle;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.unibh.loja.entidades.Fornecedor;
import br.unibh.loja.negocio.ServicoFornecedor;

@ManagedBean(name = "fornecedormb")
@ViewScoped
public class ControleFornecedor extends ControleUtil {

	@Inject
	private ServicoFornecedor ejb;

	private Fornecedor fornecedor;

	private String nomeArg;

	private List<Fornecedor> lista;

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getNomeArg() {
		return nomeArg;
	}

	public void setNomeArg(String nomeArg) {
		this.nomeArg = nomeArg;
	}

	public List<Fornecedor> getLista() {
		return lista;
	}

	@PostConstruct
	public void inicializaLista() {
		try {
			lista = ejb.findAll();
		} catch (Exception e) {
			mostrarErro(e);
		}
	}

	public void gravar() {
		try {
			if (fornecedor.getId() == null) {
				fornecedor = ejb.insert(fornecedor);
				mostrarMensagem("Inclusão realizada com sucesso!", "");
			} else {
				fornecedor = ejb.update(fornecedor);
				mostrarMensagem("Atualização realizada com sucesso!", "");
			}
			lista = ejb.findByName(nomeArg);
		} catch (Exception e) {
			mostrarErro(e);
		}
	}

	public void pesquisar() {
		fornecedor = null;
		try {
			lista = ejb.findByName(nomeArg);
		} catch (Exception e) {
			mostrarErro(e);
		}
	}

	public void novo() {
		fornecedor = new Fornecedor();
	}

	public void editar(Long id) {
		try {
			fornecedor = ejb.find(id);
			return;
		} catch (Exception e) {
			mostrarErro(e);
		}
		fornecedor = null;
	}

	public void excluir(Long id) {

		try {
			ejb.delete(ejb.find(id));
			lista = ejb.findByName(nomeArg);
		} catch (Exception e) {
			mostrarErro(e);
			return;
		}
		fornecedor = null;
		mostrarMensagem("Exclusão realizada com sucesso!", "");
	}
	
}