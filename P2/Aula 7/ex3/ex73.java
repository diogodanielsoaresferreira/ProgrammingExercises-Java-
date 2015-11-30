/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;
import java.util.Scanner;
import java.math.*;

public class ex73
{
   static Scanner sc = new Scanner(System.in);

   public static void main(String[] args)
   {
      int min = 0, max = 0;

      try {
         min = Integer.parseInt(args[0]);
         max = Integer.parseInt(args[1]);
      }
      catch (ArrayIndexOutOfBoundsException e) {
         out.println("ERRO: número de argumentos insuficiente");
         exit(1);
      }
      catch (NumberFormatException e) {
         out.println("ERRO: formato inválido");
         exit(1);
      }

      boolean result = iGuessIt(min,max);    

      if (result) out.println("\nYES! Sou um programa mesmo inteligente ;-)");
      else out.println("\nQue pena :(");
   }
 
   public static boolean iGuessIt(int min, int max) 
   {

	   int a =(int)(Math.random()*(max-min)+min);
	   System.out.println("Digo o número  " + a + ".");
	   int b = getFeedback();
	   
	   switch(b){
		   case 1:
			   return true;
		   case 2:
			   return (iGuessIt(a+1,max));
		   case 3:
			   return (iGuessIt(min,a-1));
		  default:
			   return false;
	   }
   }

   public static int getFeedback() {
      showOptions();
      int a = 0;;
      try{
    	  a = sc.nextInt();
    	  if(a<0 || a>3) throw new NumberFormatException();
      }
      catch(NumberFormatException e){
    	  System.out.println("Informação inválida!");
    	  getFeedback();
      }
      
      return a;
   }

   public static void showOptions() {
      out.println("\nQual o seu comentário?");
      out.println("  1 - Sucesso! O programa descobriu o meu número secreto");
      out.println("  2 - Número secreto é mais alto");
      out.println("  3 - Número secreto é mais baixo");
      out.println("  0 - Perdi a paciência e quero terminar o jogo");
      out.print("> ");
   }
}

