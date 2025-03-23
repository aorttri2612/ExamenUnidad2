package hospital;

public enum Especialidad {
	CARDIOLOGIA(10), PEDIATRIA(20), NEUROLOGIA(30);

	private final double descuento;

	Especialidad(double descuento) {
		this.descuento = descuento;
	}

	public double getDescuento() {
		return descuento;
	}

	public double applyDiscount(double precio) {
		return precio - (precio * (descuento / 100));
	}

	@Override
	public String toString() {
		return String.format("%s (Descuento: %.0f%%)", name(), descuento);
	}
}