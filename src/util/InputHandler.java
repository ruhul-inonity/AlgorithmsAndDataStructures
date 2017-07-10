package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ruhul on 5/24/17.
 */

//http://algs4.cs.princeton.edu/code/


public class InputHandler {

    public InputHandler() {
    }

    //takes input from file located at "dataSet" directory  and returns data as string array
    public static String[] scanStringData(String fileName){
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream
                    .filter(line -> !line.startsWith(" "))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] whiteList = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            whiteList[i] = list.get(i);
        }
        return whiteList;
    }

    //takes input from file located at "/dataSet" directory  and returns data as integer array
    public static int[] scanIntData(String fileName){
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
        return whiteList;
    }
}
