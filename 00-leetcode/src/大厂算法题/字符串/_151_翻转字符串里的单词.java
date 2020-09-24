package ���㷨��.�ַ���;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * @author rnang0
 * @date 2020/9/22
 **/
public class _151_��ת�ַ�����ĵ��� {
    // ��Ч����
    int length = 0;


    /**
     * ���淽����������ո��ٴӺ������Ȼ�������ո񣬾ͱ���һ������
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        int lengthS = s.length();
        if (s == null || lengthS == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        //1.�����ո�
        char[] charsAfterClear = clearSpace(chars);
        if (length < 0) {
            return "";
        }
        //2.��ʼ�淽�����
        char[] charsPrint = new char[length];
        // ÿ���������һ��
        int cur = 0;
        // i + 1�������ָ��
        int k = 0;
        int j = 0;
        boolean end = true;
        for (int i = length - 1; i >= 0; i--) {
            if (charsAfterClear[i] == ' ' || i == 0) {
                // ��i + 1������cur
                if (i == 0) {
                    k = i;
                    cur = end ? i : cur;
                } else {
                    k = i + 1;
                }
                while (k <= cur) {
                    charsPrint[j++] = charsAfterClear[k++];
                }
                if (j < length - 1) {
                    charsPrint[j++] = ' ';
                }
                end = true;
            } else if (end){
                cur = i;
                end = false;
            }
        }
        return new String(charsPrint);
    }

    /**
     * �������ո�
     * @param chars
     * @return
     */
    private char[] clearSpace(char[] chars) {
        boolean space = true;
        // curΪ����Ч��λ��
        int cur = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                chars[cur++] = chars[i];
                space = false;
            } else if (space == false) {
                chars[cur++] = ' ';
                space = true;
            }
        }
        length = space ? (cur - 1) : cur;
        return chars;
    }

    /**
     * ���ݽṹ�Ż���ʹ��ջ
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        int lengthS = s.length();
        if (s == null || lengthS == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        //1.�����ո�
        char[] charsAfterClear = clearSpace(chars);
        if (length < 0) {
            return "";
        }
        //2.��ʼ�淽�����
        Stack<Character> stack = new Stack<>();
        char[] charsPrint = new char[length];
        int j = 0;
        boolean isSpace = true;
        for (int i = length - 1; i >= 0 ; i--) {
            if (charsAfterClear[i] == ' ' || i == 0) {
                if (i == 0) {
                    stack.push(charsAfterClear[i]);
                    isSpace = false;
                }
                while (!stack.isEmpty()) {
                    charsPrint[j++] = stack.pop();
                }
                if (isSpace) {
                    charsPrint[j++] = ' ';
                }
            } else {
                stack.push(charsAfterClear[i]);
            }
        }
        return new String(charsPrint);
    }


    /**
     * ���淽�����Ż�������ո�������ַ���������ÿ������
     * @param s
     * @return
     */
    public String reverseWords3(String s) {
        int lengthS = s.length();
        if (s == null || lengthS == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        //1.�����ո�
        char[] charsAfterClear = clearSpace(chars);
        if (length < 0) {
            return "";
        }

        //2.���������ַ���
        reverseString(charsAfterClear, 0, length);

        //3.�����������
        int begin = -1;
        for (int i = 0; i < length; i++) {
            if (charsAfterClear[i] != ' ') {
                continue;
            }
            reverseString(charsAfterClear, begin + 1, i);
            begin = i;
        }
        //�������һ������
        reverseString(charsAfterClear, begin + 1, length);
        return new String(charsAfterClear, 0, length);
    }

    /**
     * ����chars��[begin, end)
     * @param chars
     * @param begin
     * @param end
     */
    private void reverseString(char[] chars, int begin, int end) {
        end--;
        while (begin < end) {
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
            begin++;
            end--;
        }
    }
}
