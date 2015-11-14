package org.ciphermethods;

import java.util.ArrayList;
import java.util.Random;

public class EscitaloDeEsparta {
	
	private char[][] matrizInicial;
	private char[][] matrizFinal;
	
	private int numFilas;
	private int numCols;
	
	private String[] clave;
	
	private String textoEntrada;
	private String textoEncriptado = "";
	private String textoSalida = "";
	
	
	public void encriptarEscitaloDeEsparta(){
		
		
		matrizInicial = new char[numCols][numFilas];
		
		rellenarTextoEntrada();
		
		rellenarmatrizInicialConEntrada();
		
		//crearClave();
		//System.out.println("Imprimir clave: ");
		//imprimirClave();
		
		generartextoEncriptado();
		
		imprimirtextoEncriptado();
		
	}
	
	public void desencriptarEscitaloDeEsparta(){
		
		reconstruirmatrizInicial();
		generarTextoSalida();
		imprimirtextoSalida();
		
		
	}
	
	

	private void reconstruirmatrizInicial() {
		
		matrizFinal = new char[numCols][numFilas];
		String subStr = "";
		String encriptadoAux = textoEncriptado;
		
		
			for(int i = 0; i < numCols ; i++){
				
				if(encriptadoAux.length() >= numFilas){
					subStr = encriptadoAux.substring(0, numFilas);
					encriptadoAux = encriptadoAux.substring(numFilas);		
				}
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
			
			if(subStr.length() > i){
			
				if(subStr.charAt(i) != '_'){
					matrizFinal[pCol-1][i] = subStr.charAt(i);
				}
				else{
					matrizFinal[pCol-1][i] = ' ';
				}
			}
		}
		
	}

	public void crearClave(Integer pClave){
		
		clave = new String[numCols];
		
		String strClave = Integer.toString(pClave);
		
		for(int i = 0; i < clave.length; i++){
			
			clave[i] = strClave.substring(i,i+1);
		}
		
		
	}
	
	public String generarClaveAleatoria(){
		clave = new String[numCols];
		Random random = new Random();
		ArrayList<Integer> arrayAux = new ArrayList<Integer>();
		int aux = 0;
		int cont = 0;
		String strClave = "";
		boolean completo = false;
		
		while(!completo){
			
			aux = random.nextInt(numCols)+1;
			if(!arrayAux.contains(aux)){
				arrayAux.add(aux);
				clave[cont] = Integer.toString(aux);
				strClave = strClave + Integer.toString(aux);
				cont++;
			}
			if(cont == numCols) completo= true;
			
		}
		
		
		
		return strClave;
		 
		
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
	public void imprimirMatrizFinal(){
			
			for(int i = 0; i < numFilas; i++){
				for(int j = 0; j < numCols; j++){
						System.out.print(matrizFinal[j][i] + " ");
				}
				System.out.println();
			}
			
		}
	
	//Pruebas
	public void imprimirClave(){
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
	public void imprimirtextoSalida(){
		System.out.println(textoSalida);
	}
	
	public void imprimirFilasYColumnas(){
		System.out.println("Filas: "+numFilas);
		System.out.println("Columnas "+numCols);
	}
	
	public void setFilas(int pFilas){
		numFilas = pFilas;
	}
	
	public void setColumnas(int pColumnas){
		numCols = pColumnas;
	}
	public void setTexto(String pTexto){
		textoEntrada = pTexto;
	}
	
	public String getTextoEncriptado() {
		return textoEncriptado;
	}
	
	public String getTextoSalida(){
		return textoSalida;
	}

	public boolean longitudOk(int pFilas, int pCols, String pText) {
		
		boolean ok = false;
		if(pFilas*pCols >= pText.length()) ok = true;
		return ok;
	}
	
	public void reset(){
		numFilas = -1;
		numCols = -1;
		if(clave != null){
			for(int i = 0; i < clave.length; i++){
				clave[i] = "";
			}
		}
		textoEntrada = "";
		textoEncriptado = "";
		textoSalida = "";
		
	}
	
	public void setTextoEncriptado(String pText) {
	
		textoEncriptado = pText;
		
	}
	

	public static void main(String[] args) {
				
		
	}

	

	

}