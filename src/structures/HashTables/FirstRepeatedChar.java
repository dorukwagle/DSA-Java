package structures.HashTables;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedChar {
    public static char getFirstRepeatedChar(String str) {
        Set<Character> set = new HashSet<>();
        char[] charArray = str.toLowerCase().toCharArray();

        for (var ch : charArray){
            if(set.contains(ch))
                return ch;
            set.add(ch);
        }

        return Character.MIN_VALUE;
    }

    public static void main(String[] args) {
        String test = "helo world";
        System.out.println(getFirstRepeatedChar(test));
    }
}
