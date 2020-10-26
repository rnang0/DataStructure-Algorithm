package ���㷨��.������;

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

        traverseTree(root.right);
    }

    /**
     * ʹ�� O(1) �ռ临�ӶȵĽⷨ
     * @param root
     */
    public void recoverTree1(TreeNode root) {

    }
}
