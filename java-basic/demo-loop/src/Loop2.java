public class Loop2 {
  public static void main(String[] args) {
    // break
    for (int i = 0; i < 6; i++) { // 0, 1, 2, 3, 4, 5
      for (int j = 0; j < 3; j++) { // 0, 1, 2
        System.out.println("i=" + i + " ,j=" + j);
        if (i == j) {
          break; // this break statement just break the inner loop
        }
      }
    }
    // i = 0, j = 0, yes, break
    // i = 0, j = 1, no
    // i = 0, j = 2, no
    // i = 1, j = 0, yes
    // i = 1, j = 1, yes, break
    // i = 1, j = 2, no
    // i = 2, j = 0, yes
    // i = 2, j = 1, yes
    // i = 2, j = 2, yes, break
    // ...

    // continue
    System.out.println("Example of Continue:");
    for (int i = 0; i < 6; i++) { // 0, 1, 2, 3, 4, 5
      for (int j = 0; j < 3; j++) { // 0, 1, 2
        if (i == j) {
          continue; // Skip the rest in inner loop, go to next iteration
        }
        System.out.println("i=" + i + ", j=" + j);
      }
    }
    // i = 0, j = 0, continue (skip)
    // i = 0, j = 1, print
    // i = 0, j = 2, print
    // i = 1, j = 0, print
    // i = 1, j = 1, continue (skip)
    // i = 1, j = 2, print
    // i = 2, ...

    String str = "I love programming. I love Java.";
    System.out.println("str length=" + str.length()); // 32
    // for loop: Iteration times, based on the length of the String.
    for (int i = 0; i < str.length(); i++) { // i < 32 (0 - 31)
      System.out.println("Hello");
    }
    // Print the index of the first occurrence of the character 'e'
    // str.charAt(int index)
    System.out.println(str.charAt(2)); // l, the 3rd character in the String
    for (int i = 0; i < str.length(); ++i) {
      if (str.charAt(i) == 'e') { // true/ false
        System.out.println("index=" + i);
        break;
      }
    }
    // check if 'y' exists in the string
    // Found or Not Found
    boolean found = false;
    for (int i = 0; i < str.length(); ++i) {
      if (str.charAt(i) == 'y') {
        found = true;
        break;
      }
    }
    if (found == true) {
      System.out.println("Found");
    } else {
      System.out.println("Not Found");
    }
    // if the number of occurrence of target >= 3, print Yes
    // otherwise, print No
    char target = 'o';
    int count = 0;
    boolean bonus = false;
    for (int i = 0; i < str.length(); ++i) {
      if (str.charAt(i) == target) {
        count++;
      }
      // nice to have
      if (count >= 3) {
        bonus = true;
        break;
      }
    }
    if (bonus == true) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

  }

}
