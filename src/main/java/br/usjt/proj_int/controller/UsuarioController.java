package br.usjt.proj_int.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.usjt.proj_int.enums.TipoUsuario;
import br.usjt.proj_int.model.beans.Usuario;
import br.usjt.proj_int.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired UsuarioService usuarioService;
		
	@GetMapping("/")
	public String home() {
		return "redirect:/conteudos/timeline";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar() {
		return "cadastro";
	}
	
	@PostMapping("/cadastrar")
	public String cadastrar(Usuario usuario){
		usuarioService.cadastrar(usuario.setTipo(TipoUsuario.COMUM));
		return login();
	}
}
