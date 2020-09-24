package ���㷨��.�ַ���;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author rnang0
 * @date 2020/9/24
 **/
public class _3_���ظ��ַ�����Ӵ� {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (s == null || length == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();

        // ��һ���ظ��ַ���λ�ã�Ĭ��Ϊ-1��û�������棬��Ϊ������߱�
        int[] prevIndex = new int[128];
        for (int i = 0; i < prevIndex.length; i++) {
            prevIndex[i] = -1;
        }
        // ���һ���ַ�����ֵ��
        prevIndex[chars[0]] = 0;
        // ��iλ���ַ���β������ظ��Ӵ��Ŀ�ʼλ�ã������������
        int li = 0;
        int max = 1;
        for (int i = 1; i < chars.length; i++) {
            // iλ���ϴγ��ֵ�λ��
            int pi = prevIndex[chars[i]];
            // �ϴε��ַ������棬�ǾͲ�������
            if (li <= pi) {
                li = pi + 1;
            }
            // �洢����ַ����ֵ�λ��
            prevIndex[chars[i]] = i;
            // i - li + 1����ÿ��λ�õ�����ظ��Ӵ�����
            max = Math.max(max, i - li + 1);
        }
        return max;
    }
}
