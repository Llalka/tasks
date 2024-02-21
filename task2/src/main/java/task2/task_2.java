package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class task_2 {
    public static void main(String[] args) throws FileNotFoundException {
            File file1 = new File("1.txt");
            Scanner scanner1 = new Scanner(file1);
            double xCenter = scanner1.nextDouble();
            double yCenter = scanner1.nextDouble();
            double radius = scanner1.nextDouble();
            scanner1.close();

            File file2 = new File("2.txt");
            Scanner scanner2 = new Scanner(file2);
            while (scanner2.hasNext()) {
                double x = scanner2.nextDouble();
                double y = scanner2.nextDouble();

                double distance = Math.sqrt(Math.pow(x - xCenter, 2) + Math.pow(y - yCenter, 2));

                if (distance < radius) {
                    System.out.println("1");
                } else if (distance > radius){
                    System.out.println("2");
                } else if (distance == radius){
                    System.out.println("0");
                }
            }
            scanner2.close();
    }
}
