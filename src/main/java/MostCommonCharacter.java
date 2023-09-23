import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MostCommonCharacter {
    /**
     * Find the most common character in str.
     * You could use a HashMap that maps a Character key to an Int value to represent how many times a Character has
     * been spotted.
     * @param str A String.
     * @return the most common character within str.
     */
    public char recurringChar(String str) {
        Set<Character> charSet = new HashSet<>();
        char[] strArr = str.toCharArray();
        for (int i = 0; i < strArr.length; i++) {
            charSet.add(strArr[i]);
        }

        Map<Character, Integer> charMap = new HashMap<>();
            
        for (char c : strArr) {
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            } else {
                charMap.put(c, 1);
            }
        }

        LinkedHashMap<Character, Integer> sortedMap = charMap.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    
    System.out.println(sortedMap);
      
        return sortedMap.keySet().iterator().next();
    }
    
}