package br.unibh.loja.entidades;

import java.math.BigDecimal;
import java.util.Calendar;
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
public class TestValidationFuncionario {

	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		System.out.println("Inicializando validador...");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void testeValidacaoFuncionario1() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, 10);
		Cidade cidade = new Cidade(1L, "Belo Horizonte", Estado.MG);
		Funcionario o = new Funcionario(1L, "João@", cal.getTime(), new BigDecimal(10.0), cidade);
		System.out.println(o);
		Set<ConstraintViolation<Funcionario>> constraintViolations = validator.validate( o );
		for (ConstraintViolation<Funcionario> c: constraintViolations) {
			System.out.println(" Erro de Validacao: "+c.getMessage());
		}
		Assert.assertEquals(3, constraintViolations.size() );
	}
}
