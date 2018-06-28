package br.unibh.loja.negocio;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public abstract class DAO<T, K> {

	@Inject
	EntityManager em;

	@Inject
	private Logger log;

	private Class<T> type;

	public DAO(Class<T> type) {
		this.type = type;
	}

	public T insert(T t) throws Exception {
		log.info("Persistindo " + t);
		em.persist(t);
		return t;
	}

	public T update(T t) throws Exception {
		log.info("Atualizando " + t);
		return em.merge(t);
	}

	public void delete(T t) throws Exception {
		log.info("Removendo " + t);
		Object c = em.merge(t);
		em.remove(c);
	}

	public T find(K k) throws Exception {
		log.info("Encontrando pela chave " + k);
		return em.find(this.type, k);
	}

}
