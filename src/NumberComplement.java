/**
 * Created by dharabavishi on 6/17/17.
 */
public class NumberComplement {
    public static int findComplement(int num)
    {
        int i = 0;
        int j = 0;

        while (i < num)
        {
            i += Math.pow(2, j);
            j++;
        }

        return i - num;
    }

    public static void main(String args[]){
        String arr[];
        System.out.println("Complmenet is: " +findComplement(5));
    }
}
