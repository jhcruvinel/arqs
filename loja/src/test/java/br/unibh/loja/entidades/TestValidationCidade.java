package br.unibh.loja.entidades;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestValidationCidade {

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		System.out.println("Inicializando validador...");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void testeValidacaoCidade1() {
		Cidade o = new Cidade(1L, "Belo Horizonte", Estado.MG);
		System.out.println(o);
		Set<ConstraintViolation<Cidade>> constraintViolations = validator.validate( o );
		for (ConstraintViolation<Cidade> c: constraintViolations) {
			System.out.println(" Erro de Validacao: "+c.getMessage());
		}
		Assert.assertEquals(0, constraintViolations.size() );
	}

	
	@Test
	public void testeValidacaoCidade2() {
		Cidade o = new Cidade(1L, "Belo Horizonte@", Estado.MG);
		System.out.println(o);
		Set<ConstraintViolation<Cidade>> constraintViolations = validator.validate( o );
		for (ConstraintViolation<Cidade> c: constraintViolations) {
			System.out.println(" Erro de Validacao: "+c.getMessage());
		}
		Assert.assertEquals(1, constraintViolations.size() );
	}
}
