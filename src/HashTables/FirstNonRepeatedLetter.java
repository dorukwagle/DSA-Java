package HashTables;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedLetter {
    public static char getFirstNonRepeatedLetter(String string){
        Map<Character, Integer> map = new HashMap<>();
        char[] array = string.toLowerCase().toCharArray();
        for(var c : array){
            int count = (map.containsKey(c)? map.get(c) + 1: 1);
            map.put(c, count);
        }

        for(var item : array){
            if(map.get(item) == 1)
                return item;
        }
        return Character.MIN_VALUE;
    }

    public static void main(String[] args) {
        String str = "Hello world This is an amazing end witcher";
        String s = "tt hh kk ss ll cc asdsrda";
        System.out.println(getFirstNonRepeatedLetter(s));
    }
}
