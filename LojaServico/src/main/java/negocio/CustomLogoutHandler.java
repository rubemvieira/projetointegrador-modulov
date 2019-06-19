package negocio;
import javax.el.ELContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class CustomLogoutHandler extends SecurityContextLogoutHandler{
		
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) {
		FacesContext context = FacesContext.getCurrentInstance();
		if (context != null) {
			ELContext elContext = context.getELContext();
			CarrinhoController carrinho = (CarrinhoController) elContext.getELResolver().getValue(elContext, null, "carrinhoController");
			carrinho.limparCarrinho();
		}
		
	}
}
