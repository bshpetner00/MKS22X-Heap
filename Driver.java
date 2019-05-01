import java.util.*;

public class Driver{
    public static void main(String[]args){
        int[] test1 = new int[]{9,1,2,1,2,3,5,6,10,20,-20};
        System.out.println(Arrays.toString(test1));
        MyHeap.heapify(test1);
        System.out.println(Arrays.toString(test1));
        MyHeap.heapsort(test1);
        System.out.println(Arrays.toString(test1));
  }
}