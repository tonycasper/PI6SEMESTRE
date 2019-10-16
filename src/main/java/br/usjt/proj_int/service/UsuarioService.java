package br.usjt.proj_int.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.usjt.proj_int.enums.TipoUsuario;
import br.usjt.proj_int.model.beans.Usuario;
import br.usjt.proj_int.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{

	@Autowired UsuarioRepository usuarioRepository;
	
	public Usuario cadastrar(Usuario usuario) {
		return usuarioRepository.save(criptografarSenha(usuario));
	}
	
	public Usuario criptografarSenha(Usuario usuario) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
	}

	@Override
	public UserDetails loadUserByUsername(String usuario) {
		List<GrantedAuthority> authorityList = AuthorityUtils.createAuthorityList();
		Usuario usuarioAutenticado = usuarioRepository.findByUsuario(usuario);		
		if(usuarioAutenticado.getTipo() == TipoUsuario.ADMINISTRADOR)	authorityList = AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_ESTAGIARIO");
		else if(usuarioAutenticado.getTipo() == TipoUsuario.ESTAGIARIO) authorityList = AuthorityUtils.createAuthorityList("ROLE_ESTAGIARIO");		
		return new User(usuarioAutenticado.getUsuario(), usuarioAutenticado.getSenha(), authorityList);
	}

	public Object findByUsuario(Usuario usuario) {
		return usuarioRepository.findByUsuario(usuario.getUsuario());
	}
}
