package hospital;

public class Hospital {
	public static Persona[] createObjects() {
		Persona[] personas = new Persona[8];
		personas[0] = new Paciente("Carlos Pérez");
		personas[1] = new Paciente("Laura Gómez");
		personas[2] = new Paciente("David Martin");
		personas[3] = new Paciente("Sofía Ramírez");
		personas[4] = new Paciente("Antonio Fernández");
		personas[5] = new Medico("Juan Sánchez", Especialidad.CARDIOLOGIA);
		personas[6] = new Medico("Ana Mijas", Especialidad.PEDIATRIA);
		personas[7] = new Medico("Javier Cuevas", Especialidad.NEUROLOGIA);
		return personas;
	}

	public void showOrder(Persona[] personas) {
		for (int i = 0; i < personas.length; i++) {
			if (personas[i] instanceof Paciente) {
				Paciente paciente = (Paciente) personas[i];
				System.out.println(paciente.numberType());
			}
			if (personas[i] instanceof Medico) {
				Medico medico = (Medico) personas[i];
				System.out.println(medico.numberType());
			}
		}
	}

	public void showObjects(Persona[] personas) {
		for (int i = 0; i < personas.length; i++) {
			System.out.println(personas[i]);
		}
	}

	public void processData(Validate[] personas) {
		for (int i = 0; i < personas.length; i++) {
			personas[i].validate();
			if (personas[i] instanceof Paciente) {
				Paciente paciente = (Paciente) personas[i];
				try {
					if (i == 3) {
						paciente.addDiagnostico("Diagnóstico inicial");
					} else {
						paciente.addDiagnostico("- seguimiento");
					}
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				}
			} else if (personas[i] instanceof Medico) {
				Medico medico = (Medico) personas[i];
				medico.setPrecioConsulta(10 * (i + 1));
			}
		}
	}

	public void calculatePrice(Persona[] personas) {
		for (Persona persona : personas) {
			if (persona instanceof Medico) {
				Medico medico = (Medico) persona;
				System.out.printf("Precio consulta de %s: %.2f%n", medico.name, medico.getPrecioConsulta());
			}
		}

	}

	public void show() {
		Persona[] personas = hospital.Hospital.createObjects();
		Validate[] personas2 = (Validate[]) personas;
		new hospital.Hospital().showOrder(personas);
		new hospital.Hospital().showObjects(personas);
		new hospital.Hospital().processData(personas2);
		new hospital.Hospital().showObjects(personas);
		new hospital.Hospital().calculatePrice(personas);
	}

	public static void main(String[] args) {
		new hospital.Hospital().show();
	}
}