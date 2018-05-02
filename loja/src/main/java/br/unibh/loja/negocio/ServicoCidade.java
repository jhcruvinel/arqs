package br.unibh.loja.negocio;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.unibh.loja.entidades.Cidade;

@Stateless
@LocalBean
public class ServicoCidade implements DAO<Cidade, Long> {
	@Inject
	EntityManager em;

	@Inject
	private Logger log;
	
	public Cidade insert(Cidade t) throws Exception {
		log.info("Persistindo "+t);
		em.persist(t);
		return t;
	}

	public Cidade update(Cidade t) throws Exception {
		log.info("Atualizando "+t);
		return em.merge(t);
	}

	public void delete(Cidade t) throws Exception {
		log.info("Removendo "+t);
		Object c = em.merge(t);
		em.remove(c);
	}

	public Cidade find(Long k) throws Exception {
		log.info("Encontrando pela chave "+k);
		return em.find(Cidade.class, k);
	}

	@SuppressWarnings("unchecked")
	public List<Cidade> findAll() throws Exception {
		log.info("Encontrando todos os objetos");
		return em.createQuery("from Cidade").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Cidade> findByName(String name) throws Exception {
		log.info("Encontrando o "+name);
		return em.createNamedQuery("Cidade.findByName")
				.setParameter("nome", "%"+name+"%").getResultList();
	}
	
}