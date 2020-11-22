package ���㷨��.��Ƶ��;

/**
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * @author rnang0
 * @date 2020/11/17
 **/
public class _��ָOffer62_ԲȦ�����ʣ�µ����� {

    /**
     * f(n,m) = (f(n - 1,m) + m) % n
     * ʹ�õݹ���
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        // һ���ˣ�Ҫ���ص�m�����Ǿ�������˱��Ϊ0
        if (n == 1) {
            return 0;
        }
        return (lastRemaining(n - 1, m) + m) % n;
    }

    /**
     * f(n,m) = (f(n - 1,m) + m) % n
     * ��֪һЩ��ʼֵ��ǰ��ģ��͵���ʽ����Ҫ�����ֵ���������
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining1(int n, int m) {
        // һ���ˣ�Ҫ���ص�m�����Ǿ�������˱��Ϊ0
        if (n == 1) {
            return 0;
        }
        int result = 0;
        for (int i = 2; i <= n; i++) {
            result = (result + m) % i;
        }
        return result;
    }
}
