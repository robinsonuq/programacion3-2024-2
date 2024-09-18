package recursividad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Recursividad {

	
	public static void main(String[] args) {
		
		ArrayList<Integer> lista = new ArrayList<>();
		lista.add(2);
		lista.add(1);
		lista.add(5);
		lista.add(4);
		lista.add(3);
		
		Collections.sort(lista);
		
		System.out.println(Collections.binarySearch(lista,1));
		
	}

	
}
