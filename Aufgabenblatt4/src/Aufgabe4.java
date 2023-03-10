/*
    Aufgabe 4) Eindimensionale Arrays und rekursive Methoden
*/

import java.util.Arrays;

public class Aufgabe4 {

    private static void shiftHighestValue(int[] workArray, int index) {

        if(index>=workArray.length-1){
            return;
        }

        if(workArray[index]>workArray[index+1])
        {
            int temp= workArray[index+1];
            workArray[index+1]=workArray[index];
            workArray[index]=temp;
        }

        shiftHighestValue(workArray, ++index);


    }

    private static boolean containsValue(int[] workArray, int value) {

        if(workArray[0]==value) {
            return true;
        }
        if(workArray.length<=1) {
           return false;
        }

        int[] copy1 = Arrays.copyOfRange(workArray, 0, workArray.length / 2);
        int[] copy2 = Arrays.copyOfRange(workArray, workArray.length / 2, workArray.length);


        return true && (containsValue(copy1, value) || containsValue(copy2, value));

    }

    public static void main(String[] args) {
        int[] array1 = {32, 46, 22, 38, 41, 24, 33, 28, 12};
        shiftHighestValue(array1, 0);
        System.out.println(Arrays.toString(array1));

        int[] array2 = {5, 4, 3, 2, 1};
        shiftHighestValue(array2, 0);
        System.out.println(Arrays.toString(array2));

        int[] array3 = {10, 2, 3, 5, 4};
        shiftHighestValue(array3, 1);
        System.out.println(Arrays.toString(array3));

        int[] array4 = {1,5,3,6,9};
        shiftHighestValue(array4, 4);
        System.out.println(Arrays.toString(array4));
        System.out.println();

        assert (array1[array1.length-1] == 46);
        assert (array2[array2.length-1] == 5);
        assert (array3[array3.length-1] == 5);
        assert (array4[array4.length-1] == 9);

        int[] array5 = {3, 9, 17, 11, -7, 8, 0, 9, 24, -3, 17, 4};

        System.out.println(containsValue(array5, 11));
        System.out.println(containsValue(array5, 2));
        System.out.println(containsValue(array5, -7));
        System.out.println(containsValue(array5, 0));
        System.out.println(containsValue(array5, 9));
        System.out.println(containsValue(array5, 16));

        assert (containsValue(array5, 11));
        assert (!containsValue(array5, 2));
        assert (containsValue(array5, -7));
        assert (containsValue(array5, 0));
        assert (containsValue(array5, 9));
        assert (!containsValue(array5, 16));
    }
}
