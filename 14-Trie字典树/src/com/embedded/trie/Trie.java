package com.embedded.trie;

/**
 * @author Mango
 */
public class Trie<V> {

	private int size;

	private static class Node<V> {
		// 是否为单词的结尾，判断是否为完整单词
		boolean word;

		// 且word值存在单词结尾
		V value;
	}

	private Node<V> root;
	
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		size = 0;
		root = null;
	}

	public V get(String key) {

	}

	public boolean contains(String key) {

	}

	public V add(String key, V value) {

	}

	public V remove(String key) {

	}

	public boolean startsWith(String prefix) {

	}

}
