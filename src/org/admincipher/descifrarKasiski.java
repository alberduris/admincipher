package org.admincipher;

public class descifrarKasiski {
	private static descifrarKasiski miKasiski;
	private String textoADescifrar;
	private int tamanoClave;
	private String clave;
	
	private descifrarKasiski(){
	}
	
	public static descifrarKasiski getKasiski(){
		if(miKasiski == null){
			miKasiski = new descifrarKasiski();
		}
		return miKasiski;
	}
	
	public void introducirTexto(String pTexto){
		textoADescifrar = "";
		for(int i =0; i<pTexto.length(); i++){
			if(pTexto.charAt(i) <= 90 && pTexto.charAt(i) > 64){
				textoADescifrar += pTexto.charAt(i);
			}
		}
	}
	
	public void introducirTamanoClave(int pTamano){
		tamanoClave = pTamano;
	}
	
	public int[][] sacarClave(){
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
		return(tabla);
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
		
	private boolean mismo(int[] pLista, int pPos){
		boolean mismo = false;
		for(int i=0; i< pLista.length && !mismo; i++){
			if(pLista[i] == pPos){
				mismo = true;
			}
		}
		return mismo;
	}
	
	public static void main(String [] args){
		descifrarKasiski dK = descifrarKasiski.getKasiski();
		dK.introducirTexto("WEDFM     LHRRV     WCODE     JBORC     WLIEK     VHIEN     MWASV     WFEED     WFUIS  GXSKB     SGGLV     SWOEK     VBEYK     TBAVX     LKAUY     WGLRM     SLAZX     VNDRL     DXMVX   LXNRN     AXYRE     FJUVO     DWOTD     GKDFB     EBATY     FXLSK     DVOEK     TBEID     GIOIR   AZIVX     WXRRD     SGACD     GLUGS     KHQLO     FHEIK     VXSLZ     GGEIA     MXPFB     SELZR  MUIVC     WXNKB     SWOVV     SLEJS     FHLRZ     GEITS     SGOVX     UHNKB     SUACK     HBSKK  VXAHE     WECIS  EXNPI     SBBRK     SUAEN     GGAIO     DTSLX     LHCLK     FWOCK     WLPFC    SRLRM     JBAUK     VXLDE     WKTFK     UNDZO     JHNUO     KIAMY     JBDRC     SEAAO     XTTLB   SLACD     SGDFN     WEORV     LHDVE     FTRDK     JBOYK     TBATK     AWOJY     TKECK     EXSRV  SLHRL     ATMZB     SWOCK     KAASS     SOIJD     GRDVC     HNEJR     SUIRR     MBDFZ     GKLRR  SUIKK     UBOEE     FTMRX     GLOCS     LTRZK     QOIMK     UHMFE     FTAIK     FTACV     AEAYK    TBAEN     WCAUY    WGCVB     JTDRM     GGLCK     NXEEO     DVURB     LHLCO     FTDVD   WKRFB     SVUUS     GEAGY     DBCZK     QXLAE     WSEIK     KNDVL     WKTIK     TTJFV     WLCFC   LHCRJ     SKLRW     SGOGO     JHLRM     SSAIY     FRTFN     GLLVK     YTRIK     JHNLX     VXDFZ   GKQLO     WKAMS     YHRFC     SVOIX     GLIVX     WELRB     SWITK     KXJLX     LTTFN     SEAWE    WKZRN     WNNYY     EURVP     MXRKO     INEYK     UXRTY     FXLCK     INECE     RBBRK     SKRFT   SKSFL     JXECC     MVEJY     UHMFC     WGTVX     UBAIV     SWEHE     AXNVB     STQLO     DEADK  FHDVC     HNEJN     WNNRV     SKGRZ     SNSRK     DCUVJ     KXLVY     UNRIS     GWAIV     WEAGV    MFAGK     JTQLO     VXCCK     JTSVZ     GKEJM     JBTFV     SFAEY     WGTFX     UXSVC     UKISS  GLOPV     SFAEY     VXRRW     AKOIE     ASAJO     KBNRN     GOICW     WGTVZ     GKECN     GVTFB   WGECR     GLPZD     SEYUO     KMRFJ     SWOTY     FXNJK     FTMZO     FMOVX     DTSRV     SWEUS  KXCTS     GGHVR     WVHFT     MLTZM  ATRVV     SMOKS     LNLRN     GEADK     FHEJM     JBTFZ   GKRRW     GGGFW     WSDVV     SLEIX     S ");
		dK.introducirTamanoClave(5);
		dK.sacarClave();
	}
}
