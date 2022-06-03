public class MinHeap{
    int[] minHeap;
    int heapSize; // heapSize records the size of the array
    int realSize = 0; // realSize records the number of elements in the Heap;
    
    public MinHeap(int heapSize){
        this.heapSize = heapSize;
        minHeap = new int[heapSize+1];
        //To better track the indices of the binary tree
        //we will not use the 0-th element in the array
        //You can fill it with any value
        minHeap[0] = 0;
    }
    
    //Function to add an element
    public void add(int element){
        realSize++;
        
        if(realSize > heapSize){
            System.out.println("Added too many elements!");
            realSize--;
            return;
        }
        minHeap[realSize] = element;
        int index = realSize;
        int parent = index/2;
        
        while(minHeap[index] < minHeap[parent] && index > 1){
            int temp = minHeap[index];
            minHeap[index] = minHeap[parent];
            minHeap[parent] = temp;
            index = parent;
            parent = index / 2;
        }
    }
    
    //Get the top element of the Heap
    public int peek(){
        return minHeap[1];
    }
    
    //Delete the top element of the heap
    public int pop(){
        //If the number of elements in the current Heap is 0,
        //print "Don't have any elements" and return a default value
        if(realSize < 1){
            System.out.println("Don't have any elements");
            return Integer.MAX_VALUE;
        }else{
            //When there are still elements in the Heap
            //realSize >=1
            int removeElement = minHeap[1];
            //put the last element in the Heap to the top of Heap
            minHeap[1] = minHeap[realSize];
            realSize--;
            int index = 1;
            //When the deleted element is not a leaf node
            while(index <= realSize/2){
                int left = index * 2;
                int right = (index * 2)+1;
                if(minHeap[index] > minHeap[left] || minHeap[index] > minHeap[right]){
                    if(minHeap[index] > minHeap[left]){
                        int temp = minHeap[index];
                        minHeap[index] = minHeap[left];
                        minHeap[left] = temp;
                        index = left;
                    }else{
                        //maxHeap[left] >= maxHeap[right];
                        int temp = minHeap[right];
                        minHeap[right] = minHeap[index];
                        minHeap[index] = temp;
                        index = right;
                    }
                }else{
                    break;
                }
            }
            return removeElement;
        }
    }
    //return the number of elements 
    public int size(){
        return realSize;
    }
    public String toString(){
        if(realSize == 0){
            return "No elements!";
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for(int i = 1; i <= realSize; i++){
                sb.append(minHeap[i]);
                sb.append(',');
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append(']');
            return sb.toString();
        }
    }
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(2);
        minHeap.add(10);
        minHeap.add(9);
        minHeap.add(2);
        minHeap.add(5);
        minHeap.add(7);
        minHeap.add(9);
        minHeap.add(23);
        
        System.out.println(minHeap.toString());
        System.out.println(minHeap.peek());
        System.out.println(minHeap.pop());
        System.out.println(minHeap.toString());
        minHeap.add(4);
        minHeap.add(5); // Add too many elements
        System.out.println(minHeap.toString());
    }
}




