package lambda;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import math.LengthFunction;

public class FunctionDemo {
  public static void main(String[] args) {
    Function<String, Integer> lengthFunc = str -> str.length();
    Function<String, Character> firstCharFunc = str -> str.charAt(0);

    System.out.println(lengthFunc.apply("abc")); // 3
    System.out.println(firstCharFunc.apply("month")); // m

    LengthFunction lengthFunction = new LengthFunction();
    System.out.println(lengthFunction.apply("def")); // 3

    // Function Example in Map
    Map<String, String> map = new HashMap<>();
    map.put("abc", "Mary");
    // Function<String, String> formula = s -> "default";
    String result = map.computeIfAbsent("def", s -> "default");
    System.out.println(result);
    System.out.println(map.size()); // 2

    // BiFunction
    BiFunction<Integer, Integer, BigDecimal> addition =
        (x, y) -> BigDecimal.valueOf(x + y);
    System.out.println(addition.apply(-4, 3).abs()); // 1

    Map<String, Integer> stock = new HashMap<>();
    stock.put("clothes", 100); //

    stock.compute("clothes",
        (item, oldPrice) -> (int) (oldPrice - oldPrice * 0.1));
    System.out.println(stock.get("clothes")); // 90

    // new value: null, remove item
    stock.compute("clothes", (item, oldPrice) -> null);
    System.out.println(stock.size()); // 0

    //
    stock.compute("shoes", (item, oldPrice) -> 120);
    System.out.println(stock.get("shoes"));

  }
}
