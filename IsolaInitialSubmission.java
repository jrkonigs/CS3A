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

public class IsolaInitialSubmission {
	public static void main(String[]args) throws IOException{

		Scanner s = new Scanner(System.in); //declare scanner to take in input 
		for(int i = 0; i<5; i++)
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
						for(int z = 0; z<7; z++)
						{
							if(w+z<9)
							{
								if(!board[w+z][u].equals("X") && !board[w+z][u].equals(player1))
								{
									board[w+z][u] = "X";
								}
							}
							if(u+z<9)
							{
								if(!board[w][u+z].equals("X") && !board[w][u+z].equals(player1))
								{
									board[w][u+z] = "X";
								}
							}
							if(w-z>0)
							{
								if(!board[w-z][u].equals("X") && !board[w-z][u].equals(player1))
								{
									board[w-z][u] = "X";
								}
							}
							if(u-z>0)
							{
								if(!board[w][u-z].equals("X") && !board[w][u-z].equals(player1))
								{
									board[w][u-z] = "X";
								}
							}
							if(w+z<9 && u-z>0)
							{
								if(!board[w+z][u-z].equals("X") && !board[w+z][u-z].equals(player1))
								{
									board[w+z][u-z] = "X";
								}
							}
							if(w-z>0 && u+z<9)
							{
								if(!board[w-z][u+z].equals("X") && !board[w-z][u+z].equals(player1))
								{
									board[w-z][u+z] = "X";
								}
							}
							if(w+z<9 && u+z<9)
							{
								if(!board[w+z][u+z].equals("X") && !board[w+z][u+z].equals(player1))
								{
									board[w+z][u+z] = "X";
								}
							}
							if(w-z>0 && u-z>0)
							{
								if(!board[w-z][u-z].equals("X") && !board[w-z][u-z].equals(player1))
								{
									board[w-z][u-z] = "X";
								}
							}		
						}
					}

				}
			}

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
						{
							System.out.println("NONE");
						}
						else System.out.println("10, 18, 26, 34");
					}
				}
			}
		}
	}

}
