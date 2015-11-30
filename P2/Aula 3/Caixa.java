/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;

public class Caixa {

	long [] moedas=new long [0];
	
	public void adicionaMoeda(long m){
		long [] b = new long[moedas.length + 1];
		
		for(int i=0;i<moedas.length;i++){
			b[i] = moedas[i];
		}
		b[moedas.length] = m;
		moedas=b;
	}
	
	public void retiraDinheiro(long min){
		if(total()<min){
			out.print("Não há dinheiro suficiente!");
			return;
		}
		
		boolean troca=false;
		do{
			troca=false;
			for(int i=0;i<this.moedas.length-1;i++){
				if(moedas[i+1]<moedas[i]){
					long temp;
					temp=moedas[i];
					moedas[i]=moedas[i+1];
					moedas[i+1]=temp;
					troca=true;
				}
			}
			
		}while(troca);
		
		for(int i=moedas.length-1;i>=0;i--){
			long temp=moedas[i];
			moedas[i]=0;
			if(total()<min){
				moedas[i]=temp;
				return;
			}
		}
	}
	
	public long total(){
		int sum=0;
		for(int i=0;i<moedas.length;i++){
			sum+=moedas[i];
		}
		return sum;
	}
	
	public long [] moedas(){
		return moedas();
	}
}