/**
 * Created by dharabavishi on 6/16/17.
 */
public class BitDiff {
    public static void main(String args[]){
        int result = bitDiff(2, 3);
        System.out.println("Result is " + result);
        System.out.println("Left shift operation: " + (1 << 1));
        int temp = (1 << 1) & 1;
        System.out.println("Bitwise operation: " + temp);
        System.out.println("AND operations: " + (2 & 1));
    }


    public static int bitDiff(int a, int b)
    {
        int count = 0;
        for (int i = 0; i < 32; i++)
        {

            int aBit = (1 << i) & a;
            int bBit = (1 << i) & b;
            if (aBit != bBit)
            {
                count++;
            }
        }
        return count;
    }

}
