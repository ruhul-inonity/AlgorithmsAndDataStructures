package sorting;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import util.InputHandler;

import java.util.Comparator;

/**
 * Created by ruhul on 5/23/17.
 */

/*
* this implementation makes ~1/2 n^2 compares and exchanges in the worst case , so its not
* suitable for sorting large arbitrary arrays.More precisely the number of exchanges is exactly equal to the
 * number of inversions.
 *
* this algo is stable and users O(1) extra memory.
* */
public class Insertion {

    public static void main(String[] args) {

        String[] a = InputHandler.scanStringData("dataSet/tinyW.txt");
        final long startTime = System.nanoTime();
        Insertion.sort(a);
        final long endTime = System.nanoTime();
        System.out.println("execution time : "+(endTime - startTime)+ " nano sec");
        show(a);
    }

    //Rearranges the array in ascending order, using the natural order.
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }

    /*
    * helper methods of sorting functions
    * */

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    //is v < w ?
    public static boolean less(Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) < 0;
    }

    //exchange a[i] and a[j]
    private static void exchange(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    //exchange a[i] and a[j]
    private static void exchange(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /*
    * check if array is sorted
    * */
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    // is the array a[lo..hi) sorted
    private static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, 0, a.length, comparator);
    }

    // is the array a[lo..hi) sorted
    private static boolean isSorted(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo + 1; i < hi; i++)
            if (less(a[i], a[i - 1], comparator)) return false;
        return true;
    }

    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }


    //Rearranges the subarray a[lo..hi) in ascending order, using the natural order.
    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }
        assert isSorted(a, lo, hi);
    }


    // Rearranges the array in ascending order, using a comparator.
    public static void sort(Object[] a, Comparator comparator) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1], comparator); j--) {
                exchange(a, j, j - 1);
            }
            assert isSorted(a, 0, i, comparator);
        }
        assert isSorted(a, comparator);
    }

    // Rearranges the subarray a[lo..hi) in ascending order, using a comparator.

    public static void sort(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo; i < hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1], comparator); j--) {
                exchange(a, j, j - 1);
            }
        }
        assert isSorted(a, lo, hi, comparator);
    }

    // return a permutation that gives the elements in a[] in ascending order
    // do not change the original array a[]
    public static int[] indexSort(Comparable[] a) {
        int n = a.length;
        int[] index = new int[n];
        for (int i = 0; i < n; i++)
            index[i] = i;

        for (int i = 0; i < n; i++)
            for (int j = i; j > 0 && less(a[index[j]], a[index[j - 1]]); j--)
                exchange(index, j, j - 1);

        return index;
    }
}
