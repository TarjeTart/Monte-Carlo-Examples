import java.util.Random;
import java.util.Scanner;

//proof of simulation http://www.jstor.org/stable/2685243?seq=1#page_scan_tab_contents

public class MonteCarloE {

	public static void main(String[] args) {
		
		System.out.println("Enter # of simulations:");
		int runs = new Scanner(System.in).nextInt();
		int[] sims = new int[runs];
		
		for(int i=0; i < sims.length;i++) {
			int count = 0;
			double sum = 0;
			Random ran = new Random();
			while(sum < 1.0) {
				sum+=ran.nextDouble();
				count++;
			}
			sims[i] = count;
		}
		
		System.out.println("E is approximately: " + average(sims));

	}

	private static double average(int[] sims) {
		int sum = 0;
		for(int i : sims) {
			sum+=i;
		}
		return (double)sum/sims.length;
	}

}
