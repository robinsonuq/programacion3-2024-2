
public class ViajanteBacktracking {
    private int numCiudades;
    private int[][] distancias;
    private String[] nombresCiudades;
    private boolean[] visitado;
    private int minDistancia = Integer.MAX_VALUE;
    private String mejorRuta = "";

    public ViajanteBacktracking(int[][] distancias, String[] nombresCiudades) {
        this.numCiudades = distancias.length;
        this.distancias = distancias;
        this.nombresCiudades = nombresCiudades;
        this.visitado = new boolean[numCiudades];
    }

    // Inicia la busqueda de la mejor ruta
    public void resolver() {
        visitado[0] = true;
        buscar(0, 1, 0, nombresCiudades[0]);
        System.out.println("La mínima distancia encontrada es: " + minDistancia+ " km");
        System.out.println("La mejor ruta es: " + mejorRuta);
    }

    // Backtracking para hallar la mejor ruta 
    private void buscar(int ciudadActual, int numVisitadas, int distanciaActual, String ruta) {
        if (numVisitadas == numCiudades) {
            int distanciaTotal = distanciaActual + distancias[ciudadActual][0];
            if (distanciaTotal < minDistancia) {
                minDistancia = distanciaTotal;
                mejorRuta = ruta + " -> " + nombresCiudades[0];
            }
            System.out.println(ruta + " -> " + nombresCiudades[0] + ".  Distancia total: " + distanciaTotal+ " km");
            return;
        }

        for (int ciudadSiguiente = 0; ciudadSiguiente < numCiudades; ciudadSiguiente++) {
            if (!visitado[ciudadSiguiente] && distancias[ciudadActual][ciudadSiguiente] > 0) {
                visitado[ciudadSiguiente] = true;
                buscar(ciudadSiguiente, numVisitadas + 1, 
                       distanciaActual + distancias[ciudadActual][ciudadSiguiente], 
                       ruta + " -> " + nombresCiudades[ciudadSiguiente]);
                visitado[ciudadSiguiente] = false; 
            }
        }
    }

    public static void main(String[] args) {
        // Matriz de con las distancias entre las ciudades
        int[][] distancias = {
            { 0, 10, 15, 20 }, // Distancias desde,hasta (Armenia,Armenia) (Armenia,Cali) (Armenia,Bogotá) (Armenia,Pereira) 
            { 10, 0, 35, 25 }, // Distancias desde,hasta (Cali,Armenia) (Cali,Cali) (Cali,Bogotá) (Cali,Pereira) 
            { 15, 35, 0, 35 }, // Distancias desde,hasta (Bogotá,Armenia) (Bogotá,Cali) (Bogotá,Bogotá) (Bogotá,Pereira) 
            { 20, 25, 30, 0 } // Distancias desde,hasta (Pereira,Armenia) (Pereira,Cali) (Pereira,Bogotá) (Pereira,Pereira) 
        };

        
        String[] nombresCiudades = { "Armenia", "Cali", "Bogotá", "Pereira" };

        ViajanteBacktracking viajante = new ViajanteBacktracking(distancias, nombresCiudades);
        viajante.resolver();
    }
}