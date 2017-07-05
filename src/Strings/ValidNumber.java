package Strings;

/**
 * Created by dharabavishi on 7/3/17.
 * https://www.interviewbit.com/problems/valid-number/

 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true
 "-01.1e-10" => true
 "0.1e10 " => true
 *
 */
public class ValidNumber {

    public static void main(String args[]){
        System.out.println(isValidNumber("0.1e10 "));
        System.out.println(isValidNumber("-01.1e-10 "));

    }

    public static boolean isValidNumber(String s){

        s = s.trim();

        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;

        for(int i = 0; i < s.length(); i++){
            //If we see [0-9] we reset the number flags.
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                numberSeen = true;
                numberAfterE = true;
            // We can only see . if we didn't see e or .
            } else if(s.charAt(i) == '.'){
                if(eSeen || pointSeen){
                    return false;
                }
                pointSeen = true;
            // We can only see e if we didn't see e but we did see a number
            } else if(s.charAt(i) == 'e'){
                if(eSeen || !numberSeen){
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            // We can only see + and - in the beginning and after an e
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+'){
                if(i != 0 && s.charAt(i-1) != 'e'){
                    return false;
                }
            } else {
                return false;
            }
        }

        return numberSeen && numberAfterE;
    }
}
