package br.unibh.loja.negocio;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.unibh.loja.entidades.Fornecedor;

@Stateless
@LocalBean
public class ServicoFornecedor extends DAO<Fornecedor, Long> {
	
	public ServicoFornecedor() {
        super(Fornecedor.class);
    }
	
	@Inject
	EntityManager em;

	@Inject
	private Logger log;
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> findAll() throws Exception {
		log.info("Encontrando todos os objetos");
		return em.createQuery("from Fornecedor").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Fornecedor> findByName(String name) throws Exception {
		log.info("Encontrando o "+name);
		return em.createNamedQuery("Fornecedor.findByName")
				.setParameter("nome", "%"+name+"%").getResultList();
	}
	
}