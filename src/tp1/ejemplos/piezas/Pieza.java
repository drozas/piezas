package tp1.ejemplos.piezas;

/**
 * 
 * Implementa un objeto de tipo Pieza (Ejemplo para TP1 - UCM)
 * 
 * @author drozas (basado en slides de Simon Pickin)
 *
 */
public class Pieza {

	// Atributos de mi Pieza
	private String nombre;
	private double coste;

	/**
	 * Construye una pieza
	 * 
	 * @param n nombre de la pieza
	 * @param c coste de la pieza
	 */
	public Pieza(String n, double c) {
		this.nombre = n;
		this.coste = c;
	}

	/**
	 * Devuelve el nombre de la pieza
	 * 
	 * @return nombre de la pieza
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Asigna un valor al nombre de la pieza
	 * 
	 * @param nombre nombre de la pieza
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Devuelve el coste de la pieza
	 * 
	 * @return coste de la pieza
	 */
	public double getCoste() {
		return coste;
	}

	/**
	 * Asigna un coste a la pieza
	 * 
	 * @param coste coste de la pieza
	 */
	public void setCoste(double coste) {
		this.coste = coste;
	}

	/**
	 * Devuelve una representación en formato cadena de la pieza
	 */
	public String toString() {
		return "La pieza es " + this.nombre + " y su coste es " + this.coste;
	}

	/**
	 * Punto de entrada alternativo para testeo de objetos de tipo pieza
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Pieza p1 = new Pieza("Correa", 10);
		Pieza p2 = new Pieza("Radiador", 20);

		System.out.println(p1);
		System.out.println(p2);
	}

}
