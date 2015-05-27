import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/*********
 * 
 * @author James Konigsberg
 * Goal: Complete FASCL
 * Date: 11/18/14
 * Sample Data:
 * 1. 5,a,y,t,z
 * 2. 4,q,r,s,t
 * 3. 7,s,p,q,z
 * 4. 3,a,b,c,d,e
 * 5. 8,a,b,c,d
 *
 */

public class FASCL {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); //declare scanner to take in input 
		String[] input = s.nextLine().split("[, ]+"); //divide up input into the size and the input chars 
		int size = Integer.parseInt(input[0]);  //declare size as the int given as the first char in the input 
		char[] data = new char[size]; //make a char array with the size given
		int largest = Integer.MIN_VALUE;  //declare largest as the minimum value 
		double collisioncounter = 0; //declare collisioncounter 
		double inputstuff = 0; //declare inputstuff
		for(int i = 0; i< data.length; i++) //loop that sets all values in data to 0 
		{
			data[i] = 0;
		}
		for(int i = 1; i< input.length; i++) //loop that adds all elements into the array, counting and adding to several variable to print later 
		{
			char a = input[i].charAt(0);
			int q = a - 'a';
			if(data[q%size] == 0) 
			{
				data[q%size]++; 
				inputstuff++;
			}
			else 
			{
				data[q%size]++;
				collisioncounter++;
				inputstuff++;
			}
		}
		System.out.println((int) collisioncounter); //print collisioncounter 
		double collisionrate = (collisioncounter/inputstuff); //rate is the CC/IS
		DecimalFormat df = new DecimalFormat(".00"); //use DM format 
		System.out.println(df.format(collisionrate)); 
		for(int i = 0; i < data.length; i++) //loop to print X / - for diff spots in the array 
		{
			if(data[i]== 0) 
			{
				System.out.print("-");
			}
			else System.out.print("x");
		}
		System.out.println();
		for(int i =0;i<data.length;i++) { //find the max value in the data to represent max chain 
			if(data[i] > largest) {

				largest = data[i];
			}

		}
		System.out.println(largest-1); 
		NumberFormat nf = NumberFormat.getInstance(); //uses NumberFormat in order to get the rounded percent for the fill rate 
		nf.setRoundingMode(RoundingMode.HALF_UP); 
		nf.setMaximumFractionDigits(0); 
		System.out.println((nf.format(((inputstuff-collisioncounter)*100/size))) + "%"); 
	}
}
