package DynamicProgramming;

/**
 * Created by ruchitmehta on 8/9/17.
 * http://algorithms.tutorialhorizon.com/dynamic-programming-count-all-paths-in-2d-matrix-with-obstructions-in-it/
 */
public class RoboWalk {

    public static void main(String args[]){
        int arrA [][] = {{1,1,1,1},{1,1,1,1},{1,-1,1,1},{1,1,1,1}};
        RoboWalk noOfPaths = new RoboWalk();
        System.out.println("No Of Path (DP): " +noOfPaths.countDP(arrA));
    }

    public int countDP(int [][] arrA){
        int result [][] = arrA;

        for (int i = 1; i <result.length ; i++) {
            for (int j = 1; j <result[0].length ; j++) {
                if(result[i][j]!=-1){
                    result[i][j]=0;
                    if(result[i-1][j]>0)
                        result[i][j]+=result[i-1][j];
                    if(result[i][j-1]>0)
                        result[i][j]+=result[i][j-1];
                }
            }
        }

        return result[result.length-1][result[0].length-1];
    }


}
