package ���㷨��.ջ_����;

import java.util.Arrays;
import java.util.Stack;

/**
 * ����һ�����飬�����������ÿ���ڵ�ĸ��ڵ�����������û�и��ڵ㣬�ʹ�-1��
 * @author rnang0
 * @date 2020/9/15
 **/
public class _654_��������������_���ڵ����� {

    /**
     * ���õ����ݼ���ջ��ʵ�֣��ҵ���������Ԫ��
     * @param nums
     * @return
     */
    public int[] parentIndexes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] leftIndexes = new int[nums.length];
        int[] rightIndexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            leftIndexes[i] = -1;
            rightIndexes[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                leftIndexes[i] = stack.peek();
            }

            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                rightIndexes[stack.pop()] = i;
            }

            stack.push(i);
        }

        int[] parentIndexes = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (leftIndexes[i] == -1 && rightIndexes[i] == -1) {
                parentIndexes[i] = -1;
            }
            parentIndexes[i] = Math.max(leftIndexes[i], rightIndexes[i]);
        }
        return parentIndexes;
    }

    public static void main(String[] args) {
        _654_��������������_���ڵ����� o = new _654_��������������_���ڵ�����();
        int[] nums = { 3, 2, 1, 6, 0, 5 };
    	System.out.println(Arrays.toString(o.parentIndexes(nums)));
    }
}
