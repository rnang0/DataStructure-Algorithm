package ���㷨��.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 * @author rnang0
 * @date 2020/11/11
 **/
public class _46_ȫ���� {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }

        // ÿ���������
        int[] result = new int[nums.length];
        // ��¼�Ƿ��ù�����ʹ�ò��ظ�
        boolean[] used = new boolean[nums.length];
        dfs(0, nums, list, result, used);
        return list;
    }

    private void dfs(int index, int[] nums, List<List<Integer>> list, int[] result, boolean[] used) {
        if (index == nums.length) {
            // ��result������뵽list��
            List<Integer> resultList = new ArrayList<>();
            for (int value : result) {
                resultList.add(value);
            }
            list.add(resultList);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // ���ڲ����ظ����ж�һ���Ƿ��ù�
            if (used[i]) continue;
            result[index] = nums[i];
            used[i] = true;
            dfs(index + 1, nums, list, result, used);
            // ������һ������Ҫ����used��ԭ������λ�ò���ʹ�ø�ֵ
            used[i] = false;
        }

    }

    /**
     * ��ʹ�ö����result
     * ʹ�ø���nums��ʵ�֣���Ȼ�Ľ������һ�㲻��ʹ����һ��ѡ��ֵ������
     * @param nums
     * @return
     */
    public List<List<Integer>> permute1(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) {
            return list;
        }

        dfs1(0, nums, list);
        return list;
    }

    private void dfs1(int index, int[] nums, List<List<Integer>> list) {
        if (index == nums.length) {
            // �����Ҫ����List<List>
            List<Integer> resultList = new ArrayList<>();
            for (int value : nums) {
                resultList.add(value);
            }
            list.add(resultList);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            // i��index��ʼ��indexλ����i���н���
            swap(nums, i, index);
            dfs1(index + 1, nums, list);
            //ÿ��dfs���غ���ָ��ֳ�
            swap(nums, i, index);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
