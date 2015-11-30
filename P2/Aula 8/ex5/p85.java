/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

import static java.lang.System.*;
import java.io.*;
import java.util.Scanner;
import java.io.IOException;

public class p85
{
   public static void main(String[] args)
   {
	  String[] words = null;
	  PrintWriter w_words = null;
	  File f_words;
	  
      if (args.length != 1)
         exit(1);
      try{
    	  File fin = new File("Words.txt");
    	  words = extractsWords(fin);
    	  
    	  if(words.length>50) ordenWordsMergeS(words, 0, words.length);
    	  else words=ordenWordsInser(words);
      
    	  for(int i=0;i<words.length-1;i++){
    		  if(words[i].equals(words[i+1])){
    			  words=delString(words, i);
    		  }
    	  }
    	  
    	  f_words = new File("Words.txt");
    	  w_words = new PrintWriter(f_words);
    	  if(!f_words.canWrite()) throw new IOException();
      
    	  for(int i = 0;i < words.length;i++){
    		  w_words.print(words[i]);
    		  w_words.println();
    		  out.printf("[%05d] %s\n",i+1,words[i]);
    	  }
    	  w_words.close();
      }
      catch(IOException e){
    	  out.print("Ficheiro não pode ser lido.");
    	  exit(1);
      }
   }

   static String[] extractsWords(File fin) throws IOException
   {
      assert fin != null;

      Scanner scf = null;
      
      // count the words
      int n = 0;
      
      try{
    	  scf = new Scanner(fin).useDelimiter("[\\p{Punct}\\p{Space}]+");
    	  if (fin.isDirectory() || !fin.canRead()) throw new IOException ();
      }
      catch(IOException e){
    	throw e;  
      }
      
      while(scf.hasNext())
      {
         scf.next();
         n++;
      }
      scf.close();

      String[] result = new String[n];

      // read the words
      int i = 0;
      scf = new Scanner(fin).useDelimiter("[\\p{Punct}\\p{Space}]+");
      while(scf.hasNext())
      {
         result[i] = scf.next();
         i++;
      }
      scf.close();

      return result;
   }

   static void ordenWordsMergeS(String [] array, int start, int end){
	   assert array!=null;
	   assert start>=0 && start<end && end<=array.length;
	   
	   if(end-start>1){
		   int middle = (end+start)/2;
		   ordenWordsMergeS(array, start, middle);
		   ordenWordsMergeS(array, middle, end);
		   subArrayMerge(array, start, middle, end);
	   }
	   
   }
   
   static void subArrayMerge(String [] array, int start, int middle, int end){
	   assert array!=null;
	   assert start>=0 && start<end && end<=array.length;
	   
	   String [] b = new String[end-start];
	   int i1=start, i2=middle, j=0;
	   
	   while(i1<middle && i2<end){
		   if(isGreater(array[i1], array[i2])){
			   b[j++] = array[i2++];
		   }
		   else
			   b[j++] = array[i1++];
		   
	   }
	   
	   while(i1<middle)
		   b[j++] = array[i1++];
	   while(i2<end)
		   b[j++] = array[i2++];
	   
	   arraycopy(b,0,array,start,end-start);
   }

   static String[] ordenWordsInser(String [] array){
	   assert array!=null;
	   
	   for(int i=1;i<array.length;i++){
		   String a = array[i];
		   int j=0;
		   
		   for(j=i-1;j>=0 && isGreater(array[j], a);j--){
			   array[j+1] = array[j];
		   }
		   array[j+1] = a;
		   
	   }
	   return array;
	   
   }
   
   static boolean isGreater(String a, String b){
	   assert a.isEmpty() && !b.isEmpty();
	   
	   for(int i=0;i<a.length();i++){
		   if(a.charAt(i)>b.charAt(i)) return true;
		   if(b.charAt(i)>a.charAt(i)) return false;
	   }
	   
	   return false;
   }
   
   static String[] delString(String [] array, int i){
	   assert array!=null;
	   assert i<array.length;
	   
	   String []b = new String[array.length-1];
	   
	   for(int j=0;j<i;j++){
		   b[j]=array[j];
	   }
	   
	   for(int j=i+1;j<array.length;j++){
		   b[j-1]=array[j];
	   }
	   
	   
	   return b;
   }
   
}

