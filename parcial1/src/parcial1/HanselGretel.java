package parcial1;


public class HanselGretel {

	// Funci�n principal para encontrar todas las rutas
	public static void main(String[] args) {
		String[][] bosque = {
				{"1", "1", "1", "1", "1", "0", "1", "1"},
				{"1", "0", "0", "1", "0", "0", "1", "0"},
				{"1", "1", "0", "1", "1", "1", "1", "1"},
				{"0", "0", "1", "1", "1", "0", "0", "1"},
				{"0", "1", "0", "0", "1", "0", "0", "1"},
				{"1", "1", "1", "1", "1", "1", "1", "1"},
				{"0", "1", "0", "1", "0", "0", "1", "1"}
		};
		int finX = 6;
		int finY = 7;

		// Empezamos desde la posici�n (0, 0)
		encontrarRutas(bosque, 0, 0, finX,finY);

	}

	// Funci�n recursiva para encontrar todas las rutas
	public static void encontrarRutas(String[][] bosque ,  int x, int y, int finx, int finY) {
		// Si llegamos a la posici�n (N-1, N-1), imprimimos la ruta
		if (x == finx && y == finY) {
			imprimirRuta(bosque);
			return;
		}
		//invalidos
		if(x < 0 || x == bosque.length-1 || y < 0 || y == bosque[0].length) {
			return;
		}
		if (bosque[x][y] == "0"||bosque[x][y] == "H") { // si llegamos a una pared o al mismo punto,
			return; // entonces el laberinto no puede resolverse y termina.
		}
		bosque[x][y] = "H";
		encontrarRutas(bosque,  x  + 1, y + 1, finx, finY);//diagonal
		encontrarRutas(bosque,  x + 1, y, finx, finY);//abajo
		encontrarRutas(bosque,  x, y - 1, finx, finY);//izquierda
		encontrarRutas(bosque,  x - 1, y, finx, finY);//arriba
		encontrarRutas(bosque,  x, y + 1, finx, finY);//derecha
		bosque[x][y] = "1"; // Backtrack: desmarcamos el camino para encontrar otras rutas
	}

	// Funci�n para verificar si podemos movernos a la celda P[x][y]
	public static boolean esSeguro(String[][] bosque, int x, int y) {
		return x >= 0 && x < bosque.length && y >= 0 && y < bosque.length && bosque[x][y] == "C";
	}

	// Funci�n para imprimir la matriz con la ruta encontrada
	public static void imprimirRuta(String[][] ruta ){
		System.out.println("Ruta encontrada:");
		for (int i = 0; i < ruta.length; i++) {
			for (int j = 0; j < ruta[0].length; j++) {
				System.out.print(ruta[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}



































}