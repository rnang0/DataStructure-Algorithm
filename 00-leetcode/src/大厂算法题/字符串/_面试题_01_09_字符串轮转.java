package ���㷨��.�ַ���;

/**
 * https://leetcode-cn.com/problems/string-rotation-lcci/
 * @author rnang0
 * @date 2020/9/21
 **/
public class _������_01_09_�ַ�����ת {
    /**
     * ������O��n^2���ĸĽ�
     * ĳһ������ȣ���һ��ͨ�����������̫��s1��s2��ƴ
     * �����Ӵ���ѭ��ƴ��������ʱ�����ڵ��ص㣬����ƴ�Ӷ��ʱ������(����s1)
     * @param s1
     * @param s2
     * @return
     */
    public boolean isFlipedString(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        if (length1 == 0 && length2 == 0) {
            return true;
        } else if (length1 != length2) {
            return false;
        }
        // ���Կ���ʹ��KMP�㷨��Ч�ʽϸ�
        // return (s1 + s1).contains(s2);

        String s = s1 + s1;
        int length = s.length();
        char[] charsS = s.toCharArray();
        char[] charsS2 = s2.toCharArray();
        for (int i = 0; i < length; i++) {
            int k = i;
            for (int j = 0; j < length2 && k < length; j++, k++) {
                if (charsS[k] != charsS2[j]) {
                    break;
                }
                if (j == length2 - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
