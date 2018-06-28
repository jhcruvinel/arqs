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
public class ServicoCidade extends DAO<Cidade, Long> {
	
	public ServicoCidade() {
        super(Cidade.class);
    }
	
	@Inject
	EntityManager em;

	@Inject
	private Logger log;
	
	@SuppressWarnings("unchecked")
	public List<Cidade> findAll() throws Exception {
		log.info("Encontrando todos os objetos");
		return em.createQuery("select o from Cidade o order by o.nome").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Cidade> findByName(String name) throws Exception {
		log.info("Encontrando o "+name);
		return em.createNamedQuery("Cidade.findByName")
				.setParameter("nome", "%"+name+"%").getResultList();
	}
	
	
}