package algorithms;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringUtils {
    public static int countVowels(String str) {
        if (str == null || str.equals(""))
            return 0;

        int count = 0;
        String vowels = "aeiou";
        for (char c : str.toLowerCase().toCharArray())
            if (vowels.indexOf(c) != -1)
                count++;
        return count;
    }

//    public static String reverseString(String str) {
//        int len = str.length();
//        char[] seq = new char[len];
//        for (int i = len - 1; i >= 0; --i)
//            seq[len - 1 - i] = str.charAt(i);
//
//        return String.valueOf(seq);
//    }

    public static String reverseString(String str) {
        if (str == null)
            return "";

        int len = str.length();
        StringBuilder rev = new StringBuilder();
        for (int i = len - 1; i >= 0; --i)
            rev.append(str.charAt(i));

        return rev.toString();
    }

//    public static String reverseWords(String str) {
//        if (str == null)
//            return "";
//
//        String[] strings = str.split(" ");
//        StringBuilder reversed = new StringBuilder();
//
//        if (strings.length == 1)
//            return str;
//
//        int len = strings.length;
//        for (int i = len - 1; i >= 0; --i) {
//            reversed.append(strings[i]);
//            reversed.append(" ");
//        }
//
//        return reversed.toString().trim();
//    }
//

//    public static String reverseWords(String str) {
//        if (str == null)
//            return "";
//
//        String[] words = str.split(" ");
//
////        for (int i = 0, j = words.length - 1; i < j; ++i, --j) {
////            String temp = words[i];
////            words[i] = words[j];
////            words[j] = temp;
////        }
//
//        int i = 0;
//        int j = words.length - 1;
//
//        while (i < j) {
//            String temp = words[i];
//            words[i++] = words[j];
//            words[j--] = temp;
//        }
//
//        return String.join(" ", words);
//    }

    public static String reverseWords(String str) {
        if (str == null)
            return "";

        String[] words = str.trim().split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

//    public static boolean isRotation(String str1, String str2) {
//        // ABCD -> DABC
////              -> CDAB
////              -> BCDA
////              -> ABCD
//
//        if (str1 == null || str2 == null || str1.length() != str2.length())
//            return false;
//
//        int j = 0;
//        while (j < str2.length() - 2 && str2.charAt(j) != str1.charAt(0))
//            j++;
//
//        if (str1.charAt(0) != str2.charAt(j))
//            return false;
//
//        for (int i = 0; i < str1.length(); ++i) {
//            if (str1.charAt(i) != str2.charAt(j++))
//                return false;
//            j = j % str2.length();
//        }
//
//        return true;
//    }

    public static boolean isRotation(String str1, String str2) {
        if (str1 == null || str2 == null )
            return false;
        return  (str1.length() == str2.length() && (str1 + str1).contains(str2));
    }

    public static String removeDuplicate(String str) {
        if (str == null)
            return "";
        Set<Character> set = new HashSet<>();
        StringBuilder string = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
                string.append(c);
            }
        }

        return string.toString();
    }

//    public static char mostRepeatedChar(String str) {
//        Map<Character, Integer> map = new HashMap<>();
//
//        for (var c : str.toLowerCase().toCharArray()) {
//            if (map.containsKey(c))
//                map.replace(c, map.get(c) + 1);
//            else map.put(c, 1);
//        }
//
//        int max = 0;
//        char f = '\0';
//
//        for (char c : map.keySet()) {
//            if (c == ' ')
//                continue;
//            int a = map.get(c);
//            if (a > max) {
//                max = a;
//                f = c;
//            }
//        }
//        return f;
//    }

    public static char mostRepeatedChar(String str) {
        if (str == null || str.isEmpty())
            throw new IllegalArgumentException();

        final int ASCIIS = 256;
        int[] frequency = new int[ASCIIS];

        for (char ch : str.toLowerCase().toCharArray()) {
            if (ch == ' ')
                continue;
            frequency[ch]++;
        }

        int max = frequency[0];
        char f = ' ';
        for (int i = 1; i < ASCIIS; ++i) {
            if (frequency[i] > max) {
                max = frequency[i];
                f = (char) i;
            }
        }
        return f;
    }

//    public static String capitalize(String str) {
//        String[] words = str.split(" ");
//
//        var cap = Arrays.stream(words).map(
//                string -> string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase())
//                .toList();
//
//        return String.join(" ", cap);
//    }

    public static String capitalize(String sentence) {
        if (sentence == null || sentence.isBlank())
            throw new IllegalArgumentException();

        String[] words = sentence
                .trim()
                .replaceAll(" +", " ")
                .split(" ");

        for (int i = 0; i < words.length; ++i)
            words[i] = words[i].substring(0, 1).toUpperCase() +
                    words[i].substring(1).toLowerCase();

        return String.join(" ", words);
    }

//    public static boolean areAnagram(String str1, String str2) {
//        if (str1 == null || str2 == null || str1.length() != str2.length() || str1.isEmpty() || str2.isEmpty())
//            return false;
//
//        for (var ch : str1.split(""))
//            if (!str2.contains(ch))
//                return false;
//
//        return true;
//    }

    // find anagrams using sorting method
    public static boolean areAnagrams(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length())
            return false;

        char[] first = str1.toLowerCase().toCharArray();
        char[] second = str2.toLowerCase().toCharArray();

        Arrays.sort(first);
        Arrays.sort(second);

        return Arrays.equals(first, second);
    }

    // find anagrams using histogram method
    public static boolean areAnagramsH(String first, String second) {
        final int ALPHABETS = 26;

        if (first == null || second == null || first.length() != second.length())
            return false;

        int[] frequency = new int[ALPHABETS];
        first = first.toLowerCase();
        second = second.toLowerCase();

        for (int i = 0; i < first.length(); ++i)
            frequency[first.charAt(i) - 'a']++;

        for (int i = 0; i < second.length(); ++i) {
            var index = second.charAt(i) - 'a';
            if (frequency[index] == 0)
                return false;
            frequency[index]--;
        }
        return true;
    }

    public static boolean isPalindrome(String string) {
        if (string == null || string.isEmpty())
            return false;

        for (
                int i = 0, j = string.length() - 1;
                i < j; ++i, --j
        )
            if (string.charAt(i) != string.charAt(j))
                return false;
        return true;
    }
}
