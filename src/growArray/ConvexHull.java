package growArray;
import java.io.*;
import java.util.Scanner;


public class ConvexHull {
	private GrowArray[][] ga;
	private GrowArray temp = new GrowArray();
	private int grids;
	private double minx;
	private double maxx;
	private double miny;
	private double maxy;
	
	public ConvexHull(int i) {
		grids = i;
		ga = new GrowArray[grids][grids];
		for(int j=0;j<grids;j++) {
			for(int k=0;k<grids;k++)
			ga[j][k] = new GrowArray();
		}
	}
	public void read(String s) throws FileNotFoundException {
		File f = new File(s);
		Scanner sc = new Scanner(f);
		double firstx = sc.nextDouble();
		double firsty = sc.nextDouble();
		maxx = firstx;
		minx = firstx;
		maxy = firsty;
		miny = firsty;
		temp.addEnd(new Points2D(firstx,firsty));
		while(sc.hasNextLine()) {
			double x = sc.nextDouble();
			double y = sc.nextDouble();
			if(x>maxx)
				maxx = x;
			if(x<minx)
				minx = x;
			if(y>maxy)
				maxy = y;
			if(y<miny)
				miny = y;
			temp.addEnd(new Points2D(x,y));
		}
		double xsteps = (maxx-minx)/grids;
		double ysteps = (maxy-miny)/grids;
		for(int i = 0;i<temp.size();i++) {
			int xgrids = (int)((temp.get(i).getx()-minx)/xsteps);
			int ygrids =  (int)((temp.get(i).gety()-miny)/ysteps);
			if(xgrids==grids)
				xgrids--;
			if(ygrids==grids)
				ygrids--;
			//System.out.println(xgrids+" , "+ygrids);
			ga[xgrids][ygrids].addEnd(temp.get(i));
		}
	}
	public void printAllListSizes() {
		for(int i = 0;i<grids;i++) {
			for(int j = 0; j<grids;j++) 
				System.out.print(ga[i][j].size()+" , ");
			System.out.println("");
		}
	}
	public void printPerimeterClockWiseOrder() {
		for(int i1 = 0;i1<grids;i1++)
			System.out.println("box ("+i1+","+0+") contains: "+ga[i1][0]);
		for(int i2 = 0;i2<grids;i2++)
			System.out.println("box ("+(grids-1)+","+i2+") contains: "+ga[grids-1][i2]);
		for(int i3 = grids-1;i3>=0;i3--)
			System.out.println("box ("+i3+","+(grids-1)+") contains: "+ga[i3][grids-1]);
		for(int i4 = grids-1;i4>=0;i4--)
			System.out.println("box ("+0+","+i4+") contains: "+ga[0][i4]);
	}
	public void printMinMax() {
		System.out.println("maxx is: "+maxx);
		System.out.println("minx is: "+minx);
		System.out.println("maxy is: "+maxy);
		System.out.println("miny is: "+miny);
	}
	
	
	public static void main(String[] args) throws IOException {
		ConvexHull ch = new ConvexHull(16); // create a 16x16 grid of GrowArray
		ch.read("convexhullpoints.dat");
		ch.printAllListSizes(); // tell us how many are in each list
		ch.printMinMax(); // print minx, maxx, miny, maxy
		ch.printPerimeterClockWiseOrder(); // p1,p2,p3,p4,p8,p12,p16..
	}
}
