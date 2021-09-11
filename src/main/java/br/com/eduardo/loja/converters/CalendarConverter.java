package br.com.eduardo.loja.converters;

import java.util.Calendar;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=Calendar.class)
public class CalendarConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// Conversão Tela >>> ManagerBean
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// Conversão MenagerBean >>> Tela
		return null;
	}

}
