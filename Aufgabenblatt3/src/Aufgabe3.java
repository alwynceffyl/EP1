import com.sun.source.doctree.TextTree;

/*
    Aufgabe 3) Rekursion
*/
public class Aufgabe3 {

    private static void printEvenNumbersAscending(int start, int end) {

        if(start%2==0){
            System.out.println(start);
        }
        if(start>end){
            return ;
        }
        if(start<=end) {
            printEvenNumbersAscending(++start, end);
        }
    }

    private static void printOddNumbersDescending(int start, int end) {

        if(end%2==1){
            System.out.println(end);
        }
        if(start>end){
            return ;
        }
        if(start<=end) {
            printOddNumbersDescending(start, --end);
        }
    }

    private static int sumSquaredDigits(int number) {

        if(number<=0){return 0;}

        else {
            return (number%10)*(number%10)+sumSquaredDigits(number/10);
        }

    }

    private static String removeSpaces(String text) {

        if (text.length() <= 0 ){
            return "";
        }
        if (text.charAt(0) == ' ' ){
           return  removeSpaces(text.substring(1));
        }
        return   text.charAt(0)  + removeSpaces(text.substring(1));

    }

    public static void main(String[] args) {
        printEvenNumbersAscending(10, 20);
        System.out.println();
        printOddNumbersDescending(5, 15);
        System.out.println();

        System.out.println(sumSquaredDigits(1));
        System.out.println(sumSquaredDigits(102));
        System.out.println(sumSquaredDigits(1234));
        System.out.println(sumSquaredDigits(10000));
        System.out.println(sumSquaredDigits(93842));
        System.out.println(sumSquaredDigits(875943789));
        assert (sumSquaredDigits(1) == 1);
        assert (sumSquaredDigits(102) == 5);
        assert (sumSquaredDigits(1234) == 30);
        assert (sumSquaredDigits(10000) == 1);
        assert (sumSquaredDigits(93842) == 174);
        assert (sumSquaredDigits(875943789) == 438);
        System.out.println();

        System.out.println(removeSpaces(" "));
        System.out.println(removeSpaces("+ +"));
        System.out.println(removeSpaces(" 12 3 45 "));
        System.out.println(removeSpaces("a  b   c    d"));
        assert (removeSpaces(" ").equals(""));
        assert (removeSpaces("+ +").equals("++"));
        assert (removeSpaces(" 12 3 45 ").equals("12345"));
        assert (removeSpaces("a  b   c    d").equals("abcd"));
    }
}

