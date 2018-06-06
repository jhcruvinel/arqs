package br.unibh.loja.controle;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.naming.InitialContext;

import br.unibh.loja.entidades.Cidade;
import br.unibh.loja.negocio.ServicoCidade;

public class ConversorCidade implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent component,
			String value) {
		try {
			ServicoCidade ss = (ServicoCidade) new InitialContext()
					.lookup("java:module/ServicoCidade");
			if (value != null) return ss.find(new Long(value));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent component,
			Object value) {
		if (value != null && value instanceof Cidade) {
			Cidade s = (Cidade) value;
			if (s.getId() != null)
				return s.getId().toString();
		}
		return null;
	}
}
