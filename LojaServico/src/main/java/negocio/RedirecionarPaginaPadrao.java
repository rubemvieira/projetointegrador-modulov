package negocio;
import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class RedirecionarPaginaPadrao implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
		if(roles.contains("ROLE_ADMINISTRADOR")) {
			response.sendRedirect("/LojaServico/admin/admin.xhtml");
		}else if(roles.contains("ROLE_CLIENTE")) {
			response.sendRedirect("/LojaServico/cliente/carrinho.xhtml");
		}
		
	}

	
	
}