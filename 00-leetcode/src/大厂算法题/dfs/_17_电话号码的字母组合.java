package ���㷨��.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @author rnang0
 * @date 2020/11/10
 **/
public class _17_�绰�������ĸ��� {

    private char[][] lettersArray = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };


    public List<String> letterCombinations(String digits) {
        if (digits == null) {
            return null;
        }
        List<String> list = new ArrayList<>();
        char[] chars = digits.toCharArray();
        if (chars.length == 0) {
            return list;
        }

        // �������ַ�����
        char[] letterChars = new char[chars.length];
        //1. ֱ�ӽ����0��
        dfs(0, chars, list, letterChars);
        return list;
    }

    private void dfs(int idx, char[] chars, List<String> list, char[] letterChars) {
        // 3. ����������һ�㣬����������
        if (idx == chars.length) {
            list.add(new String(letterChars));
            return;
        }

        // 2. ��ö������ÿ��ѡ��
        char[] letters = lettersArray[chars[idx] - '2'];
        for (char letter : letters) {
            letterChars[idx] = letter;
            dfs(idx + 1, chars, list, letterChars);
        }
    }
}
