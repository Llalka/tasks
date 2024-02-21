package task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class task_4 {
    public static void main(String[] args) throws FileNotFoundException {
            File file = new File(args[0]);
            Scanner scanner = new Scanner(file);
            List <Integer> nums = new ArrayList<>();
            while(scanner.hasNextInt()) {
                nums.add(scanner.nextInt());
            }
            scanner.close();
            Collections.sort(nums);
            int minStep = 0, median = nums.get(nums.size() / 2);
            for (int num : nums) minStep += Math.abs(median - num);

            System.out.println(minStep);

    }
}
