package model.bo;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import model.dao.UsuarioDAO;
import model.vo.UsuarioVO;

public class UsuarioBO {

	
	//Create
	
	public UsuarioVO cadastrarUsuarioBo(UsuarioVO usuario) {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		if(usuarioDao.verificarCadastroUsuarioBaseDadosDao(usuario)) {
			System.out.println("\nPessoa já cadastrada na base de Dados.");
		} else {
			if(Period.between(usuario.getDataNascimento(), LocalDate.now()).getYears() >= 18) {
				usuario = usuarioDao.cadastrarUsuarioDao(usuario);
			} else {
				System.out.println("\nPessoa é menor de idade.");
			}
		}
		return usuario;
	}
	
	//Read all
	public ArrayList<UsuarioVO> consultarTodosUsuariosBo () {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		ArrayList<UsuarioVO> listaUsuarios = usuarioDao.consultarTodosUsuariosDao();
		if(listaUsuarios.isEmpty()) {
			System.out.println("Lista de Usuários está vazia!");
		}
		return listaUsuarios;
	}
	
	//Read one
	public UsuarioVO consultarUsuarioBo (int idUsuario) {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		UsuarioVO usuario = usuarioDao.consultarUsuarioDao(idUsuario);
		if(usuario == null) {
			System.out.println("\nUsuário não localizado!");
		}
		return usuario;
	}
	
}
