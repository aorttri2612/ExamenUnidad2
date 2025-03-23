package hospital;

public class Medico extends Persona implements Sanitary {
	private double precioConsulta = 0;
	private Especialidad especialidad;
	private static int number;

	public Medico(String nombre, Especialidad especialidad) {
		super(nombre);
		this.especialidad = especialidad;
		numberObject = ++number;
	}

	public void setPrecioConsulta(double precio) {
		this.precioConsulta = precio;
	}

	public double getPrecioConsulta() {
		return especialidad.applyDiscount(precioConsulta);
	}

	@Override
	public String numberType() {
		return String.format("Soy el médico número %d", numberObject);
	}

	@Override
	public String toString() {
		return String.format("Médico %s, Precio consulta: %.2f, Especialidad: %s", super.toString(),
				getPrecioConsulta(), especialidad);
	}
}