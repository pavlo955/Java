package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Оберіть завдання: \t1 - оператора розгалуження if; \t2 - Круг і квадрат; \t3 - Маршрути трамваю; \t4 - Рівняння;");
        int zav = scanner.nextInt();
        switch (zav) {
            case 1:
                System.out.println("Оберіть спосіб:\n1 - Cкорочена форма;\n2 - Повна форма");
                zav = scanner.nextInt();
                try {
                    System.out.println("Введіть c: ");
                    float a = 1, b = 1, c = scanner.nextFloat();
                    switch (zav) {
                        case 1:
                            if (c > 0) {
                                while (!(b > 2 * a)) {
                                    System.out.println("Введіть a та b, з умовою, що b>2a: ");
                                    a = scanner.nextFloat();
                                    b = scanner.nextFloat();
                                }
                                System.out.println("y = " + (float)(Math.sqrt(b - 2 * a) + 2 * Math.sqrt(c)));
                            }
                            if (c == 0) {
                                System.out.println("Введіть a та b: ");
                                a = scanner.nextFloat();
                                b = scanner.nextFloat();
                                System.out.println("y = " + (float)(b / (c - 6 * a)));
                            }
                            if (c < 0) {
                                System.out.println("Введіть a та b: ");
                                a = scanner.nextFloat();
                                b = scanner.nextFloat();
                                System.out.println("y = " + (float)(b + 12 * Math.pow(c, 3)));
                            }
                            break;
                        case 2:
                            if (c > 0) {
                                while (!(b > 2 * a)) {
                                    System.out.println("Введіть a та b, з умовою, що b>2a: ");
                                    a = scanner.nextFloat();
                                    b = scanner.nextFloat();
                                }
                                System.out.println("y = " + (float)(Math.sqrt(b - 2 * a) + 2 * Math.sqrt(c)));
                            }
                            else if (c == 0){
                                System.out.println("Введіть a та b: ");
                                a = scanner.nextFloat();
                                b = scanner.nextFloat();
                                System.out.println("y = " +(float)(b / (c - 6 * a)));
                            }
                            else if (c < 0) {
                                System.out.println("Введіть a та b: ");
                                a = scanner.nextFloat();
                                b = scanner.nextFloat();
                                System.out.println("y = " +(float)(b + 12 * Math.pow(c, 3)));
                            }
                            else
                                System.out.println("Нема розвязків");
                            break;
                    }
                } catch (Exception ex) {
                    System.out.println("Помилка");
                }
                break;
            case 2:
                System.out.println("Введіть радіус кола та довжину сторони квадрата:");
                float r = scanner.nextFloat(), a = scanner.nextFloat();
                double Sr = Math.PI*Math.pow(r,2), Sa = Math.pow(a,2);
                if (Sr>Sa)
                    System.out.println("Коло не поміститься у квадрат.");
                else
                    System.out.println("Коло поміститься у квадрат.");
                break;
            case 3:
                System.out.println("Введіть номер рейсу трамвая:");
                zav = scanner.nextInt();
                switch (zav){
                    case 1:
                        System.out.println("Чернівці - Київ");
                        break;
                    case 2:
                        System.out.println("Чернівці - Львів");
                        break;
                    case 3:
                        System.out.println("Чернівці - Тернопіль");
                        break;
                    case 4:
                        System.out.println("Київ - Львів");
                        break;
                    case 5:
                        System.out.println("Київ - Чернігів");
                        break;
                    case 6:
                        System.out.println("Чернігів - Черкаси");
                        break;
                    case 7:
                        System.out.println("Чернівці - Луцьк");
                        break;
                    case 8:
                        System.out.println("Луцьк - Житомир");
                        break;
                    case 9:
                        System.out.println("Луцьк - Чернівці");
                        break;
                    default:
                        System.out.println("Вибраний номер рейсу не існує");
                }
                break;
            case 4:
                try {
                    System.out.println("Введіть 2 числа x та y:");
                    float x = scanner.nextFloat(), y = scanner.nextFloat();
                    double res = (x*x+x*y+y*y)/(1+x*x+y*y);
                    System.out.println("f = " + (float)res);
                    break;
                } catch (Exception ex) {
                    System.out.println("Помилка.");
                }
                break;
            default:
                System.out.println("Невірне число.");
                break;
        }
    }
}