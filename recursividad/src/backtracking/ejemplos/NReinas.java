package backtracking.ejemplos;

public class NReinas {

	int [][]tablero = new int [4][4]; 
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		NReinas nReinas = new NReinas();
		nReinas.resolver();
	}

	public NReinas(){
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j] = 0;
			}
		}
	}

	public void imprimir(){
		System.out.println();
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				System.out.print(tablero[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}


	public void vueltaAtras(int etapa){
		for (int i = 0; i < tablero.length; i++) {
			if(aceptable(i, etapa))
			{
				tablero[i][etapa]=1;
				if(etapa == tablero.length-1){
					imprimir();
				}else{
					vueltaAtras(etapa+1);
				}
				tablero[i][etapa]=0;
			}
		}

	}

	public boolean aceptable(int i,int etapa){

		//filas
		for (int j = 0; j <= i; j++) {
			if(tablero[j][etapa] ==1){
				return false;
			}
		}

		//columna
//		for (int j = 0; j <= etapa; j++) {
		for (int j = 0; j < tablero.length; j++) {

			if(tablero[i][j] ==1){
				return false;
			}
		}

		//diagonal izquierdo
		int h = i;
		for (int j = etapa; j >=0 && h>=0; j--) {

			if(tablero[h][j] ==1){
				return false;
			}
			h--;
		}

		//diagonal derecha
		h = i;
		for (int j = etapa; j >=0 && h<tablero.length; j--) {

			if(tablero[h][j] ==1){
				return false;
			}
			h++;
		}

		return true;
	}
	
	
	public void  resolver(){
		imprimir();
		vueltaAtras(0);
	}
	
	


}
