/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * N� Mecanogr�fico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

/**
Este programa gere uma fila de espera que comprime valores repetidos � entrada.

Modifique o m�dulo de forma que o programa compile e funcione como desejado.
**/

import static java.lang.System.*;

public class Exame13 {
   public static void main(String[] args) {
      CompressedQueue queue = new CompressedQueue(); // cria uma fila vazia

      for (int a = 0; a < args.length; a++) {
         String name = args[a];
         if (isNumber(name)) {
            out.println("IN "+name);
            queue.in(Integer.parseInt(name)); // adiciona um valor ao fim da fila
         }
         else if (name.equalsIgnoreCase("out")) {
            if (queue.isEmpty()) // queue vazia?
               err.println("ERROR: a non-empty queue is required!");
            else
            {
               out.println("OUT: ["+queue.peek()+":"+queue.peekCount()+"]"); // devolve valor e repeti��es do elemento que est� na frente da fila
               queue.out(); // remove elemento que est� na frente da fila
            }
         }
         else if (name.equalsIgnoreCase("show")) {
            out.println("QUEUE: "+queue.toStringq()); // devolve o conte�do da fila na forma de String
         }
         else if (name.equalsIgnoreCase("max")) {
            if (queue.size() < 2) // n�mero de elementos da fila
               err.println("ERROR: a queue with a least two elements is required!");
            else
               out.println("MAX: "+queue.maxDiff()); // diferen�a m�xima entre elementos consecutivos na fila (valor absoluto)
         }
         else if (name.equalsIgnoreCase("min")) {
            if (queue.size() < 2)
               err.println("ERROR: a queue with a least two elements is required!");
            else
               out.println("MIN: "+queue.minDiff()); // diferen�a m�nima entre elementos consecutivos na fila (valor absoluto)
         }
         else if (name.equals("clear")) {
            out.println("CLEAR");
            queue.clear();  // esvazia a fila
            assert queue.isEmpty();  // verifica se a fila est� vazia
         }
         else
            err.println("ERROR: invalid argument!");
      }
      out.println("QUEUE: "+queue.toStringq());
   }

   // Checks if string s contains an integer.
   public static boolean isNumber(String s) {
      boolean r = true;
      try {
         int n = Integer.parseInt(s);
      } catch (NumberFormatException e) {
         r = false;
      }
      return r;
   }
}
