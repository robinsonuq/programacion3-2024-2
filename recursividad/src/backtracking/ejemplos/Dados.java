package backtracking.ejemplos;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que contiene la l�gica para resolver el problema de los dados usando backtracking.
 * El problema consiste en encontrar las posibles combinaciones de un n�mero n de dados
 * para que al sumarlos su resultado sea un n�mero b 
 *
 */
public class Dados {

	public static void main(String[] args) {
		Dados d = new Dados();
		d.sumarDados(2, 5);
	}

	/**
	 * M�todo principal
	 * @param dados N�mero de dados
	 * @param cantidad Valor que deben sumar los dados
	 */
	public void sumarDados(int dados, int cantidad) {
		List<List<Integer>> seleccionados = new ArrayList<List<Integer>>();
		sumarDados(dados, cantidad, new ArrayList<Integer>(), seleccionados, 0);
		System.out.println(seleccionados);
	}

	/**
	 * Resuelve el problema de los dados
	 * @param dados N�mero de dados
	 * @param cantidad Valor que deben sumar los dados
	 * @param seleccionados Lista de valores seleccionados
	 * @param acumulado Suma de los valores
	 */
	private void sumarDados(int dados, int cantidad, List<Integer> seleccionados, List<List<Integer>> lista, int acumulado) {
		if (dados == 0) {
			if (acumulado == cantidad) {
				lista.add(new ArrayList<>(seleccionados));
			}
		} else if (acumulado <= cantidad) {
			for (int i = 1; i <= 6; i++) {
				seleccionados.add(i);
				sumarDados(dados - 1, cantidad, seleccionados, lista, acumulado + i);
				seleccionados.remove(seleccionados.size() - 1);
			}
		}
	}
	
}