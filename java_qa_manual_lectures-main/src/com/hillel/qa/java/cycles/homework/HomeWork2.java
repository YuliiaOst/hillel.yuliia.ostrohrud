package com.hillel.qa.java.cycles.homework;

import java.util.Scanner;

public class HomeWork2 {
    /**
     * <p style="font-size:12px">
     * Напишемо програму, в яку потрібно вводити з клавіатури цілі числа й рахувати їх суму,
     * якщо користувач введе слово "Exit", закінчуємо програму. Вивести на екран отриману суму й завершити програму.
     * Використовуйте цикл while().
     * </p>
     * <br>
     * <h2>Підказка</h2>
     *
     * @see <a href="https://www.w3schools.blog/string-to-int-java">String To Int In Java</a>
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int sum = 0;

        while (true) {
            System.out.println("Введіть ціле число або Exit для виходу:");
            if (input.hasNextInt()) {
                int num = input.nextInt();
                sum += num;
            } else {
                String str = input.next();
                if (str.equalsIgnoreCase("exit")) {
                    break;
                } else {
                    System.err.println("Ви ввели некоректне значення. Спробуйте ще раз!");
                }
            }
        }

        System.out.println("Сума введених чисел: " + sum);

        input.close();
    }
}