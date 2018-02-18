package br.com.caelum.vraptor.intercepts;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotations.Public;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.controller.LoginController;
import br.com.caelum.vraptor.controller.SessaoUsuario;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

@Intercepts
public class AutorizadorInterceptor {
	
	
	@Inject private SessaoUsuario sessaoUsuario;
	@Inject private Result result;
	@Inject private ControllerMethod method;
	
	@Accepts
	public boolean accepts() {
		return !method.containsAnnotation(Public.class);
	}

	@AroundCall
	public void intercept(SimpleInterceptorStack stack) {
		
		if(sessaoUsuario.getUsuario() == null) {
			result.redirectTo(LoginController.class).formulario();
			return;
		}
		
		stack.next();
	}
}
