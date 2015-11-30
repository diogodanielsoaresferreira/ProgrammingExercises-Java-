/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */

package p2;

import static java.lang.System.*;
import java.util.Scanner;

public class p82
{
   public static void main(String[] args)
   {
      NumberArray na = new NumberArray();
      insertionSort(na.array(), 0, na.length());
      na.print();
   }

   static void insertionSort(int[] array, int start, int end)
   {
	   
	   for(int i=start+1;i<end;i++){
		   int v = array[i];
		   int j;
		   for(j=i-1;j>=start && array[j]>v;j--){
			   array[j+1]=array[j];
		   }
		   array[j+1] = v;
	   }
	   
   }
}

