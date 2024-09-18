package backtracking.ejemplos;


//https://www.youtube.com/watch?v=NdDxwA_tlpI
/**Se necesita simular una ruleta por medio de matrices. En este caso se recibe una matriz
la cual se va a girar hasta encontrar su forma final despu�s de lograr una cantidad de giros N.
Donde N ser� igual a la cantidad de giros de 90 grados que debe hacer la matriz. Si el valor de N es positivo,
indica que los giros deben hacerse en sentido de las manecillas del reloj. Si el valor es negativo,
el giro deber� hacerse en sentido contrario a las manecillas del reloj.**/

public class Ruleta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        String[][] matriz = {
                {"N", "J"},
                {"I", "Z"},
                {"U", "E"}
            };

//        String[][] matriz = {
//                {"1", "2", "3"},
//                {"4", "5", "6"}
//               };

        String [][] newMatrix     = null;

        int sizeFilas = matriz.length;
		int sizeColumnas = matriz[0].length;
		int giros = -2;

		newMatrix = girarRuleta(matriz, giros, sizeFilas, sizeColumnas);

		System.out.println(imprimirMatriz(newMatrix,0,0));
	}



	public static String[][] girarRuleta(String[][] matriz, int giros, int sizeFilas, int sizeColumnas) {

		String[][] nuevaMatriz = new String[sizeColumnas][sizeFilas];

		if(giros == 0)
			return matriz;
		else
		{

			nuevaMatriz = rotarMatriz(matriz,nuevaMatriz, giros, sizeFilas, sizeColumnas,0,0);

			if(giros > 0)
				giros--;// = giros-1;
			else
				giros++;// = giros+1;

		    return  girarRuleta(nuevaMatriz, giros, nuevaMatriz.length, nuevaMatriz[0].length);
		}
	}



	private static String[][] rotarMatriz(String[][] matriz, String[][] nuevaMatriz, int giros, int sizeFilas, int sizeColumnas, int i, int j) {


        if (i != matriz.length   )
        {

        	if(j != matriz[i].length)
        	{
                //Indico si llego al final de la fila
                if (j == matriz[i].length) {
                    i++; //Paso a la siguiente fila
                    j = 0; //Reinicio la j
                } else {

    				if(giros > 0)
    					nuevaMatriz[j][sizeFilas -1 -i] = matriz [i][j]; //giro der- en sentido de las manecillas del reloj.
    				else
    					nuevaMatriz[sizeColumnas-j-1][i] = matriz [i][j];   //giro izq - en sentido contrario a las manecillas del reloj.

                	j++;
                }

                //Volvemos a llamar la funci�n recursivamente
                return rotarMatriz(matriz, nuevaMatriz, giros, sizeFilas, sizeColumnas, i, j);
        	}
        	else
        	{
        		i++;
        		j=0;
        		return rotarMatriz(matriz, nuevaMatriz, giros, sizeFilas, sizeColumnas, i, j);
        	}

        }
        else
        {
        	return nuevaMatriz;
        }

	}


	private static String imprimirMatriz(String[][] matriz, int i, int j) { // imprimiremos nuestra soluci�n. Debido a que la clase Arrays no tiene implementado


		String salida = "";

		if( i < matriz.length )
		{
			if(j < matriz[i].length)
			{
				salida += matriz[i][j] + " ";
				return salida + imprimirMatriz(matriz,i, j+1);
			}
			else
			{
				salida += "\n";
				j = 0;
				return salida + imprimirMatriz(matriz,i+1, j);
			}
		}
		else
		{
			return salida;
		}
	}

}
