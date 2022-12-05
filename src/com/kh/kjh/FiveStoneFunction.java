package com.kh.kjh;

import java.util.Scanner;

public class FiveStoneFunction {

	int[][] board = new int[19][19];

	public FiveStoneFunction() {
		//board = new int[19][19];
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				board[i][j] = '*';
			}
		}
	}
	
	void cleanBoard() {
		for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 19; j++) {
				board[i][j] = '*';
	        }
        }
	}

	void printBoard() {
		System.out.print(" ");
		for (int k = 1; k < 20; k++) {
			System.out.printf("%2d", k);
		}
		System.out.println();
		for (int k = 0; k < 19; k++) {
			System.out.printf("%2d", k + 1);
			for (int m = 0; m < 19; m++) {
				System.out.print((char) board[k][m] + " ");
			}
			System.out.println("");
		}
	}

	boolean input(char player) {
		Scanner sc = new Scanner(System.in);
		int numx = 0;
		int numy = 0;
		System.out.print("xÁÂÇ¥ ÀÔ·Â : ");
		numx = sc.nextInt();
		System.out.print("yÁÂÇ¥ ÀÔ·Â : ");
		numy = sc.nextInt();
		if(board[numy - 1][numx - 1] == '*') {
		board[numy - 1][numx - 1] = player;
		return true;
		}else {
		return false;
		}
	}

	boolean victory() {
		boolean t = false;
		END1: for (int i = 0; i < 19; i++) {
			for (int j = 0; j < 15; j++) {
				if (board[i][j] != '*') {
					if (board[i][j] == board[i][j + 1] && board[i][j] == board[i][j + 2]
							&& board[i][j] == board[i][j + 3] && board[i][j] == board[i][j + 4]) {
						t = true;
						break END1;
					} else if (board[i][j] == board[i + 1][j] && board[i][j] == board[i + 2][j]
							&& board[i][j] == board[i + 3][j] && board[i][j] == board[i + 4][j]) {
						t = true;
						break END1;
					} else if (board[i][j] == board[i + 1][j + 1] && board[i][j] == board[i + 2][j + 2]
							&& board[i][j] == board[i + 3][j + 2] && board[i][j + 2] == board[i + 4][j + 2]) {
						t = true;
						break END1;
					}
				}
			}
		}
		return t;
	}
}
