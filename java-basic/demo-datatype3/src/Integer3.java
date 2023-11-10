public class Integer3 {

  // Internal Cache (-128 to 127)
  public static void main(String[] args) {
    Integer i1 = 100;
    Integer i2 = 100;
    System.out.println(i1 == i2); // address, true
    Integer i3 = 128;
    Integer i4 = 128;
    if (i3 == 128) { // i3 -> int (Wrapper Class -> primitive)

    }
    System.out.println(i3 == i4); // address, false
    Integer i5 = -128;
    Integer i6 = -128;
    System.out.println(i5 == i6); // address, true

    Byte b1 = 127;
    // Byte b2 = new Byte(127); // destroy Internal Cache

    // Short, Long. Practice yourself

    // No Internal Cache in Float and Double
    Float f1 = 1.3f;
    Float f2 = 1.3f;
    System.out.println(f1 == f2); // false
    Double d1 = 1.3d;
    Double d2 = 1.3d;
    System.out.println(d1 == d2); // false

    Boolean bool1 = false;
    Boolean bool2 = false;
    System.out.println(bool1 == bool2); // true, same address

    // Internal Cache -> ASCII(0-127)
    Character c1 = 'a';
    Character c2 = 'a';
    Character c3 = 'Ϩ'; // ASCII code = 1000, out of cache range
    Character c4 = 'Ϩ'; // ASCII code = 1000, out of cache range
    System.out.println(c1 == c2); // true, same address
    System.out.println(c3 == c4); // false

    // valueOf() has Internal Cache
    Integer i7 = Integer.valueOf(127); // 127
    Integer i8 = 127;
    System.out.println(i7 == i8); // true

    Integer i9 = Integer.valueOf(128); // 128
    Integer i10 = 128;
    System.out.println(i9 == i10); // false

  }
}
