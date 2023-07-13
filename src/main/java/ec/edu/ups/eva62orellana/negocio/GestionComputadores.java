package ec.edu.ups.eva62orellana.negocio;

import ec.edu.ups.eva62orellana.datos.ComputadorDAO;
import ec.edu.ups.eva62orellana.modelo.Computador;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionComputadores {
	
	@Inject
	private ComputadorDAO daoComputador;
	
	public void guardarComputadores(Computador computador) throws Exception {
		if(!this.isCodigoValido(computador.getIdComputador()))
			throw new Exception("Codigo Incorrecto");
		
		if(daoComputador.read(computador.getIdComputador()) == null) {
			try {
				daoComputador.insert(computador);
			}catch(Exception e){
				throw new Exception("Error al insertar: "+ e.getMessage());
			}
		}else {
			try {
				daoComputador.update(computador);
			}catch (Exception e) {
				throw new Exception("Error al actualizar: "+ e.getMessage());
			}
		}
	}
	
	private boolean isCodigoValido(int idComputador) {
		return idComputador == 0 || idComputador != 0;
	}
}
