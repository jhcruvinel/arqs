package br.unibh.loja.negocio;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.unibh.loja.entidades.Funcionario;

@Stateless
@LocalBean
public class ServicoFuncionario extends DAO<Funcionario, Long> {
	
	public ServicoFuncionario() {
        super(Funcionario.class);
    }
	
	@Inject
	EntityManager em;

	@Inject
	private Logger log;
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> findAll() throws Exception {
		log.info("Encontrando todos os objetos");
		return em.createQuery("from Funcionario").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> findByName(String name) throws Exception {
		log.info("Encontrando o "+name);
		return em.createNamedQuery("Funcionario.findByName")
				.setParameter("nome", "%"+name+"%").getResultList();
	}
	
}