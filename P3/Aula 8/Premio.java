/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula8;

public enum Premio {
	VINTE_CINCO(25),CINQUENTA(50),CENTOEVINTECINCO(125),DUZENTOSECINQUENTA(250),QUINHENTOS(500),SETECENTOSECINQUENTA(750),MILEQUINHENTOS(1500),
	DOISMILEQUINHENTOS(2500),CINCOMIL(5000),DEZMIL(10000),DEZASSEISMIL(16000),TRINTAEDOISMIL(32000),SESSENTAEQUATROMIL(64000),CENTOEVINTECINCOMIL(125000),DUZENTOSECINQUENTAMIL(250000);
	
	private int num;
	Premio(int num){
		this.num=num;
	}
	
	public int getNum(){
		return num;
	}
	
	public static Premio next(Premio p){
		
		Premio p2 = null;
		
		switch(p.getNum()){
		case 25:
			p2=CINQUENTA;
			break;
		case 50:
			p2=CENTOEVINTECINCO;
			break;
		case 125:
			p2=DUZENTOSECINQUENTA;
			break;
		case 250:
			p2=QUINHENTOS;
			break;
		case 500:
			p2=SETECENTOSECINQUENTA;
			break;
		case 750:
			p2=MILEQUINHENTOS;
			break;
		case 1500:
			p2=DOISMILEQUINHENTOS;
			break;
		case 2500:
			p2=CINCOMIL;
			break;
		case 5000:
			p2=DEZMIL;
			break;
		case 10000:
			p2=DEZASSEISMIL;
			break;
		case 16000:
			p2=TRINTAEDOISMIL;
			break;
		case 32000:
			p2=SESSENTAEQUATROMIL;
			break;
		case 64000:
			p2=CENTOEVINTECINCOMIL;
			break;
		case 125000:
			p2=DUZENTOSECINQUENTAMIL;
			break;
		case 250000:
			break;
		
		}
		return p2;
	}
	
}
