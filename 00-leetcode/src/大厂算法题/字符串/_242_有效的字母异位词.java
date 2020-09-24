package ���㷨��.�ַ���;

/**
 * https://leetcode-cn.com/problems/valid-anagram/
 * @author rnang0
 * @date 2020/9/22
 **/
public class _242_��Ч����ĸ��λ�� {

    /**
     * ������hash�Ż���ֻ��Сд�ʹ����СΪ26������
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        if (s == null || t == null || length1 != length2) {
            return false;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        int[] counts = new int[26];
        for (int i = 0; i < length1; i++) {
            counts[chars1[i] - 'a']++;
        }

        // ���⿪���¿ռ�洮2����
        for (int i = 0; i < length2; i++) {
            if (--counts[chars2[i] - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
