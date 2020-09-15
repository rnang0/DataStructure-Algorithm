package ���㷨��.������;

/**
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 * @author rnang0
 * @date 2020/9/14
 **/
public class _654_�������� {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
          val = x;
        }
    }

    /**
     * ��ͨ�������ݹ�������
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        return findRoot(nums, 0, nums.length);
    }

    private TreeNode findRoot(int[] nums, int l, int r) {

        if (l == r) {
            return null;
        }
        // �ҳ�[l,r)��Χ�����ֵ��Ӧ������
        int maxIndex = l;
        for (int i = l + 1; i < r; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        TreeNode root = new TreeNode(nums[maxIndex]);
        // ���ص���һ��new�Ľڵ�
        root.left = findRoot(nums, l, maxIndex);
        root.right = findRoot(nums, maxIndex + 1, r);
        return root;
    }
}
