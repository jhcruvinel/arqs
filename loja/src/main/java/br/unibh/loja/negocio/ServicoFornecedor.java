package br.unibh.loja.negocio;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.unibh.loja.entidades.Fornecedor;

@Stateless
@LocalBean
public class ServicoFornecedor implements DAO<Fornecedor, Long> {
	
	@Inject
	EntityManager em;

	@Inject
	private Logger log;
	
	public Fornecedor insert(Fornecedor t) throws Exception {
		log.info("Persistindo "+t);
		t.setDataCadastro(new Date());
		em.persist(t);
		return t;
	}

	public Fornecedor update(Fornecedor t) throws Exception {
		log.info("Atualizando "+t);
		return em.merge(t);
	}

	public void delete(Fornecedor t) throws Exception {
		log.info("Removendo "+t);
		Object c = em.merge(t);
		em.remove(c);
	}

	public Fornecedor find(Long k) throws Exception {
		log.info("Encontrando pela chave "+k);
		return em.find(Fornecedor.class, k);
	}

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