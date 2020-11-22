package ���㷨��.��Ƶ��;

/**
 * https://leetcode-cn.com/problems/powx-n/
 * @author rnang0
 * @date 2020/11/16
 **/
public class _50_Powx_n {

    /**
     * ʹ�õݹ���ν��
     * ���壺n����Ϊ�������������ε����ᵽ-1����-1 >> 1����-1����-1��Ҫֱ�ӷ���
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        // n����Ϊ��������-1��Ҫֱ�ӷ���
        if (n == -1) {
            return 1 / x;
        }

        // �ж�ָ���Ƿ�Ϊ����
        boolean flag = (n & 1) == 1;

        double half = myPow(x, n >> 1);
        return flag ? half * half * x : half * half;
    }

    /**
     * �����ݽ��
     * 21 = 10101(������)
     * 3^21 = 3^(1*2^0 + 0*2^1 + 1*2^2 + 0*2^3 + 1*2^4)
     * ���ָ���Ǹ�����������֮1���ɣ�1/3^21
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        double res = 1.0;
        // ���Ǳ߽�������n �� 32 λ�з�������������ֵ��Χ�� [?231, 231 ? 1] ��
        long y = n;
        if (n < 0) {
            y = -((long)n);
        }

        while (y > 0) {
            // ȡn�����һ��������λ�����˲���
            if ((y & 1) == 1) {
                res *= x;
            }

            // ��һ�εĵ���
            x = x * x;

            // ���������һλ
            y = y >> 1;
        }
        return (n < 0) ? (1 / res) : res;
    }
}
