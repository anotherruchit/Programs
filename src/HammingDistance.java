/**
 * Created by dharabavishi on 6/16/17.
 */
public class HammingDistance {

    public static int hammingDistance(int a, int b){
        int xor = a ^ b;
        int count = 0;
        while (xor != 0){
            count = count + (xor & 1);
            xor = xor >> 1;
        }
        return count;
    }

    public static void main(String args[]){
        System.out.println("Hamming distance is: " +hammingDistance(3,4));
    }
}
