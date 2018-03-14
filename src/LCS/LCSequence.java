package homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LCSequence {
	public static int larger(int a, int b) {
		if(a>b) {
			return a;
		}else {
			return b;
		}
	}
	
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
	public static void lcs(String a, String b) {
		char[] atochar = a.toCharArray();
		char[] btochar = b.toCharArray();
		int[][] table = new int[atochar.length+1][btochar.length+1];
		int max = 0;
		//String lcs = "";
		
		for(int i = a.length();i>=0;i--) {
			for (int j = b.length();j>=0;j--)
				table[i][j]=0;
		}
		for (int i = 1; i <= atochar.length; i++) {  
            for (int j = 1; j <= btochar.length; j++) {  
            	if(atochar[i-1]==btochar[j-1]) {
            			table[i][j]=table[i-1][j-1]+1;
            	}else {
            		table[i][j] = larger(table[i-1][j],table[i][j-1]);
            	}
            }
		}
		for (int i = 1; i <= atochar.length; i++) {  
            for (int j = 1; j <= btochar.length; j++) {  
            	if(table[i][j]>max) {
            			max=table[i][j];            			          			
            	}            	
            }
		}
		
		for (int i = 0; i <= atochar.length; i++) {  
            for (int j = 0; j <= btochar.length; j++) {  
                System.out.print(table[i][j]+",");  
            }  
            System.out.println("");  
        }  
		
		System.out.println("Lcs is "+max);
	}
	public static void main(String[] args) throws FileNotFoundException {
		String a = "abcdkfm";
		String b = "abdekg";
		lcs(a,b);
		
	}
}

