package com.embedded.priorityqueue;

import com.embedded.heap.BinaryHeap;

import java.util.Comparator;

/**
 * 13-优先队列
 * @author rnang0
 * @date 2020/8/16
 **/
public class PriorityQueue<E> {

	/**
	 * 最大堆实现
	 */
	private BinaryHeap<E> heap;

	public PriorityQueue(Comparator<E> comparator) {
		this.heap = new BinaryHeap<>(comparator);
	}

	public PriorityQueue() {
		this(null);
	}

    public int size() {
		return heap.size();
	}

	public boolean isEmpty() {
		return heap.isEmpty();
	}

	public void clear() {
		heap.clear();
	}

	public void offer(E element) {
		heap.add(element);
	}

	public E poll() {
		return heap.remove();
	}

	public E peek() {
		return heap.get();
	}
}
