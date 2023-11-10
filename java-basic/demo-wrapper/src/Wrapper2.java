public class Wrapper2 {
  public static void main(String[] args) {
    // auto-boxing
    int i1 = 10;
    Integer i2 = 10; // auto-boxing
    Integer i3 = Integer.valueOf(10);
    int i4 = i2; // un-boxing

    char c = 'a';
    Character c2 = c;
    char c3 = c2;

    byte b = 1;
    Byte b2 = b;
    byte b3 = b2;

    long l4 = 100; // int -> long (upcast)
    Long l = 10L; // long -> Long (auto-box)
    // Long l10 = 10; // int -> Long (error)
    long l2 = l;
    Long l3 = l2;

  }
}
