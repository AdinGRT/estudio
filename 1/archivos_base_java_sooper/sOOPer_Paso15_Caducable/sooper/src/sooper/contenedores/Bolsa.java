package sooper.contenedores;

import java.time.LocalDate;

import sooper.Caducable;
import sooper.enums.TipoContenedor;

public class Bolsa extends Contenedor implements Caducable {
	
	private static final int ANYOS_CADUCIDAD = 5;

	private int ancho;
	private LocalDate fechaFabricacion;

	public Bolsa(String referencia, int alto, int ancho, int resistencia, LocalDate fechaFabricacion) {
		super(referencia, alto, resistencia);
		this.ancho = ancho;
		this.fechaFabricacion = fechaFabricacion;
	}

	@Override
	public TipoContenedor getTipo() {
		return TipoContenedor.BOLSA;
	}

	@Override
	public int getSuperficie() {
		int radio = getDiametro()/2;
		return (int)(Math.PI * radio * radio);
	}
	
	private int getDiametro() {
		return (int)((2 * ancho) / Math.PI);		
	}
	
	@Override
	public boolean estaCaducado() {
		return LocalDate.now().isBefore(fechaFabricacion.plusYears(ANYOS_CADUCIDAD));
	}

}
