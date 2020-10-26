package ���㷨��.��̬�滮;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @author rnang0
 * @date 2020/10/24
 **/
public class _5_������Ӵ� {
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }

        char[] chars = s.toCharArray();
        int length = chars.length;
        if (length == 0) {
            return "";
        }

        int[][] dp = new int[length][length];
        int maxLength = 1;
        int begin = 0;

        // ���µ��ϣ�������
        // ��Ϊ��Ҫdp[i + 1][j - 1]������
        for (int i = chars.length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (j - i + 1 > 2) {
                    if (dp[i + 1][j - 1] == 1 && chars[i] == chars[j]) {
                        dp[i][j] = 1;
                        if (j - i + 1 > maxLength) {
                            maxLength = j - i + 1;
                            begin = i;
                        }
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    if (chars[i] == chars[j]) {
                        dp[i][j] = 1;
                        if (j - i + 1 > maxLength) {
                            maxLength = j - i + 1;
                            begin = i;
                        }
                    } else {
                        dp[i][j] = 0;
                    }
                }

            }
        }
        return new String(chars, begin, maxLength);
    }
}
