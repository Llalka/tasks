package task1;

import java.util.Arrays;
import java.util.Scanner;

public class task_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество элементов в массиве: ");
        int numberOfElements = sc.nextInt();
        System.out.print("Введите длину интервала: ");
        int intervalLength = sc.nextInt();
        

        int[] arr = new int[numberOfElements];
        Arrays.setAll(arr, i -> ++i);

        int current = 0;
        System.out.print("Путь: ");
        do {
            System.out.print(arr[current]);
            current = (current + intervalLength - 1) % numberOfElements;
        } while (current != 0);
    }
}
