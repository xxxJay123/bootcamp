import java.util.Arrays;

public class ForEach {
  public static void main(String[] args) {
    // basic for-loop
    for (int i = 0; i < 3; i++) {
      System.out.println("basic for-loop: hello");
    }
    // For-each
    int[] arr = new int[] {200, 100, 3, 4};
    // for (Type Element : Dataset)
    // Difference of for-each:
    // 1. for-each does not have stop condition/ counter in loop signature
    //
    for (int x : arr) { // loop through all elements
      System.out.println("for-each: hello, x=" + x);
      System.out.println(arr[0]); // but you still access element by index
      // modification
      arr[0] = 8;
    }
    // {1,4,10,13,20,0}
    // 1, 0
    // 4, 20
    // 10, 13
    for (int i = 0; i < arr.length; i++) { // counter
      if (i > arr.length / 2 - 1) {
        break;
      }
      System.out.println("for-each: hello");
      System.out.println("" + arr[i] + arr[arr.length - i - 1]);
      // arr[0] = 9;
    }
    //
    String[] strs = new String[] {"hello", "world"};
    for (String str : strs) {
      System.out.println(str);
    }
    // Integer, Character (Wrapper Class)
    Character[] chars = new Character[] {'L', 'a', '!', '('};
    for (Character c : chars) {
      System.out.println(c);
    }

    String s2 = "Hello world ! I am Vincent";
    String[] strings = s2.split(" "); // Use " " to split the String s2
    for (String s : strings) {
      System.out.println(s);
    }
    // Without using split(), use a for loop to split s2
    // Output: String[]
    // 1. substring()
    System.out.println(Arrays.toString(split2(" hello world a abc !  ")));
    // System.out.println(Arrays.toString(split2(" abc ")));
    // 2. toCharArray()

  }

  public static String[] split(String s) {
    // Approach 1: substring()
    // Count Spaces
    int spaceCount = 0;
    String str = s.trim();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ' ') {
        spaceCount++;
      }
    }
    int startIdx = 0;
    int idx = 0;
    String[] result = new String[spaceCount + 1];
    for (int i = 0; i < str.length(); ++i) {
      if (str.charAt(i) == ' ') {
        result[idx] = str.substring(startIdx, i);
        idx++;
        startIdx = i + 1;
      } else if (i == str.length() - 1) { // last character
        result[idx] = str.substring(startIdx, str.length());
      }
    }
    return result;
  }

  public static String[] split2(String s) {
    // Approach 2: toCharArray()
    // Count Spaces
    int spaceCount = 0;
    String str = s.trim();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ' ') {
        spaceCount++;
      }
    }
    char[] chars = str.toCharArray();
    int idx = 0;
    String[] result = new String[spaceCount + 1];
    Arrays.fill(result, ""); // assign "" to all elements
    for (int i = 0; i < chars.length; ++i) {
      if (chars[i] == ' ') {
        idx++;
      } else {
        result[idx] += chars[i];
      }
    }
    return result;
  }


}
