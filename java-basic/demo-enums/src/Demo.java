public class Demo {
    public static void main(String[] args) throws Exception {
        // enum
        // 1. Finite number of members
        // Example 1:(Direction: LEFT, RIGHT, UP, DOWN)
        // Example 2:(Weekday: Monday, Tuesday ...)
        // Example 3:(Doube Entry: Debit, Credit)
        // 2. Growth of enum elements (Change %)
        System.out.println(Direction.EAST); // EAST
        System.out.println(Direction.EAST.name()); // EAST
        System.out.println(Direction.NORTH); // NORTH

        Direction east = Direction.EAST; // TBC (heap)
        System.out.println(east == Direction.NORTH); // false
        System.out.println(east != Direction.NORTH); // true
        // == and != are checking the object reference

        // values() -> loop
        for (Direction d : Direction.values()) { // Diection.values() -> static method
            System.out.println(d.name());
        }

        System.out.println(Direction.SOUTH.ordinal()); // 1
        System.out.println(Direction.EAST.ordinal()); // 0

        System.out.println(east.getDegree()); // 90
        System.out.println(east.getDirection()); // E
    }
}
