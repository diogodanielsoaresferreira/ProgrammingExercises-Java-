/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * N� Mecanogr�fico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;

public class p103
{
   public static void main(String[] args)
   {
      if (args.length != 1)
      {
         err.println("Usage: java -ea p103 <Number-Elements>");
         exit(1);
      }

      int n = 0;
      try
      {
         n = Integer.parseInt(args[0]);
      }
      catch(NumberFormatException e)
      {
         err.println("Error: invalid number "+args[0]);
         exit(2);
      }

      p103stack<Integer> stack = new p103stack<Integer>(); // illimited
      p103queue<Integer> queue = new p103queue<Integer>(); // illimited

      for(int i = 0; i < n; i++)
      {
         stack.push(i);
         queue.in(i);
      }

      out.print("Stack: ");
      stack.print();
      out.println();
      out.print("Queue: ");
      queue.print();
      out.println();

      while(!stack.isEmpty())
         stack.pop();
      while(!queue.isEmpty())
         queue.out();
   }
}

