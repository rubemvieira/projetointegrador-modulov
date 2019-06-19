package converter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import persistencia.FormaPagamentoDAO;
import bean.FormaPagamento;

@ManagedBean
@RequestScoped
public class FormaPagamentoConverter implements Converter {

	public FormaPagamentoConverter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
            return null;
        }
		return new FormaPagamentoDAO().retrieveById(Integer.parseInt(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
            return "";
        }
		if (value instanceof FormaPagamento) {
            return String.valueOf(((FormaPagamento) value).getId());
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid FormaPagamento", value)), null);
        }
	}

}
