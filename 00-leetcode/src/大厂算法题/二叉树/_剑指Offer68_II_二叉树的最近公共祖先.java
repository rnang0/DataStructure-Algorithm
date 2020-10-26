package ���㷨��.������;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * @author rnang0
 * @date 2020/10/25
 **/
public class _��ָOffer68_II_������������������� {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // �ݹ��ٽ��������ҵ���p����q�����߶�û�ҵ�������null
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // ��left��right���з�������
        // 1.����һ�������棬���Ҷ�����p����q
        // 2.�����������淵�أ����Ҹ��Է�����ֵ��һ��p��һ��q��
        // 3.p,q�����ڣ�����null
        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }
}
