package HeapsAndMaps;

import java.util.Arrays;

/**
 * Created by ruchitmehta on 8/2/17.
 * https://www.youtube.com/watch?v=t0Cq6tVNRBA
 *
 */
public class MinHeap {
    private int capacity = 10;
    private int size = 0;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int index){
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index){
        return 2 * index + 2;
    }

    private int getParentIndex(int childIndex){
        return (childIndex / 2) - 1;
    }

    private boolean hasLeftChild(int index){
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index){
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index){
        return getParentIndex(index) >=0;
    }

    private int leftChild(int index){
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index){
        return items[getRightChildIndex(index)];
    }

    private int getParent(int index){
        return items[getParentIndex(index)];
    }

    private void swap(int indexOne, int indexTwo){
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureCapacity(){
        if(size == capacity){
            items = Arrays.copyOf(items, capacity*2);
            capacity *= 2;
        }
    }

    public int peek(){
        if(size == 0)
            throw new IllegalStateException();
        return items[0];
    }

    public int pop(){
        if(size == 0)
            throw new IllegalStateException();

        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    private void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) < leftChild(index)){
                smallerChildIndex = getRightChildIndex(index);
            }

            if(items[index] < items[smallerChildIndex]){
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    public void add(int item){
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while(hasParent(index) && getParent(index) > items[index]){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

}
