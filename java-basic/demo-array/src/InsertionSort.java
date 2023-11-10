import java.util.Arrays;

public class InsertionSort {
  public static void main(String[] args) {
    // [5, 1, 4, 8, 2]
    // Step1.1: [1, 5, 4, 8, 2] (insert 1 to arr[0], 1 < 5)
    // After round 1, [1, 5] is sorted
    // step2.1: Compare 4 < 5 -> move 5 to the right
    // step2.2: Compare 1 < 4 -> [1, 4, 5]
    // After round 2, [1, 4, 5] is sorted
    // ...
    System.out.println(Arrays.toString(sort(new int[] {2, 3, 1, 10, -4}))); // [-4, 1, 2, 3, 10]
  }

  public static int[] sort(int[] arr) {
    int key = 0;
    int idx = 0;
    for (int i = 1; i < arr.length; i++) { // start from the second element
      key = arr[i]; // let the current element be "key"
      idx = i - 1; // the index of the first element to compare (from right to left)
      while (idx >= 0 && arr[idx] > key) { // check if the element > key
        arr[idx + 1] = arr[idx]; // move the element to right
        idx--;
      } // exit if the key > the left element, and < the right element, then it is the right position to insert
      arr[++idx] = key; // insert key
    }
    return arr;
  }
}
