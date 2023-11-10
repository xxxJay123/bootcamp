public class String3 {

  // String Literal Pool (Heap) + String is immutable
  public static void main(String[] args) {
    String str = "abc";
    String str2 = "abc";
    System.out.println(str.equals(str2)); // true, "abc" is same as "abc"
    System.out.println(str == str2); // true, same value (Literal Pool)

    // String Literal Pool -> "abc"
    String str3 = "abcd";
    System.out.println(str.equals(str3)); // false
    System.out.println(str == str3); // false, their addresses are not same
    
    str = "abc100"; // because "abc100" is not equal to "abc" -> immutable -> new String object
    System.out.println(str == str2); // false

    String temp = str; 
    str = new String("abc100"); // new object
    System.out.println(temp == str); // same values, but false

  }
}
