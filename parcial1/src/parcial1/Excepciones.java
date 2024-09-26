package parcial1;

public class Excepciones {

	public static void main(String[] args) {
		excepciones();
	}
	 private static void excepciones() {
  	   // Bloque 1
		 int a = 0;
		 int b = 5;
		 System.out.println("Hola bebe");
  	   // Bloque 2
		 System.out.println("como estas");
		 
  	   try {
  	       // Bloque 3
  		   System.out.println("haga una division " + a/b);
  	       // Bloque 4
  		   String cadena = null;
  		   cadena.toCharArray();
		   System.out.println("necesito otro favor " + a/b);
  	       try {
  	           // Bloque 5
  	           // Bloque 6
  	       }
  	       catch (ArrayIndexOutOfBoundsException e) {
  	           // Bloque 14
  	       }
  	       catch (StringIndexOutOfBoundsException e) {
  	           // Bloque 15
  	       }
  	       finally {
  	           // Bloque 7
  	       }
  	   }
  	   catch (ArithmeticException e) {
  	       // Bloque 16
  	   }
  	   catch (NumberFormatException e) {
  	       // Bloque 17
  	   }
  	   catch (Exception e) {
  	       // Bloque 8
  	       try {
  	           // Bloque 9
  	           // Bloque 10
  	    	   System.out.println("bloque 10");
  	    	   String b2 = "a";
  	    	   System.out.println("cast "+Integer.valueOf(b2));
  	       }
  	       catch (NullPointerException e1) {
  	           // Bloque 18
  	       }
  	       finally {
  	           // Bloque 11
  	    	   System.out.println("finallly 11");
  	       }
  	       // Bloque 12
  	   }
  	   finally {
  	       // Bloque 13
  		 System.out.println("finallly 13");
  	   }
  	   
  	   
  	   // Bloque 19
  	   try {
  	       // Bloque 20
  	   }
  	   catch (NullPointerException e) {
  	       // Bloque 21
  	   }
  	   // Bloque 22
  	   
  	   System.out.println("termino");
  	}

}
