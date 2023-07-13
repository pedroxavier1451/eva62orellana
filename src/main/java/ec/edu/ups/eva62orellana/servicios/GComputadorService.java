package ec.edu.ups.eva62orellana.servicios;

import java.util.List;

import ec.edu.ups.eva62orellana.datos.ComputadorDAO;
import ec.edu.ups.eva62orellana.modelo.Computador;
import ec.edu.ups.eva62orellana.negocio.GestionComputadores;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("computadores")
public class GComputadorService {
	
	@Inject
	private GestionComputadores gestionComputadores;
	
	@Inject
	private ComputadorDAO comdao;
	
	@Inject
	private ComputadorDAO cd;
	
	//el GET nos ayuda a solamente realizar consultas hacia la base de datos
	
	@GET
	@Path("computadoreslista")
	@Produces("application/json")
	public String datos2() {
	    List<Computador> computadores = cd.getAll();
	    StringBuilder sb = new StringBuilder();

	    for (Computador computador : computadores) {
	        sb.append("--------------------------------------------------------").append("\n").
	        	 append("ID: ").append(computador.getIdComputador()).append("\n")
	            .append("Año: ").append(computador.getAnio()).append("\n")
	            .append("Marca: ").append(computador.getMarca()).append("\n")
	            .append("Gama: ").append(computador.getGama()).append("\n")
	            .append("\n");
	    }

	    String result = sb.toString();
	    System.out.print(result);
	    return result;
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public Response guardarComputador(Computador computador) {
		try {
			gestionComputadores.guardarComputadores(computador);
			return Response.status(Response.Status.OK).entity(computador).build();
		}catch(Exception e){
			e.printStackTrace();
			Error error = new Error();
			error.setCodigo(99);
			error.setMensaje("Error al guardar: " + e.getMessage());
			return Response.status(Response.Status.OK).entity(error).build();
		}
	}
}
