package org.ciphermethods;

public class Vigenere {
	private static Vigenere miVigenere;
	private String texto;
	private String textoClave;
	private String textoModificado;
	private char[][] sopa;
	
	private Vigenere(){
		crearSopa();
		textoModificado = "";
		texto = "";
	}
	
	public static Vigenere getDescifrarVigenere(){
		if(miVigenere == null){
			miVigenere = new Vigenere();
		}
		return miVigenere;
	}
	
	public void introducirTexto(String pTexto){
		texto = "";
		for(int i =0; i<pTexto.length(); i++){
			if(pTexto.charAt(i) <= 90 && pTexto.charAt(i) >= 65){
				texto += pTexto.charAt(i);
			}
		}
	}
	
	public void introducirClave(String pClave){
		int i =0;
		textoClave = "";
		while(textoClave.length() < texto.length()){
			textoClave += pClave.charAt(i);
			i++;
			if(i == pClave.length()){
				i = 0;
			}
		}
	}
	
	private void crearSopa(){
		sopa = new char[26][26];
		char digito = 'A';
		for(int i = 0; i<26; i++){
			sopa[i][0] = digito;
			digito ++;
		}
		for(int i = 0; i<26; i++){
			digito = sopa[i][0];
			digito++;
			for(int j = 1; j<26; j++){
				if(digito > 90){
					digito = 'A';
				}
				sopa [i][j] = digito;
				digito ++;
			}
		}
	}
	//para pruebas
	private void imprimirSopa(){
		for(int i = 0; i<26; i++){
			for(int j = 0; j<26; j++){
				System.out.print(sopa[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public String cifrar(){
		for(int i = 0; i<texto.length(); i++){
			if(texto.charAt(i) > 90 && texto.charAt(i) <64){
				textoModificado = textoModificado + ' ';
			}else{
				textoModificado = textoModificado + sopa[texto.charAt(i)-65][textoClave.charAt(i)-65];
			}
		}
		return textoModificado;
	}
	
	public String descifrar(){
		for(int i = 0; i<texto.length(); i++){
			if(texto.charAt(i) > 90 && texto.charAt(i) <64){
				textoModificado = textoModificado + ' ';
			}else{
				textoModificado = textoModificado + sacarLetra(texto.charAt(i), textoClave.charAt(i));
			}
		}
		return textoModificado;
	}
	
	private char sacarLetra(char pLetra, char pLetraClave){
		int i = 0;
		boolean encontrado = false;
		while(!encontrado){
			if(sopa[i][pLetraClave-65] == pLetra){
				encontrado = true;
			}else{
				i++;
			}
		}
		char caracter = (char) (i+65);
		return caracter;
	}

	
	public static void main(String [] args){
		Vigenere dV = Vigenere.getDescifrarVigenere();
		dV.introducirTexto("WEDFM     LHRRV     WCODE     JBORC     WLIEK     VHIEN     MWASV     WFEED     WFUIS  GXSKB     SGGLV     SWOEK     VBEYK     TBAVX     LKAUY     WGLRM     SLAZX     VNDRL     DXMVX   LXNRN     AXYRE     FJUVO     DWOTD     GKDFB     EBATY     FXLSK     DVOEK     TBEID     GIOIR   AZIVX     WXRRD     SGACD     GLUGS     KHQLO     FHEIK     VXSLZ     GGEIA     MXPFB     SELZR  MUIVC     WXNKB     SWOVV     SLEJS     FHLRZ     GEITS     SGOVX     UHNKB     SUACK     HBSKK  VXAHE     WECIS  EXNPI     SBBRK     SUAEN     GGAIO     DTSLX     LHCLK     FWOCK     WLPFC    SRLRM     JBAUK     VXLDE     WKTFK     UNDZO     JHNUO     KIAMY     JBDRC     SEAAO     XTTLB   SLACD     SGDFN     WEORV     LHDVE     FTRDK     JBOYK     TBATK     AWOJY     TKECK     EXSRV  SLHRL     ATMZB     SWOCK     KAASS     SOIJD     GRDVC     HNEJR     SUIRR     MBDFZ     GKLRR  SUIKK     UBOEE     FTMRX     GLOCS     LTRZK     QOIMK     UHMFE     FTAIK     FTACV     AEAYK    TBAEN     WCAUY    WGCVB     JTDRM     GGLCK     NXEEO     DVURB     LHLCO     FTDVD   WKRFB     SVUUS     GEAGY     DBCZK     QXLAE     WSEIK     KNDVL     WKTIK     TTJFV     WLCFC   LHCRJ     SKLRW     SGOGO     JHLRM     SSAIY     FRTFN     GLLVK     YTRIK     JHNLX     VXDFZ   GKQLO     WKAMS     YHRFC     SVOIX     GLIVX     WELRB     SWITK     KXJLX     LTTFN     SEAWE    WKZRN     WNNYY     EURVP     MXRKO     INEYK     UXRTY     FXLCK     INECE     RBBRK     SKRFT   SKSFL     JXECC     MVEJY     UHMFC     WGTVX     UBAIV     SWEHE     AXNVB     STQLO     DEADK  FHDVC     HNEJN     WNNRV     SKGRZ     SNSRK     DCUVJ     KXLVY     UNRIS     GWAIV     WEAGV    MFAGK     JTQLO     VXCCK     JTSVZ     GKEJM     JBTFV     SFAEY     WGTFX     UXSVC     UKISS  GLOPV     SFAEY     VXRRW     AKOIE     ASAJO     KBNRN     GOICW     WGTVZ     GKECN     GVTFB   WGECR     GLPZD     SEYUO     KMRFJ     SWOTY     FXNJK     FTMZO     FMOVX     DTSRV     SWEUS  KXCTS     GGHVR     WVHFT     MLTZM  ATRVV     SMOKS     LNLRN     GEADK     FHEJM     JBTFZ   GKRRW     GGGFW     WSDVV     SLEIX     S ");
		dV.introducirClave("STARK");
		System.out.println(dV.descifrar());
	}
}
