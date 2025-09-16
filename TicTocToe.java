package com.projects.tictoctoe;

import java.util.Scanner;

public class TicTocToe {
	static char player = 'X';
	static char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			display();
			System.out.println("Player " + player + " turn");
			System.out.println("Enter row number(0-2)");
			int row = sc.nextInt();
			System.out.println("Enter column number(0-2)");
			int col = sc.nextInt();

			// To check if input is valid
			if (row < 0 || row >= 3 || col < 0 || col >= 3) {
				System.out.println("Invalid Position !! Please try again  ");
				continue;
			}

			// To check if the position is already occupied
			if (board[row][col] != ' ') {
				System.out.println("This position is already taken ! Please Try again !!");
				continue;
			}
			
			// Place the move
			board[row][col] = player;

			// check win
						if (checkWin(player)) {
							display();
							System.out.println(" Player " + player + " wins!");
							break;
						}
						// check draw
						if (checkFull()) {
							display();
							System.out.println(" It's a draw!");
							break;
						}

			// Switch the move
			player = player == 'X' ? 'O' : 'X';

		}
		sc.close();
	}

	public static void display() {

		System.out.println("------------");
		for (char a1[] : board) {
			System.out.print("|");
			for (char a2 : a1) {
				System.out.print(a2 + " | ");
			}
			System.out.println();
			System.out.println("------------");

		}
	}

	// To check Win
	public static boolean checkWin(char p) {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
				return true;
			}
		}
		
		for (int i = 0; i < 3; i++) {
			if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
				return true;
			}
		}

		if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			return true;
		}
		if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
			return true;
		}

		return false;
	}

	// check if board is full
	public static boolean checkFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}

}
