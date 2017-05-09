package search;
import java.util.Arrays;
import java.io.*;


/**
 * Created by ruhul on 5/4/17.
 */

/*
* recursive binary search with static data input
*
* */

public class BinarySearch_V0 {
    public static void main (String[] args){

        int key = 65;// key that will be searched
        int whiteList[] =  {0, 1, 3, 6,34,232,65,2,46,345};// data set where search will work
        Arrays.sort(whiteList);

        int keyLocation = binarySearch(key,whiteList); // calling search method with key and data-set
        if (keyLocation != -1){ // return value -1 means not found otherwise data found in data-set

            System.out.println("key location " + keyLocation);
        }else
            System.out.println("key not found in data set!!");


    }


    private static int binarySearch(int key, int[] dataSet){
        return binarySearch(key,dataSet,0,dataSet.length-1);//calling overloaded with key,data,low index value and high index value
    }

    private static int binarySearch(int key, int[] dataSet, int low, int high) {
        if (low > high){
            return -1;
        }
        int mid = low + (high - low)/2; //finding mid index

        if (key < dataSet[mid]){ // if true,key must be lower than mid value, so high value will be less than mid
            return binarySearch(key, dataSet, low, mid-1);
        }else if (key > dataSet[mid]){ // if true,key must be higher than mid value, so low value will be more than mid
            return binarySearch(key,dataSet,mid+1,high);
        }else {
            return mid;
        }
    }
}
