package ec.edu.ups.eva62orellana.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Computador {
	
	@Id
	@GeneratedValue
	@Column(name="id_Computador")
	private int idComputador;
	
	@Column(nullable = false)
    private String marca;
	
	@Column(nullable = false)
    private String anio;
	
	@Column(nullable = false)
    private String gama;
	
    public Computador(){
        
    }

	public int getIdComputador() {
		return idComputador;
	}


	public void setIdComputador(int idComputador) {
		this.idComputador = idComputador;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getAnio() {
		return anio;
	}


	public void setAnio(String anio) {
		this.anio = anio;
	}


	public String getGama() {
		return gama;
	}


	public void setGama(String gama) {
		this.gama = gama;
	}

	@Override
	public String toString() {
		return "Computador [idComputador=" + idComputador + ", marca=" + marca + ", anio=" + anio + ", gama=" + gama
				+ "]";
	}
    
}
