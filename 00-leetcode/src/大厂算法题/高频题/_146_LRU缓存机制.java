package ���㷨��.��Ƶ��;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 * @author rnang0
 * @date 2020/11/18
 **/
public class _146_LRU������� {

    private static class Node {
        public int key;
        public int value;

        public Node prev;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }

    private Map<Integer, Node> map;
    private int capacity;
    // ����ͷ���
    private Node first;

    // ����β���
    private Node last;

    public _146_LRU�������(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
        first = new Node();
        last = new Node();
        // ��ʼ��
        first.next = last;
        last.prev = first;
    }

    /**
     * ��ȡkey��Ӧ��ֵ
     * @param key
     * @return
     */
    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }

        removeNode(node);
        addAfterFirst(node);

        return node.value;
    }

    /**
     * ��������ɾ��
     * @param node
     */
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * ����first�ĺ���
     * @param node
     */
    private void addAfterFirst(Node node) {
        node.next = first.next;
        first.next.prev = node;

        first.next = node;
        node.prev = first;
    }

    /**
     * put��ȥһ��ֵ
     * 1.�޸�ֵ����put��ȥ�Ҹ��³�����
     * 2.�и�ֵ�����³�����
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            // �������ҲҪɾ����ͷ��
            removeNode(node);
            addAfterFirst(node);
        } else {
            if (map.size() == capacity) {
                // ��̭��β���ڵ�
                Node remove = map.remove(last.prev.key);
                removeNode(remove);
            }

            map.put(key, node = new Node(key, value));
            addAfterFirst(node);
        }
    }
}
