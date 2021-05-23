import java.util.Random;
import java.util.Scanner;

//monte hall simulation of Monty Hall problem

public class MontyHall {

	public static void main(String[] args) {

		System.out.println("Enter number of runs of each case:");
		
		int runs = new Scanner(System.in).nextInt();
		
		int keepSuccess = 0;
		int switchSuccess = 0;
		
		for(int i = 0; i < runs; i++) {
			Random ran = new Random();
			int real = ran.nextInt(4);
			int guess = ran.nextInt(4);
			if(guess == real) {
				keepSuccess++;
			}else {
				switchSuccess++;
			}
		}
		
		System.out.println("Times keeping first door worked:" + keepSuccess + 
				"\nTimes switching first door worked:" + switchSuccess);

	}

}
