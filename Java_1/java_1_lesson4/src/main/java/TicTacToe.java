/**
 * java 1. Homework 4
 *
 * @version 20 sep 2021
 * @autor Anton_Mahin
 */

import java.util.Random;
import java.util.Scanner;

class TicTacToe {
    final char SIGN_X = 'X';
    final char SIGN_O = 'O';
    final char SIGN_EMPTY = '.';
    char[][] table;
    Random random;
    Scanner scanner;

    public static void main(String[] args) {
        new TicTacToe().game();//создаем объект на основании класса
    }

    TicTacToe() {
        random = new Random();
        scanner = new Scanner(System.in);
        table = new char[3][3];
        System.out.println("Game init...");
    }

    void game() {//Игровая логика
        initTable(); //инициализация таблицы
        while (true) {
            printTable();
            turnHuman(); //Ход человека
            if (checkWin(SIGN_X)) {
                System.out.println("YOU WIN!");
                break;
            }
            if (isTableFull()) {//проверка - победа или ничья?
                System.out.println("Sorry, DRAW");
                break;
            }
            turnAI();
            if (checkWin(SIGN_O)) {//Ход компьютера
                System.out.println("AI WIN!");
                break;
            }
            if (isTableFull()) {//проверка - победа или ничья?
                System.out.println("Sorry, DRAW");
                break;
            }
        }
        printTable();
    }

    void initTable() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                table[i][j] = SIGN_EMPTY;
            }
        }
    } //инициализация стола

    void printTable() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    } // печать стола

    boolean isTableFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j] == SIGN_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    } //заполнение таблицы

    void turnHuman() {
        int x, y;
        do {
            System.out.print("enter X Y (1..3): ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y));
        table[y][x] = SIGN_X;
    } // ход человека

    void turnAI() {
        int x, y;
        do {
            x = random.nextInt(3);
            y = random.nextInt(3);
        } while (!isCellValid(x, y));
        table[y][x] = SIGN_O;
    }//ход ИИ

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= 3 || y >= 3) {
            return false;
        }
        return table[y][x] == SIGN_EMPTY;
    }

    boolean checkWin(char ch) {
        for (int i = 0; i < 3; i++)
            if ((table[i][0] == ch && table[i][1] == ch && table[i][2] == ch) || (table[0][i] == ch && table[1][i] == ch && table[2][i] == ch))
                return true;
            if ((table[0][0] == ch && table[1][1] == ch && table[2][2] == ch) ||
                (table[0][2] == ch && table[1][1] == ch && table[2][0] == ch))
            return true;
        return false;
    }
}