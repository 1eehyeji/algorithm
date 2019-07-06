package baekjoon.collections;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class Compare implements Comparator<Integer>{

	@Override
	public int compare(Integer num1, Integer num2) {
		return num2.compareTo(num1);
	}
}
public class B11279 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.parseInt(br.readLine());
		
		// Comparator을 구현한 클래스를 기준으로 우선순위를 정함
		PriorityQueue<Integer> q = new PriorityQueue<>(new Compare());
		MaxHeap heap = new MaxHeap(count);
		
		/*
		for(int i = 0; i < count; ++i) {
			int value = Integer.parseInt(br.readLine());
			
			if(value != 0) heap.add(value);
			else heap.remove();
		}
		*/
		
		for(int i = 0; i < count; ++i) {
			int value = Integer.parseInt(br.readLine());
			
			if(value != 0) q.offer(value);
			else if(q.isEmpty()) System.out.println("0");
			else System.out.println(q.remove());
		}
	}

}

class MaxHeap{
	private int[] heap;
	int size = 0;
	
	public MaxHeap(int count) {
		heap = new int[count];
	}
	
	public void buildHeap() {
		int end = size - 1;
		for(int i = end / 2; i >= 0; --i) {
			heapify(i, end);
		}
	}
	
	public void heapify(int idx, int end) {
		int leftChild = (2 * idx) + 1;
		int rightChild = (2 * idx) + 2;
		int maxIdx;
		
		if(rightChild <= end) 
			maxIdx = heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
		else if(leftChild <= end)
			maxIdx = leftChild;
		else return;
		
		if(heap[maxIdx] > heap[idx]) {
			swap(maxIdx, idx);
			heapify(maxIdx, end);
		}
	}
	
	public void heapSort() {
		buildHeap();
		for(int i = size - 1; i >= 1; --i) {
			swap(0, i);
			heapify(0, i - 1);
		}
	}
	
	public void add(int n){
		heap[size] = n;
		++size;
		heapSort();
	}
	
	public void remove() {
		if(size == 0) System.out.println("0");
		else System.out.println(heap[--size]);
	}
	
	public void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}
}
