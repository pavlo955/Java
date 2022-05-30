package com.company;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();
    static int n, m;

    static int[][] createRandMatrix() {
        System.out.println("Введіть розмірі матриці(n m): ");
        n = scan.nextInt();
        m = scan.nextInt();
        int[][] mtrx = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j<m;j++){
                mtrx[i][j] = rand.nextInt(100 + 100) - 100;
            }
        }
        printMtrx(mtrx);
        return mtrx;
    }
    static int[][] createMatrix(){
        System.out.println("Введіть розмірі матриці(n m): ");
        n = scan.nextInt();
        m = scan.nextInt();
        int[][] mtrx = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j<m;j++){
                mtrx[i][j] = scan.nextInt();
            }
        }
        return mtrx;
    }
    static void printMtrx(int[][]matrix) {
        String output;
        for (int i = 0; i < n; i++) {
            output = "";
            for (int j = 0; j < m; j++) {
                output += matrix[i][j] + " ";
            }
            System.out.println(output);
        }
    }
    static void printMass(int[]mass){
        String output = "";
        for (int i = 0; i<m; i++){
            output+=mass[i]+" ";
        }
        System.out.println(output);
    }

    static void serGeo(int[][]matrix){
        double dob = 1;
        for (int i = 0; i<n; i++){
            for (int j = 0; j<m;j++){
                dob*=matrix[i][j];
            }
        }
        int dil = n+m;
        System.out.println("Середнє геометричне всіх чисел: "+ (float)(Math.pow(dob, 1.0/dil))); // -8 62 -37 -86 -24 -36 -25 -37 -72 -96 -10 -57

    }

    static int findMax(int[][]matrix, boolean without, int MaxIn){
        int sum = 0, maxSum = 0, maxSumInR =0;
        for (int i =0; i<n;i++){
            if (without == true&& i==MaxIn){
                continue;
            }
            else{
                for (int j = 0; j<m;j++){
                    sum+=matrix[i][j];
                }
                if (maxSum == 0){
                    maxSum = sum;
                    maxSumInR = i;
                }
                if (maxSum<sum){
                    maxSum = sum;
                    maxSumInR = i;
                }
                sum = 0;
            }
        }
        return maxSumInR;
    }
    static void addSum(int[][]matrix, int[]mass){ // -17 0
        int max1In, max2In;
        if (m>2){
            max1In = findMax(matrix, false, 0);
            max2In = findMax(matrix, true, max1In);
        }else{
            max1In = 0; max2In = 1;
        }
        for (int i = 0; i<m;i++){
            mass[i] = matrix[max1In][i]+matrix[max2In][i];
        }
        System.out.println("Сума двох рядків з максимальною сумою("+(max1In+1)+", "+(max2In+1)+"): "); // -172  2  135
        printMass(mass);
    }

    public static void main(String[] args) {
        System.out.println("Оберіть завдання, натисніть цифру: \n1 - Знайти середнє геометричне значення всіх " +
                "елементів матриці; \n2 - Знайдені суми елементів рядків записати у одновимірний масив.;");
        int ask = scan.nextInt();
        switch (ask) {
            case 1 ->{
                System.out.println("Який спосіб вводу оберете? \n1 - Ввід з клавіатури; \n2 - Рандомний ввід на проміжку [-100;100];");
                ask = scan.nextInt();
                switch (ask) {
                    case 1 -> {
                        int[][] matrix = createMatrix();
                        serGeo(matrix);
                        break;
                    }
                    case 2 -> {
                        int[][] matrix = createRandMatrix();
                        serGeo(matrix);
                        break;
                    }
                    default -> System.out.println("Невірне число.");
                }
            }

            case 2 ->{
                System.out.println("Який спосіб вводу оберете? \n1 - Ввід з клавіатури; \n2 - Рандомний ввід на проміжку [-100;100];");
                ask = scan.nextInt();
                switch (ask) {
                    case 1 -> {
                        int[][] matrix = createMatrix();
                        int[] mass = new int[m];
                        addSum(matrix, mass);

                        break;
                    }
                    case 2 -> {
                        int[][] matrix = createRandMatrix();
                        int[] mass = new int[m];
                        addSum(matrix, mass);
                        break;
                    }
                    default -> System.out.println("Невірне число.");
                }
            }

        }
    }
}