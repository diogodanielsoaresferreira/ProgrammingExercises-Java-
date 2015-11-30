package p1;

import java.util.Scanner;

// Complete o programa
public class Ex603 {
  static final Scanner sc = new Scanner(System.in);
  
  public static void main(String[] args) {
    // Cria um registo de estatisticas:
    Statistics xstat = new Statistics();
    
    // Enquanto houver um valor para ler:
    while (sc.hasNextDouble()) {
      // Lê um valor:
      double x = sc.nextDouble();
      // Atualiza o registo de estatisticas:
      updateStats(xstat, x);
    }
    
    // Escreve resultados:
    System.out.printf("min = %f\n", xstat.min);
    System.out.printf("max = %f\n", xstat.max);
    System.out.printf("numero de valores = %f\n", xstat.num);
    System.out.printf("soma dos valores = %f\n", xstat.sum);
    System.out.printf("soma dos quadrados = %f\n", xstat.sum2);
    System.out.printf("média = %f\n", mean(xstat));
    System.out.printf("variancia = %f\n", variance(xstat));
  }

  // Definir funções updateStats, mean e variance!
  public static void updateStats(Statistics xstat, double x){
		
		if (x<=xstat.min){
			xstat.min=x;
		}
		
		if (x>=xstat.max){
			xstat.max=x;
		}
		
		xstat.num += 1;
		
		if(xstat.num==1){
			xstat.max=x;
			xstat.min=x;
		}
		
		xstat.sum += x;
		
		xstat.sum2 += Math.pow(x, 2);
		
	}

	public static double mean(Statistics xstat){
		double m;
		
		m = (xstat.sum)/(xstat.num);
		
		return m;
	}

	public static double variance(Statistics xstat){
		double v;
		
		v = Math.sqrt((xstat.sum2/xstat.num)-Math.pow(mean(xstat) ,2));
		
		
		return v;
	}
	
	public static class Statistics{
		double min;
		double max;
		double num=0;
		double sum=0;
		double sum2=0;
	}
}

