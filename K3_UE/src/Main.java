import java.util.Arrays;

public class Main {
    public static int[][] labelPath(int n, int[][] points){

        int[][] result=new int[n][n];

        for(int i=0; i< result.length; i++){
            for(int j=0; j< result[i].length; j++){
                result[i][j]=n;
            }
        }

        for(int i=0; i< points.length; i++){
            result[points[i][0]][points[i][1]]=-1;
        }


        return  result;
    }
    public  static  void findMatches(int[][] data, int[] pattern, int[] target) {
        for (int i = 0; i < data.length; i++) {
            int count = 0;
            for (int j = 0; j <= data[i].length - pattern.length; j++) {
                boolean match = true;
                for (int k = 0; k < pattern.length; k++) {
                    if (data[i][j + k] != pattern[k]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    count++;
                }
            }
            target[i] = count;

        }


        for (int i = 0; i < target.length; i++) {
            System.out.print(target[i] + " ");
        }
        System.out.println();

    }

    public static String insertMiddle(String input, String seps) {
        if (seps.length() == 0 || input.length() == 0) {
            return input;
        }
        int index = input.length() / 2;
        if (input.length() % 2 == 0) {
            index--;
        }
        return insertMiddle(input.substring(0, index + 1), seps.substring(1)) + seps.charAt(0) + insertMiddle(input.substring(index + 1), seps.substring(1));
    }

    public static void main(String[] args)
    {
        int[][] data0 = {{3, 0}, {0, 1}, {2, 2}};
        int[][] data1 = {{0, 1, 0, 0, 1, 0}, {}, {2, 2, 2, 2, 0, 1}};
        int[] target1 = {0, 0, 0};
        int[] target2 = {9, 9, 9, 9};
        System.out.println(Arrays.deepToString(labelPath(3, new int[][] {})));
        findMatches(data1, data0[1], target1) ;
        System.out.println(insertMiddle("01234567890123", "./-"));

    }
}