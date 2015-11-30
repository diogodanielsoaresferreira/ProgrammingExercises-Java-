/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * N� Mecanogr�fico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;


import static java.lang.System.*;

public class p111
{
   public static void main(String[] args)
   {
      AssociativeArray<String> aa = new AssociativeArray<String>(100);
      int i = 0;
      while(i < args.length)
      {
         if (args[i].equals("set")) // set key value
         {
            if (i+2 >= args.length)
            {
               err.println("ERROR: missing "+args[i]+" arguments!");
               exit(1);
            }
            aa.set(args[i+1], args[i+2]);
            i+=2;
         }
         else if (args[i].equals("get")) // get key
         {
            if (i+1 >= args.length)
            {
               err.println("ERROR: missing "+args[i]+" arguments!");
               exit(1);
            }
            if (!aa.exists(args[i+1]))
            {
               err.println("ERROR: aa["+args[i+1]+"] does not exist");
               exit(2);
            }
            out.println("aa["+args[i+1]+"] = "+aa.get(args[i+1]));
            i+=1;
         }
         else if (args[i].equals("delete")) // delete key
         {
            if (i+1 >= args.length)
            {
               err.println("ERROR: missing "+args[i]+" arguments!");
               exit(1);
            }
            if (!aa.exists(args[i+1]))
            {
               err.println("ERROR: aa["+args[i+1]+"] does not exist");
               exit(2);
            }
            aa.delete(args[i+1]);
            i+=1;
         }
         else if (args[i].equals("exists")) // exists key
         {
            if (i+1 >= args.length)
            {
               err.println("ERROR: missing "+args[i]+" arguments!");
               exit(1);
            }
            out.print("aa["+args[i+1]+"]");
            if (aa.exists(args[i+1]))
               out.println(" exists");
            else
               out.println(" does not exist");
            i+=1;
         }
         else if (args[i].equals("isEmpty")) // isEmpty
         {
            out.print("aa is");
            if (!aa.isEmpty())
               out.print(" not");
            out.println(" empty");
         }
         else if (args[i].equals("size")) // size
         {
            out.println("aa has "+aa.size()+" elements");
         }
         else if (args[i].equals("clear")) // clear
         {
            aa.clear();
         }
         else if (args[i].equals("allKeys")) // allKeys
         {
            String[] keys = aa.keysToArray();
            out.print("aa current keys:");
            for(int j = 0; j < keys.length; j++)
               out.print(" \""+keys[j]+"\"");
            out.println();
         }
         i++;
      }
   }
}

