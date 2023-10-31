package com.example;
import java.util.Scanner;
public class Matrix {

    protected int [][] array; //матрица
    protected int rowsCount; //количество строк
    protected int colsCount; //количество столбцов


    //гетеры
    public int get_rowsCount() {return rowsCount;}
    public int get_colsCount() {return colsCount;}
    public int [][] get_array() {return array;}

    //сетеры
    public void set_rowsCount(int rowsCount) {this.rowsCount = rowsCount;}
    public void set_colsCount(int colsCount) {this.colsCount = colsCount;}
    public void set_array(int [][] array) {this.array = array;}



    //ввод матрицы
    public static void Input() {
        //пользователь определяет размеры желаемой матрицы
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите кол-во строк желаемой матрицы");
        int n = scan.nextInt();
        System.out.println("Введите кол-во столбцов желаемой матрицы");
        int m = scan.nextInt();
        int [][] matrix = new int [n][m];

        System.out.println("Какой ввод матрицы выбираете: поэлементный или пострончый?");
        System.out.println("поэлементный - 1");
        System.out.println("пострончый - 2");
        int answer = scan.nextInt();
        if (answer == 1) {
            //поэлементный ввод
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    System.out.println("Введите элемент, находящийся на " + x + " строке и " + y + " столбце ");
                    matrix[x][y] = scan.nextInt();
                }
            }
        } else if (answer == 2) {
            //построчный ввод
            for (int x = 0; x < n; x++) {
                System.out.println("Введите элементы "+x+"-ой строки через пробел");
                String stroka = scan.next();
                String[] words = stroka.split(" ");

                boolean flag = true;
                while (flag) {
                    if (words.length != m) {
                        System.out.println("Количество введённых вами элементов матрицы не совпадает  с количеством столбцов матрицы," +
                                "\n попробуйте ввести ещё раз: ");
                    } else {
                        flag = false;
                    }
                }

                for (int y = 0; y < m; y++) {
                    matrix[x][y] = Integer.parseInt(words[y]);
                }
            }
        } else {
            System.out.println("Такого способа ввода матриц нет :( ");
        }
    }



    //вывод матрицы
    public static void Output(int rowsCount, int colsCount, int[][] matrix) {
        System.out.println("Матрица размерами "+colsCount+"x"+rowsCount);
        for (int x = 0; x < colsCount; x++) {
            for (int y = 0; y < rowsCount; y++) {
                System.out.println(matrix[x][y] + "\t");
            }
            System.out.println("\n");
        }
    }


    //транспонирование
    public static void Transposition(int[][] matrix) {
        int str1 = matrix.length;
        int stolb1 = matrix[0].length;

        int[][] matrix_transposition = new int[stolb1][str1];

        for (int x = 0; x < str1; x++) { //строки
            for (int y = 0; y < stolb1; y++) { //столбцы
                if (x != y) {
                    matrix_transposition[x][y] = matrix[y][x];
                } else {
                    matrix_transposition[x][y] = matrix[x][y];
                }
            }
        }

        for (int x = 0; x < str1; x++) { //строки
            for (int y = 0; y < stolb1; y++) { //столбцы
                System.out.print(matrix_transposition[x][y] + "\t");
            }
            System.out.print("\n");
        }

    }
}
