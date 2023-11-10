public class Swap {
  public static void main(String[] args) {
    int[] arr = new int[] {100, -400, 3, 99};
    // code here ... to swap 100 and 99
    int temp = arr[0]; // backup
    arr[0] = arr[arr.length - 1];
    arr[arr.length - 1] = temp;

    // print all elements
    for (int i = 0; i < arr.length; i++) {
      System.out.println("arr[" + i + "]=" + arr[i]);
    }

    System.out.println(swapOddEvenCharacter("hello!"));
    System.out.println(swapOddEvenCharacter("abcd"));
    System.out.println(swapOddEvenCharacter("aabb"));
    System.out.println(swapOddEvenCharacter("abcdef"));
    System.out.println(swapOddEvenCharacter("abc"));
    System.out.println(swapOddEvenCharacter("c"));
  }

  // Swap
  public static String swapOddEvenCharacter(String str) {
    // hello! -> ehll!o
    // abcd -> badc
    // aabb -> aabb
    // abcdef -> badcfe
    // abc -> bac
    // c -> c
    // "" -> ""
    // "ab cd" -> "bac d"

    char[] chars = str.toCharArray();
    char temp;
    for (int i = 0; i < chars.length - 1; ++i) {
      if (i % 2 == 0) { // [0] [1] [2]
        // Swap
        temp = chars[i];
        chars[i] = chars[i + 1];
        chars[i + 1] = temp;
      }
    }
    return String.valueOf(chars); // static method
  }
}
