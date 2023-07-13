package ec.edu.ups.eva62orellana.negocio;

import java.util.Date;
import java.util.List;

import ec.edu.ups.eva62orellana.datos.ComputadorDAO;
import ec.edu.ups.eva62orellana.modelo.Computador;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class DatosEva62 {
	
	@Inject
	private ComputadorDAO daoComputador;
	
	@PostConstruct
	public void init() {
		
		Computador c = new Computador();
		
		c.setAnio("2019");
		c.setMarca("Mac");
		c.setGama("Media");
		
		daoComputador.insert(c);
		
		List<Computador> lista;
		
		lista = daoComputador.getAll();
		
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
	}
}
