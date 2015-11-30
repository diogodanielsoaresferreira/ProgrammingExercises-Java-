/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

public class Data2 {

	private int dia;
	private int mes;
	private int ano;
	
	Data2(int dia, int mes, int ano){
		this.dia=dia;
		this.mes=mes;
		this.ano=ano;
	}
	
	public int getday(){
		return this.dia;
	}
	
	public int getmonth(){
		return this.mes;
	}
	
	public int getyear(){
		return this.ano;
	}
	
	public boolean igualA(Data2 x){
		if(x.ano == this.ano && x.mes == this.mes && x.dia == this.dia){
			return true;
		}
		else return false;
	}
	
	public boolean menorDoQue(Data2 x){
		if(this.ano<x.ano || (this.ano==x.ano && this.mes<x.mes) || (this.ano==x.ano && this.mes==x.mes && this.dia<x.dia)){
			return true;
		}
		else 
			return false;
	}
	
	public boolean maiorDoQue(Data2 x){
		if(this.ano>x.ano || (this.ano==x.ano && this.mes>x.mes) || (this.ano==x.ano && this.mes==x.mes && this.dia>x.dia)){
			return true;
		}
		else return false;
	}
	
	public String escreve(){
		return(this.dia + "-" + this.mes + "-" + this.ano);
		
	}
}
