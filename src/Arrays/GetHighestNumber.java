package Arrays;

/**
 * Created by ruchitmehta
 * Interview Question
 */
public class GetHighestNumber {
    public static void main(String args[]){
        GetHighestNumber number = new GetHighestNumber();
        System.out.println(number.getLargest(824199323));
    }

    public int getLargest(int number){

        String num = String.valueOf(number);
        int[] digits = new int[10];
        int[] repeat = new int[10];

        for(int i = 0; i < 10; i++){
            digits[i] = -1;
            repeat[i] = 0;
        }

        for(int i = 0 ; i < num.length(); i++){
//            System.out.println("processing for : " + Character.getNumericValue(num.charAt(i)));
            digits[Character.getNumericValue(num.charAt(i))] = Character.getNumericValue(num.charAt(i));
            repeat[Character.getNumericValue(num.charAt(i))]++;
        }

//        System.out.println(Arrays.toString(digits));
//        System.out.println(Arrays.toString(repeat));

        StringBuilder builder = new StringBuilder();

        for(int i = digits.length-1; i >= 0; i--){
            if(digits[i] != -1){
                for(int k = 0; k < repeat[i]; k++){
                    builder.append((digits[i]));
                }
            }
        }
        return Integer.parseInt(builder.toString());
    }
}
