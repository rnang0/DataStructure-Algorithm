package ���㷨��.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 * @author rnang0
 * @date 2020/11/11
 **/
public class _47_ȫ����II {
    /**
     * ��ʹ�ö����result
     * ʹ�ø���nums��ʵ�֣���Ȼ�Ľ������һ�㲻��ʹ����һ��ѡ��ֵ������
     * ���ظ�����
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
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
            // ��֤indexλ�ã�ÿ��ֵֻ����һ�Σ���Ϊ������ͬ����������һ���ģ�Ҷ���ظ�
            if (isEqual(nums, index, i)) {
                continue;
            }
            swap(nums, i, index);
            dfs1(index + 1, nums, list);
            //ÿ��dfs���غ���ָ��ֳ�
            swap(nums, i, index);
        }

    }

    private boolean isEqual(int[] nums, int index, int i) {
        for (int j = index; j < i; j++) {
            // index��i������ֹ���num[i]��ͬ��ֵ���Ͳ��ý�������Ϊǰ�滻��
            // ǰ�滻������Ҷ�ӵ����������һ����
            if (nums[j] == nums[i]) {
                return true;
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
