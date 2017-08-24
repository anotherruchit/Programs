package HeapsAndMaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by ruchitmehta on 8/20/17.
 * https://www.youtube.com/watch?v=VmogG01IjYc&t=5s
 */
public class RunningMedianProblem {
    public static void main(String args[]){

    }

    public static double[] getMedians(int[] array){

        // max heap
        PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return -1 * a.compareTo(b);
            }
        });

        // min heap
        PriorityQueue<Integer> highers = new PriorityQueue<>();

        double[] median = new double[array.length];
        for(int i = 0; i < array.length; i++){
            int number = array[i];
            addNumber(number, lowers, highers);
            rebalance(lowers, highers);
            median[i] = getMedian(lowers, highers);

        }

        return median;
    }

    public static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        if(lowers.isEmpty() || number < lowers.peek()){
            lowers.add(number);
        } else {
            highers.add(number);
        }
    }

    public static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if(biggerHeap.size() - smallerHeap.size() >= 2){
            smallerHeap.add(biggerHeap.poll());
        }
    }

    public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if(biggerHeap.size() == smallerHeap.size()){
            return (double)(biggerHeap.peek() + smallerHeap.peek()) / 2;
        } else {
            return biggerHeap.peek();
        }
    }
}
