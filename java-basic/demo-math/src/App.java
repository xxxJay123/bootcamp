public class App {
    public static void main(String[] args) {
        System.out.println(Math.round(5.4)); // Result: 5
        System.out.println(Math.round(5.5)); // Result: 6
        System.out.println(Math.round(5.44)); // Result: 5
        System.out.println(Math.round(5.45)); // Result: 5

        System.out.println(Math.sqrt(-26));

        int num = -25;
        if (num > 0 && Math.sqrt(num) == 5) { // if num <= 0, exit
            // dosomthing
        }

        Math.random(); // 0.0 - 1.0
        // base10:
        // log10 -> 1
        // log1000 -> 3
        // base2:
        // log8 -> 3
        double number = 2.0; // The number for which we want to calculate the natural log
        double naturalLog = Math.log(number);
        System.out.println(naturalLog);

        System.out.println(Math.log10(1000)); // 3.0

        int[] nums = new int[] {-100, 100, 90, 50};
        // -100 -> 100
        // 100 + 100 + 90 + 50
        int sum = 0;
        for (int i = 0; i < nums.length; i++) { // 10 sec
            sum += Math.abs(nums[i]);
        }

        double[] arr = new double[] {-5.64, 5.23, 9.800, 6.55};
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total = total + (int) Math.round(Math.abs(arr[i])); //
        }
        System.out.println(total);

        int cubeLength = 3;
        double volume = Math.pow(cubeLength, 3); // 9
        
        int[] bases = new int[] {2, 3, 4, 5};
        int[] indexes = new int[] {3, 4, 5, 6};
        int[] results = new int[bases.length];
        for (int i = 0; i < bases.length; i++) {
            results[i] = (int) Math.pow(bases[i], indexes[i]);
        }
    }
}
