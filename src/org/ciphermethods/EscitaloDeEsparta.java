package org.ciphermethods;

public class EscitaloDeEsparta {
	
	private char[][] matrizInicial;
	private char[][] matrizFinal;
	
	private int numFilas;
	private int numCols;
	
	private String[] clave;
	
	private String textoEntrada;
	private String textoEncriptado = "";
	private String textoSalida = "";
	
	
	private void encriptarEscitaloDeEsparta(){
		
		numFilas = 7;
		numCols = 5;
		
		matrizInicial = new char[numCols][numFilas];
		
		textoEntrada = "El perro de San Roque notiene rabo.";
		
		rellenarTextoEntrada();
		
		rellenarmatrizInicialConEntrada();
		
		imprimirMatriz(matrizInicial);
		
		clave = new String[numCols];
		
		crearClave(32154);
		
		//imprimirClave();
		
		generartextoEncriptado();
		
		imprimirtextoEncriptado();
		
	}
	
	private void desencriptarEscitaloDeEsparta(){
		
		reconstruirmatrizInicial();
		generarTextoSalida();
		imprimirtextoSalida();
		
		
	}
	
	

	private void reconstruirmatrizInicial() {
		
		matrizFinal = new char[numCols][numFilas];
		String subStr;
		String encriptadoAux = textoEncriptado;
		
		
		
			
		
			for(int i = 0; i < numCols ; i++){
				
				
				subStr = encriptadoAux.substring(0, numFilas);
				
				encriptadoAux = encriptadoAux.substring(numFilas);
				
				escribirColumna(Integer.parseInt(clave[i]),subStr);
			}
	}
	
	private void generarTextoSalida() {
		
		for(int i = 0; i < numFilas; i++){
			for(int j = 0; j < numCols; j++){
			
				textoSalida = textoSalida + matrizFinal[j][i];
				
			}
			
		}
		
	}

	private void generartextoEncriptado() {
		
		for(int i = 0; i < numCols; i++){
			leerColumna(Integer.parseInt(clave[i]));
		}
		
	}
	
	private void leerColumna(int pCol){
		
		for(int i = 0; i < numFilas; i++){
			if(matrizInicial[pCol-1][i] != ' '){
				textoEncriptado = textoEncriptado + matrizInicial[pCol-1][i];
			}
			else{
				textoEncriptado = textoEncriptado + '_';
			}
			
		}
		
	}
	
	private void escribirColumna(int pCol, String subStr){
		
		for(int i = 0; i < numFilas; i++){
			
			if(subStr.charAt(i) != '_'){
				matrizFinal[pCol-1][i] = subStr.charAt(i);
			}
			else{
				matrizFinal[pCol-1][i] = ' ';
			}
		}
		
	}

	private void crearClave(Integer pClave){
		
		String strClave = Integer.toString(pClave);
		
		for(int i = 0; i < clave.length; i++){
			
			clave[i] = strClave.substring(i,i+1);
		}
		
		
	}

	private void rellenarmatrizInicialConEntrada(){
		
		int cont = 0;
		
		for(int i = 0; i < numFilas; i++){
			for(int j = 0; j < numCols; j++){
					
				matrizInicial[j][i] = textoEntrada.charAt(cont);
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
					System.out.print(pMatriz[j][i] + " ");
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
	private void imprimirtextoEncriptado(){
		System.out.println(textoEncriptado);
	}
	
	//Pruebas
	private void imprimirtextoSalida(){
		System.out.println(textoSalida);
	}
		
	

	public static void main(String[] args) {
		EscitaloDeEsparta ede = new EscitaloDeEsparta();
		ede.encriptarEscitaloDeEsparta();
		ede.desencriptarEscitaloDeEsparta();
		
		
		
	}

}
