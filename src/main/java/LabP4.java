import java.util.Scanner;
import java.util.Random;

public class L {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int opcion;
        int[] contadores = new int[4];

        do {
            System.out.println("Menu:");
            System.out.println("1. Palabra al reves");
            System.out.println("2. Numero perfecto");
            System.out.println("3. Primos");
            System.out.println("4. Votaciones");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer
            contadores[opcion - 1]++;

            switch (opcion) {
                case 1:
                    System.out.print("Favor ingresar una palabra: ");
                    String palabra = sc.nextLine();
                    System.out.println("Su palabra al reves es: " + new StringBuilder(palabra).reverse().toString());
                    break;
                case 2:
                    System.out.print("Favor ingresar un numero: ");
                    int numero = sc.nextInt();
                    if (esNumeroPerfecto(numero)) {
                        System.out.println("El numero si es perfecto");
                    } else {
                        System.out.println("El numero no es");
                    }
                    break;
                case 3:
                    int numeroaleatorio = random.nextInt(100) + 1;
                    System.out.println("Su numero generado es " + numeroaleatorio);
                    if (esPrimo(numeroaleatorio)) {
                        System.out.println(numeroaleatorio + " es primo.");
                    } else {
                        System.out.println(numeroaleatorio + " no es primo.");
                    }
                    break;
                case 4:
                    int votantes;
                    System.out.print("Ingrese la cantidad de votantes: ");
                    votantes = sc.nextInt();
                    sc.nextLine(); // Limpiar buffer
                    int votosazules = 0, votosrojos = 0, votosnegros = 0, votosamarillos = 0, votosnulos = 0;

                    for (int i = 0; i < votantes; i++) {
                        System.out.print("Ingrese el voto (" + (i + 1) + " de " + votantes + "): ");
                        String voto = sc.nextLine().toUpperCase();
                        switch (voto) {
                            case "AZUL":
                                votosazules++;
                                break;
                            case "ROJO":
                                votosrojos++;
                                break;
                            case "NEGRO":
                                votosnegros++;
                                break;
                            case "AMARILLO":
                                votosamarillos++;
                                break;
                            default:
                                votosnulos++;
                                break;
                        }
                    }

                    int votosvalidos = votosazules + votosrojos + votosnegros + votosamarillos;
                    if (votosvalidos >= votantes * 0.60) {
                        if (votosazules > votosrojos && votosazules > votosnegros && votosazules > votosamarillos) {
                            System.out.println("La planilla ganadora es: AZUL");
                        } else if (votosrojos > votosazules && votosrojos > votosnegros && votosrojos > votosamarillos) {
                            System.out.println("La planilla ganadora es: ROJO");
                        } else if (votosnegros > votosazules && votosnegros > votosrojos && votosnegros > votosamarillos) {
                            System.out.println("La planilla ganadora es: NEGRO");
                        } else {
                            System.out.println("La planilla ganadora es: AMARILLO");
                        }
                    } else {
                        System.out.println("VOTACIÓN FALLIDA");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    System.out.println("Contadores de opciones:");
                    System.out.println("1. Palabra al revés: " + contadores[0]);
                    System.out.println("2. Número perfecto: " + contadores[1]);
                    System.out.println("3. Primos: " + contadores[2]);
                    System.out.println("4. Votaciones: " + contadores[3]);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 5);

        sc.close();
    }

    public static boolean esNumeroPerfecto(int numero) {
        int suma = 0;
        for (int i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) {
                suma += i;
            }
        }
        return suma == numero;
    }

    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; int sqrt = (int) Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
}
