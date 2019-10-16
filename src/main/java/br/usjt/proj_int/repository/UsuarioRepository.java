package br.usjt.proj_int.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.usjt.proj_int.model.beans.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{

	Usuario findByUsuario(String usuario);

}
