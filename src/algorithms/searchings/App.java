package algorithms.searchings;


import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class App {
    public static void main(String[] args) {
//        int[] arr = {9, 8, 2, 5, 7, 1, 3, 34, 22, 14};
        int[] arr = {9, 8, 2, 5, 7, 1, 3, 34, 22, 14};
//        int[] arr = {7, 3, 1, 5, 2};
        // 9 8 2 5 7 1 3 14 22 34
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        var found = ExponentialSearch.search(arr, 34);
        System.out.println(found);
    }
}
