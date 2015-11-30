package p1;

import java.util.Scanner;

public class Ex210 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int ano, mes, dia, ano2=0, mes2=0, dia2=0;
		int i=0;
		
		System.out.print("Insira aqui o ano: ");
		ano = sc.nextInt();
		System.out.println();
		
		System.out.print("Insira aqui o mes, de 1 a 12: ");
		mes = sc.nextInt();
		System.out.println();
		
		System.out.print("Insira aqui o dia: ");
		dia = sc.nextInt();
		System.out.println();

		if ((mes == 1) || (mes == 3)||(mes == 5)||(mes == 7)|| (mes == 8)||(mes == 10)||(mes == 12)){
			
			i=31;
			if(dia==31){
				if(mes==12){
					ano2=ano+1;
					mes2=1;
					dia2=1;
				}
				else{
					ano2=ano;
					mes2=mes+1;
					dia2=dia+1;
				}
			}
			else{
				
				ano2=ano;
				mes2=mes;
				dia2=dia+1;
				
			}
				
			
			
		}
		else if ((mes == 4) || (mes == 6)||(mes == 9)||(mes == 11)){
			
			i=30;
			if (dia==30){
				dia2=1;
				mes2=mes+1;
				ano2=ano;
			}
			else{
				dia2=dia+1;
				mes2=mes;
				ano2=ano;
				
			}
			
		}
		
		else if (mes==2){
			
			if((ano%4)==0){
				
				if((ano%100)==0){
					if((ano%400)==0){
						i=29;
						
						if(dia==29){
							dia2=1;
							mes2=3;
							ano2=ano;
						}
						else{
							dia2=dia+1;
							mes2=2;
							ano2=ano;
							
						}
						
					}
					else{
						i=28;
						if (dia==28){
							dia2=1;
							mes2=3;
							ano2=ano;
							
						}
						else{
							dia2=dia+1;
							mes2=2;
							ano2=ano;
							
						}
					}
					
					
				}
				
				else {
					i=29;
					if (dia==29){
						dia2=1;
						mes2=3;
						ano2=ano;
						
					}
					else{
						dia2=dia+1;
						mes2=2;
						ano2=ano;
					}
				}

				
			}
			else{
				i=28;
				if(dia==28){
					dia2=1;
					mes2=3;
					ano2=ano;
					
				}
				else{
					dia2=dia+1;
					mes2=2;
					ano2=ano;
				}
			}

			
		}
		
		System.out.println("O mes " + mes + " do ano " + ano + " tem " + i + " dias.");
		System.out.println("O dia seguinte é dia " + dia2 + " do mês " + mes2 + " do ano " + ano2 + ".");
		sc.close();
	}

}
