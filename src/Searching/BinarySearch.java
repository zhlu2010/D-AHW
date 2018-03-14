package practice;

public class BinarySearch {
	 public static void qSort(int[] a,int sta, int end) {
			if((end-sta)<1) { return ;}
			else {
				int left = sta;
				int right = end;
				int[] res = new int[a.length];//if res = a , a will change. ???		
				for(int i = 0;i<a.length;i++)
					res[i] = a[i];
				int rn =sta+(int)(Math.random() * (end-sta+1));
			
				//System.out.println(a[rn]);
				for(int i = sta; i<= end;i++) {
					if(i!=rn) {
						if(a[i]>a[rn]) {
							res[right]=a[i];
							right--;
						}else {
							res[left]=a[i];
							left++;
						}
					}
				}res[left] = a[rn];
			
			for(int i = 0;i<a.length;i++)
				a[i] = res[i];
			
			 qSort(a,sta,left-1);
			 qSort(a,right+1,end);
			}
		}
	 public static int binaryS(int target, int[] a) {
			int i = 0;
			int j = a.length-1;
			int guess = 0;
			while(i<=j) {
				guess = (i+j)/2;
				if(target>a[guess]) {
					i = guess + 1;
				}else if(target<a[guess]) {
					j = guess - 1;
				}else {
					break;
				}
			}
			return guess+1;
		}
	 public static void main(String[] args) {
			int[] a = {3,1,4,6,45,7,456,76,86,9,567,67,8,65,7,0,8,2};
			qSort(a,0,a.length-1);
			for(int i = 0;i<a.length;i++)
				System.out.print(a[i]+" ");
			System.out.println("");
			System.out.println(binaryS(4,a));
	 }
}
