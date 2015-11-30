/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;

public class ex75
{
   public static void main(String[] args)
   {
      double number = 0.0, epsilon=0.0, init=1.0;

      try {
         number = Double.parseDouble(args[0]);
         epsilon = Double.parseDouble(args[1]);
         init = Double.parseDouble(args[2]);
      }
      catch (ArrayIndexOutOfBoundsException e) {
         out.println("ERRO: número de argumentos insuficiente");
         out.println("Uso: java -ea p75 <number> <epsilon> <init>");
         exit(1);
      }
      catch (NumberFormatException e) {
         out.println("ERRO: formato inválido");
         out.println("Uso: java -ea p75 <number> <epsilon> <init>");
         exit(1);
      }

      double root = squareRoot(number,epsilon,init);

      out.println("Raiz quadrada de "+number+": "+root);

   }

   static double squareRoot(double number, double epsilon, double initRoot)
   {
      if(epsilon==0){
    	  return initRoot;
      }
      else{
    	  return((squareRoot(number, epsilon-1, initRoot)+number)/squareRoot(number, epsilon-1, initRoot))/2;
      }
   }
} 


