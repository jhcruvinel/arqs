package br.unibh.loja.controle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import br.unibh.loja.entidades.Cidade;
import br.unibh.loja.entidades.Estado;
import br.unibh.loja.negocio.ServicoCidade;

@ManagedBean(name = "cidademb")
@ViewScoped
public class ControleCidade extends ControleUtil {

	@Inject
	private ServicoCidade ejb;
	
	private Cidade cidade;
	
	private String nomeArg;
	
	private List<Cidade> lista;
	
	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getNomeArg() {
		return nomeArg;
	}

	public void setNomeArg(String nomeArg) {
		this.nomeArg = nomeArg;
	}
	
	public List<Cidade> getLista() {
		return lista;
	}
	
	@PostConstruct
	public void inicializaLista(){
		try {
			lista = ejb.findAll();
		} catch (Exception e) {
			mostrarErro(e);
		}
	}
	
	public void gravar() {
		try {
			if (cidade.getId() == null) {
				cidade = ejb.insert(cidade);
				mostrarMensagem("Inclusão realizada com sucesso!","");
			} else {
				cidade = ejb.update(cidade);
				mostrarMensagem("Atualização realizada com sucesso!","");
			}
			lista = ejb.findByName(nomeArg);
		} catch (Exception e){
			mostrarErro(e);
		}
	}
	
	public void pesquisar() {
		cidade = null;
		try {
			lista = ejb.findByName(nomeArg);
		} catch (Exception e) {
			mostrarErro(e);
		}
	}
	
	public void novo(){
		cidade = new Cidade();
	}

	public void editar(Long id){
		try {
			cidade = ejb.find(id);
			return;
		} catch (Exception e) {
			mostrarErro(e);
		}
		cidade = null;
	}
	
	public void excluir(Long id){
		try {
			ejb.delete(ejb.find(id));
			lista = ejb.findByName(nomeArg);
		} catch (Exception e) {
			if (checkString(e, "a foreign key constraint fails")){
				mostrarAviso("Não é possível excluir a Cidade pois está sendo utilizada em outro registro","");
				return;
			}
			mostrarErro(e);
			return;
		}
		cidade = null;
		mostrarMensagem("Exclusão realizada com sucesso!","");
	}
	
	public Estado[] getEstados() {
		Estado[] estados = Estado.values();
		Comparator<Estado> comparator = new Comparator<Estado>() {
			  public int compare(Estado e1, Estado e2) {
			     return e1.getNome().compareTo(e2.getNome());
			  }
			};
		Arrays.sort(estados, comparator);
        return estados;
    }
	
	public List<Cidade> getCidades(){
		try {
			return ejb.findAll();
		} catch (Exception e) {
			mostrarErro(e);
			return new ArrayList<Cidade>();
		}
	}
	
}