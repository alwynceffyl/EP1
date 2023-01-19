/*
    Aufgabe 1) Code Analyse - Eindimensionale Arrays
*/
public class Aufgabe1 {

    private static void fillArray(int[] filledArray) {
        int number = 6;
        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = number;
            number += 6;
        }
    }

    private static void printContentFilteredArray(int[] workArray) {
        int[] copiedArray = workArray;
        for (int i = 0; i < copiedArray.length; i++) {
            if (copiedArray[i] % 4 == 0) {
                copiedArray[i] = -1;
            }
        }
        printArray(copiedArray);
    }

    private static void fillArrayWithNewContent(int[] workArray) {
        int[] helpArray = new int[10];
        int number = 6;
        for (int i = 0; i < helpArray.length; i++) {
            helpArray[i] = number;
            number += 6;
        }
        workArray = helpArray;
        printArray(workArray);
    }

    private static void printArray(int[] workArray) {
        for (int i = 0; i < workArray.length; i++) {
            System.out.print(workArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] filledArray = new int[10];
        fillArray(filledArray);
        printArray(filledArray);

        printContentFilteredArray(filledArray);
        printArray(filledArray);

        filledArray[0] = 777;
        printArray(filledArray);

        fillArrayWithNewContent(filledArray);
        printArray(filledArray);
    }

    //**************************************************************************
    //**** Notizen und Fragebeantwortungen bitte hier unterhalb durchführen! ***
    //**************************************************************************
    //Frage 1:
    // i-- bei 0 kommt -1 raus und das Array mit Index minus 1 gibt es nicht  - wirft Fehler
    //Frage 2:
    // Es zeigt immer auf den Speicher des Arrays.
    //Frage 3:
    //Weil sie auf den gleichen Speicherbereich zeigen.
    //Frage 4:
    // Weil in der Methode FillArrayWithNewContent wird ein neues Array erzeugt und es wird die Erreichbarkeit unterbunden.


    //integer ab 0
    //nein
    //durch Zuweisung des Arrays
    //Arrays.copyOf()
    //Ja
    //Operator == bei Arrays meist nicht geeignet
    //Vergleicht nur, ob Arrays die gleichen Referenzen haben. Vergleicht nicht den Inhalt der Arrays
}
