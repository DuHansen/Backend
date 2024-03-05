package controller;


import java.util.List;

import jakarta.ws.rs.Consumes;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import model.bo.UsuarioBO;

import model.vo.UsuarioVO;

@Path("/usuario")
public class UsuarioRest {
	
	@POST
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioVO cadastrarUsuarioController(UsuarioVO usuario) {
		UsuarioBO receitaBO = new UsuarioBO();
		return receitaBO.cadastrarUsuarioBo(usuario);
	}

    
    @GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioVO> consultarTodosUsuarioController() {
    	UsuarioBO usuarioBO = new UsuarioBO();
		return usuarioBO.consultarTodosUsuariosBo();
	}
	
	@GET
	@Path("/pesquisar/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioVO consultarPessoaController(@PathParam("id") int id) {
		UsuarioBO pessoaBO = new UsuarioBO();
		return pessoaBO.consultarUsuarioBo(id);
	}
    
}

