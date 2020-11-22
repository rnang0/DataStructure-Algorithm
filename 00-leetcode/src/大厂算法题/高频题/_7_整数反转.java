package ���㷨��.��Ƶ��;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 * @author rnang0
 * @date 2020/11/18
 **/
public class _7_������ת {
    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int mod = x % 10;
            int prevResult = result;
            result = result * 10 + mod;
            // ����ˣ�ǰ��һ��
            if ((result - mod) / 10 != prevResult) {
                return 0;
            }

            x /= 10;
        }
        return result;
    }
}
