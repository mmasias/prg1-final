import java.util.Scanner;

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

        int[][] elPersonaje = { { 14, 23 } };
        do {
            imprimeMundo(elMapa, elPersonaje);
        } while (procesaMovimiento(elMapa, elPersonaje));
    };

    private static boolean procesaMovimiento(int[][] elMapa, int[][] elPersonaje) {

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

        // mueveNPCs(elMapa, losNPCs);
        mueve(elPersonaje[0], elMapa, laDireccion);
        return true;
    }

    private static void mueve(int[] unPersonaje, int[][] unMapa, char unaDireccion) {

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

        unPersonaje[0] = elPersonajeX;
        unPersonaje[1] = elPersonajeY;
    }

    private static void imprimeMundo(int[][] elMapa, int[][] elPersonaje) {

        for (int i = 0; i < elMapa.length; i = i + 1) {
            for (int j = 0; j < elMapa[i].length; j = j + 1) {
                if (i == elPersonaje[0][1] && j == elPersonaje[0][0]) {
                    imprimePersonaje();
                } else {
                    // if (hayNPC(losNPCs, i, j)) {
                    // imprimeNPC();
                    // } else {
                    imprimeElemento(elMapa[i][j]);
                    // }
                }
            }
        }
        // imprimeBordeVertical(true);
    }
    // imprimeBordeHorizontal(elMapa[0].length);
    // imprimeStatus(elPersonaje, losNPCs, elReloj);

    private static void imprimeElemento(int elementoDelMapa) {

        String[] matrizDeElementos = {
                INICIO + YELLOW + WHITE_BACKGROUND + " . " + RESET,
                INICIO + WHITE + WHITE_BACKGROUND + "[#]" + RESET,
                INICIO + RED + GREEN_BACKGROUND + "*" + RESET + INICIO + GREEN_BOLD + GREEN_BACKGROUND + "Y" + RESET
                        + INICIO + RED + GREEN_BACKGROUND + "*" + RESET,
                INICIO + BLUE_BOLD + BLUE_BACKGROUND + "~ ~" + RESET,
                INICIO + YELLOW + GREEN_BACKGROUND + " : " + RESET
        };
        System.out.print(matrizDeElementos[elementoDelMapa]);
    };

    private static void imprimePersonaje() {
        System.out.print(":v");
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