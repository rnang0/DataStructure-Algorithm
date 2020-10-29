package ���㷨��.������;

import sun.reflect.generics.tree.Tree;

/**
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 * @author rnang0
 * @date 2020/10/26
 **/
public class _99_�ָ����������� {

    private TreeNode prev;

    private TreeNode first;

    private TreeNode second;

    public void recoverTree(TreeNode root) {
        // ����������������еݹ����
        traverseTree(root);

        // ����first��second��ֵ
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void traverseTree(TreeNode root) {
        if (root == null) {
            return;
        }
        traverseTree(root.left);

        find(root);

        traverseTree(root.right);
    }

    private void find(TreeNode root) {
        // ��Ҫǰ���ֵ���бȽ�
        if (prev != null && root.val < prev.val) {
            // �ڶ���ֵ���Ը��ǣ���Ϊ��������ȡС��ֵ
            second = root;

            if (first != null) {
                // ��Ϊsecond�϶���ֵ
                return;
            }
            first = prev;
        }
        prev = root;
    }

    /**
     * ʹ��Morris�ⷨ
     * O(1) �ռ临�Ӷ�
     * @param root
     */
    public void recoverTree1(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                TreeNode pred = node.left;
                // pred.right == node ��ʾ�����ˣ����ڶ��α�����������ӡ��
                while (pred.right != null && pred.right != node) {
                    // ˳������һֱ��
                    pred = pred.right;
                }
                // ��ǰ����㴮����
                if (pred.right == null) {
                    pred.right = node;
                    //����
                    node = node.left;
                } else {
                    // ���ڶ��α���������ִ�д�����
                    find(node);
                    // ��ӡ�˾Ͳ���Ҫright�������
                    // ͬʱnode.right��node������ȥ�������ұ���
                    pred.right = null;
                    node = node.right;
                }
            } else {
                // ���������
                find(node);
                node = node.right;
            }
        }
        // ����first��second��ֵ
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

}
