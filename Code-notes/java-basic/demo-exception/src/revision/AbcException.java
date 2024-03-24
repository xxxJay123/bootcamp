package revision;

public class AbcException extends RuntimeException {
  // / by Zero
  // null pointer
  // array size (outbound)
  // concurrentModification
  public AbcException() {
    super("abc exception");
  }

  public static void main(String[] args) {
    int a = 10 / 0;
  }
}
