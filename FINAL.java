import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * Author: Jamie Konigsberg
 * Date: 2/9/15
 * Purpose: Complete ACSL #2
Sample Data: 
(SUB (MULT 6 2) (ADD 3 4 5) (EXP -3 -3) (SQR 4) (DIV 1 2))
SORT 2 5
REVERSE 1 4
MAXIMUM
REMOVE 3 4
COUNT

Expected Output:
(SUB (MULT 6 2) (ADD 3 4 5) (DIV 1 2) (EXP -3 -3) (SQR 4))
(SUB (SQR 4) (EXP -3 -3) (ADD 3 4 5) (MULT 6 2) (DIV 1 2))
(ADD 3 4 5)
(SUB (MULT 6 2) (ADD 3 4 5) (DIV 1 2)) 
5
 */

public class FINAL {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); //declare scanner to take in input 
		String[] input = s.nextLine().split("\\("); //taking in the first line of the input
		input[input.length-1]	= input[input.length-1].substring(0, input[input.length-1].length()-1);
		input[input.length-1]   = input[input.length-1]+" ";
		for(int i = 0; i<5; i++)
		{
			String johnny = s.nextLine();
			if(johnny.toUpperCase().contains("SO")) //all of these cases help determine which method to call
			{
				int j = Character.getNumericValue(johnny.charAt(5)); //charAt gets the different j or k values
				int k = Character.getNumericValue(johnny.charAt(7));
				sort(copy(input),j,k); //calling a method
			}
			else if(johnny.toUpperCase().contains("CO"))
			{
				System.out.print(count(copy(input)));
			}
			else if(johnny.toUpperCase().contains("REV"))
			{
				int q = Character.getNumericValue(johnny.charAt(8));
				int t = Character.getNumericValue(johnny.charAt(10));
				reverse(copy(input),q,t);
				System.out.println();
			}
			else if(johnny.toUpperCase().contains("REM"))
			{
				int m = Character.getNumericValue(johnny.charAt(7));
				int n = Character.getNumericValue(johnny.charAt(9));
				remove(copy(input),m,n);
				System.out.println();
			}
			else if(johnny.toUpperCase().contains("MAX"))
			{
				maximum(copy(input));
			}
		}
	}

	//Count
	static int count(String[] input)
	{
		int count = 0;
		for(int i=2; i<input.length; i++) //because of split, uses i=2 as first value as its the first term 
		{
			count++; 
		}
		return count; 
	}

	//Remove J K 
	static void remove(String[]input, int m, int n)
	{
		for(int i=n+1; i>=m+1; i--)
		{
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(input)); //eliminating from a String[]
			list.remove(input[i]);
			input = list.toArray(new String[input.length-1]); //converting list back to String[] with length of one less than input 
		}
		System.out.println();
		input[input.length-1] = input[input.length-1].substring(0, input[input.length-1].length()-1);
		for(int i=1; i<input.length;i++) System.out.print("(" + input[i]); 
		System.out.print(")");
	}

	//Sort J K
	static void sort(String[]input, int j, int k)
	{
		for(int i = 1; i<input.length; i++)
		{
			for(int i1=j+1; i1<k+1;i1++) //Sorting Loop (based on j and k values)
			{
				if(input[i1].charAt(0) > input[i1+1].charAt(0)) //condition of greater or not (ASCII)
				{
					String temp = input[i1];
					input[i1] = input[i1+1];
					input[i1+1] = temp; 
				}
			}
		}				
		System.out.println();
		input[input.length-1] = input[input.length-1].substring(0, input[input.length-1].length()-1);
		for(int i=1; i<input.length; i++) System.out.print("(" + input[i]);
		System.out.print(")");
		System.out.println();

	}

	//Reverse J K
	static void reverse(String[]input, int j, int k) //hard coded reverse 
	{	
		if(k-j == 1 || k-j == 2)
		{
			int q = j+1; 
			String temp = input[q];
			System.out.println(temp);
			input[q] = input[k+1];
			System.out.println(q);
			System.out.println(input[q]);
			input[k+1] = temp; 
			System.out.println(k+1);
			System.out.println(input[k+1]);
		}
		else if(k-j == 3 || k-j == 4)
		{
			int q = j+1;
			String temp = input[q];
			input[q] = input[k+1];
			input[k+1] = temp; 
			String temp2 = input[q+1];
			input[q+1] = input[k];
			input[k] = temp2;
		}
		else if(k-j == 5  || k-j == 6)
		{
			int q = j+1;
			String temp = input[q];
			input[q] = input[k+1];
			input[k+1] = temp; 
			String temp2 = input[q+1];
			input[q+1] = input[k];
			input[k] = temp2;
			String temp3 = input[q+2];
			input[q+2] = input[k-1];
			input[k-1] = temp3; 		
		}
		input[input.length-1] = input[input.length-1].substring(0, input[input.length-1].length()-1);
		for (int i = 1; i<input.length; i++) System.out.print("(" + input[i]);
		System.out.print(")");
	}

	//Maximum 
	static void maximum(String[]input) //finding the max value of spaces, using that index as max element term
	{
		int count = 0; 
		int count1 = 0; 
		int index = 0;
		for(int i = 0; i<input.length;i++)
		{
			count1 = 0;
			for(int j = 0; j<input[i].length(); j++)
			{
				if(input[i].charAt(j)==32)
				{
					count1++;
				}
			}
			if(count1>count)
			{
				index = i;
				count = count1; 
			}		
			else continue;
		}
		System.out.print("(" + input[index]); 
	}

	static String[] copy(String[] input) //in order to not change the input String[]
	{
		String [] dog = new String [input.length];
		for(int i =0; i<input.length; i++)
		{
			dog[i] = input[i];
		}
		return dog;
	}
}

