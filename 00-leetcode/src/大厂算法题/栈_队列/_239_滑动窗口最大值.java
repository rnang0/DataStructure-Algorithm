package ���㷨��.ջ_����;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * @author rnang0
 * @date 2020/9/14
 **/
public class _239_�����������ֵ {

    /**
     * �����Ľ��棨�����ڵ�������O��n����
     * ���㲻����k�飬���ҳ����ֵ��Ȼ�������ߣ������ҵ����ֵ
     * �����ֵ���ڴ��ڣ����ٽ���k�����������ֵ
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < 1) {
            return new int[0];
        }

        if (k == 1) {
            return nums;
        }

        int[] maxes = new int[nums.length - k + 1];
        int maxIndex = 0;
        for (int i = 1; i < k; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        maxes[0] = nums[maxIndex];

        for (int li = 1; li < maxes.length; li++) {
            int ri = li + k - 1;
            // ������һλ�󣬷������ֵ���˴���
            if (maxIndex < li) {
                // �ٱ���һ�´�������ֵ
                maxIndex = li;
                for (int i = li + 1; i <= ri; i++) {
                    if (nums[i] > nums[maxIndex]) {
                        maxIndex = i;
                    }
                }
            //д"="�ţ�Ϊ�������ֵ����Ų�����������
            } else if (nums[ri] >= nums[maxIndex]){
                maxIndex = ri;
            }
            maxes[li] = nums[maxIndex];
        }
        return maxes;
    }

    /**
     * ������O��k * n�����Ż���
     * �ҵ�һ�ֽṹ��ʹ�ýṹͷ�����Ǹô��ڵ����ֵ����С��û�����塣
     * ������ά��һ��˫�˶���
     * 1.���д�ŵ�������ֵ
     * 2.�����е�������ͷ��β��Ӧ��Ԫ��ֵ�𽥼�С�����Ԫ����ǰ����
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowByDeque(int[] nums, int k) {
        if (nums == null || nums.length < 1 || k < 1) {
            return new int[0];
        }

        if (k == 1) {
            return nums;
        }

        int[] maxes = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // ɾ��������������ӦԪ��ֵС��
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i] ) {
                deque.pollLast();
            }

            // �����������
            deque.offerLast(i);

            // ����Ҫ�õ����ڵ����ֵ������Ҫ��鴰�ڵ������Ƿ�Ϸ�
            int w = i - k + 1;
            if (w < 0) continue;

            // ÿ��ֻŲ��һ�Σ����Ծ�ɾһ������֤�����������ڴ�����
            if (deque.peekFirst() < w) {
                deque.pollFirst();
            }

            // �������ֵ
            maxes[w] = nums[deque.peekFirst()];
        }
        return maxes;
    }
}
