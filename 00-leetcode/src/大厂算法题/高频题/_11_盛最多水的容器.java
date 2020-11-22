package ���㷨��.��Ƶ��;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * @author rnang0
 * @date 2020/11/21
 **/
public class _11_ʢ���ˮ������ {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int water = 0;
        // ˫ָ�룬���������
        int l = 0, r = height.length - 1;
        int high = 0;

        while (l < r) {
            // ����̵��ߣ�ֻ��Ӷ���������
            if (height[l] >= height[r]) {
                high = height[r];
                // ���ϴε�����Ƚ�
                water = Math.max((r - l) * high, water);
                // �����ѣ����̵Ļ�����ȵľ�����
                while (l < r && height[r] <= high) {
                    r--;
                }
            } else {
                high = height[l];
                // ���ϴε�����Ƚ�
                water = Math.max((r - l) * high, water);
                // �����ѣ����̵Ļ�����ȵľ�����
                while (l < r && height[l] <= high) {
                    l++;
                }
            }
        }
        return water;
    }
}
