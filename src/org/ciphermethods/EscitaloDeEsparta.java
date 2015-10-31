package org.ciphermethods;

public class EscitaloDeEsparta {
	
	private char[][] matriz;
	
	
	private int numFilas;
	private int numCols;
	
	private String[] clave;
	
	private String textoEntrada;
	private String textoSalida = "";
	
	
	private void encriptarEscitaloDeEsparta(){
		
		numFilas = 7;
		numCols = 5;
		
		matriz = new char[numCols][numFilas];
		
		textoEntrada = "El perro de San Roque notiene rabo.";
		
		rellenarTextoEntrada();
		
		rellenarMatrizConEntrada();
		
		imprimirMatriz(matriz);
		
		clave = new String[numCols];
		
		crearClave(32154);
		
		//imprimirClave();
		
		generarTextoSalida();
		
		imprimirTextoSalida();
		
		
		//TODO
		
	}
	
	private void generarTextoSalida() {
		
		for(int i = 0; i < numCols; i++){
			leerColumna(Integer.parseInt(clave[i]));
		}
		
	}
	
	private void leerColumna(int pCol){
		
		for(int i = 0; i < numFilas; i++){
			if(matriz[pCol-1][i] != ' '){
				textoSalida = textoSalida + matriz[pCol-1][i];
			}
			else{
				textoSalida = textoSalida + '_';
			}
			
		}
		
	}

	private void crearClave(Integer pClave){
		
		String strClave = Integer.toString(pClave);
		
		for(int i = 0; i < clave.length; i++){
			
			clave[i] = strClave.substring(i,i+1);
		}
		
		
	}

	private void rellenarMatrizConEntrada(){
		
		int cont = 0;
		
		for(int i = 0; i < numFilas; i++){
			for(int j = 0; j < numCols; j++){
					
				matriz[j][i] = textoEntrada.charAt(cont);
				cont++;
			}
					
		}
		
	}

	private void rellenarTextoEntrada() {
		for(int i = textoEntrada.length() ; i < numFilas*numCols; i++){
			textoEntrada = textoEntrada + " ";
		}
	}
	
	
	//Pruebas
	private void imprimirMatriz(char[][] pMatriz){
		
		for(int i = 0; i < numFilas; i++){
			for(int j = 0; j < numCols; j++){
					System.out.print(matriz[j][i] + " ");
				
			}
			System.out.println();
		}
		
	}
	
	//Pruebas
	private void imprimirClave(){
		for(int i = 0; i < clave.length; i++){
			System.out.print(clave[i]+" - ");
		}
		System.out.println();
	}
	
	//Pruebas
	private void imprimirTextoSalida(){
		System.out.println(textoSalida);
	}
	

	public static void main(String[] args) {
		EscitaloDeEsparta ede = new EscitaloDeEsparta();
		ede.encriptarEscitaloDeEsparta();
		
		
		
	}

}
