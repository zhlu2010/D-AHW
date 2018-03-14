package threadandprime;
import java.util.*;

public class ThreadedPrimes {
	private ArrayList<Integer> primes;
	public ThreadedPrimes() {
		primes = new ArrayList<>();
	}
	public synchronized void calculate(int num) {
		int pro = 1;		
			for(int i = 2;i<=Math.sqrt(num);i++) {				
				pro = pro*(num%i);
			}if(pro!=0) {
				primes.add(num);
			}
		
	}
	public void printout() {
		for (Integer p: primes ) {
			System.out.println(p);
		}
		//System.out.println(primes.size());
	}
	public static void main(String[] args) throws InterruptedException {
		ThreadedPrimes tp = new ThreadedPrimes();
		Thread t = new Thread() {
	           public void run() {
	               for (int i = 2; i <= 10; i++)
	                 tp.calculate(i);;                
	           }
	       };
	     Thread t2 = new Thread() {
	           public void run() {
	               for (int i = 11; i <= 20; i++)
	                   tp.calculate(i);;
	           }
	       };
	       Thread t3 = new Thread() {
	           public void run() {
	               for (int i = 21; i <= 30; i++)
	                   tp.calculate(i);;
	           }
	       };
	       Thread t4 = new Thread() {
	           public void run() {
	               for (int i = 31; i <= 40; i++)
	                   tp.calculate(i);;
	           }
	       };
	       t.start();
	       t2.start();
	       t3.start();
	       t4.start();
	       t.join();
	       t2.join();
	       t3.join();
	       t4.join();
	       tp.printout();
	}
}
