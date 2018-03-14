package growArray;

class Points2D {
	private double xloc;
	private double yloc;
	public Points2D(double x, double y) {
		xloc = x; 
		yloc = y;
	}
	public double getx() {
		return xloc;
	}
	public double gety() {
		return yloc;
	}
	public String toString() {
		StringBuilder b = new StringBuilder();
		b.append("(").append(xloc).append(",").append(yloc).append(")");
		return b.toString();
	}
}

public class GrowArray {
	private Points2D[] dp;
	private int used;
	private int capacity;
	private void grow() {
		capacity = 2*capacity;
		Points2D[] old = dp;
		dp = new Points2D[capacity];
		for(int i=0;i<old.length;i++)
			dp[i] = old[i];
	}
	private void checkgrow() {
		if(used==capacity) {
			grow();
		}
	}
	public GrowArray() {
		dp = new Points2D[1];
		used = 0;
		capacity = 1;
	}
	public GrowArray(int len) {
		dp = new Points2D[len];
		used = 0;
		capacity = len;
	}
	public Points2D get(int i) {
		return dp[i];
	}
	public void addEnd(Points2D p) {
		checkgrow();
		dp[used] = p;
		used++;
	}
	public void addStart(Points2D p) {
		checkgrow();
		if(used == 0) {
			dp[0]=p;
		}else {
		for(int i = 0;i<used;i++) 
			dp[i+1]=dp[i];
		dp[0]=p;
		}
		used++;
	}
	public void insert(int pos, Points2D p) {
		checkgrow();
		if(used>pos) {
		for(int i = pos;i<used;i++) 
			dp[i+1] = dp[i];
		dp[pos] = p;
		used++;
		}
	}
	public void removeStart() {
		for(int i = 0;i<used;i++) 
			dp[i]=dp[i+1];
		used--;
	}
	public void removeEnd() {
		used--;
	}
	public void remvove(int pos) {
		if(used>pos) {
		for(int i = pos;i<used;i++)
			dp[i]=dp[i+1];
		used--;
		}
	}
	public int size() {
		return used;
	}
	public String toString() {
		StringBuilder b = new StringBuilder();
		for(int i = 0;i<used;i++)
			b.append(dp[i]).append(" ");
		return b.toString();
	}


	public static void main(String[] args) {
		Points2D a1 = new Points2D(1,2);
		Points2D a2 = new Points2D(2,2);
		Points2D a3 = new Points2D(1,3);
		GrowArray ga = new GrowArray(100);
		ga.addEnd(a1);
		ga.addEnd(a2);
		ga.addEnd(a3);
		//ga.removeStart();
		//ga.removeEnd();
		ga.remvove(1);
		System.out.println(ga);
	}
}



