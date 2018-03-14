package homework;

import java.io.*;
import java.util.Scanner;

public class EditDistance {	
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
	public static int min(int a, int b, int c) {
		if (a<b) {
			if(a<c)
				return a;
			else 
				return c;
		}else {
			if(b<c)
				return b;
			else 
				return c;
		}
	}
	public static void editDistance(String a, String b) {
		int res = 0;
		char[] ac = a.toCharArray();
		char[] bc = b.toCharArray();
		int[][] table = new int[ac.length+1][bc.length+1];
		
		for(int i = 0; i<=ac.length;i++)
			table[i][0] = i;
		for(int j = 0; j<=bc.length;j++)
			table[0][j] = j;
		
		for(int i = 0; i<ac.length;i++)
			for(int j = 0; j<bc.length;j++) {
				if (ac[i]==bc[j]) {
					table[i+1][j+1] = table[i][j];
				}else {
					table[i+1][j+1] = min(table[i][j]+1,table[i][j+1]+1,table[i+1][j]+1);
				}
			}
		
		for (int i = 0; i <= ac.length; i++) {  
            for (int j = 0; j <= bc.length; j++) {  
                System.out.print(table[i][j]+",");  
            }  
            System.out.println("");  
        }  
		
		res = table[ac.length][bc.length];
		System.out.println("Edit distance is " + res);
		
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		String a ="abdef";		//readfile("EditDist a.txt");
		String b = "gbcde";		//readfile("EditDist b.txt");
		editDistance(a,b);
	}
}

