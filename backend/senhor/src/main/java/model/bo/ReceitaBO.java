package model.bo;

import java.util.ArrayList;

import model.dao.ReceitaDAO;
import model.vo.ReceitaVO;


public class ReceitaBO {

	
		public ReceitaVO cadastrarReceitaBO (ReceitaVO receitaVo) {
			ReceitaDAO receitaDao = new ReceitaDAO();
			if(receitaDao.verificarCadastroReceitaBaseDadosDao(receitaVo)) {
				System.out.println("receita ja cadastrado!");
			}else {
				receitaVo = receitaDao.cadastrarReceitaDao(receitaVo);
			}
			return receitaVo;
		}
		
		
		public ArrayList<ReceitaVO> consultarTodasReceitasBO () {
			ReceitaDAO receitaDao = new ReceitaDAO();
			ArrayList<ReceitaVO> listaReceitasVo = receitaDao.consultarTodasReceitasDao();
			if(listaReceitasVo.isEmpty()) {
				System.out.println("Lista de Receita está vazia!");
			}
			return listaReceitasVo;
		}
        
	
		public ReceitaVO consultarReceitaBO (int idReceita) {
			ReceitaDAO receitaDao = new ReceitaDAO();
			ReceitaVO receita = receitaDao.consultarReceitaDao(idReceita);
			if(receita == null) {
				System.out.println("\nReceita não localizada!");
			}
			return receita;
		}
	
		public boolean atualizarReceitaBO (ReceitaVO receitaVo) {
			boolean resultado = false;
			ReceitaDAO receitaDao = new ReceitaDAO();
			if(receitaDao.verificarCadastroReceitaBaseDadosDao(receitaVo)) {
				resultado = receitaDao.atualizarReceitaDao(receitaVo);
			}else {
				System.out.println("Receita não existe");
			}
			return resultado;
		}
		
		public boolean excluirReceitaBO(ReceitaVO receitaVo) {
			boolean resultado = false;
			ReceitaDAO receitaDao = new ReceitaDAO();
			if(receitaDao.verificarCadastroReceitaBaseDadosDao(receitaVo)) {
				resultado = receitaDao.excluirReceitaDao(receitaVo);
			}else {
				System.out.println("Receita não existe na base de dados");
			}
			return resultado;

		}

}
