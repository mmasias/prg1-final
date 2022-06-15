import java.util.Scanner;
class laberinto{	
	
	public static void main(String[] args){
			
		int[][] unMapa = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
            {1,0,1,1,0,1,1,1,0,1,0,1,1,1,0,1,1,0,1},
            {1,0,1,1,0,1,1,1,0,1,0,1,1,1,0,1,1,0,1},
            {1,0,1,1,0,1,1,1,0,1,0,1,1,1,0,1,1,0,1},
            {1,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,1},
            {1,0,1,1,0,1,0,1,1,1,1,1,1,1,0,1,1,0,1},
            {1,0,1,1,0,1,0,1,1,1,1,1,1,1,0,1,1,0,1},
            {1,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,0,1,1,1,0,1,0,1,1,1,0,1,1,1,1},
            {1,1,1,1,0,1,1,1,0,1,0,1,1,1,0,1,1,1,1},
            {1,1,1,1,0,1,1,1,0,1,0,1,1,1,0,1,1,1,1},
            {1,1,1,1,0,1,1,1,2,1,2,1,1,1,0,1,1,1,1},
            {1,1,1,1,0,1,1,1,2,1,2,1,1,1,0,1,1,1,1},
            {1,1,1,1,0,1,1,1,2,1,2,1,1,1,0,1,1,1,1},
            {1,1,1,1,0,1,2,2,2,2,2,2,2,1,0,1,1,1,1},
            {1,1,1,1,0,1,2,1,1,2,1,1,2,1,0,1,1,1,1},
            {2,2,2,2,0,2,2,1,2,2,2,1,2,2,0,2,2,2,2},
            {1,1,1,1,0,1,2,1,1,1,1,1,2,1,0,1,1,1,1},
            {1,1,1,1,0,1,2,2,2,4,2,2,2,1,0,1,1,1,1},
            {1,1,1,1,0,1,2,1,1,1,1,1,2,1,0,1,1,1,1},
            {1,1,1,1,0,1,2,1,1,1,1,1,2,1,0,1,1,1,1},
            {1,1,1,1,0,1,2,1,1,1,1,1,2,1,0,1,1,1,1},
            {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
            {1,0,1,1,0,1,1,1,0,1,0,1,1,1,0,1,1,0,1},
            {1,0,1,1,0,0,0,1,0,1,0,1,0,0,0,1,1,0,1},
            {1,5,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,5,1},
            {1,1,0,1,0,1,0,0,0,0,0,0,0,1,0,1,0,1,1},
            {1,1,0,1,0,1,0,1,1,1,1,1,0,1,0,1,0,1,1},
            {1,1,0,1,0,1,0,1,1,1,1,1,0,1,0,1,0,1,1},
            {1,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,1},
            {1,0,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1},
            {1,0,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},

        };

		int[][] elPersonaje = { { 15, 24 } };
        int[][] losNPCs = {
            { 11, 13 },
            { 12, 13 },
            { 14, 13 },
            { 17, 13 },
    };
		do {
			imprimeMapa(unMapa, elPersonaje, losNPCs);
		} while (procesaMovimiento(unMapa,elPersonaje, losNPCs));
	}


    private static void imprimeMapa(int[][] mapaPorImprimir, int[][]elPersonaje, int[][] losNPCs){
		
		imprimeBordeHorizontal(mapaPorImprimir[0].length);
		
		for (int i=0; i<mapaPorImprimir.length; i=i+1){
			imprimeBordeVertical(false);
			for (int j=0; j<mapaPorImprimir[i].length; j=j+1) {
					if (i==elPersonaje[0][1] && j==elPersonaje[0][0]) {
						imprimePersonaje();
					}else {
						if (hayNPC(losNPCs, i, j)) {
							imprimeNPC();
						} else {
							imprimeElemento(mapaPorImprimir[i][j]);
						}
					}
				 
			}
			imprimeBordeVertical(true);
		}		
		imprimeBordeHorizontal(mapaPorImprimir[0].length);
		imprimeStatus(elPersonaje, losNPCs);
	}


	private static void imprimeStatus(int[][] elPersonaje, int[][] losNPCs) {
		System.out.println("Personaje en X:[" + elPersonaje[0][0] + "] Y:[" + elPersonaje[0][1] + "]");
		for (int unNPC = 0; unNPC < losNPCs.length; unNPC++) {
			System.out.print("NPC[" + unNPC + "]=(" + losNPCs[unNPC][0] + "," + losNPCs[unNPC][1] + ") - ");
		}
	}

	
	private static void imprimePersonaje(){
		System.out.print(" :v");
	}

    //Bordes-------------------------------------------------------------------------------------------------

	private static void imprimeBordeHorizontal(int laLongitud){
		System.out.print("+");
		for (int j=0;j<laLongitud;j=j+1){
			System.out.print("---");
		}
		System.out.println("+");		
	}

	private static void imprimeBordeVertical(boolean bordeDerecho){
		System.out.print("|");
		if (bordeDerecho) {System.out.println();}
	}

// Movimientos -----------------------------------------------------------------------------------------------

    private static boolean procesaMovimiento(int[][] elMapa, int[][]elPersonaje, int[][] losNPCs){
        mueveNPCs(elMapa, losNPCs);
		Scanner entrada = new Scanner(System.in);
		String inputUsuario;
		
		inputUsuario = entrada.nextLine();
        int elPersonajeX, elPersonajeY;
		
        elPersonajeX = elPersonaje[0][0];
		elPersonajeY = elPersonaje[0][1];
		    if (inputUsuario.equals("a") && elMapa[elPersonajeY][elPersonajeX - 1] % 2 == 0) {
			elPersonajeX = elPersonajeX - 1;
		    } else if (inputUsuario.equals("d") && elMapa[elPersonajeY][elPersonajeX + 1] % 2 == 0) {
			elPersonajeX = elPersonajeX + 1;
		    } else if (inputUsuario.equals("w") && elMapa[elPersonajeY - 1][elPersonajeX] % 2 == 0) {
			elPersonajeY = elPersonajeY - 1;
		    } else if (inputUsuario.equals("s") && elMapa[elPersonajeY + 1][elPersonajeX] % 2 == 0) {
			elPersonajeY = elPersonajeY + 1;
	    	} else if (inputUsuario.equals("f")) {
			        return false;
		}else if(gameover(elPersonaje, losNPCs)==false){
                    return false;
        }

        elPersonaje[0][0] = elPersonajeX;
		elPersonaje[0][1] = elPersonajeY;

        if(elMapa[elPersonajeY][elPersonajeX]==2){
            elMapa[elPersonajeY][elPersonajeX]=0;
        } 

		return true;
	}
	
	
    private static void mueveNPCs(int[][] elMapa, int[][] losNPCs) {
		double movimiento;
		int npcX, npcY;
		for (int unNPC = 0; unNPC < losNPCs.length; unNPC++) {
			movimiento = Math.random();
			npcX = losNPCs[unNPC][0];
			npcY = losNPCs[unNPC][1];
			if (movimiento <= 0.25 && elMapa[npcY][npcX - 1] % 2 == 0) {
				npcX = npcX - 1;
			} else if (movimiento <= 0.5 && elMapa[npcY][npcX + 1] % 2 == 0) {
				npcX = npcX + 1;
			} else if (movimiento <= 0.75 && elMapa[npcY - 1][npcX] % 2 == 0) {
				npcY = npcY - 1;
			} else if (movimiento <= 1 && elMapa[npcY + 1][npcX] % 2 == 0) {
				npcY = npcY + 1;
			}
			losNPCs[unNPC][0] = npcX;
			losNPCs[unNPC][1] = npcY;
		}
	}

// Personajes ------------------------------------------------------------------------------------------------

	private static boolean hayNPC(int[][] losNPCs, int i, int j) {
		for (int unNPC = 0; unNPC < losNPCs.length; unNPC++) {
			if (losNPCs[unNPC][0] == j && losNPCs[unNPC][1] == i) {
				return true;
			}
		}
		return false;
	}
	private static void imprimeNPC() {
		System.out.print("^V^");
	}
	private static void imprimeElemento(int elementoDelMapa) {
		String[] matrizDeElementos = {"   ","[#]"," . ","111"," * ","."," @ "};
		System.out.print(matrizDeElementos[elementoDelMapa]);
	}
	

    // Game Over ----------------------------------------------------------------------------------------
    
    private static boolean gameover(int[][] elPersonaje, int[][] losNPCs) {
        for (int unNPC = 0; unNPC < losNPCs.length; unNPC++) {
            if((elPersonaje[0][0] == losNPCs[unNPC][0]) && (elPersonaje[0][1]== losNPCs[unNPC][1])){
                System.out.println("Game over!");
                return false;
            }
            
        }
        return true;
    }
}