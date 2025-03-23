package hospital;

public abstract class Persona implements Validable {
	protected String name;
	protected int numberObject;
	protected boolean isValidate;

	public Persona(String name) {
		this.name = name;
	}

	public abstract String numberType();

	protected String getName() {
		return name;
	}

	public boolean isValidate() {
		return isValidate;
	}

	@Override
	public void validate() {
		isValidate = true;
	}

	@Override
	public String toString() {
		return String.format("%s , %s", name, isValidate ? "Validado" : "No validado");
	}
}