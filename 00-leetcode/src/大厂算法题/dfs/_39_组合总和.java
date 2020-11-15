package ���㷨��.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * @author rnang0
 * @date 2020/11/15
 **/
public class _39_����ܺ� {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // ����null������leetcode�������ó�
        if (candidates == null || candidates.length == 0) {
            return null;
        }

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        Arrays.sort(candidates);
        dfs(0, target, candidates, result, list);
        return list;
    }

    private void dfs(int index, int target, int[] candidates, List<Integer> result, List<List<Integer>> list) {
        // ����Ͳ��ǽ������һ���ˣ���target��Ϊ0
        if (target == 0) {
            list.add(new ArrayList<>(result));
            return;
        }

        // ע�����ÿ��ȡ���Ǵ�index��ʼ��ÿ�μ�1
        for (int i = index; i < candidates.length; i++) {
            // ���Ƚϴ�û��Ҫ����
            if (candidates[i] > target) {
                return;
            }

            result.add(candidates[i]);
            dfs(i, target - candidates[i], candidates, result, list);
            // ��ԭ
            result.remove(result.size() - 1);
        }
    }
}
