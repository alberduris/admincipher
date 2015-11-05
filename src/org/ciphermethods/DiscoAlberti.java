package org.ciphermethods;

public class DiscoAlberti {
	int movimiento;
	boolean direccion;
	char[] original;
	char[] aMover;
	
	public DiscoAlberti(){
		movimiento =1; 
		crearPrincipal();
	}
	
	public void introducirClave(String pClave){
		posicionarInicial(pClave);
	}
	
	public void introducirDireccion(boolean pDirec){
		direccion = pDirec;
	}
	
	public void introducirMovimiento(int pMov){
		movimiento = pMov;
	}
	
	private void crearPrincipal(){
		original = new char[24];
		for(int i = 0, j = 65; i < 20; i++, j++){
			while(j == 85 || j == 72 || j == 74 || j == 75 || j == 87 || j == 89 ){
				j ++;
			}
			original[i] = (char) j;
		}
		for(int i = 20, j=1; i < 24; i++, j++){
			original[i] = (char) (j+48);
		}
	}
	
	public void crearDiscoInterno(String pOrden){
		aMover = new char[24];
		for(int i=0; i<24; i++){
			aMover[i] = pOrden.charAt(i);
		}
		
	}
		
	public String cifrar(String pTexto){
		String cifrado ="";
		int aux = 0;
		for(int i= 0; i < pTexto.length(); i++){
			if(pTexto.charAt(i) < 90 && pTexto.charAt(i) > 64){
				if(pTexto.charAt(i) == 85 || pTexto.charAt(i) == 86){
					cifrado += aMover[17];
				}else{
					if(pTexto.charAt(i) > 89){
						aux = 6;
					}else if(pTexto.charAt(i) > 87){
						aux = 5;
					}else if(pTexto.charAt(i) > 86){
						aux = 4;
					}else if(pTexto.charAt(i) > 75){
						aux = 3;
					}else if(pTexto.charAt(i) > 74){
						aux = 2;
					}else if(pTexto.charAt(i) > 72){
						aux = 1;
					}else{
						aux = 0;
					}
					cifrado += aMover[pTexto.charAt(i)-65-aux];
				}
				if(direccion){
					girar(movimiento);
				}else{
					girar(24-movimiento);
				}
			}else if(pTexto.charAt(i) < 122 && pTexto.charAt(i) > 97){
				if(pTexto.charAt(i) == 117 || pTexto.charAt(i) == 118){
					cifrado += aMover[17];
				}else{
					cifrado += aMover[pTexto.charAt(i)-97];
				}
				if(direccion){
					girar(movimiento);
				}else{
					girar(24-movimiento);
				}				
			}else if(pTexto.charAt(i) == 32){
				cifrado += " ";
			}
		}
		return cifrado;
	}
	
	public String descifrar(String pTexto){
		String descifrado ="";
		boolean fin = false;
		for(int i= 0; i < pTexto.length(); i++){
			if(pTexto.charAt(i) != 32){
				fin = false;
				for(int j = 0; j<24 && !fin; j++){
					if(pTexto.charAt(i) == aMover[j]){
						fin = true;
						descifrado += original[j];
					}
				}
				if(direccion){
					girar(movimiento);
				}else{
					girar(24-movimiento);
				}
			}else{
				descifrado += " ";
			}
		}
		return descifrado;
	}
	
	private void girar(int pValor){
		char aux;
		while(pValor != 0){
			aux = aMover[aMover.length-1];
			for(int i = aMover.length-1; i>0; i--){
				aMover[i] = aMover[i-1];
			}
			aMover[0] = aux;
			pValor --;
		}
	}
	
	private void posicionarInicial(String pClave){
		int pos = 0, posAux = 0;
		boolean enc = false, fin = false;
		for(int i = 0; i<24 && !enc; i++){
			if(pClave.charAt(0) == original[i]){
				enc = true;
				pos = i;
			}
		}
		while(!fin){
			enc = false;
			for(int i = 0; i<24 && !enc; i++){
				if(pClave.charAt(1) == aMover[i]){
					enc = true;
					posAux = i;
				}
			}
			if(posAux == pos){
				fin = true;
			}else{
				girar(1);
			}
		}
	}
	
	public void imprimir(){
		for(int i = 0; i < original.length; i++){
			System.out.print(original[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < aMover.length; i++){
			System.out.print(aMover[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		DiscoAlberti dA = new DiscoAlberti();
		dA.crearDiscoInterno("qixkvptmrdlgazenbosfchty");
		dA.introducirClave("Ti");
		dA.introducirMovimiento(1);
		dA.introducirDireccion(true);
		
		String tx =dA.cifrar("LO LLEVO A CONOCER");
		System.out.println(tx);
		dA.introducirClave("Ti");
		System.out.println(dA.descifrar(tx));
	}
}
