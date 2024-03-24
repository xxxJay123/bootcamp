import java.util.Arrays;
import java.util.Random;

public class Swap2 {
  public static void main(String[] args) {
    int[] nums = new int[] {8, 3, -10, 30, 100, -19};
    // Move the max number to the tail
    // {8, 3, -10, 30, -19, 100}
    // Step1: Find the index of the max number
    int maxIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > nums[maxIndex]) {
        maxIndex = i; // store the index
      }
    }
    // Step2: Swap the max number to tail
    int temp = nums[maxIndex];
    nums[maxIndex] = nums[nums.length - 1];
    nums[nums.length - 1] = temp;
    System.out.println(Arrays.toString(nums));

    // Test average(int[])
    int[] testCase = new int[] {2, 3, 0};
    System.out.println(average(testCase)); // ~1.6667

    int[] classA = new int[] {20, 30, 80, 100, 30};
    int[] classB = new int[] {90, 30, 100};

    if (average(classA) > average(classB)) {
      System.out.println("Class A has higher average score");
    }
  }

  public static double average(int[] arr) {
    // calculate the average of all numbers in arr.
    int sum = 0;
    for (int i = 0; i < arr.length; ++i) {
      sum += arr[i];
    }
    // return sum / arr.length; // 5 / 3 -> 1 -> 1.0
    return (double) sum / arr.length;
  }
}
