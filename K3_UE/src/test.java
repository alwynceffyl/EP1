import java.util.Arrays;


public class test {
    public static int[][] labelPath(int n, int[][] points){

        int[][] result = new int[n][n];

        for(int i=0;i<points.length;i++){
            if(points[i][0] < n && points[i][1] < n ) {
                result[points[i][0]][points[i][1]] = -1;
            }
        }

        for(int i=0;i<result.length && i <n ;i++){
            for(int j=0;j<result[i].length && i<n;j++){
                if(result[i][j]!=-1) {
                    result[i][j] = n;
                }
            }
        }


        return result;

    }
    public  static  void findMatches(int[][] data, int[] pattern, int[] target) {

        boolean found = false;

        for(int i=0;i< data.length ;i++){
            for(int j=0;j<data[i].length;j++){

                for(int k=0; k<pattern.length;k++){
                    if(pattern[k] == data[i][j+k]){
                        found =true;
                    }
                    else{
                        found = false;
                    }
                }

                if(found){
                    target[i]= target[i]+1;
                    found=false;
                    j=j+pattern.length;
                }
            }
        }
        System.out.println(Arrays.toString(target));
    }

    public static String insertMiddle(String input, String seps) {

        if(input.length()<=0 || seps.length()<=0  )
        {
            return input;
        }


        return insertMiddle(input.substring(1), seps.substring(1));
    }

    public static void main(String[] args)
    {
        int[][] data0 = {{3, 0}, {0, 1}, {2, 2}};
        int[][] data1 = {{0, 1, 0, 0, 1, 0}, {}, {2, 2, 2, 2, 0, 1}};
        int[] target1 = {0, 0, 0};
        int[] target2 = {9, 9, 9, 9};
        System.out.println(Arrays.deepToString(labelPath(1, data0)));
        findMatches(data1, data0[1], target1) ;
        System.out.println(insertMiddle("01234567890123", "./-"));

    }
}