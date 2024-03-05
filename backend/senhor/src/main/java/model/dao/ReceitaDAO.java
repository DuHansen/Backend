package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import model.vo.ReceitaVO;


public class ReceitaDAO {


	// INSERT
	public boolean verificarCadastroReceitaBaseDadosDao(ReceitaVO receitaVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		boolean retorno = false;
		String query = "SELECT idreceita FROM receita WHERE idreceita = ' " + receitaVo.getIdReceita() + " ' ";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo verificarCadastroUsuarioBaseDadosDao!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}

	
	
	public ReceitaVO cadastrarReceitaDao(ReceitaVO receita) {
			
			String query = "INSERT INTO receita (idusuario, idReceita, descricao, valor, datareceita) VALUES (?, ?, ?, ?)";
			Connection conn = Banco.getConnection();
			PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
			try {
				pstmt.setInt(1, receita.getIdUsuario());
				pstmt.setInt(2, receita.getIdReceita());
				pstmt.setString(3, receita.getDescricao());
				pstmt.setDouble(4, receita.getValor());
				pstmt.setObject(5, receita.getDataReceita());
				pstmt.execute();
				ResultSet resultado = pstmt.getGeneratedKeys();
				if (resultado.next()) {
					receita.setIdReceita(resultado.getInt(1));
				}
			} catch (SQLException erro) {
				System.out.println("\nErro ao executar a query do metodo cadastrarReceitaDao!");
				System.out.println("Erro: " + erro.getMessage());
			} finally {
				Banco.closeStatement(pstmt);
				Banco.closeConnection(conn);
			}
			return receita;
		}

	
	
	// UPDATE
	public boolean atualizarReceitaDao(ReceitaVO receitaVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		String query = "UPDATE receita SET descricao = '" + receitaVo.getDescricao() + "', valor = '" + receitaVo.getValor()
				+ "', dataReceita = '" + receitaVo.getDataReceita() + "WHERE idreceita = "
				+ receitaVo.getIdReceita();
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

	
	
	// DELETE
	public boolean excluirReceitaDao(ReceitaVO receitaVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		String query = "DELETE FROM receita WHERE idreceita = " + receitaVo.getIdReceita();
		try {
			if (stmt.executeUpdate(query) == 1) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo excluirUsuarioDao!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}

	// READ ALL
	public ArrayList<ReceitaVO> consultarTodasReceitasDao() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<ReceitaVO> listaReceitas = new ArrayList<ReceitaVO>();
		 String query = "SELECT idusuario, idreceita, descricao, valor, datareceita FROM receita "
	        		+ "WHERE idusuario =";
	        try {
	            resultado = stmt.executeQuery(query);
	            while(resultado.next()) {
	            	ReceitaVO receita = new ReceitaVO();
	            	receita.setIdUsuario(resultado.getInt(1));
	            	receita.setIdReceita(resultado.getInt(2));	            	
	            	receita.setDescricao(resultado.getString(3));
		        	receita.setValor(resultado.getDouble(4));
		        	receita.setDataReceita(LocalDate.parse(resultado.getString(5)));
		        	listaReceitas.add(receita);
		        }
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo consultarTodasReceitasDao!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaReceitas;
		
	}
	
	// READ ONE 
	public ReceitaVO consultarReceitaDao(int idReceita) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ReceitaVO receita = new ReceitaVO();
		String query = "SELECT idusuario, descricao, valor, datareceita" + 
		"FROM receita" +
		" WHERE idreceita = "
				+ idReceita;
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				receita.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				receita.setDescricao(resultado.getString(2));
				receita.setValor(resultado.getDouble(3));			
				receita.setDataReceita(LocalDate.parse(resultado.getString(4)));
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo consultarUsuarioDao!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return receita;
	}
}

