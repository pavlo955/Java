package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner enter = new Scanner(System.in);
        while (true) {
            System.out.println("Оберіть завдання, натисніть цифру: \n1 - Приклад з циклом; \n2 - Цикли; \n3 - Сума добутку; \n4 - В Діапазоні;");
            int zav = enter.nextInt();
            switch (zav) {
                case 1:
                    boolean cykl = true;
                    int x, y, z;
                    while (cykl) {
                        System.out.println("Введіть 3 додатніх числа: ");
                        x = enter.nextInt();
                        y = enter.nextInt();
                        z = enter.nextInt();
                        if (x > 0 && y > 0 && z > 0) {
                            cykl = false;
                            double a = (Math.pow(x, 2) + 2 * x * z - Math.pow(y, 2)) / (Math.sqrt(2 * x) - (Math.pow(x, 2) * y));
                            System.out.println("a = " + (float) a);
                        } else {
                            System.out.println("Помилка вводу. Повторіть спробу.");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Оберіть форму:\n1 - З використанням циклу з параметром;\n2 - З використанням циклу з передумовою;\n3 - З використанням циклу з післяумовою;");
                    zav = enter.nextInt();
                    double dob = 1;
                    int i;
                    switch (zav) {
                        case 1 -> {
                            for (i = 21; i < 80; i++) {
                                if (i % 10 == 0) {
                                    dob *= i;
                                }
                            }
                            System.out.println(dob);
                        }
                        case 2 -> {
                            i = 20;
                            while (i <= 80) {
                                if (i % 10 == 0) {
                                    dob *= i;
                                }
                                i++;
                            }
                            System.out.println(dob);
                        }
                        case 3 -> {
                            i = 20;
                            do {
                                if (i % 10 == 0) {
                                    dob *= i;
                                }
                                i++;
                            } while (i <= 80);
                            System.out.println(dob);
                        }
                        default -> System.out.println("Невірне число.");
                    }
                    break;
                case 3:
                    int resx, resy = 0;
                    System.out.println("Введіть 2 додатніх числа n та х: ");
                    try{
                        int n = enter.nextInt();
                        int X = enter.nextInt();
                        if (n > 0 &&X > 0) {
                            for (int I = 1; I <= n; I++) {
                                resx = 1;
                                for (int j = 1; j <= I; j++) {
                                    resx *= (I*Math.pow(j,X));
                                }
                                resy += resx;
                            }
                        }else{
                            throw new Exception();
                        }
                        System.out.println("Сума добутку формули: " + resy);
                    }catch (Exception err){
                        System.out.println("Невірне число.");
                    }
                    break;
                case 4:
                    double a = 0, b = 3;
                    double c;
                    Exception ERROR = new Exception();
                    for (c = a; c <= b; c += 0.025) {
                        try {
                            if ((float) (Math.log(c)/(4*c+13)) != -Double.POSITIVE_INFINITY)
                                System.out.println("y = " + (float) c + "\t\t\tt = " + (float)(Math.log(c)/(4*c+13)));
                            else
                                throw ERROR;
                        } catch (Exception er) {
                            System.out.println("y = " + c + "\t\t\tt = Помилка значень.");
                        }
                    }
                    break;
                default:
                    System.out.println("Невірне число.");
                    break;
            }

        }
    }
}