package br.unibh.loja.util;

import java.util.Calendar;

import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 * Código de exemplo de como calcular número de dias entre datas
 */
public class DataUtil {
	
	public static void main(String args[]) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -6); // Diminuindo 6 meses
		DateTime anterior = new DateTime(cal.getTime());
		DateTime atual = new DateTime();
		long dias = Days.daysBetween(anterior.toLocalDate(), atual.toLocalDate()).getDays();
		System.out.println(dias);
	}

}
