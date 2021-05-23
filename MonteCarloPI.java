import java.util.Random;
import java.util.Scanner;

/*
 Monte Carlo of PI:
 circle area/square area = 1/pi*r^2 = pi/4
 pi = 4*circle area/square area = 4*simulation
 */

public class MonteCarloPI {
	public static void main(String[] args) {
	
		System.out.println("Enter the number of total point:");
		
		int total = new Scanner(System.in).nextInt();
		int success = 0;
		
		for(int i = 0; i < total; i++) {
			if(checkPoint(makePoint(),makePoint())) {
				success++;
			}
		}
		
		System.out.println("PI is approximately: " + 4.0*success/total);
		
	}
	
	public static double makePoint() {
		Random ran = new Random();
		return ran.nextDouble()*2-1;
	}
	
	public static boolean checkPoint(double x, double y) {
		double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		if(distance <= 1) {
			return true;
		}
		return false;
	}
	
}
