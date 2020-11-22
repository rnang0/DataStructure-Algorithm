package ���㷨��.��Ƶ��;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * @author rnang0
 * @date 2020/11/21
 **/
public class _42_����ˮ {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        // ĳ����λ���������ĸ߶ȣ�������
        int[] leftIndexes = new int[height.length];
        int[] rightIndexes = new int[height.length];

        // ������ɨ�裬��������
        int leftMax = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] >= leftMax) {
                leftIndexes[i] = height[i - 1];
                leftMax = height[i - 1];
            } else {
                leftIndexes[i] = leftMax;
            }
        }
        // ���ҵ���ɨ�裬���ұ����
        int rightMax = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            if (height[i + 1] >= rightMax) {
                rightIndexes[i] = height[i + 1];
                rightMax = height[i + 1];
            } else {
                rightIndexes[i] = rightMax;
            }
        }

        // ������ˮ�ĸ߶�
        int water = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int high = Math.min(leftIndexes[i], rightIndexes[i]) - height[i];
            if (high > 0) {
                water += high;
            }
        }
        return water;
    }
}
