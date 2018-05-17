package br.unibh.loja.negocio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Calendar;
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
import br.unibh.loja.entidades.Funcionario;
import br.unibh.loja.util.Resources;

@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteServicoFuncionario {

	@Deployment
	public static Archive<?> createTestArchive() {
		// Cria o pacote que vai ser instalado no Wildfly para realizacao dos testes
		return ShrinkWrap.create(WebArchive.class, "testeloja.war")
				.addClasses(
						Funcionario.class, Cidade.class, Estado.class, 
						ServicoFuncionario.class, ServicoCidade.class,
						Resources.class, DAO.class)
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	// Realiza as injecoes com CDI
	
	@Inject
	private Logger log;

	@Inject
	private ServicoCidade sc;

	@Inject
	private ServicoFuncionario sf;

	@Test
	public void teste01_inserirCidade() throws Exception {
		log.info("============> Iniciando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Cidade c = new Cidade(1L, "Belo Horizonte", Estado.MG);
		sc.insert(c);
		Cidade aux = sc.findByName("Belo Horizonte").get(0);
		assertEquals("Belo Horizonte", aux.getNome());
		log.info("============> Finalizando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	@Test
	public void teste02_inserirFuncionario() throws Exception {
		log.info("============> Iniciando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Cidade cid = (Cidade) sc.findByName("Belo Horizonte").get(0);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -10);
		Funcionario o = new Funcionario(1L, "João da Silva", cal.getTime(), new BigDecimal("2000.0"), cid); 
		sf.insert(o);
		Funcionario aux = (Funcionario) sf.find(1L);
		assertEquals("João da Silva", aux.getNome());
		log.info("============> Finalizando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void teste03_inserirCidade() throws Exception {
		log.info("============> Iniciando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Cidade c = new Cidade(null, "Betim", Estado.MG);
		sc.insert(c);
		Cidade aux = sc.findByName("Betim").get(0);
		assertEquals("Betim", aux.getNome());
		log.info("============> Finalizando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}
		
	@Test
	public void teste04_atualizarFuncionario() throws Exception {
		log.info("============> Iniciando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Funcionario o = (Funcionario) sf.findByName("João da Silva").get(0);
		Cidade cid = sc.findByName("Betim").get(0); 
		o.setCidade(cid);
		sf.update(o);
		Funcionario aux = (Funcionario) sf.findByName("João da Silva").get(0);
		assertEquals("Betim", aux.getCidade().getNome());
		log.info("============> Finalizando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}

	@Test
	public void teste05_inserirComErro() throws Exception {
		log.info("============> Iniciando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
		try {
			Cidade cid = sc.findByName("Betim").get(0); 
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.YEAR, +1); // Data futura
			Funcionario o = new Funcionario(null, "João da Silva@", cal.getTime(), new BigDecimal("10.0"), cid); 
			sf.insert(o);
		} catch (Exception e){
			assertTrue(checkString(e, "deve estar no passado"));
		}
		log.info("============> Finalizando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
	}
	
	@Test
	public void teste06_excluir() throws Exception {
		log.info("============> Iniciando o teste " + Thread.currentThread().getStackTrace()[1].getMethodName());
		Funcionario aux = (Funcionario) sf.findByName("João da Silva").get(0);
		sf.delete(aux);
		Cidade cid = sc.findByName("Betim").get(0); 
		sc.delete(cid);
		Cidade cid2 = sc.findByName("Belo Horizonte").get(0); 
		sc.delete(cid2);
		assertEquals(0, sf.findByName("João Andrade").size());
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
