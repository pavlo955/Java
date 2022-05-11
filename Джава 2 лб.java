package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static Random rand = new Random();
    static int size;

    static int[] createMass() {
        System.out.println("Введіть розмір масиву: ");
        size = scan.nextInt();
        int[] mass = new int[size];
        System.out.println("Введіть елементи масиву: ");
        for (int i = 0; i < size; i++) {
            mass[i] = scan.nextInt();
        }
        return mass;
    }
    static int[] createRandMass(int min, int max) {
        System.out.println("Введіть розмір масиву: ");
        size = scan.nextInt();
        int[] mass = new int[size];
        for (int i = 0; i < size; i++) {
            mass[i] = rand.nextInt(max - min) + min;
        }
        return mass;
    }
    static void printMass(int[] mass) {
        for (int i = 0; i < mass.length; i++) {
            System.out.println(mass[i]);
        }
    }

    static void findSumPlus(int[] mass) {
        int sum = 0, kst = 0;
        for (int i = 0; i < size; i++) {
            if (mass[i] > 0) {
                sum += mass[i];
                kst++;
            }
        }
        System.out.println("Сума додатніх елементів: " + sum + ", кількість: " + kst + ";");
    }

    static void bigFive(int[] mass) {
        int kst = 0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] > 5) {
                kst++;
            }
        }
        System.out.println("Кількість елементів більше числа '5': " + kst + ";");
    }

    static int findMax(int[] mass) {
        int max = mass[0], maxIn = 0;
        for (int i = 0; i < size; i++) {
            if (max < mass[i]) {
                max = mass[i];
                maxIn = i;
            }
        }
        return maxIn;
    }
    static void afterMax(int[] mass) {
        int sum = 0, max = findMax(mass);
        for (int i = max + 1; i < size; i++) {
            sum += mass[i];
        }
        System.out.println("Сума елементів розташованих після максимального числа(" + mass[max] + ") = " + sum + ";");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Оберіть завдання, натисніть цифру: \n1 - Обчислити суму та кількість додатніх \n" +
                    "елементів масиву.; \n2 - Визначити a) кількість елементів масиву, більших за число п’ять; б) суму елементів масиву, \n" +
                    "розташованих після максимального елемента.;");
            int zav = scan.nextInt();
            switch (zav) {
                case 1:
                    int[] mass = createMass();
                    findSumPlus(mass);
                    break;
                case 2:
                    System.out.println("Оберіть спосіб вводу? \n1 - Ввід з клавіатури; \n2 - Рандомний ввід на проміжку [-100;100];");
                    zav = scan.nextInt();
                    switch (zav) {
                        case 1:
                            mass = createMass();
                            bigFive(mass);
                            afterMax(mass);
                            break;
                        case 2:
                            mass = createRandMass(-100, 100);
                            printMass(mass);
                            bigFive(mass);
                            afterMax(mass);
                            break;
                        default:
                            System.out.println("Невірне число.");
                            break;
                    }
                    break;
                default:
                    System.out.println("Невірне число.");
                    break;
            }
        }

    }
}