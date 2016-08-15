package ru.ablokhin.l_05;

/**
 * Created by Andrey on 15.08.2016.
 */
public class SortMain {
    public static void main(String[] args) {

        int arrLen = args.length;
        int[] arr = new int[arrLen];

        for(int i = 0; i < arrLen; i++){
            arr[i] = Integer.valueOf(args[i]);
        }

        Sort bubbleSort = new Sort(arr);
        int[] result = bubbleSort.sort();

        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
