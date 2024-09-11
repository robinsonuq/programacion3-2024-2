package backtracking;
import java.util.ArrayList;
import java.util.List;

public class LaberintoTodasLasSoluciones {

    public char[][] laberinto = {
        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
        {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', ' ', '#', ' ', '#', '#', ' ', '#', '#', '#'},
        {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
        {'#', '#', '#', ' ', ' ', ' ', '#', '#', '#', '#'},
        {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
        {'#', '#', '#', '#', '#', ' ', '#', '#', '#', '#'},
        {'#', ' ', ' ', ' ', '#', ' ', '#', ' ', '#', '#'},
        {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
        {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}, 
    };

    private List<char[][]> soluciones = new ArrayList<>();

    public static void main(String[] args) {
        LaberintoTodasLasSoluciones m = new LaberintoTodasLasSoluciones();
        m.laberinto[1][1] = 'X';
        m.resuelve(8, 1);
        m.imprimirSoluciones();
    }

    public void resuelve(int x, int y) {
        paso(x, y);
    }

    private boolean paso(int x, int y) {
        if (laberinto[x][y] == 'X') { 
            guardarSolucion();        
            return false;
        }

        if (laberinto[x][y] == '#' || laberinto[x][y] == '*' || laberinto[x][y] == 'f') {
            return false;
        }

        laberinto[x][y] = '*';

        
        paso(x, y + 1); 
        paso(x - 1, y); 
        paso(x, y - 1); 
        paso(x + 1, y); 

        laberinto[x][y] = ' ';
        return false;
    }

    private void guardarSolucion() {
        char[][] copia = new char[laberinto.length][laberinto[0].length];
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[i].length; j++) {
                copia[i][j] = laberinto[i][j];
            }
        }
        soluciones.add(copia);
    }

    public void imprimirSoluciones() {
        if (soluciones.isEmpty()) {
            System.out.println("No se encontraron soluciones.");
        } else {
            int contador = 1;
            for (char[][] solucion : soluciones) {
                System.out.println("Solución " + contador + ":");
                imprimirLaberinto(solucion);
                contador++;
            }
        }
    }

    private void imprimirLaberinto(char[][] laberinto) {
        for (int x = 0; x < laberinto.length; x++) {
            for (int y = 0; y < laberinto[x].length; y++) {
                System.out.print(laberinto[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
