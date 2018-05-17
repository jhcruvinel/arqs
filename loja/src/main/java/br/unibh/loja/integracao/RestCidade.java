package br.unibh.loja.integracao;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unibh.loja.entidades.Cidade;
import br.unibh.loja.negocio.ServicoCidade;
import io.swagger.annotations.Api;

@Api
@Path("cidade")
public class RestCidade {

	@Inject
	private ServicoCidade sc;

	@GET
	@Path("list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cidade> helloworld() throws Exception {
		return sc.findAll();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cidade hello(@PathParam("id") final Long id) throws Exception {
		return sc.find(id);
	}

}
