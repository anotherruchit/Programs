package Arrays;

import java.util.Stack;

/**
 * Created by ruchitmehta on 8/17/17.
 * https://www.careercup.com/question?id=5686024018591744
 */
public class SortValuesUsingStack {

    public static void main(String args[]){
        Stack<Integer> input = new Stack<Integer>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);
        System.out.println("input: "+input);
        System.out.println("final sorted list: "+sortStack(input));
    }

    public static Stack<Integer> sortStack(Stack<Integer> input){

        Stack<Integer> tempStack = new Stack<>();

        while(! input.isEmpty()){
            int temp = input.pop();
            while(!tempStack.isEmpty() && tempStack.peek() > temp){
                input.push(tempStack.pop());
            }
            tempStack.push(temp);

        }
        return tempStack;
    }
}
