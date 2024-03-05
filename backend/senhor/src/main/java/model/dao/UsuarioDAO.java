package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import java.util.ArrayList;



import model.vo.UsuarioVO;

public class UsuarioDAO {


	// INSERT
	public boolean verificarCadastroUsuarioBaseDadosDao(UsuarioVO usuario) {
	    Connection conn = Banco.getConnection();
	    Statement stmt = Banco.getStatement(conn);
	    ResultSet resultado = null;
	    boolean retorno = false;

	    String query = "SELECT cpf FROM usuario WHERE cpf = '" + usuario.getCpf() + "' ";
	    try {
	        PreparedStatement pstmt = conn.prepareStatement(query);
	        pstmt.setString(1, usuario.getCpf());

	        resultado = pstmt.executeQuery();

	        if (resultado.next()) {
	            retorno = true;
	        }
	    } catch (SQLException erro) {
	        System.out.println("\nErro ao executar a query do método verificarCadastroUsuarioBaseDadosDao!");
	        System.out.println("Erro: " + erro.getMessage());
	    } finally {
	        Banco.closeResultSet(resultado);
	        Banco.closeStatement(stmt);
	        Banco.closeConnection(conn);
	    }
	    return retorno;
	}


	
	public UsuarioVO cadastrarUsuarioDao(UsuarioVO usuario) {
		String query = "INSERT INTO usuario (nome, cpf, email, datanascimento, login, senha) VALUES (?, ?, ?, ?, ?, ?)";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		try {
			pstmt.setString(1, usuario.getNome());
			pstmt.setString(2, usuario.getCpf());
			pstmt.setString(3, usuario.getEmail());
			pstmt.setObject(4, usuario.getDataNascimento());
			pstmt.setString(5, usuario.getLogin());
			pstmt.setString(6, usuario.getSenha());
			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys();
			if (resultado.next()) {
				usuario.setIdUsuario(resultado.getInt(1));
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo cadastrarUsuarioDao!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return usuario;
	}

	// UPDATE
	public boolean atualizarUsuarioDao(UsuarioVO usuarioVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		String query = "UPDATE usuario SET nome = '" + usuarioVo.getNome() + "', cpf = '" + usuarioVo.getCpf()
				+ "', email = '" + usuarioVo.getEmail() + "', datanascimento = '" + usuarioVo.getDataNascimento()
				+ "', login = '" + usuarioVo.getLogin() + "', senha = '" + usuarioVo.getSenha() + "WHERE idusuario = "
				+ usuarioVo.getIdUsuario();
		try {
			if (stmt.executeUpdate(query) == 1) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo atualizarUsuarioDao!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}

	// READ ALL
	
	
	public ArrayList<UsuarioVO> consultarTodosUsuariosDao() {
	    Connection conn = Banco.getConnection();
	    Statement stmt = Banco.getStatement(conn);
	    ResultSet resultado = null;
	    ArrayList<UsuarioVO> listaUsuarios = new ArrayList<UsuarioVO>();
	    String query = "SELECT * FROM usuario";
	    try {
	        resultado = stmt.executeQuery(query);
	        while (resultado.next()) {
	            UsuarioVO usuario = new UsuarioVO();
	            usuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
	            usuario.setNome(resultado.getString(2));
	            usuario.setCpf(resultado.getString(3));
	            usuario.setEmail(resultado.getString(4));	          
	            usuario.setDataNascimento(LocalDate.parse(resultado.getString(5)));
	            usuario.setLogin(resultado.getString(6));
	            usuario.setSenha(resultado.getString(7));
	        }
	    } catch (SQLException erro) {
	        System.out.println("\nErro ao executar a query do metodo consultarTodosUsuariosDao!");
	        System.out.println("Erro: " + erro.getMessage());
	    } finally {
	        Banco.closeResultSet(resultado);
	        Banco.closeStatement(stmt);
	        Banco.closeConnection(conn);
	    }
	    return listaUsuarios;
	}


	// READ ONE
	public UsuarioVO consultarUsuarioDao(int idUsuario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		UsuarioVO usuario = new UsuarioVO();
		String query = "SELECT idusuario, nome, cpf, email, datanascimento FROM usuario" + " WHERE idusuario = "
				+ idUsuario;
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				usuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				usuario.setNome(resultado.getString(2));
				usuario.setCpf(resultado.getString(3));
				usuario.setEmail(resultado.getString(4));
				usuario.setDataNascimento(LocalDate.parse(resultado.getString(5)));
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo consultarUsuarioDao!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuario;
	}

}


