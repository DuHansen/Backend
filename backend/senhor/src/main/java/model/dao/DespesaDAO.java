package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.vo.DespesaVO;


public class DespesaDAO {

	public boolean verificarCadastroDespesaBaseDadosDao(DespesaVO despesaVo) {
			Connection conn = Banco.getConnection();
			Statement stmt = Banco.getStatement(conn);
			ResultSet resultado = null;
			boolean retorno = false;
			String query = "SELECT iddespesa FROM despesa WHERE iddespesa = ' " + despesaVo.getIdDespesa() + " ' ";
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


	public DespesaVO cadastrarDespesaDao(DespesaVO despesa) {
			
			String query = "INSERT INTO despesa (idusuario, descricao, valor, datapagamento, datavencimento) VALUES (?, ?, ?, ?, ?)";
			Connection conn = Banco.getConnection();
			PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
			try {
				pstmt.setInt(1, despesa.getIdUsuario());
				pstmt.setString(2, despesa.getDescricao());
				pstmt.setDouble(3, despesa.getValor());
				pstmt.setObject(4, despesa.getDataPagamento());
				pstmt.setObject(5, despesa.getDataVencimento());
				pstmt.execute();
				ResultSet resultado = pstmt.getGeneratedKeys();
				if (resultado.next()) {
					despesa.setIdDespesa(resultado.getInt(1));
				}
			} catch (SQLException erro) {
				System.out.println("\nErro ao executar a query do metodo cadastrarReceitaDao!");
				System.out.println("Erro: " + erro.getMessage());
			} finally {
				Banco.closeStatement(pstmt);
				Banco.closeConnection(conn);
			}
			return despesa;
		}


	public ArrayList<DespesaVO> consultarTodasDespesasDao(DespesaVO despesaVo) {
			Connection conn = Banco.getConnection();
			Statement stmt = Banco.getStatement(conn);
			ResultSet resultado = null;
			ArrayList<DespesaVO> listaDespesas = new ArrayList<DespesaVO>();
			 String query = "SELECT iddespesa, descricao, valor, datapagamento, datavencimento FROM despesa "
		        		+ "WHERE idusuario =";
		        try {
		            resultado = stmt.executeQuery(query);
		            while(resultado.next()) {
		            	DespesaVO despesas = new DespesaVO();
		            	despesaVo.setIdDespesa(resultado.getInt(1));	            	
		            	despesaVo.setDescricao(resultado.getString(2));
		            	despesaVo.setValor(resultado.getDouble(3));
		            	despesaVo.setDataPagamento(LocalDate.parse(resultado.getString(4)));
		            	despesaVo.setDataVencimento(LocalDate.parse(resultado.getString(5)));
			        	listaDespesas.add(despesas);
			        }
			} catch (SQLException erro) {
				System.out.println("\nErro ao executar a query do metodo consultarTodasReceitasDao!");
				System.out.println("Erro: " + erro.getMessage());
			} finally {
				Banco.closeResultSet(resultado);
				Banco.closeStatement(stmt);
				Banco.closeConnection(conn);
			}
			return listaDespesas;
			
	}

	public DespesaVO consultarDespesaDao(int idDespesa) {
		
			Connection conn = Banco.getConnection();
			Statement stmt = Banco.getStatement(conn);
			ResultSet resultado = null;
			DespesaVO despesa = new DespesaVO();
			String query = "SELECT idusuario, descricao, valor, datareceita, datapagamento, datavencimento" + 
			"FROM receita" +
			" WHERE idreceita = "
					+ idDespesa;
			try {
				resultado = stmt.executeQuery(query);
				if (resultado.next()) {
					despesa.setIdUsuario(Integer.parseInt(resultado.getString(1)));
					despesa.setDescricao(resultado.getString(2));
					despesa.setValor(resultado.getDouble(3));			
					despesa.setDataPagamento(LocalDate.parse(resultado.getString(4)));
					despesa.setDataVencimento(LocalDate.parse(resultado.getString(5)));
					
				}
			} catch (SQLException erro) {
				System.out.println("\nErro ao executar a query do metodo consultarUsuarioDao!");
				System.out.println("Erro: " + erro.getMessage());
			} finally {
				Banco.closeResultSet(resultado);
				Banco.closeStatement(stmt);
				Banco.closeConnection(conn);
			}
			return despesa;
		}
	


	public boolean atualizarDespesaDao(DespesaVO despesaVo) {
		
			Connection conn = Banco.getConnection();
			Statement stmt = Banco.getStatement(conn);
			boolean retorno = false;
			String query = "UPDATE receita SET descricao = '" + despesaVo.getDescricao() + "', valor = '" + despesaVo.getValor()
					+ "', datavencimento = '" + despesaVo.getDataVencimento() + "', datapagamento = '" + despesaVo.getDataPagamento() + "WHERE idreceita = "
					+ despesaVo.getIdDespesa();
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
	

	public boolean excluirDespesaDao(DespesaVO despesaVo) {
			Connection conn = Banco.getConnection();
			Statement stmt = Banco.getStatement(conn);
			boolean retorno = false;
			String query = "DELETE FROM receita WHERE idreceita = " + despesaVo.getIdDespesa();
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

}
