package ���㷨��.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 * @author rnang0
 * @date 2020/11/15
 **/




public class _113_·���ܺ�II {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
        val = x;
    }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        // ���ؿռ��ϣ�ͨ��leetcode�������ó�
        if (root == null) {
            return list;
        }

        // �����һ��
        dfs(root, sum, new ArrayList<>(), list);
        return list;
    }

    private void dfs(TreeNode node, int sum, List<Integer> result, List<List<Integer>> list) {
        // ����������һ�㣬����������
        if (node == null) {
            return;
        }

        // sum������val������
        sum -= node.val;
        result.add(node.val);
        // �ж�node�����ң����һ����һ����Ϊnull������
        if (node.left == null && node.right == null) {
            if (sum == 0) {
                list.add(new ArrayList<>(result));
            }
        } else {
            dfs(node.left, sum, result, list);
            dfs(node.right, sum, result, list);
        }
        // ��ԭ
        result.remove(result.size() - 1);
    }
}
