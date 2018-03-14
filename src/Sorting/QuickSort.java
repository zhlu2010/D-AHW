package homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuickSort {
	public static String readfile(String a) throws FileNotFoundException {
		String output = "";
		File f = new File(a);
		Scanner sc = new Scanner(f);
		while(sc.hasNextLine()) {
			output += sc.nextLine();
		}
		sc.close();
		return output;
	}
	public static void quickSort(int[] a,int sta, int end) {
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
		
		 quickSort(a,sta,left-1);
		 quickSort(a,right+1,end);
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		/*String s = readfile("hw3a.dat");
		String[] nums = s.split(" +");
		int n = Integer.parseInt(nums[0]);
		int[] a = new int[n];
		for(int i = 1; i < n + 1; i++) {
			a[i - 1] = Integer.parseInt(nums[i]);
		}*/
		int[] a = {3,5,7,99,78,54,36,23,4,6,55,7777,533,3,12,15};
		quickSort(a,0,a.length-1);
		for(int i = 0;i<a.length;i++)
			System.out.print(a[i]+" ");
		
	}
}
