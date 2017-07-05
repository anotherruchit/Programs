package DynamicProgramming;

/**
 * Created by dharabavishi on 7/1/17.
 * https://www.interviewbit.com/problems/jump-game-array/
 *

 A = [2,3,1,1,4], return 1 ( true ).
 A = [3,2,1,0,4], return 0 ( false ).

 * http://www.programcreek.com/2014/03/leetcode-jump-game-java/
 */
public class JumpArray {

    public static void main(String args[]){
        JumpArray jump = new JumpArray();
        System.out.println("Can jump ? : " + jump.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println("Can jump ? : " + jump.canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public boolean canJump(int[] A){
        if(A.length <= 1)
            return true;

        // max stands for larget index that can be reached
        int max = A[0];

        for(int i = 0; i < A.length; i++){
            // if not enough to go to next
            if(max <= i && A[i] == 0){
                return false;
            }

            //update max
            if(i + A[i] > max){
                max = i + A[i];
            }

            // max is enough to reach the end
            if(max >= A.length - 1){
                return true;
            }
        }
        return false;
    }
}
