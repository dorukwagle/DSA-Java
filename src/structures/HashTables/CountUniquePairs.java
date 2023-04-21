/**
 *  Given an array of integers, count the number of unique pairs of
 * integers that have difference k.
 * Input: [1, 7, 5, 9, 2, 12, 3] K=2
 * Output: 4
 * We have four pairs with difference 2: (1, 3), (3, 5), (5, 7), (7, 9). Note
 * that we only want the number of these pairs, not the pairs themselves.
 */

package structures.HashTables;

import java.util.*;

public class CountUniquePairs {
    public static int countPairs(int[] array, int k){
        Map<Integer, Integer> maps = new HashMap<>();
        int count = 0;
        for (int i = 0; i < array.length; ++i){
            for (int j = i; j < array.length; ++j){
                if (Math.abs(array[i] - array[j]) == k)
                    count++;
            }
        }
        return count;
    }

//    Efficient iteration of the above method

    public static int countPairsEfficient(int[] array, int diff){
        Set<Integer> set = new HashSet<>();
        for (int j : array) set.add(j);

        int count = 0;
        for (int i : array){
            if (set.contains(i - diff))
                count++;
            if (set.contains(i + diff))
                count++;
            set.remove(i);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 5, 9, 2, 12, 3};
        int unique = countPairsEfficient(arr, 2);
        System.out.println(unique);
    }
}
