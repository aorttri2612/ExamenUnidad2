package hospital;

public enum Especialidad {
	CARDIOLOGIA(0.10), PEDIATRIA(0.20), NEUROLOGIA(0.30);

	private final double descuento;

	Especialidad(double descuento) {
		this.descuento = descuento;
	}

	public double getDescuento() {
		return descuento;
	}

	public double applyDiscount(double precio) {
		return precio * (1 - descuento);
	}
}
