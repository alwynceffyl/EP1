/*
    Aufgabe 2) Zweidimensionale Arrays - Sortieren und Filtern
*/
import java.lang.Math;

public class Aufgabe2 {

    private static double[][] genCircleFilter(int n, double radius) {
        //Überprüfen der Eingabewerte:
        // n muss ungerade und >=1 sein
        if(n%2==0 && n<1){
            return null;
        }

        double [][] arr =new double[n][n];

        double center = (n - 1) / 2;

        for(int x=0; x<arr.length;x++){
            for(int y=0; y<arr[x].length;y++){
                double eukAbstand =Math.sqrt(Math.pow(x-center, 2)+Math.pow(y-center, 2));
                arr[x][y]= (eukAbstand<radius)? 1 : 0;
            }
        }

        return arr;
    }

    private static double[][] applyFilter(double[][] workArray, double[][] filterArray) {

        double[][] resultArray = new double[workArray.length][ workArray[0].length];

        int centerFilterRows = (filterArray.length-1)/2;
        int centerFilterCols = (filterArray[0].length-1)/2;

        int countRowsPos=workArray.length-filterArray.length  + centerFilterRows;
        int countColsPos=workArray[0].length-filterArray[0].length + centerFilterCols;

        for (int x = centerFilterRows; x < workArray.length && x <= countRowsPos; x++) {
            for (int y = centerFilterCols; y <  workArray[0].length && y <= countColsPos; y++) {
                double sum = 0;
                for (int i = 0; i < filterArray.length; i++) {
                    for (int j = 0; j < filterArray[i].length; j++) {
                        int workArrayX=x - centerFilterRows + i;
                        int workArrayY=y - centerFilterCols + j;
                        sum += filterArray[i][j] * workArray[workArrayX][workArrayY];
                    }
                }
                resultArray[x][y] = sum;
            }
        }

        return resultArray;
    }

    private static void print(double[][] workArray) {
        if (workArray != null) {
            for (int y = 0; y < workArray.length; y++) {
                for (int x = 0; x < workArray[y].length; x++) {
                    System.out.printf("%.2f", workArray[y][x]);
                    System.out.print("\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        double[][] myResultArray;

        double[][] myFilter1 = genCircleFilter(3, 1.2);
        System.out.println("Output -> myFilter1 (genCircleFilter mit size = 3 und radius = 1.2):");
        print(myFilter1);

        double[][] myFilter2 = genCircleFilter(7, 2.5);
        System.out.println("Output -> myFilter2 (genCircleFilter mit size = 7 und radius = 2.5):");
        print(myFilter2);

        double[][] myArray1 = {{0, 0, 0, 0, 0}, {0, 1, 1, 1, 0}, {0, 2, 2, 2, 0}, {0, 3, 3, 3, 0}, {0, 0, 0, 0, 0}};
        System.out.println("Output -> myArray1:");
        print(myArray1);

        myResultArray = applyFilter(myArray1, myFilter1);
        System.out.println("Output -> myFilter1 applied to myArray1:");
        print(myResultArray);


        myResultArray = applyFilter(myArray1, myFilter2);
        System.out.println("Output -> myFilter2 applied to myArray1:");
        print(myResultArray);

        //Beispiel aus Aufgabenblatt
        double[][] myArray3 = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}};
        double[][] myFilter3 = {{1, 0, 0}, {1, 2, 0}, {0, 0, 3}};
        System.out.println("Output -> myArray3:");
        print(myArray3);
        System.out.println("Output -> myFilter3:");
        print(myFilter3);
        myResultArray = applyFilter(myArray3, myFilter3);
        System.out.println("Output -> myFilter3 applied to myArray3:");
        print(myResultArray);

        double[][] myArray4 = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 1, 2, 3, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        System.out.println("Output -> myArray4:");
        print(myArray4);
        //TODO: Erstellen Sie den Filter aus dem Aufgabenblatt, wenden Sie ihn auf myArray4 an und geben Sie das Ergebnis mittels print() aus
        System.out.println("Output -> myFilter4:");
        double[][] myFilter4 = {{0, 0, 0}, {0, 0, 0}, {0, 0.5, 0}};
        print(myFilter4);
        myResultArray = applyFilter(myArray4, myFilter4);
        System.out.println("Output -> myFilter4 applied to myArray4:");
        print(myResultArray);

    }


}
