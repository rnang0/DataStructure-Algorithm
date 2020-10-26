package ���㷨��.��̬�滮;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * @author rnang0
 * @date 2020/10/20
 **/
public class _121_������Ʊ�����ʱ�� {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // ������ǰ����С��ֵ
        int min = prices[0];

        // �������������
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }
        }
        return maxProfit;
    }

    /**
     * ʹ�ö�̬�滮���
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int length = prices.length;
        if (prices == null || length == 0) {
            return 0;
        }
        // ��ʼ������ֵ����
        int a[] = new int[length];
        a[0] = 0;
        for (int i = 1; i < length; i++) {
            a[i] = prices[i] - prices[i - 1];
        }

        // ���������������кͣ������������
        // int dp[] = new int[length]; �Ż���һά����
        int dp = a[0];
        int max = dp;
        for (int i = 1; i < length; i++) {
            // ǰ��ʹ���0���ż��𣬲�ȻԽ��Խ��
            if (dp < 0) {
                dp = a[i];
            } else {
                dp += a[i];
            }
            max = Math.max(dp, max);
        }
        return max;
    }
}
