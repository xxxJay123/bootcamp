public class DataType {
  public static void main(String[] args) {
    // Number
    // Declaration
    int num; // int is a way to declare a variable
    // from now now, you can only put integer to variable num.
    // Assignment
    num = 3; // from right to left
    // Declaration + Assignment
    int n = 10;
    System.out.println("3");
    System.out.println(3);
    System.out.println(num);

    // Text
    // Declaration + Assignment
    String str = "hello   ";
    System.out.println(str);

    // String str2 = 1; // error
    // int num2 = "hello";

    // Re-assignment
    num = 10;
    // floating point
    // int num3 = 1.1; // error, int can only store Integer
    double f = 1.03;
    double f2 = 1; // OK. will explain later

    // byte, short, long
    byte b = 127;
    // byte b2 = 128; // error, out of range
    byte b3 = -128;
    // byte b4 = -129; // error, out of range

    short s = 23;
    short s2 = -60;

    long l = 400;
    long l2 = 1000;
    long l3 = 30L; // norm -> L, but not l
    System.out.println(l2);

    // floating point -> double/ float
    float f3 = 1.000000000000003f; // norm -> f, but not F
    double d4 = 23.9;

    // char, value should be assigned by single quote ''
    char gender = 'M';
    char s10 = ' ';
    // char empty = ''; // error

    // boolean
    boolean isMale = true;
    boolean isSalaryGreaterThan1000 = true;
    boolean isValid = false;

    // initialization, means the 1st time of assignment
    int a10 = 0;
    // short a10 = 2; // not OK
    // int a10 = 3; // not OK
    System.out.println(a10);
    a10 = 100;

    // String + operation
    String str1 = "something";
    String str2 = " something2";
    String result = str1 + str2;
    System.out.println(result); // something something2

    String result2 = "something" + " something2";
    System.out.println(result2); // something something2

    System.out.println(result + " " + result2); // something something2 something something2

    String str3 = "abc" + 13; // default behaviour: convert 13 to String
    // abc13
    String str4 = "abc" + 'A'; // 'A' -> String "A", abcA
    String str5 = "abcd" + true;
    System.out.println(str5); // abcdtrue

    // String str6 = 13 + 13; // error
    String str7 = "" + 13 + 13; // 13 -> String "13", result: 1313

    //
    int a = 1 + 3; // 4
    int b10 = 1 - 3; // -2
    int c10 = 2 - 80; // -78
    int i = 2 * 101; // 202
    int p = 10 / 3; // 3
    int o = 10 % 3; // 1, 1 is reminder

    a10 = 10000;
    System.out.println(o); // 1
    System.out.println(a10); // 10000
  }
}
