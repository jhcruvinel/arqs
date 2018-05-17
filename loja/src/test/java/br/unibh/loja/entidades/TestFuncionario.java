package br.unibh.loja.entidades;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

public class TestFuncionario {

	@Test
	public void testEquals() {
		Date d = new Date();
		Cidade c = new Cidade(1L, "Belo Horizonte", Estado.MG);
		Funcionario f1 = new Funcionario(1L, "João", d, new BigDecimal(1000.00), c);
		Funcionario f2 = new Funcionario(1L, "João", d, new BigDecimal(1000.00), c);
		assertEquals(true, f1.equals(f2));
	}	
}
