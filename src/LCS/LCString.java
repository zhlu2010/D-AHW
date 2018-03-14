package homework;

public class LCString {
	public static void Lcs(String a, String b) {
		char[] atochar = a.toCharArray();
		char[] btochar = b.toCharArray();
		int[][] table = new int[atochar.length+1][btochar.length+1];
		int max = 0;
		int maxsta1=1;
		int maxend1=0;
		for(int i = a.length();i>=0;i--) {
			for (int j = b.length();j>=0;j--)
				table[i][j]=0;
		}
		for (int i = 1; i <= atochar.length; i++) {  
            for (int j = 1; j <= btochar.length; j++) {  
            	if(atochar[i-1]==btochar[j-1]) {
            			table[i][j]=table[i-1][j-1]+1;
            	}            	
            }
		}
		for (int i = 1; i <= atochar.length; i++) {  
            for (int j = 1; j <= btochar.length; j++) {  
            	if(table[i][j]>max) {
            			max=table[i][j];
            			maxend1 = i;
            			
            	}            	
            }
		}
		
		
		/*for (int i = 0; i <= atochar.length; i++) {  
            for (int j = 0; j <= btochar.length; j++) {  
                System.out.print(table[i][j]+",");  
            }  
            System.out.println("");  
        } */ 
		for (int i = maxsta1;i<=maxend1;i++)
			System.out.print(atochar[i-1]);
	}
	public static void main(String[] args) {
		String a = "saoge niu ji";
		String b = "luge bi saoge niu bi";
		Lcs(a,b);
	}
}
