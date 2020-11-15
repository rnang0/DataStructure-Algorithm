package ���㷨��.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * @author rnang0
 * @date 2020/11/12
 **/
public class _22_�������� {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        // ����leetcode���жϻ����ó��践�ؿռ���
        if (n < 0) {
            return list;
        }

        dfs(0, 0, 0, n, new char[n << 1], list);
        return list;
    }

    /**
     *
     * @param index
     * @param left �����ŵ���������
     * @param right �����ŵ���������
     * @param n �������ŵ��ܸ���
     * @param chars ����ַ�����
     * @param list
     */
    private void dfs(int index, int left, int right, int n, char[] chars, List<String> list) {
        // ����������һ�㣬����������
        if (index == chars.length) {
            list.add(new String(chars));
            return;
        }

        // ö����һ�����п��ܵ�ѡ�񣬸ò����ѡ�󣬿���ѡ��
        // ѡ��
        if (n - left > 0) {
            chars[index] = '(';
            // ������һ��
            dfs(index + 1, left + 1, right, n, chars, list);
        }

        // ѡ��
        if (n - right > 0 && right < left) {
            chars[index] = ')';
            dfs(index + 1, left, right + 1, n, chars, list);
        }
    }
}
