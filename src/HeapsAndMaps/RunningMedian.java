package HeapsAndMaps;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by ruchitmehta on 7/27/17.
 */
public class RunningMedian {
    public static void main(String args[]){
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){

            @Override
            public int compare(Integer a, Integer b){
                return b-a;
            }
        });
        queue.add(5);
        queue.add(3);
        queue.add(9);
        queue.add(1);
        queue.add(10);

        System.out.println("iterating method");
        Iterator<Integer> it = queue.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("polling method");
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
