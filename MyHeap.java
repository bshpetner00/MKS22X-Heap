public class MyHeap {

	private static void swap(int[] data, int one, int two) {
        int val = data[one];
        data[one] = data[two];
        data[two] = val;
    }

	private static void pushDown(int[]data,int size,int index) {
		int son = index*2+1; //get two childs
		int daughter = index*2+2; 
		int bigMan = data[index]; //and OG value
		if (size <= son) { //can't move it
			return;
		}
		else if (size <= daughter) { //only child (lonely)
			if (bigMax < data[son]) {
				swap(data,index,son);
			}
		}
		while (bigMan < data[son] || bigMan < data[daughter] && size > son && size > daughter) {
			if (bigMan < data[son]) {
				swap(data,index,son);
				index = son;
				son = index*2+1;
				daughter = index*2+1;
				bigMan = data[index];
			}
			else if (bigMan < data[daughter]) {
				swap(data,bigMan, daughter);
				index = daughter;
				son = index*2+1;
				daughter = index*2+1;
				bigMan = data[index];
			}
		}
	}

	private static void pushUp(int[]data,int index) {
		int papa = (index-1)/2; //get initial parent
		while (data[index] > data[papa]) { //while it still needs to move up
			swap(data,index,papa); //move it up
			papa = (papa-1)/2; //and find the new dad
		}
	}

	public static void heapify(int[]) {

	}

	public static void heapsort(int[]) {

	}
}