/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

public class BlockArray<T>
{
   @SuppressWarnings(value = "unchecked")
   public BlockArray(int blockSize,int numBlocks,T defaultValue)
   {
      assert blockSize > 0;
      assert numBlocks > 0;

      a = (T[]) new Object[blockSize*numBlocks];
      this.defaultValue = defaultValue;
      blocks++;
   }

   public T get(int index)
   {
      assert validIndex(index);

      if (a[index] == null)
         a[index] = defaultValue;
      return a[index];
   }

   public void put(T elem,int index)
   {
      assert validIndex(index);

      a[index] = elem;
   }

   public void incrementNumberOfBlocks(){
	   
	T[] blockarray = (T[]) new Object[2*a.length / blocks];
	
	for(int i = 0; i < a.length; i++){
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

   private T[] a;
   private T defaultValue;
   private int blocks;
}

