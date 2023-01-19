/*
    Aufgabe 2) Eindimensionale Arrays
*/
public class Aufgabe2 {

    private static void arraycopy(int[] arr) {
        int anzahl_seven=0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]== 7) {
                anzahl_seven++;
            }
        }

        int[] copiedArray = new int[arr.length + anzahl_seven];

        for (int i = 0,k=0,l=0; i < arr.length; i++,l++) {
            if (k== 7) {
                copiedArray[l] = -1 ;
                l++;
            }
            copiedArray[l] = arr[i];
            k= arr[i];
        }

        printArray(copiedArray,' ');
    }
    private static void printArray(int[] arr,char character) {
        for (int i = 0; i < arr.length; i++) {
            if(i==arr.length-1){ System.out.print(arr[i]);}
            else {System.out.print(arr[i] +String.valueOf(character));}
        }
        System.out.println();
    }

    private static void forwhile(int[] arr) {

        for (int i = 0; i<arr.length; i++) {
            arr[i]=i+1;
        }

        System.out.print("for-Schleife: ");
        for (int i = arr.length-1; i >=0; i--) {
            if(i==0){ System.out.print(arr[i]);}
            else{System.out.print(arr[i]+",");}
        }

        System.out.println();
        System.out.print("while-Schleife: ");
        int i= arr.length-1;
        while(i>=0){
            if(i==0){ System.out.print(arr[i]);}
            else{System.out.print(arr[i]+",");}
            i--;
        }
        System.out.println();

    }

    private static void fillArray(int[] arr) {
        int number = 6;
        for (int i = 0; i < arr.length; i++) {
            if(number%9==0){arr[i]=0;}
            else {arr[i] = number;}
            number += 6;
        }
        printArray(arr,' ');
    }

    public static void main(String[] args) {
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        int[] arr1 = {6, 1, 8, 2, 5, 3, 4, 7, 9, 0};
        printArray(arr1,'#');
        int[] arr2 = new int[12];
        fillArray(arr2);
        int[] arr3 = {7, 3, 2, 7, 6, 7, 7, 8, 9, 5};
        arraycopy(arr3);
        int[] arr4 = new int[11];
        forwhile(arr4);

    }
}

