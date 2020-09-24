package ���㷨��.�ַ���;

/**
 * https://leetcode-cn.com/problems/subtree-of-another-tree/
 * @author rnang0
 * @date 2020/9/21
 **/
public class _572_��һ���������� {

    /**
     * �������л����ַ�����ǰ�к����л�������
     * ���磺ǰ��������л����ַ���Ϊ!3��4��1��#��#��2��#��#��5
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     * @param s
     * @param t
     * @return
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // 1.ǰ��������л�s��t
        String s1 = serialize(s);
        String s2 = serialize(t);
        // 2.�ַ����Ӵ��Ƚ�
        return s1.contains(s2);
    }

    private String serialize(TreeNode s) {
        StringBuilder sb = new StringBuilder();
        sb.append("!");
        serializeByPre(s, sb);
        return sb.toString();
    }

    /**
     * ǰ��������л�
     * @param root
     * @param sb
     */
    private void serializeByPre(TreeNode root, StringBuilder sb) {
        sb.append(root.val).append("!");

        if (root.left == null) {
            // ��������
            sb.append("#!");
        } else {
            serializeByPre(root.left, sb);
        }
        if (root.right == null) {
            sb.append("#!");
        } else {
            serializeByPre(root.right, sb);
        }
    }
}
