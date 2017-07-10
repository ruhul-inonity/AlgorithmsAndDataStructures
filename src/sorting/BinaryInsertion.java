package sorting;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.xml.internal.messaging.saaj.soap.ver1_1.SOAPPart1_1Impl;
import util.InputHandler;

/**
 * Created by ruhul on 5/29/17.
 */

/*
* this class provides a static method for sorting an array using an optimized binary
 * insertion sort with half exchanges.
 *
 * This implementation makes ~ n lg n compares for any array of length n.
 *  However, in the worst case, the running time is quadratic because the
 *  number of array accesses can be proportional to n^2 (e.g, if the array
 *  is reverse sorted). As such, it is not suitable for sorting large
 *  arrays (unless the number of inversions is small).
* */
public class BinaryInsertion {

    public static void main(String[] args) {
        String[] data = InputHandler.scanStringData("dataSet/tinyW.txt");
        final long startTime = System.nanoTime();
        BinaryInsertion.sort(data);
        final long endTime = System.nanoTime();
        System.out.println("Execution time of binaryInsertion: " + (endTime - startTime) + " nano sec");
        show(data);
    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {

            // binary search to determine index j at which to insert a[i]
            Comparable v = a[i]; //  v = i th index of array a.
            int lo = 0, hi = i;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (less(v, a[mid])) hi = mid; //if v is less than mid then hi = mid
                else lo = mid + 1;
            }

            // insetion sort with "half exchanges"
            // (insert a[i] at index j and shift a[j], ..., a[i-1] to right)
            for (int j = i; j > lo; --j)
                a[j] = a[j - 1];
            a[lo] = v;
        }
        assert isSorted(a);
    }

    /***
     * Helper sorting function.
     ***/

    // is v < w then true else false
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


    // Check if array is sorted - useful for debugging.

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

}
