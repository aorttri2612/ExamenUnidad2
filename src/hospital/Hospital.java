package hospital;

public class Hospital {

	public static void main(String[] args) {
		new Hospital().show();
	}

	public void show() {
		Persona[] personas = createPersons();
		showOrder(personas);
		showObjects(personas);
		processData(personas);
		showObjects(personas);
		calculatePrice(personas);
	}

	public Persona[] createPersons() {
		return new Persona[] { new Paciente("Carlos Pérez"), new Paciente("Laura Gómez"), new Paciente("David Martín"),
				new Paciente("Pepe Perez"), new Paciente("Rosa Mancebo"),
				new Medico("Juan Sánchez", Especialidad.CARDIOLOGIA), new Medico("Ana Mijas", Especialidad.PEDIATRIA),
				new Medico("Javier Cuevas", Especialidad.NEUROLOGIA) };
	}

	public void showObjects(Persona[] personas) {
		for (Persona persona : personas) {
			System.out.println(persona);
		}
	}

	public void showOrder(Persona[] personas) {
		for (Persona persona : personas) {
			System.out.println(persona.numberType());
		}
	}

	public void processData(Validable[] personas) {
		for (int i = 0; i < personas.length; i++) {
			personas[i].validate();
			if (personas[i] instanceof Diagnosticable) {
				insertDiagnostic((Diagnosticable) personas[i], i);
			}
			if (personas[i] instanceof Sanitary) {
				setVisitPrice((Sanitary) personas[i], i);
			}
		}
	}

	private void insertDiagnostic(Diagnosticable diagnosticable, int numDiag) {
		final String DIAGNOSTIC_INICIAL = "Diagnóstico inicial";
		final String DIAGNOSTIC = " - Seguimiento";
		String diagnostic = DIAGNOSTIC_INICIAL;
		try {
			for (int i = 1; i <= numDiag; i++) {
				diagnosticable.insertDiagnostic(diagnostic);
				diagnostic += DIAGNOSTIC;
			}
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}

	private void setVisitPrice(Sanitary sanitary, int index) {
		final double QUANTITY = 10;
		sanitary.setPrecioConsulta(QUANTITY * index);
	}

	private void calculatePrice(Persona[] personas) {
		Medico medico;
		for (int i = 0; i < personas.length; i++) {
			if (personas[i] instanceof Medico) {
				medico = (Medico) personas[i];
				System.out.printf("Precio final de la consulta de %s: %.1f €\n", medico.getName(),
						medico.getPrecioConsulta());
			}
		}
	}
}
