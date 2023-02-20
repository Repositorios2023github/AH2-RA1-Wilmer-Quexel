package juego_escaleritayserpiente;

import java.util.Scanner;
/**
 *
 * @author Wilmer Quexel
 */
public class Juego_EscaleritaYserpiente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      Scanner validacion = new Scanner(System.in);
         int[][] numeros = new int[8][8];
        int Contador = 64;
        char[][] arroba = new char[8][8];
        char[][] Trampa = new char[8][8];
        int posicionJugador = 1;
        int Menu=0;
        int numeroTrampas;
        int Dado;
        

        Scanner in = new Scanner(System.in);


        for (int c = 0; c < numeros.length; c++) {
            if (c % 2 == 0) {
                for (int f = numeros[c].length - 1; f >= 0; f--) {
                    numeros[c][f] = Contador--;
                }
            } else if (c % 2 != 0) {
                for (int f = 0; f < numeros[c].length; f++) {
                    numeros[c][f] = Contador--;
                }
            }
          
            for (int t = 0; t < Trampa[c].length; t++) {
                Trampa[c][t] = ' ';
            }
        }
  
        for (int c = 0; c < Trampa.length; c++) {
            numeroTrampas = (int) (Math.random() * 3) + 1;
            for (int t = 1; t <= numeroTrampas; t++) {
                int numeroColumna = (int) (Math.random() * 7) + 0;
                if (Trampa[c][numeroColumna] == ' ') {
                    Trampa[c][numeroColumna] = '#';
                } else {
                    t--;
                }
            }
        }

        arroba[7][7] = '@';
        while (Menu!=3) {
            System.out.println(" MENU PRINCIPAL");
            System.out.println("1. Iniciar Juego");              
            System.out.println("2. Retornar Juego");               
            System.out.println("3. Salir");               
                           
            Menu = validacion.nextInt();
            switch (Menu) {
                case 1:
                    while (posicionJugador <= 64) {	
                       for (int i = 0; i < numeros.length; i++) {
                            for (int j = 0; j < numeros[i].length; j++) {
                                if (numeros[i][j] <= 9) {
                                    System.out.print("|     " + numeros[i][j]);
                                    System.out.print("");
                                } else {
                                    System.out.print("|    " + numeros[i][j]);
                                }
                            }
                            System.out.println("|        ");

                            //**********MOSTRAMOS SEGUNDA MATRIZ CON TRAMPAS
                            for (int k = 0; k < Trampa.length; k++) {
                                if (arroba[i][k] == '@' || arroba[i][k] == ' ') {
                                    System.out.print("|" + arroba[i][k] + "    " + Trampa[i][k]);
                                } else {
                                    System.out.print("|" + arroba[i][k] + "     " + Trampa[i][k]);
                                }
                            }
                            System.out.println("|");
                            System.out.println("-----------------------------------------------------------");
                        }
                        for (int c = 0; c < arroba.length; c++) {
                            for (int f = 0; f < arroba[c].length; f++) {
                                if (arroba[c][f] == '@' && Trampa[c][f] == '#') {
                                    
                                    System.out.println("Has caido en una Trampa!");
                             
                                }
                            }
                        }

                        System.out.println("ingresa el numeros 'D' para tirar el dado, o 'P' para regresar al menu principal: ");
                        String opcion2 = in.nextLine();
                    
                        for (int f = 0; f < arroba.length; f++) {
                            for (int c = 0; c < arroba[f].length; c++) {
                                if (arroba[f][c] == '@') {
                                    arroba[f][c] = ' ';
                                }
                            }
                        }

                    
                        if (opcion2.equalsIgnoreCase("d")) {
                            Dado = (int) (Math.random() * 5) + 2;
                            System.out.println("Resultado del dato = " + Dado);
                            posicionJugador += Dado;

                           
                            for (int c = 0; c < numeros.length; c++) {
                                for (int f = 0; f < numeros[c].length; f++) {
                                    if (numeros[c][f] == posicionJugador) {
                                        arroba[c][f] = '@';
                                    }
                                }
                            }
                            if (posicionJugador >= 64) {
                               
                                System.out.println("Has Ganado!!!!!!");
                               
                            }
                        }
                    } 
                    break;
                case 2:
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("Has salido del juego");
                    break;
                default:
                    System.out.println("Solo opciones del 1 al 3");


                    
            }
        }
        
    }
    
}
