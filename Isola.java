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
44, 43, 37, 38, 45, 0
44, 16, 43, 45, 36, 38, 0
31, 4, 1, 6, 8, 0
24, 15, 23, 30, 31, 32, 25, 0
9, 18, 2, 46, 47, 0

 * Expected Output:
36, 29, 22, 15, 8, 1 
23, 30, 37
NONE
16, 17, 18, 19, 20, 21
NONE
 * 
 ************/

public class Isola {
	public static void main(String[]args) throws IOException{

		Scanner s = new Scanner(System.in); //declare scanner to take in input 
		for(int i = 0; i<5; i++)
		{
			int[][] board = new int[][]{

					{ 0,  0,   0,  0,  0,  0,  0,  0, 0},
					{ 0,  43, 44, 45, 46, 47, 48, 49, 0},
					{ 0,  36, 37, 38, 39, 40, 41, 42, 0},
					{ 0,  29, 30, 31, 32, 33, 34, 35, 0},
					{ 0,  22, 23, 24, 25, 26, 27, 28, 0},
					{ 0,  15, 16, 17, 18, 19, 20, 21, 0},
					{ 0,   8,  9, 10, 11, 12, 13, 14, 0},
					{ 0,   1,  2,  3,  4,  5,  6,  7, 0},
					{ 0,   0,  0,  0,  0,  0,  0,  0, 0},

			};
			String[] input = s.nextLine().split(", ");	
			int[]input1 = new int[input.length];
			for (int j = 0; j < input.length; j++) {
				input1[j] = Integer.parseInt(input[j]);
			}
			int player1 = input1[0];
			int player2 = input1[1];
			int row2 = 0; 
			int column2 = 0;
			String dog =  ""; 
			String dog1 = ""; 
			String dog2 = ""; 
			String dog3 = ""; 
			String dog4 = ""; 
			String dog5=  ""; 
			String dog6 = ""; 
			String dog7 = "";
			boolean worked = false; 
			for(int j = 2; j<input1.length; j++)
			{
				for(int k = 1; k < 9; k++)
				{
					for(int l = 1; l < 9; l++)
					{
						if(board[k][l] == input1[j])
						{
							board[k][l] = 0;
						}		
					}
				}
			}
			for(int w = 1; w<9; w++) {
				for(int u = 1; u<9; u++)
				{
					if(board[w][u] == player2)
					{
						row2 = w; 
						column2 = u; 
						board[w][u] = 0; 
					}
				}
			}

			for(int z = 1; z<7; z++)
			{
				if(row2+z<9)
				{
					if(board[row2+z][column2] != 0 && board[row2+z][column2] != player1)
					{
						dog = dog + (board[row2+z][column2] + ", ");
						board[row2+z][column2] = 0;
						if(checker(board,player1) && (board[row2+z+1][column2] == 0 || board[row2+z+1][column2] == player1)) 
						{
							System.out.println(dog.substring(0,dog.length()-2));
							worked = true; 
						}
					}
				}
			}
			reset(board,input1);
			for(int z1 = 1; z1<7; z1++)
			{
				if(column2+z1<9)
				{
					if(board[row2][column2+z1] != 0 && board[row2][column2+z1] != player1)
					{
						dog1 = dog1 + (board[row2][column2+z1] + ", ");
						board[row2][column2+z1] = 0;
						if(checker(board, player1) && (board[row2][column2+z1+1] == 0 || board[row2][column2+z1+1] == player1)) 
						{
							System.out.println(dog1.substring(0,dog1.length()-2));
							worked = true; 
						}
					}
				}
			}
			reset(board,input1);
			for(int z2 = 1; z2<7; z2++)
			{
				if(row2-z2>0)
				{
					if(board[row2-z2][column2] != 0 && board[row2-z2][column2] != player1)
					{
						dog2 = dog2 + (board[row2-z2][column2] + ", ");
						board[row2-z2][column2] = 0;
						if(checker(board, player1) && (board[row2-z2-1][column2] == 0 || board[row2-z2-1][column2] == player1)) 
						{
							System.out.println(dog2.substring(0,dog2.length()-2));
							worked = true; 
						}
					}
				}
			}
			reset(board,input1);

			for(int z3 = 1; z3 < 7; z3++)
				if(column2-z3>0)
				{
					if(board[row2][column2-z3] != 0 && board[row2][column2-z3] != player1)
					{
						dog3 = dog3 + (board[row2][column2-z3] + ", ");
						board[row2][column2-z3] = 0;
						if(checker(board,player1) && (board[row2][column2-z3-1] == 0 || board[row2][column2-z3-1] == player1)) 
						{
							{
								System.out.println(dog3.substring(0,dog3.length()-2));
								worked = true; 
							}
						}
					}
				}	
			reset(board,input1);

			for(int z4 = 1; z4<7; z4++)
			{
				if(row2+z4<9 && column2-z4>0)
				{
					if(board[row2+z4][column2-z4] == 0 && board[row2+z4][column2-z4] != player1)
					{
						dog4 = dog4 + (board[row2+z4][column2-z4] + ", ");
						board[row2+z4][column2-z4] = 0;
						if(checker(board,player1) && (board[row2+z4+1][column2-z4-1] == 0 || board[row2+z4+1][column2-z4-1] == player1)) 
						{
							System.out.println(dog4.substring(0,dog4.length()-2));
							worked = true; 
						}
					}
				}
			}
			reset(board,input1);

			for(int z5 = 1; z5<7; z5++)
			{
				if(row2-z5>0 && column2+z5<9)
				{
					if(board[row2-z5][column2+z5] != 0 && board[row2-z5][column2+z5] != player1)
					{
						dog5 = dog5 + (board[row2-z5][column2+z5] + ", ");
						board[row2-z5][column2+z5] = 0;
						if(checker(board,player1) && (board[row2-z5-1][column2+z5+1] == 0 || board[row2-z5-1][column2+z5+1] == player1)) 
						{
							System.out.println(dog5.substring(0,dog5.length()-2));
							worked = true; 
						}

					}
				}
			}
			reset(board,input1);

			for(int z6 =1; z6<7; z6++)
			{
				if(row2+z6<9 && column2+z6<9)
				{
					if(board[row2+z6][column2+z6] != 0 && board[row2+z6][column2+z6] != player1)
					{
						dog6 = dog6 + (board[row2+z6][column2+z6]+", ");
						board[row2+z6][column2+z6] = 0;
						if(checker(board,player1) && (board[row2+z6+1][column2+z6+1] == 0 || board[row2+z6+1][column2+z6+1] == player1)) 
						{
							System.out.println(dog6.substring(0,dog6.length()-2));
							worked = true; 
						}
					}
				}
			}

			reset(board,input1);

			for(int z7 = 1; z7 <7; z7++)
			{
				if(row2-z7>0 && column2-z7>0)
				{
					if(board[row2-z7][column2-z7] != 0 && board[row2-z7][column2-z7] != player1)
					{		
						dog7 = dog7 + (board[row2-z7][column2-z7]+", ");
						board[row2-z7][column2-z7] = 0;
						if(checker(board,player1) && (board[row2-z7-1][column2-z7-1] == 0 || board[row2-z7-1][column2-z7-1] == player1)) 
						{
							System.out.println(dog7.substring(0,dog7.length()-2));
							worked = true; 
						}
					}
				}
			}
			if(worked == false) System.out.println("NONE");
		}
	}
	
	public static boolean checker(int[][] board, int player1)	{
		int row1 = 0;
		int column1 = 0; 
		for (int i = 0; i < 8; i++) {
			for(int j=0; j< 8; j++) {
				if(board[i][j] == player1)
				{
					row1 = i;
					column1 =j;

				}
			}
		}

		if(board[row1][column1+1] == 0 && board[row1][column1-1] == 0 &&
				board[row1+1][column1] == 0 && board[row1-1][column1] == 0 &&
				board[row1+1][column1+1] == 0 && board[row1+1][column1-1] == 0 &&
				board[row1-1][column1+1] == 0 && board[row1-1][column1-1] == 0)
		{
			return true; 
		}
		else {
			return false; 
		}
	}


public static int[][] reset(int[][]board, int[]input1)
{
	board[0][0] = 0; board[0][1] = 0;   board[0][2] =  0;  board[0][3] = 0;   board[0][4] = 0;   board[0][5] = 0;   board[0][6] = 0;   board[0][7] =  0; board[0][8] = 0;
	board[1][0] = 0; board[1][1] = 43;  board[1][2] = 44;  board[1][3] = 45;  board[1][4] = 46;  board[1][5] = 47;  board[1][6] = 48;  board[1][7] = 49; board[1][8] = 0;
	board[2][0] = 0; board[2][1] = 36;  board[2][2] = 37;  board[2][3] = 38;  board[2][4] = 39;  board[2][5] = 40;  board[2][6] = 41;  board[2][7] = 42; board[2][8] = 0;
	board[3][0] = 0; board[3][1] = 29;  board[3][2] = 30;  board[3][3] = 31;  board[3][4] = 32;  board[3][5] = 33;  board[3][6] = 34;  board[3][7] = 35; board[3][8] = 0;
	board[4][0] = 0; board[4][1] = 22;  board[4][2] = 23;  board[4][3] = 24;  board[4][4] = 25;  board[4][5] = 26;  board[4][6] = 27;  board[4][7] = 28; board[4][8] = 0;
	board[5][0] = 0; board[5][1] = 15;  board[5][2] = 16;  board[5][3] = 17;  board[5][4] = 18;  board[5][5] = 19;  board[5][6] = 20;  board[5][7] = 21; board[5][8] = 0;
	board[6][0] = 0; board[6][1] =  8;  board[6][2] = 9;   board[6][3] = 10;  board[6][4] = 11;  board[6][5] = 12;  board[6][6] = 13;  board[6][7] = 14; board[6][8] = 0;
	board[7][0] = 0; board[7][1] =  1;  board[7][2] = 2;   board[7][3] =  3;  board[7][4] =  4;  board[7][5] =  5;  board[7][6] =  6;  board[7][7] =  7; board[7][8] = 0;
	board[8][0] = 0; board[8][1] =  0;  board[8][2] = 0;   board[8][3] =  0;  board[8][4] =  0;  board[8][5] =  0;  board[8][6] =  0;  board[8][7] =  0; board[8][8] = 0;
	for(int j = 2; j<input1.length; j++)
	{
		for(int k = 1; k < 9; k++)
		{
			for(int l = 1; l < 9; l++)
			{
				if(board[k][l] == input1[j])
				{
					board[k][l] = 0;
				}		
			}
		}
	}
	return board;
}
}