package search;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ruhul on 5/9/17.
 */
public class BinarySearch_V1 {


    private BinarySearch_V1() {
    }

    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {

        String fileName = "dataSet/largeW.txt";
        //int key = 444444;
        int key = 670770;

        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream
                    .filter(line -> !line.startsWith(" "))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int[] whiteList = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            whiteList[i] = Integer.parseInt(list.get(i));
        }
        // sort the array
        Arrays.sort(whiteList);

            final long startTime = System.nanoTime();
            int index = indexOf(whiteList, key);
            final long endTime = System.nanoTime();

            System.out.println("execution time : "+(endTime - startTime)+ " nano sec");

            if (index != -1)
                System.out.println(key +" found in index : " + index);
            else
                System.out.println("Not Found");
    }
}