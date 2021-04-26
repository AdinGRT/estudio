package sooper.productos;

import java.time.LocalDate;

import sooper.Caducable;

public class Congelado extends Alimentacion implements Caducable {

	private LocalDate caducidad;

	public Congelado(String referencia, int peso, int volumen, LocalDate caducidad) {
		super(referencia, peso, volumen);
	}

	@Override
	public boolean estaCaducado() {
		return caducidad.isBefore(LocalDate.now());
	}

}
