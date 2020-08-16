package com.embedded.queue;

import com.embedded.linkedlist.impl.LinkedList;

public class Deque<E> extends LinkedList<E> {

	public int size() {
		return size();
	}

	public boolean isEmpty() {
		return isEmpty();
	}
	
	public void clear() {
		clear();
	}

	public void enQueueRear(E element) {
		add(element);
	}

	public E deQueueFront() {
		return remove(0);
	}

	public void enQueueFront(E element) {
		add(0, element);
	}

	public E deQueueRear() {
		return remove(size() - 1);
	}

	public E front() {
		return get(0);
	}

	public E rear() {
		return get(size() - 1);
	}
}
