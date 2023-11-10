package hashmap1;

import java.util.HashMap;
import java.util.Map;

public class DemoHashMap {
  public static void main(String[] args) {
    // Background: String[int], Array must use int as index
    // Limitation: you can only access the element by int index
    // Solution: HashMap<>
    HashMap<String, String> map = new HashMap<>();
    // <String>, String> -> <key, value>
    map.put("abc", "hello world"); // entry
    map.put("bcd", "I am Developer"); // entry
    System.out.println(map.size()); // 2 entries
    // Map.Entry -> Key + Value

    // if duplicated (equals(), hashCode()), override
    map.put("abc", "hello world !!!"); // Override the entry with key "abc"
    System.out.println(map.get("abc")); // hello world !!!
    System.out.println(map.size()); // 2 entries

    System.out.println(map.isEmpty()); // false
    System.out.println(map.toString()); // {bcd=I am Developer, abc=hello world !!!}
    System.out.println(map); // {bcd=I am Developer, abc=hello world !!!}

    System.out.println(map.containsKey("abc")); // true
    System.out.println(map.containsValue("I am Developer")); // true

    if (!map.containsKey("abc"))
      return;

    // Loop Entries
    for (Map.Entry<String, String> entry : map.entrySet()) {
      System.out.println(entry.getKey() + ":" + entry.getValue());
    }
    // Loop Keys
    for (String key : map.keySet()) {
      System.out.println(key);
    }
    // Loop Values
    for (String value : map.values()) {
      System.out.println(value);
    }

    System.out.println(map.remove("abc")); // hello world !!!
    System.out.println(map.remove("bcd", "I am NOT Developer")); // false
    System.out.println(map.remove("bcd", "I am Developer")); // true

  }
}
