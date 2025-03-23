package hospital;

import java.util.Arrays;

public class Paciente extends Persona implements Diagnosticable {
	private final int NUMDIAGNOSTICS = 3;
	private String[] diagnostics = new String[NUMDIAGNOSTICS];
	private static int number = 0;

	public Paciente(String name) {
		super(name);
		Arrays.fill(diagnostics, "");
		numberObject = ++number;
	}

	@Override
	public String numberType() {
		return String.format("Soy el paciente número %d", numberObject);
	}

	public void insertDiagnostic(String diagnostic) {
		boolean assigned = false;
		if (diagnostic.equals("")) {
			throw new IllegalArgumentException("Se debe insertar un diagnóstico válido");
		} else {
			for (int i = 0; i < diagnostics.length && !assigned; i++) {
				if (diagnostics[i].equals("")) {
					diagnostics[i] = diagnostic;
					assigned = true;
				}
			}
		}
		if (!assigned) {
			throw new IllegalArgumentException(
					"Se ha intentado introducir un diagnóstico a un paciente que ya tiene 3 diagnósticos");
		}
	}

	@Override
	public String toString() {
		StringBuilder chain = new StringBuilder(String.format("Paciente %s", super.toString()));
		for (int i = 0; i < diagnostics.length; i++) {
			if (!diagnostics[i].equals("")) {
				chain.append(String.format("\n    Diagnóstico %d: %s", i + 1, diagnostics[i]));
			}
		}
		return chain.toString();
	}
}