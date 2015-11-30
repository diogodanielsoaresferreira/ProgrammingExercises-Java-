package p1;

import java.util.Scanner;


public class Ex601 {
  static final Scanner sc = new Scanner(System.in);
  
  public static void main(String[] args) {
    Hora inicio;  // tem de definir o novo tipo Hora!
    Hora fim;
    
    inicio = new Hora();
    fim = new Hora();
    inicio.h = 9;
    inicio.m = 23;
    inicio.s = 5;
    
    System.out.print("Começou às ");
    printHora(inicio);  // crie esta função!
    System.out.println(".");
    System.out.println("Quando termina?");
    fim = lerHora();  // crie esta função!
    System.out.print("Início: ");
    printHora(inicio);
    System.out.print(" Fim: ");
    printHora(fim);
  }
  
  public static Hora  lerHora(){
	  int hl, ml, sl;
	  
	  Hora n;
	  n = new Hora();
	  
	  System.out.print("Insira a hora: "); 
	  hl = sc.nextInt();
	  while (hl<=0 || hl>=23){
		  
		  System.out.println("\nInsira um valor entre 0 e 23: ");
		  hl = sc.nextInt();
		  
	  }
	  n.h=hl;
	  
	  System.out.print("\nInsira os minutos: ");
	  ml = sc.nextInt();
	  
	  while (ml<=0 || ml>=59){
		  
		  System.out.println("\nInsira um valor entre 0 e 59: ");
		  ml = sc.nextInt();  
	  }
	  
	  n.m=ml;
 
	  System.out.print("\nInsira os segundos: ");
	  sl = sc.nextInt();
	  
	  while (sl<=0 || sl>=59){
		  
		  System.out.println("\nInsira um valor entre 0 e 59: ");
		  sl = sc.nextInt();
		  
	  }
	  n.s=sl;
	
	  return n;
  }
  
  public static void printHora(Hora x){
	  System.out.println(x.h + ":" + x.m + ":" + x.s);
	  
  }
  
public static class Hora{
	  public int h;
	  public int m;
	  public int s;  
  }
  
}

/**
EXEMPLO do pretendido:
$ java TestaHora
Começou às 09:23:05.
Quando termina?
horas? 11
minutos? 72
minutos? 7
segundos? 2
Início: 09:23:05 Fim: 11:07:02.
**/
