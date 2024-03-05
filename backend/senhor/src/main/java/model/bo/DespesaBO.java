package model.bo;

import java.util.ArrayList;

import model.dao.DespesaDAO;
import model.vo.DespesaVO;

public class DespesaBO {

	//Create
			public DespesaVO cadastrarDespesaBo (DespesaVO despesaVo) {
				DespesaDAO despesaDao = new DespesaDAO();
				if(despesaDao.verificarCadastroDespesaBaseDadosDao(despesaVo)) {
					System.out.println("Despesa ja cadastrado!");
				}else {
					despesaVo = despesaDao.cadastrarDespesaDao(despesaVo);
				}
				return despesaVo;
			}
			
			//Read all
			public ArrayList<DespesaVO> consultarTodasDespesaBo () {
				DespesaDAO despesaDao = new DespesaDAO();
				ArrayList<DespesaVO> listaDespesasVo = despesaDao.consultarTodasDespesasDao();
				if(listaDespesasVo.isEmpty()) {
					System.out.println("Lista de Despesa está vazia!");
				}
				return listaDespesasVo;
			}
			
			//Read one
			public DespesaVO consultarDespesaBo (DespesaVO despesaVo) {
				DespesaDAO despesaDao = new DespesaDAO();
				DespesaVO despesa = despesaDao.consultarDespesaDao(despesaVo);
				if(despesa == null) {
					System.out.println("\nDespesa não localizada!");
				}
				return despesa;
			}
			
			//Update
			public boolean atualizarDespesaBo (DespesaVO despesaVo) {
				boolean resultado = false;
				DespesaDAO despesaDao = new DespesaDAO();
				if(despesaDao.verificarCadastroDespesaBaseDadosDao(despesaVo)) {
					resultado = despesaDao.atualizarDespesaDao(despesaVo);
				}else {
					System.out.println("Despesa não existe");
				}
				return resultado;
			}
			
			//Delete
			public boolean excluirDespesaBo(DespesaVO despesaVo) {
				boolean resultado = false;
				DespesaDAO despesaDao = new DespesaDAO();
				if(despesaDao.verificarCadastroDespesaBaseDadosDao(despesaVo)) {
					resultado = despesaDao.excluirDespesaDao(despesaVo);
				}else {
					System.out.println("Despesa não existe na base de dados");
				}
				return resultado;

			}

}
