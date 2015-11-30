/**
 * Diogo Daniel Soares Ferreira
 * <diogodanielsoaresferreira@ua.pt>
 * Nº Mecanográfico: 76504
 * Universidade de Aveiro, 2015
 */
package p2;

public class p73 {

	public static void main(String[] args) {

		double [] arr = {1,2,3,4,5,6,7,8,9};
		
		System.out.println(sum(arr,1,8));
		System.out.println(recSum(arr,1,8));
		
	}
	
	// sum of subarray [ start , end [ of arr :
	public static double sum(double [ ] arr , int start , int end)
	{
		assert arr != null ;
		assert start >= 0 && start <= end && end <= arr.length ;
		
		double res = 0 ;
		for ( int i = start ; i < end ; i++)
			res += arr[ i ] ;
		return res ;
	}
	
	public static double recSum(double [ ] arr , int start , int end){
		
		assert arr != null ;
		assert start >= 0 && start <= end && end <= arr.length ;
		
		if(start>=end) return 0;
		
		double value = arr[start];
		
		start++;
		
		return value + recSum(arr, start, end);
	}

}
