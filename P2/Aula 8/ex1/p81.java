/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */

package p2;

import static java.lang.System.*;
import java.util.Scanner;

public class p81
{
   public static void main(String[] args)
   {
	  
	  
      NumberArray na = new NumberArray();
      mergeSort(na.array(), 0, na.length());
      na.print();
   }

   static void mergeSort(int[] array, int start, int end)
   {  
	   if(end-start>1){
		   int middle = (start+end)/2;
		   mergeSort(array, start, middle);
		   mergeSort(array, middle, end);
		   mergeSubArrays(array, start, middle, end);
	   }
   }
   
   static void mergeSubArrays(int [] array, int start, int middle, int end){
	   int [] b = new int[end-start];
	   int l1 = start, l2 = middle;
	   int j=0;
	   
	   while(l1 < middle && l2 < end) {
		   if (array[l1] < array[l2])
			   b[j++] = array[l1++];
		   else
			   b[j++] = array[l2++];
		   }
	   
		   while(l1 < middle)
			   b[j++] = array[l1++];
		   while(l2 < end)
			   b[j++] = array[l2++];
		   arraycopy(b, 0, array, start, end-start);
   }
	   

}

