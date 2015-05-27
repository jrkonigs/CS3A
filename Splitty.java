import java.util.Scanner;


public class Splitty {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); //declare scanner to take in input 
		String[] input = s.nextLine().split(")");
		for(int i = 0; i<input.length;i++)
		{
			System.out.println(input[i]);
		}
	}
}
