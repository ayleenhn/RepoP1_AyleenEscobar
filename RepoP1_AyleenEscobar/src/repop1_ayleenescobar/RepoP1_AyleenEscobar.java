package repop1_ayleenescobar;
import java.util.Scanner;

public class RepoP1_AyleenEscobar {

    public static void main(String[] args) {
        
        boolean respuesta = true;
        
        Scanner sc = new Scanner(System.in);
        Scanner sc_ca = new Scanner(System.in);
        
        while (respuesta){
            System.out.println("Menu");
            System.out.println("1.Ejercicio 1");
            System.out.println("2.Ejercicio 2");
            System.out.println("3.Ejercicio 3");
            System.out.println("4.SALIR");
            System.out.println("Ingrese su opcion: "); 

            int opcion = 0;
            opcion = sc.nextInt();

            switch (opcion){
                case 1 : {
                    System.out.print("Ingrese la cadena que desea encriptar: ");
                    String cadena = sc_ca.nextLine();
                    while (cadena.length() >10) {
                        System.out.println("La cadena debe de ser menor que 10.");
                        System.out.print("Ingrese la cadena que desea encriptar: ");
                        cadena = sc_ca.nextLine();
                    }
                    System.out.print("Ingrese la llave: ");
                    int llave = sc.nextInt();
                    while (llave >10 && llave<=1) {
                        System.out.println("la llave debe ser entre 1 y 10.");
                        System.out.print("Ingrese la llave: ");
                        llave = sc.nextInt();
                    }
                    
                    String cadenaE = encripta(cadena, llave);
                    System.out.println("La cadena encriptada es: " + cadenaE);
                } break;
                
                case 2:{
                    System.out.print("Ingrese la cadena: ");
                    String cadena2 = sc_ca.nextLine();
                    
                    System.out.print("Ingrese el carácter: ");
                    char separador = sc_ca.nextLine().charAt(0);
                    String[] resultado = separar(cadena2, separador);

                    System.out.print("Resultado: ");
                    for (String palabra : resultado) {
                        System.out.print("[" + palabra + "] ");
                    }
                    System.out.println("");   
                } break;
                
                case 3:{
                    String[] arregloID = datosID();
                    String[] arregloContra = datosContra();
                    
                    System.out.println("Arreglos creados:");
                    System.out.println("");
                    System.out.print("arregloID = ");
                    imprimirArreglo(arregloID);
                    
                    System.out.print("arregloContra = ");
                    imprimirArreglo(arregloContra);
                    System.out.println("");
                    System.out.print("Ingrese el ID del usuario: ");
                    String id = sc_ca.nextLine();

                    System.out.print("Ingrese la contraseña: ");
                    String contra = sc_ca.nextLine();

                    if (ingreso(arregloID, arregloContra, id, contra)) {
                        System.out.println("La autenticación fue exitosa");
                    } else {
                        System.out.println("Error, el usuario y la contraseña no son las mismas");
                    }
                } break;
                
                case 4:{
                    respuesta = false; 
                }break;

                default:
                    System.out.println("NUMERO NO VALIDO.");
                    break;
            }
        }
    }
  
    public static String encripta(String cadena, int llave){
        String acum="";
        boolean par = (false);
        int carac= cadena.charAt(0);
        if (carac%2 ==0){
        par = true;
        }
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
                if (par) {
                    caracter += llave;
                } else {
                    caracter -= llave;
                }
            acum += caracter;
        }
        return acum;
    }
    
    public static String[] separar(String cadena2, char separador) {
        int cont = 1;
        for (int i = 0; i < cadena2.length(); i++) {
            if (cadena2.charAt(i) == separador) {
                cont++;
            }
        }
        String[] resultado = new String[cont];
        int r2 = 0;
        int palabra2 = 0;
        for (int i = 0; i < cadena2.length(); i++) {
            char caracter = cadena2.charAt(i);

            if (caracter == separador) {
                int largo = i - palabra2;
                resultado[r2] = cadena2.substring(palabra2, palabra2 + largo);
                r2++;
                palabra2 = i + 1;
            }
        }
        int largopalabra = cadena2.length() - palabra2;
        resultado[r2] = cadena2.substring(palabra2, palabra2 + largopalabra);
        return resultado;
    }
    
    public static String[] datosID() {
        return new String[]{"usuario1", "persona", "otro85"};
    }

    public static String[] datosContra() {
        return new String[]{"123", "abcd12", "qwerty11"};
    }

    public static void imprimirArreglo(String[] arreglo) {
        System.out.print("{");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i]);
            if (i < arreglo.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    public static boolean ingreso(String[] arregloID, String[] arregloContra, String id, String contra) {
        for (int i = 0; i < arregloID.length; i++) {
            if (arregloID[i].contains(id) && arregloContra[i].contains(contra)) {
                return true;
            }
        }return false;
    }
}



