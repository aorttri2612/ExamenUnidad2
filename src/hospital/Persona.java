package hospital;

public class Persona implements Validate {

	protected String name;
	protected int numberObject;
	protected boolean isValidate = false;

	public Persona(String name) {
		this.name = name;
	}

	@Override
	public boolean validate() {
		return false;
	}

}
