package Arrays;

import java.util.ArrayList;

/**
 * Created by ruchitmehta
 * https://www.interviewbit.com/problems/add-one-to-number/
 * TODO: remaining
 *
 */
public class AddOneToNumber {

    public static void main(String args[]){
        AddOneToNumber add = new AddOneToNumber();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(9);
        list.add(9);

        System.out.println(add.plusOne(list).toString());
    }

    public ArrayList<Integer> plusOne(ArrayList<Integer> A){
        int sum = 0, carry = 1;
        for(int i = A.size() - 1; i >= 0; i--){
            sum = A.get(i) + carry;
            if(sum >= 10){
                carry = 1;
            } else {
                carry = 0;
            }
            A.set(i, sum % 10);
        }

        if(carry == 1){
            ArrayList<Integer> newNumber = new ArrayList<>();
            newNumber.add(1);
            for(int i = 0; i < A.size(); i++){
                newNumber.add(A.get(i));
            }
            return newNumber;
        } else {
            return A;
        }
    }
}
