/**
 *  Given an array of integers, return indices of the two numbers such
 * that they add up to a specific target.
 * Input: [2, 7, 11, 15] - target = 9
 * Output: [0, 1] (because 2 + 7 = 9)
 * Assume that each input has exactly one solution, and you may not use
 * the same element twice.
 */

package HashTables;

import Array.Array;

import java.util.*;

public class ElementsOfGivenSum {
    public static int[] findIndices(int[] elements, int sum){
        int[] indices = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int j = 0; j < elements.length; ++j)
            map.put(elements[j], j);

        for (int i = 0; i < elements.length; i++){
            int diff = sum - elements[i];
            if (map.containsKey(diff)){
                indices[0] = i;
                indices[1] = map.get(diff);
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        int[] test = {2, 7, 11, 15};
        System.out.println(Arrays.toString(findIndices(test, 9)));
    }
}
