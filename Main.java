import heaps.MinHeap;
import heaps.TaskMaxHeap;

public class Main {
    public static void main(String[] args) {
        MinHeap mh = new MinHeap(10);
        mh.insert(10);
        mh.insert(5);
        System.out.println("MinHeap Extracted: " + mh.extractMin()); 

        TaskMaxHeap tmh = new TaskMaxHeap(10);
        
       
        tmh.insert("Fix Bug", 5);
        tmh.insert("Submit Project", 10);
        
        
        System.out.println("TaskMaxHeap Extracted: " + tmh.extractMax().name); 
    }
}