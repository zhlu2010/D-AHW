package homework;

public class InsertionSort {
	public static void insertionSort(int[] a) {		
		for( int i=0; i<a.length-1; i++ ) {	
	        for( int j=i+1; j>0; j-- ) {
	            if( a[j-1] <= a[j] )
	                break;
	            int temp = a[j];
	            a[j] = a[j-1];
	            a[j-1] = temp;
	        }
	    }
		
	}
	public static void main(String[] args) {
		int[] a = {3,4,1,9,6,4,2};
		 insertionSort(a);
		for(int i =0;i<a.length;i++)
			System.out.println(a[i]);
	}
}
