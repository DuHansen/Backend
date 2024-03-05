package controller;
import java.util.List;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.bo.DespesaBO;
import model.vo.DespesaVO;

@Path("/despesa")
public class DespesaRest {
	
	@POST
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DespesaVO cadastrarReceitaController(DespesaVO despesa) {
		DespesaBO receitaBO = new DespesaBO();
		return receitaBO.cadastrarDespesaBo(despesa);
	}
	
	
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DespesaVO> consultarTodasReceitasController() {
		DespesaBO despesaBO = new DespesaBO();
		return despesaBO.consultarTodasDespesasBo();
	}
	
	
	@GET
	@Path("/pesquisar/{idReceita}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DespesaVO consultarReceitaController(@PathParam("idDespesa") int idDespesa) {
		DespesaBO despesaBO = new DespesaBO();
		return despesaBO.consultarDespesaBo(idDespesa);
	}
	
	@PUT
	@Path("/atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean atualizarReceitaController(DespesaVO despesaVO) {
		DespesaBO despesaBO = new DespesaBO();
		return despesaBO.atualizarDespesaBo(despesaVO);
	}
	
	@DELETE
	@Path("/excluir")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean excluirReceitaController(DespesaVO despesaVO) {
		DespesaBO receitaBO = new DespesaBO();
		return receitaBO.excluirDespesaBo(despesaVO);
	}
	
}
