package homework;

public class HeapSort {
 static void heapS(int[] a,int end) {
		int temp=0;
		if(end<=1) {return;}
		else{
		if(end%2 == 0) {
			for(int i  = end;i>=2;i-=2) {
				if(a[i/2-1]>a[i-1]) {
					if(a[i]>a[i/2-1]) {
						temp = a[i/2-1];
						a[i/2-1] = a[i];
						a[i] = temp;
					}
				}else {
					if(a[i-1]>a[i]) {
						temp = a[i/2-1];
						a[i/2-1] = a[i-1]; 
						a[i-1]= temp;
					}else {
						temp = a[i/2-1];
						a[i/2-1] = a[i];
						a[i] = temp;
					}
				}
			}
		}
				else {
				if(a[end]>a[end/2-1]) {
					temp = a[end/2-1];
					a[end/2-1] = a[end];
					a[end] = temp;
				}
				for(int i = end-1;i>=2;i-=2){
					if(a[i/2-1]>a[i-1]) {
						if(a[i]>a[i/2-1]) {
							temp = a[i/2-1];
							a[i/2-1] = a[i];
							a[i] = temp;
						}
					}else {
						if(a[i-1]>a[i]) {
							temp = a[i/2-1];
							a[i/2-1] = a[i-1]; 
							a[i-1]= temp;
						}else {
							temp = a[i/2-1];
							a[i/2-1] = a[i];
							a[i] = temp;
						}
					}
				}
			}
		temp = a[end];
		a[end] = a[0];
		a[0] = temp;
			}
		heapS(a,end-1);
		}
	public static void main(String[] args) {
		int[] a = {3,5,7,99,78,54,36,23,4,6,55,7777,533,3,12,15};
		heapS(a,a.length-1);
		for(int x:a)
		System.out.print(x+" ");
	}
	}

