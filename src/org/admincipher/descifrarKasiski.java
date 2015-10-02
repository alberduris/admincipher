package org.admincipher;

public class descifrarKasiski {
	private String textoADescifrar;
	private String textoDescifrado;
	private int tamanoClave;
	private String clave;
	
	public descifrarKasiski(String pTexto, int pTamano){
		textoADescifrar = "";
		for(int i =0; i<pTexto.length(); i++){
			if(pTexto.charAt(i) <= 90 && pTexto.charAt(i) > 64){
				textoADescifrar += pTexto.charAt(i);
			}
		}
		tamanoClave = pTamano;
		clave = "";
		sacarClave();
	}
	
	private void sacarClave(){
		int cant = (textoADescifrar.length()/tamanoClave)+1;
		int j = 0;
		char[][] cript= new char[tamanoClave][cant];
		for(int k = 0; k < tamanoClave; k++){
			for(int i =k; i<textoADescifrar.length(); i = i+tamanoClave){
				cript[k][j] = textoADescifrar.charAt(i);
				j++;
			}
			j = 0;
		}		
		int[][] tabla = ordenar(cript);
		//imprimir(tabla);
		int[] claveFinal = new int[tamanoClave];
		for(int i=0; i<tamanoClave; i++){
			claveFinal[i] = sacarLetraClave(tabla[i]);
		}
		for(int i=0; i<claveFinal.length; i++){
			clave += String.valueOf(Character.toChars(claveFinal[i]+65));				
		}		
		System.out.println(clave);
	}
	
	private void imprimir(int[][] pTabla){
		for(int i= 0; i<tamanoClave; i++){
			for(int j=0; j<26; j++){
				System.out.print(pTabla[i][j] +" ");
			}
			System.out.println("");
		}
	}
	
	private int[][] ordenar(char[][] s){
		int[][] tabla = new int[tamanoClave][26];
		for(int k= 0; k<tamanoClave; k++){
			for(int i = 0; i< s[k].length; i++){
				if(s[k][i] > 0){
					tabla[k][s[k][i]-65] ++;
				}
			}			
		}
		
		return tabla;
	}
	
	private int sacarLetraClave(int[] pLista){
		int[] posibilidadesE = new int[0];
		int[] posibilidadesA = new int[0];
		int[] posibilidadesO = new int[0];
		int[] posibilidadesS = new int[0];
		int E = buscarMaximo(pLista,posibilidadesE , posibilidadesA, posibilidadesS);
		posibilidadesE = buscarPosiciones(pLista, E);
		int A = buscarMaximo(pLista, posibilidadesE, posibilidadesA, posibilidadesS);
		posibilidadesA = buscarPosiciones(pLista, A);
		int O = buscarMaximo(pLista, posibilidadesE, posibilidadesA, posibilidadesS);
		posibilidadesO = buscarPosiciones(pLista, O);
		int S = buscarMaximo(pLista, posibilidadesE, posibilidadesA, posibilidadesO);
		posibilidadesS = buscarPosiciones(pLista, S);
		System.out.println("la S es:"+S);
		int[] todos = new int[posibilidadesE.length+posibilidadesA.length+posibilidadesO.length+posibilidadesS.length];
		for(int i=0; i<posibilidadesE.length;i++){
			todos[i] = posibilidadesE[i];
		}
		int j = 0;
		for(int i=posibilidadesE.length; i<posibilidadesE.length+posibilidadesA.length;i++){
			todos[i] = posibilidadesA[j];
			j++;
		}
		j = 0;
		for(int i=posibilidadesE.length+posibilidadesA.length; i<posibilidadesE.length+posibilidadesA.length+posibilidadesO.length;i++){
			todos[i] = posibilidadesO[j];
			j++;
		}
		j = 0;
		for(int i=posibilidadesE.length+posibilidadesA.length+posibilidadesO.length; i<todos.length;i++){
			todos[i] = posibilidadesS[j];
			j++;
		}
		return sacarAEO(todos)[0];
	}
	
	private int[] sacarAEO(int[] pTodos){
		int[] posible = new int[3];
		int[] todos = pTodos;
		int numAuxCuatro = 0;
		int numAuxDiez = 0;
		boolean fin = false;
		for(int i= 0; i<todos.length && !fin; i++){
			numAuxCuatro = todos[i] + 4;
			if(numAuxCuatro > 25){
				numAuxCuatro -= 26;
			}
			numAuxDiez = numAuxCuatro + 10;
			if(numAuxDiez > 25){
				numAuxDiez -= 26;
			}
			System.out.println("con:" + todos[i] +" E:" + numAuxCuatro + " O:" + numAuxDiez);
			if(comprobar(todos, numAuxCuatro) && comprobar(todos, numAuxDiez)){
				posible[0] = todos[i];
				posible[1] = numAuxCuatro;
				posible[2] = numAuxDiez;
				fin = true;
			}
			System.out.println(posible[0]);
		}
		return posible;
	}
	
	private boolean comprobar(int[] pTodos, int pValor){
		boolean fin = false;
		for(int i=0; i<pTodos.length && !fin; i++){
			if(pValor == pTodos[i]){
				fin = true;
			}
		}
		System.out.println(pValor + "es:"+ fin);
		return fin;
	}
	
	private int buscarMaximo(int[] pLista, int[] pE, int[] pA, int[] pO){
		int numero = 0;
		if(pE.length == 0){
			for(int i=0; i<pLista.length; i++){
				if(pLista[numero] < pLista[i]){
					numero = i;
				}
			}
		}else{
			if(pA.length == 0){
				for(int i=0; i<pLista.length; i++){
					if(pLista[numero] < pLista[i] && !mismo(pE, i)){
						numero = i;
					}
				}
			}else{
				if(pO.length == 0){
					for(int i=0; i<pLista.length; i++){
						if(pLista[numero] < pLista[i] && !mismo(pE, i) && !mismo(pA, i)){
							numero = i;
						}
					}
				}else{
					for(int i=0; i<pLista.length; i++){
						if(pLista[numero] < pLista[i] && !mismo(pE, i) && !mismo(pA, i) && !mismo(pO,i)){
							numero = i;
						}
					}
				}
			}
		}
		return numero;
	}
		
	private int[] buscarPosiciones(int[] pLista, int pNum){
		int[] numeros = new int[0];
		for(int i=0; i<pLista.length; i++){
			if(pLista[i] == pLista[pNum]){
				int[] numerosAux = new int[numeros.length];
				for(int j=0; j< numeros.length; j++){
					numerosAux[j] = numeros[j];
				}
				numeros = new int[numerosAux.length + 1];
				for(int j=0; j< numerosAux.length; j++){
					numeros[j] = numerosAux[j];
				}
				numeros[numeros.length-1] = i;
			}
		}
		return numeros;
	}
	
	public boolean mismo(int[] pLista, int pPos){
		boolean mismo = false;
		for(int i=0; i< pLista.length && !mismo; i++){
			if(pLista[i] == pPos){
				mismo = true;
			}
		}
		return mismo;
	}
	
	public static void main(String [] args){
		descifrarKasiski dK = new descifrarKasiski("WEDFM     LHRRV     WCODE     JBORC     WLIEK     VHIEN     MWASV     WFEED     WFUIS  GXSKB     SGGLV     SWOEK     VBEYK     TBAVX     LKAUY     WGLRM     SLAZX     VNDRL     DXMVX   LXNRN     AXYRE     FJUVO     DWOTD     GKDFB     EBATY     FXLSK     DVOEK     TBEID     GIOIR   AZIVX     WXRRD     SGACD     GLUGS     KHQLO     FHEIK     VXSLZ     GGEIA     MXPFB     SELZR  MUIVC     WXNKB     SWOVV     SLEJS     FHLRZ     GEITS     SGOVX     UHNKB     SUACK     HBSKK  VXAHE     WECIS  EXNPI     SBBRK     SUAEN     GGAIO     DTSLX     LHCLK     FWOCK     WLPFC    SRLRM     JBAUK     VXLDE     WKTFK     UNDZO     JHNUO     KIAMY     JBDRC     SEAAO     XTTLB   SLACD     SGDFN     WEORV     LHDVE     FTRDK     JBOYK     TBATK     AWOJY     TKECK     EXSRV  SLHRL     ATMZB     SWOCK     KAASS     SOIJD     GRDVC     HNEJR     SUIRR     MBDFZ     GKLRR  SUIKK     UBOEE     FTMRX     GLOCS     LTRZK     QOIMK     UHMFE     FTAIK     FTACV     AEAYK    TBAEN     WCAUY    WGCVB     JTDRM     GGLCK     NXEEO     DVURB     LHLCO     FTDVD   WKRFB     SVUUS     GEAGY     DBCZK     QXLAE     WSEIK     KNDVL     WKTIK     TTJFV     WLCFC   LHCRJ     SKLRW     SGOGO     JHLRM     SSAIY     FRTFN     GLLVK     YTRIK     JHNLX     VXDFZ   GKQLO     WKAMS     YHRFC     SVOIX     GLIVX     WELRB     SWITK     KXJLX     LTTFN     SEAWE    WKZRN     WNNYY     EURVP     MXRKO     INEYK     UXRTY     FXLCK     INECE     RBBRK     SKRFT   SKSFL     JXECC     MVEJY     UHMFC     WGTVX     UBAIV     SWEHE     AXNVB     STQLO     DEADK  FHDVC     HNEJN     WNNRV     SKGRZ     SNSRK     DCUVJ     KXLVY     UNRIS     GWAIV     WEAGV    MFAGK     JTQLO     VXCCK     JTSVZ     GKEJM     JBTFV     SFAEY     WGTFX     UXSVC     UKISS  GLOPV     SFAEY     VXRRW     AKOIE     ASAJO     KBNRN     GOICW     WGTVZ     GKECN     GVTFB   WGECR     GLPZD     SEYUO     KMRFJ     SWOTY     FXNJK     FTMZO     FMOVX     DTSRV     SWEUS  KXCTS     GGHVR     WVHFT     MLTZM  ATRVV     SMOKS     LNLRN     GEADK     FHEJM     JBTFZ   GKRRW     GGGFW     WSDVV     SLEIX     S ", 5);
	}
}
