package practice;

public class GoldenMeanSearch {
	public static double forum(double x) {
		return 6-x*x;
	}
	public static double gmSearch(double left, double right , double wc) {
		if(right-left<wc) 
			return forum(right);		
		else {
			double l = left+(right-left)/1.618;
			double r = right-(right-left)/1.618;
			if(forum(l)>forum(r)) {
				return gmSearch(r,right,wc);
			}else {
				return gmSearch(left,l,wc);
			}
		}
	}
	public static void main(String[] args) {
		double y = gmSearch(1.5,6,0.0000000001);
		System.out.println(y);
	}
}
