/**
 * Universidade de Aveiro, 2015
 * Programação 3
 * Mestrado Integrado em Engenharia de Computadores e Telemática
 * Diogo Daniel Soares Ferreira
 * Nº. Mec: 76504
 */
package aula3;

public class Clientes {
	
	private static long num;
	private long socio;
	private Data insc;
	private String nome;
	private long CC;
	private Data nasc;
	private int n;
	private Videos[] vid = new Videos[0];
	
	public Clientes(Data insc, String nome, long CC, Data nasc, int n){
		assert Data.validarData(insc.getYear(), insc.getMonth(), insc.getDay());
		assert Data.validarData(nasc.getYear(), nasc.getMonth(), nasc.getDay());
		assert CC>0;
		num ++;
		socio = num;
		this.insc = insc;
		this.nome = nome;
		this.CC = CC;
		this.nasc = nasc;
		this.n = n;
	}
	
	public long getSocio(){
		return socio;
	}
	
	public Data getInsc(){
		return insc;
	}
	
	public String getNome(){
		return nome;
	}
	
	public long getCC(){
		return CC;
	}
	
	public Data getNasc(){
		return nasc;
	}
	
	public void addVid(Videos v){
		Videos[]c = new Videos[vid.length+1];
		for(int i=0;i<vid.length;i++){
			c[i] = vid[i];
		}
		c[vid.length] = v;
		vid=c;
	}
	
	public Videos[] getHist(){
		return vid;
	}
	
	public int getNLeft(){
		return n-vid.length;
	}
	
}
