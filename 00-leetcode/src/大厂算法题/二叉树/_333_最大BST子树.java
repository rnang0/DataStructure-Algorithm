package ���㷨��.������;

/**
 * https://leetcode-cn.com/problems/largest-bst-subtree/
 * @author rnang0
 * @date 2020/10/27
 **/
public class _333_���BST���� {
    /**
     * �Զ�����
     * ����root�������������BST�����ڵ����
     * �������BST�����򷵻�����������
     * @param root
     * @return
     */
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isBST(root)) {
            return nodesCount(root);
        }
        // ����ͷ�����������������
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private boolean isBST(TreeNode root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * �ж���rootΪ�����������Ƿ�ΪBST��
     * @param root
     * @return
     */
    private boolean isBST(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }

        if (isBST(root.left, minValue, root.val) && isBST(root.right, root.val, maxValue)
            && minValue < root.val && root.val < maxValue) {
           return true;
        }
        return false;
    }

    /**
     * ����root�Ľڵ���Ŀ
     * @param root
     * @return
     */
    private int nodesCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return nodesCount(root.left) + nodesCount(root.right) + 1;
    }
}
