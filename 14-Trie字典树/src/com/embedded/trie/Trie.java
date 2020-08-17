package com.embedded.trie;

import java.util.HashMap;

/**
 * 14-Trie字典前缀树
 * @author Mango
 * @date 2020/8/16
 */
public class Trie<V> {

	private int size;

	private Node<V> root;

	private static class Node<V> {
		// 是否为单词的结尾，判断是否为完整单词
		boolean word;

		// 且word值存在单词结尾
		V value;

		Node<V> parent;

		Character character;

		HashMap<Character, Node<V>> children;

		public Node(Node<V> parent) {
			this.parent = parent;
		}
	}


	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		size = 0;
		root= null;
	}

	/**
	 * 拿取key字符串的value值
	 * @param key
	 * @return
	 */
	public V get(String key) {
		Node<V> node = node(key);
		return node != null && node.word ? node.value : null;
	}

	/**
	 * 是否有完整的单词
	 * @param key
	 * @return
	 */
	public boolean contains(String key) {
		Node<V> node = node(key);
		return node != null && node.word;
	}

	/**
	 * 添加一个单词和对应value
	 * @param key
	 * @param value
	 * @return
	 */
	public V add(String key, V value) {
		keyCheck(key);

		if (root == null) {
			root = new Node<>(null);
		}

		Node<V> node = root;
		int length = key.length();
		for (int i = 0; i < length; i++) {
			char c = key.charAt(i);
			boolean emptyChildren = node.children == null;
			Node<V> childNode = emptyChildren? null : node.children.get(c);
			// 没有对应字符创建节点put进去map，有就继续循环
			if (childNode == null) {
				childNode = new Node<>(node);
				childNode.character = c;
				node.children = emptyChildren ? new HashMap<>() : node.children;
				node.children.put(c,childNode);
			}
		}

		if (node.word) {
			// 覆盖value
			V oldValue = node.value;
			node.value = value;
			return oldValue;
		}
		// 新增
		node.word = true;
		node.value = value;
		size++;
		return null;
	}

	/**
	 * 检验入参字符
	 * @param key
	 */
	private void keyCheck(String key) {
		if (key == null || key.length() == 0) {
			throw new IllegalArgumentException("key must not be empty!");
		}
	}

	/**
	 * 前缀搜索，是否以prefix开头
	 * @param prefix
	 * @return
	 */
	public boolean startsWith(String prefix) {
		return node(prefix) != null;
	}

	/**
	 * 找传入字符串的最后节点
	 * 检验前缀，找完整字符串通用
	 * @param key
	 * @return
	 */
	private Node<V> node(String key) {
		keyCheck(key);

		Node<V> node = root;
		int length = key.length();
		for (int i = 0; i < length; i++) {
			// 没有子节点
			if (node == null || node.children == null || node.children.isEmpty()) {
				return null;
			}
			char c = key.charAt(i);
			node = node.children.get(c);
		}
		// 遍历到了最后一个字符节点
		return node;
	}

	/**
	 * 删除一个完整的单词
	 *
	 * @param key
	 * @return
	 */
	public V remove(String key) {
		// 因为要修改最后一个节点node属性，则contains麻烦，直接用node
		Node<V> node = node(key);

		// 不是单词结尾
		if (node == null || !node.word) {
			return null;
		}
		size--;
		V oldValue = node.value;

		// 后面还有子节点，直接修改word即可
		if (node.children != null || !node.children.isEmpty()) {
			node.word = false;
			node.value = null;
			return oldValue;
		}

		// 后面没有子节点，则需要删除单词全部节点（除非节点有分支）
		Node<V> parent = null;
		while ((parent = node.parent) != null) {
			// 从hashmap中删除这一个character节点
			parent.children.remove(node.character);

			//删除掉后还有其他分支,或者本身就是单词结尾
			if (!parent.children.isEmpty() || parent.word) {
				break;
			}
			node = parent;
		}

		return oldValue;
	}
}
