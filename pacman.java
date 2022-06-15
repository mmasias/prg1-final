import java.util.Scanner;
import java.util.Random;

class pacman {
    public static void main(String[] args) {

        int[][] elMapa = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1 },
                { 1, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 1 },
                { 1, 2, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1 },
                { 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1 },
                { 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 2, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 1, 1 },
                { 0, 0, 0, 0, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 2, 1, 0, 0, 0, 0, 0, 6, 6, 0, 0, 0, 0, 0, 1, 2, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 2, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 2, 1, 1, 1, 1, 1, 1 },
                { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 2, 2, 2, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 2, 2, 2, 1, 1, 1, 1, 2, 1 },
                { 1, 4, 2, 2, 1, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 1, 1, 2, 2, 4, 1 },
                { 1, 1, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 1, 1 },
                { 1, 1, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 1, 1 },
                { 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1 },
                { 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1 },
                { 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };

        int[][] elPersonaje = { { 13, 21 } };
        int[][] NPCs = {
                { 13, 12 },
                { 13, 12 },
                { 13, 12 },
                { 13, 12 }
        };
        int[] contarMovimientos = { -1 };
        int[] puntos = { 0 };
        do {
            pasaElTiempo(contarMovimientos);
            fruta(contarMovimientos, elMapa, elPersonaje[0], puntos);
            imprimeMundo(elMapa, elPersonaje, NPCs, contarMovimientos, puntos);
        } while (procesaMovimiento(elMapa, elPersonaje, NPCs, puntos));
    };

    private static void fruta(int[] contarMovimientos, int[][] unMapa, int[] unPersonaje, int[] puntos) {
        int elPersonajeX, elPersonajeY;
        elPersonajeX = unPersonaje[0];
        elPersonajeY = unPersonaje[1];
        for (int tiempoFruta = 0; tiempoFruta > contarMovimientos[0]; tiempoFruta++) {
            if (tiempoFruta > 80) {
                unMapa[elPersonajeY][elPersonajeX] = 0;
                puntos[0] = puntos[0] + 10;
            } else {
                unMapa[elPersonajeY][elPersonajeX] = 6;
            }
        }
    }

    private static void pasaElTiempo(int[] contarMovimientos) {
        contarMovimientos[0]++;
    }

    private static boolean procesaMovimiento(int[][] elMapa, int[][] elPersonaje, int[][] NPCs, int[] puntos) {

        Scanner entrada = new Scanner(System.in);
        String inputUsuario;
        char laDireccion = ' ';

        inputUsuario = entrada.nextLine();

        if (inputUsuario.equals("f")) {
            return false;
        } else if (inputUsuario.equals("w")) {
            laDireccion = 'N';
        } else if (inputUsuario.equals("a")) {
            laDireccion = 'O';
        } else if (inputUsuario.equals("s")) {
            laDireccion = 'S';
        } else if (inputUsuario.equals("d")) {
            laDireccion = 'E';
        }

        mueveNPCs(elMapa, NPCs, puntos);
        mueve(elPersonaje[0], elMapa, laDireccion, false, puntos);
        return true;
    }

    private static void mueve(int[] unPersonaje, int[][] unMapa, char unaDireccion, boolean isNPC, int[] puntos) {

        int elPersonajeX, elPersonajeY;
        elPersonajeX = unPersonaje[0];
        elPersonajeY = unPersonaje[1];

        if (unaDireccion == 'O') {
            if (elPersonajeX == 0) {
                elPersonajeX = unMapa[0].length - 1;
            } else if (unMapa[elPersonajeY][elPersonajeX - 1] % 2 == 0) {
                elPersonajeX = elPersonajeX - 1;
            }
        } else if (unaDireccion == 'N') {
            if (elPersonajeY == 0) {
                elPersonajeY = unMapa.length - 1;
            } else if (unMapa[elPersonajeY - 1][elPersonajeX] % 2 == 0) {
                elPersonajeY = elPersonajeY - 1;
            }
        } else if (unaDireccion == 'E') {
            if (elPersonajeX == unMapa[0].length - 1) {
                elPersonajeX = 0;
            } else if (unMapa[elPersonajeY][elPersonajeX + 1] % 2 == 0) {
                elPersonajeX = elPersonajeX + 1;
            }
        } else if (unaDireccion == 'S') {
            if (elPersonajeY == unMapa.length - 1) {
                elPersonajeY = 0;
            } else if (unMapa[elPersonajeY + 1][elPersonajeX] % 2 == 0) {
                elPersonajeY = elPersonajeY + 1;
            }
        }

        if (unMapa[elPersonajeY][elPersonajeX] == 2 && isNPC == false) {
            unMapa[elPersonajeY][elPersonajeX] = 0;
            puntos[0]++;
        }
        if (unMapa[elPersonajeY][elPersonajeX] == 4 && isNPC == false) {
            unMapa[elPersonajeY][elPersonajeX] = 0;
            puntos[0] = puntos[0] + 5;
        }
        if (unMapa[elPersonajeY][elPersonajeX] == 6 && isNPC == false) {
            unMapa[elPersonajeY][elPersonajeX] = 0;
            puntos[0] = puntos[0] + 10;
        }

        unPersonaje[0] = elPersonajeX;
        unPersonaje[1] = elPersonajeY;
    }

    private static void mueveNPCs(int[][] elMapa, int[][] losNPCs, int[] puntos) {

        char[] laDireccion = { 'N', 'S', 'E', 'O' };
        char unaDireccion = ' ';

        for (int unNPC = 0; unNPC < losNPCs.length; unNPC++) {
            Random random = new Random();
            unaDireccion = laDireccion[random.nextInt(3)];
            mueve(losNPCs[unNPC], elMapa, unaDireccion, true, puntos);
        }
    }

    private static boolean hayNPC(int[][] losNPCs, int i, int j, int[] puntos, int[] elPersonaje, int[][] elMapa) {
        int elPersonajeX, elPersonajeY;
        elPersonajeX = elPersonaje[0];
        elPersonajeY = elPersonaje[1];
        for (int unNPC = 0; unNPC < losNPCs.length; unNPC++) {
            if (losNPCs[unNPC][0] == j && losNPCs[unNPC][1] == i) {
                return true;
            } else if (losNPCs[unNPC][0] == elMapa[elPersonajeY][elPersonajeX]) {
                losNPCs[unNPC][0] = 14;
                losNPCs[unNPC][1] = 13;
                puntos[0] = puntos[0] + 10;
            }
        }
        return false;
    }

    private static void imprimeMundo(int[][] elMapa, int[][] elPersonaje, int[][] losNPCs, int[] contarMovimientos,
            int[] puntos) {

        for (int i = 0; i < elMapa.length; i = i + 1) {
            for (int j = 0; j < elMapa[i].length; j = j + 1) {
                if (i == elPersonaje[0][1] && j == elPersonaje[0][0]) {
                    imprimePersonaje();
                } else {
                    if (hayNPC(losNPCs, i, j, puntos, elPersonaje[0], elMapa)) {
                        imprimeNPC();
                    } else {
                        imprimeElemento(elMapa[i][j]);
                    }
                }
            }
            System.out.println();
        }
        imprimeStatus(elPersonaje, losNPCs, contarMovimientos, puntos);
    }

    private static void imprimeNPC() {
        System.out.print(INICIO + BLACK + CYAN_BACKGROUND + "^V^" + RESET);
    }

    private static void imprimeElemento(int elementoDelMapa) {

        String[] matrizDeElementos = {
                INICIO + WHITE + WHITE_BACKGROUND + " . " + RESET,
                INICIO + BLACK + BLACK_BACKGROUND + "[#]" + RESET,
                INICIO + YELLOW + YELLOW_BACKGROUND + " * " + RESET,
                INICIO + BLUE_BOLD + BLUE_BACKGROUND + "~ ~" + RESET,
                INICIO + RED + RED_BACKGROUND + " - " + RESET,
                INICIO + BLACK + GREEN_BACKGROUND + " : " + RESET,
                INICIO + GREEN + GREEN_BACKGROUND + " : " + RESET
        };
        System.out.print(matrizDeElementos[elementoDelMapa]);
    };

    private static void imprimePersonaje() {
        System.out.print(" :v");
    }

    private static void imprimeStatus(int[][] elPersonaje, int[][] losNPCs, int[] contarMovimientos, int[] puntos) {
        System.out.println("Llevas [" + contarMovimientos[0] + "] movimientos");
        System.out.println("Tienes un puntjae de [" + puntos[0] + "]");
    }

    private static String INICIO = "\033[";
    private static String RESET = "\033[0m";

    private static String BLACK = "0;30";
    private static String RED = "0;31";
    private static String GREEN = "0;32";
    private static String YELLOW = "0;33";
    private static String BLUE = "0;34";
    private static String PURPLE = "0;35";
    private static String CYAN = "0;36";
    private static String WHITE = "0;37";

    private static String BLACK_BOLD = "1;30";
    private static String RED_BOLD = "1;31";
    private static String GREEN_BOLD = "1;32";
    private static String YELLOW_BOLD = "1;33";
    private static String BLUE_BOLD = "1;34";
    private static String PURPLE_BOLD = "1;35";
    private static String CYAN_BOLD = "1;36";
    private static String WHITE_BOLD = "1;37";

    private static String BLACK_BACKGROUND = ";40m";
    private static String RED_BACKGROUND = ";41m";
    private static String GREEN_BACKGROUND = ";42m";
    private static String YELLOW_BACKGROUND = ";43m";
    private static String BLUE_BACKGROUND = ";44m";
    private static String PURPLE_BACKGROUND = ";45m";
    private static String CYAN_BACKGROUND = ";46m";
    private static String WHITE_BACKGROUND = ";47m";
};