import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Author: Jamie Konigsberg
 * Date: 2/9/15
 * Purpose: Complete ACSL #2
 * Sample Data: 
  1. (SUB (MULT 6 2) (ADD 3 4 5) (EXP -3 -3) (DIV 1 2) (SQR 4))
  2. SORT 2 4
  3. REVERSE 1 3
  4. MAXIMUM
  5. COUNT
  6. REMOVE 3 4
 * 
 * Expected Output:
 * 1. (SUB (MULT 6 2) (ADD 3 4 5) (DIV 1 2) (EXP -3 -3) (SQR 4))
 * 2. (SUB (EXP -3 -3) (ADD 3 4 5) (MULT 6 2) (DIV 1 2) (SQR 4))
 * 3. (ADD 3 4 5)
 * 4. 5
 * 6. (SUB (MULT 6 2) (ADD 3 4 5) (SQR 4))
 */

public class LispExpressionsSeniorDivision {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); //declare scanner to take in input 
		String[] input = s.nextLine().split(" ");
		for(int i = 0; i<input.length;i++)
		{
			System.out.println(input[i]);
		}
	}
}
//		for(int i = 0; i<5; i++)
//		{
//			if(s.nextLine().toUpperCase().contains("SO"))
//			{
//				String sorting = s.nextLine();
//				int j = sorting.charAt(8);
//				int k = sorting.charAt(10);
//				System.out.println(i+1+". " +sort(input,j,k));
//			}
//			else if(s.nextLine().toUpperCase().contains("CO"))
//			{
//				System.out.println(i+1+". " +count(input));
//			}
//			else if(s.nextLine().toUpperCase().contains("REV"))
//			{
//				String reversing = s.nextLine();
//				int q = reversing.charAt(11);
//				int t = reversing.charAt(13);
//				System.out.println(i+1+". " +reverse(input,q,t));
//			}
//			else if(s.nextLine().toUpperCase().contains("REM"))
//			{
//				String removing = s.nextLine();
//				int m = removing.charAt(10);
//				int n = removing.charAt(12);
//				System.out.println(i+1+". " +remove(input,m,n));
//			}
//			else if(s.nextLine().toUpperCase().contains("MAX"))
//			{
//				System.out.println(i+1+". " +maximum(input));
//			}
//		}
//	}
//
//		//Count
//		static int count(String[] input)
//		{
//			int count = 0;
//			for(int i=2; i<input.length; i++)
//			{
//				count++; 
//			}
//			return count; 
//		}
//
//		//Remove J K 
//		static String[] remove(String[]input, int j, int k)
//		{
//			for(int i=j-1; i<=k-1; i++)
//			{
//				ArrayList<String> list = new ArrayList<String>(Arrays.asList(input));
//				list.remove(input[i]);
//				input = list.toArray(new String[input.length]); 
//			}
//			return input; 
//		}
//
//		//Sort J K
//		static String[] sort(String[]input, int j, int k)
//		{
//			for(int i = 1; i<input.length; i++)
//			{
//				for(int i1=j-1; i1<=k-1;i1++)
//				{
//					if(input[i1].charAt(0) > input[i1+1].charAt(0))
//					{
//						//swap
//					}
//					
//				}
//			}
//			
//			return input; 
//		}
//
//
//		//Reverse J K
//		static String[] reverse(String[]input, int j, int k)
//		{
//			return input;
//		}
//
//		//Maximum 
//		static String[] maximum(String[]input)
//		{
//			
//			return input; 
//		}
//	}
