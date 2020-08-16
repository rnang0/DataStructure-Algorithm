package com.embedded.set;

/**
 * Set的接口实现
 * @author rnang0
 * @date 2020/8/15
 **/
public interface Set<E> {
    
    int size();

	boolean isEmpty();

	void clear();

	boolean contains(E element);

	void add(E element);

	void remove(E element);

	void traversal(Visitor<E> visitor);

	public static abstract class Visitor<E> {
		boolean stop;
		public abstract boolean visit(E element);
	}
}
