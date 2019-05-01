public class MyHeap {

	private static void swap(int[] data, int one, int two) {
		try {
			int val = data[one];
			data[one] = data[two];
			data[two] = val;
		}
		catch (IndexOutOfBoundsException e) {}
	}

	private static void pushDown(int[]data,int size,int index) {
		int bigMan = data[index];
		int son = index*2+1;
		int daughter = index*2+2;
		try { //to prevent errors and stop at the right moment
			if (size == 2) { //base case
				int child = index+1;
				if (data[child] > bigMan) {
					swap(data,index,child);
				}
			}
			if (son < size) {
				if (data[son] >= data[daughter] && data[son] > bigMan) {
					swap(data,son,index);
					pushDown(data,size,son);
				}
				else if (data[daughter] > bigMan) {
					swap(data,daughter,index);
					pushDown(data,size,daughter);
				}
			}	
		}
		catch (IndexOutOfBoundsException e) {}
	}
	


	private static void pushUp(int[]data,int index) {
		int papa = (index-1)/2; //get initial parent
		while (data[index] > data[papa]) { //while it still needs to move up
			swap(data,index,papa); //move it up
			papa = (papa-1)/2; //and find the new dad
		}
	}

	public static void heapify(int[]data) {
		for (int i = data.length-1; i >= 0; i--) {
			pushDown(data,data.length-1,i);
		}
	}

	public static void heapsort(int[]data) {
		heapify(data);
		for (int i = data.length-1; i > 0; i--) {
			swap(data,0,i);
			pushDown(data,i-1,0);
		}
	}
}