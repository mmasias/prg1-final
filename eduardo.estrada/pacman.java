public class pacman {

    private static int puntos = 0;

    public static void main(String[] args) {
        int[][] elMapa = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},				
            {1,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,1},				
            {1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},				
            {1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},				
            {1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},				
            {1,4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,4,1},				
            {1,2,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,2,1},				
            {1,2,1,1,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,1,1,2,1},				
            {1,2,2,2,2,2,2,1,2,2,2,2,2,1,1,2,2,2,2,2,1,2,2,2,2,2,2,1},				
            {1,1,1,1,1,1,2,1,1,1,1,1,0,1,1,0,1,1,1,1,1,2,1,1,1,1,1,1},				
            {1,1,1,1,1,1,2,1,1,1,1,1,0,1,1,0,1,1,1,1,1,2,1,1,1,1,1,1},				
            {1,1,1,1,1,1,2,1,0,0,0,0,0,0,0,0,0,0,0,0,1,2,1,1,1,1,1,1},				
            {1,1,1,1,1,1,2,1,0,1,1,1,1,0,0,1,1,1,1,0,1,2,1,1,1,1,1,1},				
            {0,0,0,0,0,0,2,0,0,1,0,0,0,0,0,0,0,0,1,0,1,2,0,0,0,0,0,0},				
            {1,1,1,1,1,1,2,1,0,1,1,1,1,1,1,1,1,1,1,0,1,2,1,1,1,1,1,1},				
            {1,1,1,1,1,1,2,1,0,0,0,0,0,6,6,0,0,0,0,0,1,2,1,1,1,1,1,1},				
            {1,1,1,1,1,1,2,1,0,1,1,1,1,1,1,1,1,1,1,0,1,2,1,1,1,1,1,1},				
            {1,1,1,1,1,1,2,1,0,1,1,1,1,1,1,1,1,1,1,0,1,2,1,1,1,1,1,1},				
            {1,2,2,2,2,2,2,2,2,2,2,2,2,1,1,2,2,2,2,2,2,2,2,2,2,2,2,1},				
            {1,2,1,1,1,1,2,1,1,1,1,1,2,1,1,2,1,1,1,1,1,2,1,1,1,1,2,1},				
            {1,2,1,1,1,1,2,2,2,1,1,1,2,1,1,2,1,1,1,2,2,2,1,1,1,1,2,1},				
            {1,4,2,2,1,1,2,1,2,2,2,2,2,2,2,2,2,2,2,2,1,2,1,1,2,2,4,1},				
            {1,1,1,2,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,2,1,1,1},				
            {1,1,1,2,1,1,2,1,2,1,1,1,1,1,1,1,1,1,1,2,1,2,1,1,2,1,1,1},				
            {1,2,2,2,2,2,2,1,2,2,2,2,2,1,1,2,2,2,2,2,1,2,2,2,2,2,2,1},				
            {1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1},				
            {1,2,1,1,1,1,1,1,1,1,1,1,2,1,1,2,1,1,1,1,1,1,1,1,1,1,2,1},				
            {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1},				
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}		
        };
        int[] personaje = {0,13};
		imprimeMundo(elMapa, personaje);
    }

    private static void limpiaPantalla() {
		System.out.print("\033[H\033[2J");
        System.out.flush();
	}

    private static void imprimeMundo(int[][] elMapa, int[] elPersonaje) {

		limpiaPantalla();

		for (int y = 0; y < elMapa.length; y++) {
			for (int x = 0; x < elMapa[y].length; x++) {
                if (x == elPersonaje[0] && y == elPersonaje[1]) {
                    imprimePersonaje();
                } else {
                    imprimeElemento(elMapa[y][x]);
                }
			}
			System.out.println();
		}
		imprimeStatus(elPersonaje);
	}

    private static void imprimePersonaje() {

		System.out.print(INICIO + BLACK + WHITE_BACKGROUND + " :v" + RESET);

	}

    private static void imprimeElemento(int elementoDelMapa) {

		String[] matrizDeElementos = {
				INICIO + WHITE + WHITE_BACKGROUND + " . " + RESET, // Camino vacio
				INICIO + BLUE + BLUE_BACKGROUND + "[#]" + RESET, //Pared
                INICIO + YELLOW + WHITE_BACKGROUND + " o " + RESET, //Pastilla
				INICIO + BLUE_BOLD + BLUE_BACKGROUND + "~ ~" + RESET,
                INICIO + RED_BOLD + RED_BACKGROUND + " 0 " + RESET, //Pastilla de fuerza,
                "",
                INICIO + RED_BOLD + GREEN_BACKGROUND + "oOo" + RESET //Fruta
		};
		System.out.print(matrizDeElementos[elementoDelMapa]);
	}

    private static void imprimeStatus(int[] elPersonaje) {

		System.out.println("El personaje está en X:[" + elPersonaje[0] + "] Y:[" + elPersonaje[1] + "]");
		System.out.println("Tienes [ "+ puntos +" ] puntos");

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



}				