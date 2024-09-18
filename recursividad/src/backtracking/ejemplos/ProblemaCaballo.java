package backtracking.ejemplos;

/**
 * El problema del caballo es un antiguo problema matem�tico en el que se pide que, 
 * teniendo una cuadr�cula de n x n casillas y un caballo de ajedrez colocado en una 
 * posici�n cualquiera ( x, y ), el caballo pase por todas las casillas y una sola vez. 
 *
 */
public class ProblemaCaballo {
	
    private int n;
    private int[][] tablero;

    /**
     * Constructor de la clase
     * @param n Tama�o del tablero
     */
    public ProblemaCaballo(int n) {
        this.n = n;
        this.tablero = new int[n][n];
    }

    /**
     * Imprime la soluci�n del problema
     */
    public void mostrarTablero() {
        for(int i=0; i<tablero.length; i++) {
            for(int j=0; j<tablero[i].length; j++) {
                System.out.print(tablero[i][j]+"\t");
            }            
            System.out.println();
        }
    }

    /**
     * Resuelve el problema del salto del caballo, se contabiliza cada movimiento
     * @param f Fila del tablero
     * @param c Columna del tablero
     * @param num N�mero inicial (1)
     * @return True si pudo resolver el problema
     */
    public boolean resolverProblema(int f, int c, int num) {
        tablero[f][c] = num;
        
        if(num==(n*n)){
        	return true;
        }
        
        int[][] posibles = buscarPosibles(f, c);
        
        for(int i=0; i<posibles.length; i++) {
            if(resolverProblema(posibles[i][0], posibles[i][1], num+1)){
            	return true;
            }
        }
        
        tablero[f][c]=0;
        return false;
    }

    /**
     * Determina un posible moviemiento en forma de "L"
     * @param f Fila del tablero
     * @param c Columna del tablero
     * @return Matriz con el movimiento
     */
    public int[][] buscarPosibles(int f, int c) {
        int[][] resp = new int[8][2];
        int pos  = 0;
        
        if(esValido(f-2,c-1)){ resp[pos][0]=f-2; resp[pos++][1]=c-1; }
        if(esValido(f-2,c+1)){ resp[pos][0]=f-2; resp[pos++][1]=c+1; }
        if(esValido(f-1,c-2)){ resp[pos][0]=f-1; resp[pos++][1]=c-2; }
        if(esValido(f-1,c+2)){ resp[pos][0]=f-1; resp[pos++][1]=c+2; }
        if(esValido(f+2,c-1)){ resp[pos][0]=f+2; resp[pos++][1]=c-1; }
        if(esValido(f+2,c+1)){ resp[pos][0]=f+2; resp[pos++][1]=c+1; }
        if(esValido(f+1,c-2)){ resp[pos][0]=f+1; resp[pos++][1]=c-2; }
        if(esValido(f+1,c+2)){ resp[pos][0]=f+1; resp[pos++][1]=c+2; }
        
        int[][] tmp = new int[pos][2];
        
        for(int i=0; i<pos; i++) { 
        	tmp[i][0] = resp[i][0]; 
        	tmp[i][1]=resp[i][1]; 
    	}
        
        return tmp;
    }

    /**
     * Verifica si el movimiento del caballo es v�lido (dentro del tablero)
     * @param f Fila tablero
     * @param c Columna tablero
     * @return True si el movimiento es v�lido
     */
    public boolean esValido(int f, int c) {
        if( (f<0 || f>n-1 || c<0 || c>n-1) || tablero[f][c]!=0 ){
        	return false;
        }        
        return true;
    }

    public static void main(String[] args) 
    {
        ProblemaCaballo pc = new ProblemaCaballo(5);
        pc.resolverProblema(0,0,1);
        pc.mostrarTablero();
    }
}