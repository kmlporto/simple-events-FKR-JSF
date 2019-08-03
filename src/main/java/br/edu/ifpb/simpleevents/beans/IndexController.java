//package br.edu.ifpb.simpleevents.beans;
//
//import java.security.Principal;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.CookieValue;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import br.edu.ifpb.pweb2.projeto.simpleeventFKR.dao.EspecialidadeDAO;
//import br.edu.ifpb.pweb2.projeto.simpleeventFKR.dao.EventoDAO;
//import br.edu.ifpb.pweb2.projeto.simpleeventFKR.dao.UserDAO;
//import br.edu.ifpb.pweb2.projeto.simpleeventFKR.model.StatusEvento;
//
//@Controller
//@RequestMapping("/")
//public class IndexController {
//
//    @Autowired
//    public EventoDAO eventoDAO;
//    @Autowired
//    public UserDAO userDAO;
//    @Autowired
//    public EspecialidadeDAO especDAO;
//
//    @RequestMapping(method = RequestMethod.GET)
//    public String showIndex(Model model, Principal user, HttpServletResponse response) {
//        if(user != null) {
//        	response.addCookie(new Cookie("lastUser",user.getName()));
//        }
//    	model.addAttribute("eventos", eventoDAO.findByStatus(StatusEvento.ABERTO));
//        return "index.html";
//    }
//    
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
//
//}
