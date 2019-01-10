// "abcdefghijklmnaaaaa" => 'a'
// Loop string and put in map
// if key already exist add +1
// loop through hashmap
// keep track of the biggest value


import java.util.HashMap;
import java.util.Map;

public class MaxChar {

    // Time complexity O(2n)
    public char find(String n) {
        char result = 0;
        int biggest = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n.length(); i++) {
            char word = n.charAt(i);
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > biggest) {
                biggest = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }
}
