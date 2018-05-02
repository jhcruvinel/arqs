package br.unibh.loja.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import br.unibh.loja.entidades.Cidade;
import br.unibh.loja.entidades.Estado;
import br.unibh.loja.entidades.Fornecedor;
import br.unibh.loja.util.Resources;

@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteServicoCidade {

	@Deployment
	public static Archive<?> createTestArchive() {
		// Cria o pacote que vai ser instalado no Wildfly para realizacao dos testes
		return ShrinkWrap.create(WebArchive.class, "testeseguro.war")
				.addClasses(Cidade.class, Estado.class, Fornecedor.class, 
						Resources.class, DAO.class, ServicoCidade.class)
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	// Realiza as injecoes com CDI
	
	@Inject
	private Logger log;

	@Inject
	private ServicoCidade ss;

	@Test
	public void teste01_inserirSemErro() throws Exception {
		log.info("============> Iniciando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Cidade o = new Cidade(null, "Belo Horizonte", Estado.MG);
		ss.insert(o);
		Cidade aux = (Cidade) ss.findByName("Belo Horizonte").get(0);
		assertNotNull(aux);
		log.info("============> Finalizando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void teste02_inserirComErro() throws Exception {
		log.info("============> Iniciando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			Cidade o = new Cidade(null, "Belo Horizonte@", Estado.MG);
			ss.insert(o);
		} catch (Exception e){
			assertTrue(checkString(e, "Caracteres permitidos: letras, espaços, ponto e aspas simples"));
		}
		log.info("============> Finalizando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}
		
	@Test
	public void teste03_atualizar() throws Exception {
		log.info("============> Iniciando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Cidade o = (Cidade) ss.findByName("Belo Horizonte").get(0);
		o.setNome("Belo Horizonte modificado");
		ss.update(o);
		Cidade aux = (Cidade) ss.findByName("Belo Horizonte modificado").get(0);
		assertNotNull(aux);
		log.info("============> Finalizando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void teste04_excluir() throws Exception {
		log.info("============> Iniciando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Cidade o = (Cidade) ss.findByName("Belo Horizonte").get(0);
		ss.delete(o);
		assertEquals(0, ss.findByName("Belo Horizonte modificado").size());
		log.info("============> Finalizando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	private boolean checkString(Throwable e, String str){
		if (e.getMessage().contains(str)){
			return true;
		} else if (e.getCause() != null){
			return checkString(e.getCause(), str);
		}
		return false;
	}
}
