package hospital;

public class Medico extends Persona {
	private double precioConsulta = 0;
	private Especialidad especialidad;
	private static int number;

	public Medico(String nombre, Especialidad especialidad) {
		super(nombre);
		this.especialidad = especialidad;
		numberObject = ++number;
	}

	public boolean isValidate() {
		return isValidate;
	}

	public String numberType() {
		return "Soy el Medico número " + numberObject;
	}

	public void setPrecioConsulta(double precio) {
		this.precioConsulta = precio;
	}

	public double getPrecioConsulta() {
		return especialidad.applyDiscount(precioConsulta);
	}

	@Override
	public String toString() {
		String estadoValidado = isValidate() ? "validado" : "no validado";
		return String.format("Medico %s, %s, precio consulta: %.2f, especialidad: %s, %d%%", name, estadoValidado,
				getPrecioConsulta(), especialidad, (int) (especialidad.getDescuento() * 100));
	}
}