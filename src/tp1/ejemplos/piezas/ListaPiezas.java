package tp1.ejemplos.piezas;

/**
 * 
 * Implementa una lista de objetos de tipo Pieza con array estático y contador (Ejemplo para TP1 - UCM)
 * 
 * @author drozas (basado en slides de Simon Pickin)
 *
 */
public class ListaPiezas {
    
	// Número máximo de Piezas
	private final static int MAX = 100;
	// Array de Piezas
    private Pieza[] piezas;
    // Contador de piezas en array (coincidirá con la primera posición libre del array)
    private int contador = 0;
    
    /**
     * Crea un objeto de tipo lista de Piezas con un array de tamaño MAX
     */
    public ListaPiezas() {
        this.piezas = new Pieza[MAX];
    }

    /**
     * Comprueba si la lista está llena
     * @return true si ya está llena, false en caso contrario
     */
    public boolean llena() {
    	return this.contador == MAX;
    }
    
    /**
     * Comprueba si la lista está vacía
     * @return true si está vacía, false en caso contario
     */
    public boolean vacia() {
    	return this.contador == 0;
	}
    
    /**
     * Devuelve la longitud de la lista en el momento actual
     * @return número de elementos de la lista
     */
    public int length() { 
    	return this.contador;
    }

    /**
     * Comprueba si una lista está llena y, en caso contrario, inserta una nueva pieza
     * @param p	Nueva pieza	
     * @return	true si se hizo la inserción correctamente, false en caso contrario
     */
    public boolean insertar(Pieza p) {
    	if (this.llena()){
    		return false;
    	}else{
              this.piezas[this.contador] = p;
              this.contador++;
              return true;
    	}
    }

    /**
     * Borra un elemento de la lista
     * @param pos posición del elemento a borrar
     * @return true si se borró, false en caso contraio
     */
    public boolean borrar(int pos){
    	// Compruebo que la posición recibida esté dentro de los límites
    	if((pos < 0) || (pos > (this.contador - 1))){
        	return false;
        }else{            
        	// Si es así, reasigno el resto de elementos desde la posición dada
			for(int i=pos; i < (this.contador - 1); i++) {
                this.piezas[i] = this.piezas[i+1];
			}
			// Y decremento el contador
            this.contador--;
            return true;
        }
    }

    /**
     * Devuelve una pieza
     * @param pos posición en el array de la pieza a devolver
     * @return null si no la encuentra, o un objeto de tipo Pieza si la encuentra
     */
    public Pieza get(int pos) {
        if((pos < 0) || (pos > (this.contador - 1))){
        	return null;
        }else{
        	return this.piezas[pos];
        }
        
    }

    /**
     * Representación en formato de cadena de una lista de piezas
     */
    public String toString() {
        // %n en format: salto de línea independiente de plataforma
        String cad = String.format("Elementos de la lista:%n%n");
        for(int i = 0; i < this.contador; i++) {
            // Se realizara una llamada implícita a toString() de Pieza
            cad += String.format("%s ocupa la posición %d %n", this.piezas[i], i);
        }
        return cad;
    }

	public static void main(String[] args) {
		//Creo tres piezas, mi lista, las añado y las imprimo
		Pieza p1 = new Pieza("Broca dim 6mm", 21);
	    Pieza p2 = new Pieza("Bateria", 165);
	    Pieza p3 = new Pieza("Correa ventilador", 63.98);
	    ListaPiezas miLista = new ListaPiezas();
	    miLista.insertar(p1);
	    miLista.insertar(p2);
	    
	    //Puedo probar haciendo la lista más pequeña para ver si llena funciona
	    if (miLista.insertar(p3) == false) {
	    	System.out.println("En esta prueba puse MAX a 2 y no se pudo insertar la tercera pieza");
	    }
	    
	    System.out.println(miLista);
	    
	    //Recupero la pieza 0, le cambio el precio y la muestro
	    Pieza p = miLista.get(0);
	    p.setCoste(4.1);
	    System.out.println("Pieza 0 ahora vale " + p.getCoste());
	    
	    //Intento borrar la pieza en la posición 3 (devolverá false)
	    if (miLista.borrar(3)) {
	    	System.out.println("Borré la pieza en 3");
	    }else {
	    	System.out.println("No existía pieza en la posición 3 que intenté borrar");
	    }
	    
	    //Intento borrar la pieza en la posición 1 (devolverá true)
	    if (miLista.borrar(0)) {
	    	System.out.println("Borré la pieza en 0");
	    }
	    
	    //Muestro de nuevo mi lista
	    System.out.println(miLista);
	    
	    //Añado una nueva pieza
	    Pieza nuevaPieza = new Pieza("Bombilla 10W", 9.80);
	    miLista.insertar(nuevaPieza);
	    
	    //Muestro de nuevo mi lista
	    System.out.println(miLista); 	    
	}
}