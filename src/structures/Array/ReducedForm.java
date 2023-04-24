package structures.Array;// Given an array with N distinct elements,
// convert the given array to a reduced form
// where all elements are in range from 0 to N-1.
// The order of elements is same, i.e., 0 is placed in place of smallest element,
// 1 is placed for second smallest element, and N-1 is placed for the largest element.
// Example 1
//Input:
//        N = 3
//        Arr[] = {10, 40, 20}
// Output: 0 2 1
//        Explanation: 10 is the least element so it
//        is replaced by 0. 40 is the largest
//        element so it is replaced by 3-1 = 2. And
//        20 is the 2nd smallest element so it is
//        replaced by 1.

import java.util.Arrays;

public class ReducedForm {
    public static void main(String[] args) {
        int[] x = {20,12,3,56};

        convert(x, 4);
    }

    public static void convert(int[] arr, int n) {
        //Code here
        Arrays.stream(arr).map(item -> {
            int position = 0;
            for (int i = 0; i < n; i++){
                if(item > arr[i])
                    ++position;
            }
            return position;
        }).forEach(item -> System.out.print(item + " "));
    }
}
