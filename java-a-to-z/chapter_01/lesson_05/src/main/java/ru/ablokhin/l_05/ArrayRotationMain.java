package ru.ablokhin.l_05;

/**
 * Created by Andrey on 15.08.2016.
 */
public class ArrayRotationMain {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        ArrayRotation arrayRotation = new ArrayRotation(arr);
        int[][] result = arrayRotation.rotate();

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j] + " ");
            }
        }
    }
}
