//Implementing "Max Heap"
public class MaxHeap {
    //Create a complete binary tree using an array
    //Then use the binary Tree to construct a heap
    int[] maxHeap;
    int heapSize;
    int realSize = 0;

    public MaxHeap(int heapSize){
        this.heapSize = heapSize;
        maxHeap = new int[heapSize+1];

        maxHeap[0] = 0;
    }

    //Function to add an element
    public void add(int element){
        realSize++;

        if(realSize > heapSize){
            System.out.println("Added too many elements!");
            realSize--;
            return;
        }
        maxHeap[realSize] = element;
        int index = realSize;
        int parent = index/2;
        // If the newly added element is larger than its parent node
        while(maxHeap[parent] < maxHeap[index] && index > 1){
            int temp = maxHeap[parent];
            maxHeap[parent] = maxHeap[index];
            maxHeap[index] = temp;
            index = parent;
            parent = index/2;
        }
    }
    //Get the top element of the Heap
    public int peek(){
        return maxHeap[1];
    }
    //Delete the top element of the Heap
    public int pop(){
        if(realSize < 1){
            System.out.println("There is no element to delete");
            return Integer.MAX_VALUE;
        }

        int elementToRemove = maxHeap[1];
        maxHeap[1] = maxHeap[realSize];
        realSize--;

        int index = 1;

        while(index < realSize/2){
            int left = index*2;
            int right = (index * 2) + 1;
            if(maxHeap[index] < maxHeap[left] || maxHeap[index] < maxHeap[right]){
                if(maxHeap[index] < maxHeap[left]){
                    int temp = maxHeap[left];
                    maxHeap[left] = maxHeap[index];
                    maxHeap[index] = temp;
                    index = left;
                }else{
                    int temp = maxHeap[right];
                    maxHeap[right] = maxHeap[index];
                    maxHeap[index] = temp;
                    index = right;
                }
            }else{
                break;
            }
        }
        return elementToRemove;
    }
    //return the number of elements in the Heap
    public int size(){
        return realSize;
    }

    public String toString(){
        if(realSize == 0){
            return "There is no element to print";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for(int i = 1; i <= realSize; i++){
            sb.append(maxHeap[i]);
            sb.append(',');
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(']');

        return sb.toString();
    }

    public static void main (String[] args) {
        MaxHeap maxheap = new MaxHeap(5);
        maxheap.add(1);
        maxheap.add(2);
        maxheap.add(3);
        // [3,1,2]
        System.out.println(maxheap.toString());
        // 3
        System.out.println(maxheap.peek());
        // 3
        System.out.println(maxheap.pop());
        System.out.println(maxheap.pop());
        System.out.println(maxheap.pop());
        // No element
        System.out.println(maxheap.toString());
        maxheap.add(4);
        // Add too many elements
        maxheap.add(5);
        // [4,1,2]
        System.out.println(maxheap.toString());

    }

}
