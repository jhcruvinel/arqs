package br.unibh.loja.entidades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class TestCidade {

	@Test
	public void testCreateObject() {
		Cidade c = new Cidade(1L,"Belo Horizonte",Estado.MG);
		assertEquals(c.getId(),new Long(1));
		assertEquals(c.getNome(),"Belo Horizonte");
		assertEquals(c.getEstado().getCodigo(),"31");
	}
	
	@Test
	public void testCompareObjects() {
		Cidade c1 = new Cidade(1L,"Belo Horizonte",Estado.MG);
		Cidade c2 = new Cidade(1L,"Belo horizonte",Estado.MG);
		assertNotEquals(c1,c2);
	}
	
	@Test
	public void testGenerateHash() {
		Cidade c1 = new Cidade(1L,"Belo Horizonte",Estado.MG);
		Cidade c2 = new Cidade(1L,"Belo Horizonte",Estado.MG);
		assertEquals(c1.hashCode(), c2.hashCode());
		Cidade c3 = new Cidade(1L,"Belo horizonte",Estado.MG);
		assertNotEquals(c1.hashCode(), c3.hashCode());
	}
	
	public void testPrintObject() {
		Cidade c1 = new Cidade(1L,"Belo Horizonte",Estado.MG);
		assertEquals(c1.toString(), "Cidade [id=1, nome=Belo Horizonte, estado=MG]");
	}
	
}
