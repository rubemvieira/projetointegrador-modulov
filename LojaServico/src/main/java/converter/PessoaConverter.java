package converter;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import persistencia.PessoaDAO;
import bean.Pessoa;

@ManagedBean
@RequestScoped
public class PessoaConverter implements Converter {

	public PessoaConverter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
            return null;
        }
		return new PessoaDAO().retrieveById(Long.parseLong(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
            return "";
        }
		if (value instanceof Pessoa) {
            return String.valueOf(((Pessoa) value).getId());
        } else {
            throw new ConverterException(new FacesMessage(String.format("%s is not a valid Pessoa", value)), null);
        }
	}

}
