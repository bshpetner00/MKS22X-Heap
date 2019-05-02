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
		if (daughter >= size && son < size && bigMan < data[son]){ //if only one child needs to swap
			swap(data, son, index);
		}
		else if (daughter < size && (bigMan < data[son] || bigMan < data[daughter])){ //two children with possible swap
			if (data[son] >= data[daughter]){
				swap(data, index, son);
				pushDown(data, size, son);
			} 
			else {
				swap(data, index, daughter);
				pushDown(data,size,daughter);
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

	public static void heapify(int[]data) {
		for (int i = data.length-1; i >= 0; i--) {
			pushDown(data,data.length-1,i);
		}
	}

	public static void heapsort(int[]data) {
		heapify(data);
		for (int i = data.length-1; i > 0; i--) {
			swap(data,i,0);
			pushDown(data,i,0);
		}
	}
}