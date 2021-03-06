package br.edu.ifpb.simpleevents.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.simpleevents.controller.IndexController;
import br.edu.ifpb.simpleevents.entity.Evento;
import br.edu.ifpb.simpleevents.facade.LoginFacade;

@Named(value = "index")
@SessionScoped
public class IndexBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Evento> eventos;
	private String teste;

	@Inject
	private IndexController controller;
	
    @Inject
    private SecurityContext securityContext;

	public String teste() {
		return null;
	}
	
	public String showindex() {
    	HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    	String user = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
    	if(user != null) {
        	response.addCookie(new Cookie("lastUser",user));
        }
    	this.eventos = controller.getEventos();
    	return "/WEB-INF/facelets/evento/listInCards.xhtml";
    }
	
	public String showNavBar() {
		if(LoginFacade.isAuthenticated()) {
        	return "/WEB-INF/facelets/navbar/navbarLoggedIn.xhtml";
        }else {
        	return "/WEB-INF/facelets/navbar/navbarLoggedOut.xhtml";
        }
	}

//    @GetMapping("/login")
//    public String login(Model model, @CookieValue(value = "lastUser", defaultValue="nenhum") String lastUser) {
//    	if(!lastUser.equals("nenhum")) {
//    		model.addAttribute("lastUser",lastUser);	
//    	}
//    	return "login"; // <<< Retorna a página de login
//    }
//    
//    @GetMapping("/pesquisar")
//    public String pesquisar(Model model,
//    		@RequestParam(value = "nome", required = false) String nome) {
//    	model.addAttribute("eventos",eventoDAO.findByName(nome));
//    	return "index";
//    }

	// get and setters

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public String getTeste() {
		return teste;
	}

	public void setTeste(String teste) {
		this.teste = teste;
	}

}
