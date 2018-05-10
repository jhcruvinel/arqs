package br.unibh.loja.util;

import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Period;

public class DataUtil {
	
	public static Period comparaDatas(Date d1, Date d2) {
		return new Period(new DateTime(d1), new DateTime(d2));
	}
	
	public static Period comparaDataComDataCorrente(Date d1) {
		return new Period(new DateTime(d1), new DateTime());
	}
	
	public static void main(String args[]) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, 6);
		Period p = comparaDataComDataCorrente(cal.getTime());
		System.out.println(p.getYears());
	}

}
