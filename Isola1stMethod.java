import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/************
 * @author Jamie Konigsberg
 * @date March 2nd, 2015
 * Goal: Complete ACSL 3
 * Bonuses: N/A
 * Sample Data:
43, 7, 44, 36
44, 16, 43, 45, 36, 38
31, 4, 1, 6, 8
24, 15, 23, 30, 31, 32, 25
9, 18, 2, 46, 47
 * Expected Output:
	13, 19, 25, 31, 37 
	23, 30, 37
	NONE
	16, 17, 18, 19, 20, 21
	NONE
 * 
 ************/

///MAKE MORE METHODS!
///Find piece
///Move 
///Check victory

public class Isola1stMethod {

	public static void main(String[]args) throws IOException{

		Scanner s = new Scanner(System.in); //declare scanner to take in input 
		for(int i = 1; i<5; i++)
		{
			String[][] board = new String[][]{

					{ "X",  "X",  "X",  "X",  "X",  "X",  "X",  "X", "X"},
					{ "X", "43", "44", "45", "46", "47", "48", "49", "X"},
					{ "X", "36", "37", "38", "39", "40", "41", "42", "X"},
					{ "X", "29", "30", "31", "32", "33", "34", "35", "X"},
					{ "X", "22", "23", "24", "25", "26", "27", "28", "X"},
					{ "X", "15", "16", "17", "18", "19", "20", "21", "X"},
					{ "X",  "8",  "9", "10", "11", "12", "13", "14", "X"},
					{ "X",  "1",  "2",  "3",  "4",  "5",  "6",  "7", "X"},
					{ "X",  "X",  "X",  "X",  "X",  "X",  "X",  "X", "X"},

			};
			String[] input = s.nextLine().split(", ");	
			String player1 = input[0];
			String player2 = input[1];
			int row = 0;
			int column = 0; 
			int nonecount = 0;
			for(int j = 2; j<input.length; j++)
			{
				for(int k = 1; k < 9; k++)
				{
					for(int l = 1; l < 9; l++)
					{
						if(board[k][l].equals(input[j]))
						{
							board[k][l] = "X";
						}		
					}
				}
			}


			for(int w = 1; w<9; w++) {
				for(int u = 1; u<9; u++)
				{
					if(board[w][u].equals(player2))
					{
						row = w; 
						column = u; 
					}

					for(int z = 0; z<7; z++)
					{
						if(row+z<9)
						{
							if(!board[row+z][column].equals("X") && !board[row+z][column].equals(player1))
							{
								String dog = ""; 
								dog = dog + (board[row+z][column] + ", ");
								board[row+z][column] = "X";
								if(checker(board,player1)) System.out.println(dog);
							}
							else nonecount++;
						}
						if(column+z<9)
						{
							if(!board[row][column+z].equals("X") && !board[row][column+z].equals(player1))
							{
								String dog = ""; 
								dog = dog + (board[row][column+z] + ", ");
								board[row][column+z] = "X";
								if(checker(board, player1)) System.out.println(dog);
							}
							else nonecount++;
						}
						if(row-z>0)
						{
							if(!board[row-z][column].equals("X") && !board[row-z][column].equals(player1))
							{
								String dog = ""; 
								dog = dog + (board[row-z][column] + ", ");
								board[row-z][column] = "X";
								if(checker(board, player1)) System.out.println(dog);
							}
						}
						if(column-z>0)
						{
							if(!board[row][column-z].equals("X") && !board[row][column-z].equals(player1))
							{
								String dog = ""; 
								dog = dog + (board[row][column-z] + ", ");
								board[row][column-z] = "X";
								if(checker(board,player1)) System.out.println(dog);
							}
						}
						if(row+z<9 && column-z>0)
						{
							if(!board[row+z][column-z].equals("X") && !board[row+z][column-z].equals(player1))
							{
								String dog = ""; 
								dog = dog + (board[row+z][column-z] + ", ");
								board[row+z][column-z] = "X";
								if(checker(board,player1)) System.out.println(dog);
							}
						}
						if(row-z>0 && column+z<9)
						{
							if(!board[row-z][column+z].equals("X") && !board[row-z][column+z].equals(player1))
							{
								String dog = ""; 
								dog = dog + (board[row-z][column+z] + ", ");
								board[row-z][column+z] = "X";
								if(checker(board,player1)) System.out.println(dog);
							}
						}
						if(row+z<9 && column+z<9)
						{
							if(!board[row+z][column+z].equals("X") && !board[row+z][column+z].equals(player1))
							{
								String dog = ""; 
								dog = dog + (board[row+z][column+z]+", ");
								board[row+z][column+z] = "X";
								if(checker(board,player1)) System.out.print(dog);
							}
						}
						if(row-z>0 && column-z>0)
						{
							if(!board[row-z][column-z].equals("X") && !board[row-z][column-z].equals(player1))
							{
								String dog = ""; 
								dog = dog + (board[row-z][column-z]+", ");
								board[row-z][column-z] = "X";
								checker(board, player1); 
								if(checker(board,player1)) System.out.println(dog);
							}
						}
						else System.out.println("NONE");
					}
				}

			}
		}
	}


	public static boolean checker(String[][] board, String player1)	{
		for(int x = 0; x<9; x++)
		{
			for(int y = 0; y<9; y++)
			{
				if(board[x][y].equals(player1))
				{
					if(!board[x][y+1].equals("X") || !board[x][y-1].equals("X") ||
							!board[x+1][y].equals("X") || !board[x-1][y].equals("X") ||
							!board[x+1][y+1].equals("X") || !board[x+1][y-1].equals("X") ||
							!board[x-1][y+1].equals("X") || !board[x-1][y-1].equals("X"))
						return true; 	
				} 
			}
		}
		return false;
	}
}


