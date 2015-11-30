package p2;

import static java.lang.System.*;

public class p83
{
   static public void main(String[] args)
   {
      if (args.length != 1)
      {
         err.println("Test sorting algorithms for a N number array.");
         err.println("Usage: java -ea p83 <N>");
         exit(1);
      }
      
      String a="Sequential", b="Insertion", c="Bubble", d="Fusion";
      
      int n = Integer.valueOf(args[0]);
      int[] x = randomArray(n, n/2);
      double c2=0;
      
      out.println("Random Sequences:\n");
      
      long time = nanoTime();
      c2 = doSort(1,x);
      long elapsedTime = nanoTime() - time;
      print(elapsedTime, a, n, c2);
      out.println();
      
      x = randomArray(n, n/2);
      
      time = nanoTime();
      c2 = doSort(2,x);
      elapsedTime = nanoTime() - time;
      print(elapsedTime, b, n, c2);
      out.println();
      
      x = randomArray(n, n/2);
      
      time = nanoTime();
      c2 = doSort(3,x);
      elapsedTime = nanoTime() - time;
      print(elapsedTime, c, n, c2);
      out.println();
      
      x = randomArray(n, n/2);
      
      time = nanoTime();
      c2 = doSort(4,x);
      elapsedTime = nanoTime() - time;
      print(elapsedTime, d, n, c2);
      out.println();
      
      out.println("Crescent Sequences:\n");
      
      x = crescArray(n, n/2);
      
      time = nanoTime();
      c2 = doSort(1,x);
      elapsedTime = nanoTime() - time;
      print(elapsedTime, a, n, c2);
      out.println();
      
      x = randomArray(n, n/2);
      
      time = nanoTime();
      c2 = doSort(2,x);
      elapsedTime = nanoTime() - time;
      print(elapsedTime, b, n, c2);
      out.println();
      
      x = randomArray(n, n/2);
      
      time = nanoTime();
      c2 = doSort(3,x);
      elapsedTime = nanoTime() - time;
      print(elapsedTime, c, n, c2);
      out.println();
      
      x = randomArray(n, n/2);
      
      time = nanoTime();
      c2 = doSort(4,x);
      elapsedTime = nanoTime() - time;
      print(elapsedTime, d, n, c2);
      out.println();
      
      out.println("Dec. Sequences:\n");
      
      x = decrescArray(n, n/2);
      
      time = nanoTime();
      c2 = doSort(1,x);
      elapsedTime = nanoTime() - time;
      print(elapsedTime, a, n, c2);
      out.println();
      
      x = randomArray(n, n/2);
      
      time = nanoTime();
      c2 = doSort(2,x);
      elapsedTime = nanoTime() - time;
      print(elapsedTime, b, n, c2);
      out.println();
      
      x = randomArray(n, n/2);
      
      time = nanoTime();
      c2 = doSort(3,x);
      elapsedTime = nanoTime() - time;
      print(elapsedTime, c, n, c2);
      out.println();
      
      x = randomArray(n, n/2);
      
      time = nanoTime();
      c2 = doSort(4,x);
      elapsedTime = nanoTime() - time;
      print(elapsedTime, d, n, c2);
      out.println();

   }
   
   static int[] decrescArray(int len, int max){
	   assert len>0 && max>0;
	   
	   int [] a = new int [len];
	   
	   int b = len/max;
	   a[len-1]=0;
	   for(int i=len-2;i>=0;i--){
		   a[i]=a[i+1]+(int)b;
	   }
	   
	  
	   assert isSortedDecr(a, 0, len);
	   return a;
   }
   
   static int[] crescArray(int len, int max){
	   assert len>0 && max>0;
	   
	   int [] a = new int [len];
	   
	   int b = len/max;
	   a[0]=0;
	   for(int i=1;i<len;i++){
		   a[i]=a[i-1]+(int)b;
	   }

	   assert isSorted(a, 0, len);
	   return a;
   }
   
   public static void print(long elapsedTime, String a, int n, double c){
	   
	   int seg = (int)(elapsedTime / 1000000000L);
	   elapsedTime -= seg * 1000000000L;
	   int min = seg / 60;
	   seg = seg % 60;
	   int mseg = (int)(elapsedTime / 1000000L);
	   
	   	out.printf("%-16s | %-14s | %10s | %10s  | %21s\n", "Algorithm", "Array", "Dimension", "Time (m:s:ms)", "Nº Acess array memory");
	    out.printf("-----------------|----------------|------------|----------------|-----------------------\n");
	    out.printf("%-16s | %-14s | %10d |     %03d:%02d:%03d | %21s\n", a, "random", n, min, seg, mseg, c);
   }
   
   public static double doSort(int a, int []x){
	   
	   double c=0;
	   assert x!=null;
	   assert a>=1 && a<=4;
	   
	   switch(a){
	   case 1:
		   c=sequentialSort(x, 0, x.length);
		   break;
	   case 3:
		   c=bubbleSort(x, 0, x.length);
		   break;
	   case 4:
		   c=fusionSort(x, 0, x.length);
		   break;
	   case 2:
		   c=insertionSort(x, 0, x.length);
		   break;
	   
	   }
	   
	   
	   
	   return c;
   }

   /**
    * Creates an integer random array with numbers in the interval [0; max].
    * @param len length of the array.
    * @param max maximum random value.
    * @return the array
    */
   static int[] randomArray(int len, int max)
   {
      assert len >= 0;
      assert max >= 0;

      int[] result = new int[len];
      for (int i = 0; i < len; i++)
         result[i] = (int)(Math.random()*(max+1));
      return result;
   }

   /**
    * Swaps two elements of an integer array.
    * @param a the array
    * @param i index of an element to swap
    * @param j index of the other element to swap
    * {@code i},{@code j} must be valid indexes within array {@code a}
    */
   static void swap(int[] a, int i, int j)
   {
      assert a!=null;
      assert 0<=i && i<a.length;
      assert 0<=j && j<a.length;

      int temp;
      temp = a[i];
      a[i] = a[j];
      a[j] = temp;
   }

   /**
    * Sequential sort ("greed" variation of selection sort).
    * Increasing sorting of integer subarray a[start..end[
    * @param a      the array to be (partially) sorted.
    * @param start  index of the first element to sort.
    * @param end    index of the first element not to be sorted (the last element to sort is {@code end-1}).
    * Requires:   a!=null and 0 <= start <= end <= a.length
    * Ensures:  The elements a[k] with start <= k < end are sorted.  the remaining elements are not changed.
    */
   static double sequentialSort(int[] a, int start, int end)
   {
      assert a!=null;
      assert 0<=start && start<=end && end<=a.length;

      double c=0;
      
      for (int i=start; i<end-1; i++) // For each elements (except the last one):
      {
         for (int j=i+1; j<end; j++)
         { 
            if (a[j] < a[i]){               // compares them
               swap(a, i, j);				// if necessary a swap occurs
               c+=3;
            }
         }
      }

      assert isSorted(a, start, end); // checking for possible incorrections of the algorithm!
      
      return c;
   }

   /**
    * Checks if a given subarray is sorted (increasing order).
    * @param a[start..end[  the subarray to chack.
    * @return true    if subarray is sorted.
    */
   static boolean isSorted(int [] a, int start, int end)
   {
      assert a!=null;
      assert 0<=start && start<=end && end<=a.length;

      boolean result = true;
      for (int k=start+1; result && k<end; k++) 
         result = (a[k-1]<=a[k]);
      return result;
   }
   
   static boolean isSortedDecr(int [] a, int start, int end)
   {
      assert a!=null;
      assert 0<=start && start<=end && end<=a.length;

      boolean result = true;
      for (int k=start+1; result && k<end; k++) 
         result = (a[k-1]>=a[k]);
      return result;
   }
   
   static double bubbleSort(int [] a, int start, int end){
	   assert a!= null;
	   assert start>=0 && start<=end && end<=a.length;
	   boolean troca;
	   double c=0;
	   int f= end-1;
	   
	   do{
		   troca = false;
		   for(int i=start;i<f;i++){
			   if(a[i]>a[i+1]){
				   	swap(a,i,i+1);
			   		c+=3;
			   		troca=true;
			   }
		   }
		   f--;
	   }while(troca);
	   
	   assert isSorted(a, start, end);
	   
	   return c;
   }
   
   static double fusionSort(int [] a, int start, int end){
	   assert a!= null;
	   assert start >=0 && start <=end && end <=a.length;
	   
	   double c=0;
	   
	   if(end-start>1){
		   int middle = (start+end)/2;
		   fusionSort(a, start, middle);
		   fusionSort(a, middle, end);
		   c+=fusionSubarrays(a, start, middle, end);
	   }
	   
	   assert isSorted(a, start, end);
	   
	   return c;
   }
   
   static double fusionSubarrays(int [] a, int start, int middle, int end){
	   
	   int []b = new int[end-start];
	   int i1 = start;
	   int i2 = middle;
	   int j = 0;
	   double c=0;
	   
	   while(i1<middle && i2<end){
		   if(a[i1]<a[i2]){
			   b[j++] = a[i1++];
		   		c++;
		   }
		   else{
			   b[j++] = a[i2++];
		   		c++;
		   }
		   
	   }
	   
	   while(i1<middle)
		   b[j++] = a[i1++];
	   		c++;
	   while(i2<end)
		   b[j++] = a[i2++];
	   		c++;
	   arraycopy(b,0,a,start,end-start);
	   
	   return c;
   }
   
   static double insertionSort(int [] a, int start, int end){
	   assert a!= null;
	   assert start>=0 && start<=end && end<=a.length;
	   
	   double c=0;
	   
	   for(int i=start+1;i<end;i++){
		   int j;
		   int v = a[i];
		   
		   for(j=i-1;j>=start && a[j]>v;j--){
			   a[j+1] = a[j];
			   c++;
		   }
		   a[j+1] = v;
		   c++;
		   
	   }
	   
	   assert isSorted(a, start, end);
	   
	   return c;
   }
   

}
