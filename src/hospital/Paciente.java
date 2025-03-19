package hospital;

import java.util.Arrays;

public class Paciente extends Persona {

	private final int numberDiagnostic = 1;
	private double[] diagnostico = new double[numberDiagnostic];
	private String[] diagnosticos = new String[3];
	private static int diagnosticoCount;

	public Paciente(String name) {
		super(name);
		Arrays.fill(diagnostico, -1);
		numberObject = ++diagnosticoCount;
	}

	public boolean isValidate() {
		return isValidate;
	}

	public String numberType() {
		return "Soy el Paciente número " + numberObject;
	}

	@Override
	public boolean validate() {
		return isValidate = true;
	}

	public void addDiagnostico(String diagnostico) {
		if (diagnosticoCount >= 3) {
			throw new IllegalArgumentException("No se pueden añadir más de tres diagnósticos.");
		}
		diagnosticos[diagnosticoCount++] = diagnostico;
	}

	@Override
	public String toString() {
		if (diagnostico[0] == -1) {
			return String.format("Paciente %s, %s validado", name, isValidate() ? "Sí" : "No");
		} else if (diagnostico[1] == -1) {
			return String.format("Paciente %s, %s validado\n \tdiagnostico1:\n", name, isValidate() ? "Sí" : "No",
					diagnostico[0]);
		} else if (diagnostico[2] == -1) {
			return String.format("Alumno %s, %s validado\n \tdiagnostico1:\n \tdiagnostico2:\n", name,
					isValidate() ? "Sí" : "No", diagnostico[0], diagnostico[1]);
		} else {
			return String.format("Paciente %s, %s validado\n \tdiagnostico1:\n \tdiagnostico2:\n \tdiagnostico3:\n",
					name, isValidate() ? "Sí" : "No", diagnostico[0], diagnostico[1], diagnostico[2]);
		}

	}

}
