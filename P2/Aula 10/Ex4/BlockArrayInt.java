/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

public class BlockArrayInt
{
   public BlockArrayInt(int blockSize,int numBlocks)
   {
      assert blockSize > 0;
      assert numBlocks > 0;

      a = new int[blockSize*numBlocks];
      blocks++;
   }

   public int get(int index)
   {
      assert validIndex(index);

      return a[index];
   }

   public void put(int elem,int index)
   {
      assert validIndex(index);

      a[index] = elem;
   }

   public void incrementNumberOfBlocks(){
	   
	   int[] blockarray = new int[2*a.length / blocks];
	   
	   for(int i = 0; i < a.length; i++) {
		   blockarray[i] = a[i];
	   }
	   
	   a = blockarray;
	   blocks++;
   }

   public int size()
   {
      return a.length;
   }

   public int numberOfBlocks()
   {
      return blocks;
   }

   public int blockSize()
   {
      return a.length/blocks;
   }

   public boolean validIndex(int index)
   {
      return index >= 0 && index < size();
   }

   private int[] a;
   private int blocks;
}

