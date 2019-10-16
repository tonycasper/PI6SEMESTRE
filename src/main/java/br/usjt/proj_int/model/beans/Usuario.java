package br.usjt.proj_int.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import br.usjt.proj_int.enums.TipoUsuario;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	@NotEmpty
	@Column(unique = true)
	private String usuario;
	
	private String nome;

	private String decricao;

	@NotEmpty
	private String senha;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipo;
	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getId() {
		return id;
	}

	public Usuario setId(String id) {
		this.id = id;
		return this;
	}

	public String getUsuario() {
		return usuario;
	}

	public Usuario setUsuario(String usuario) {
		this.usuario = usuario;
		return this;
	}

	public String getSenha() {
		return senha;
	}

	public Usuario setSenha(String senha) {
		this.senha = senha;
		return this;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public Usuario setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
		return this;
	}
}
