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
public class ServicoFuncionario implements DAO<Funcionario, Long> {
	
	@Inject
	EntityManager em;

	@Inject
	private Logger log;
	
	public Funcionario insert(Funcionario t) throws Exception {
		log.info("Persistindo "+t);
		em.persist(t);
		return t;
	}

	public Funcionario update(Funcionario t) throws Exception {
		log.info("Atualizando "+t);
		return em.merge(t);
	}

	public void delete(Funcionario t) throws Exception {
		log.info("Removendo "+t);
		Object c = em.merge(t);
		em.remove(c);
	}

	public Funcionario find(Long k) throws Exception {
		log.info("Encontrando pela chave "+k);
		return em.find(Funcionario.class, k);
	}

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