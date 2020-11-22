package ���㷨��.��Ƶ��;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/spiral-matrix/
 * @author rnang0
 * @date 2020/11/17
 **/
public class _54_�������� {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // �����������ɨ
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            // �ұߴ�������ɨ
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            // ������ܻ��ִ��,���ж�һ������
            if (top > bottom || left > right) {
                break;
            }

            // �±ߴ�������ɨ
            for (int i = right; i >= left ; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;

            // ��ߴ�������ɨ
            for (int i = bottom; i >= top ; i--) {
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}
