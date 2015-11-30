package p1;
import static java.lang.System.*;
import java.util.Scanner;

public class Ex905 {

	static final Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		int num[];
		double med;
		double desv;
		
		num = lerNum();
		med = calcMed(num);
		out.print("A m�dia vai ser " + med + ".");
		desv = calcDes(num);
		out.print("\nO desvio-padr�o � de " + desv + ".");
		
		
	}
	
	public static int[] lerNum(){
		
		int a;
		
		out.print("\nQuantos n�mero reais vai introduzir? ");
		a = sc.nextInt();
		while(a<=0){
			out.print("\nEntrada inv�lida. Quantos n�meros reais vai introduzir? ");
			a = sc.nextInt();
		}
		
		int num[] = new int[a];
		
		for(int i=0; i<num.length; i++){
			out.print("\nInsira um n�mero: ");
			num[i] = sc.nextInt();
		}
		return num;
	}

	public static double calcMed(int num[]){
		int soma=0;
		double media=0;
		
		for(int i=0; i<num.length; i++){
			soma+=num[i];
		}
		
		media = soma/num.length;
		
		return media;
	}

	public static double calcDes(int num[]){
		
		int soma=0;
		double desv;
	
		for(int i=0; i<num.length; i++){
			soma+=Math.pow((num[i]-calcMed(num)),2);
		}
		
		desv=Math.sqrt((soma)/(num.length-1));
		
		return desv;
	}
}
