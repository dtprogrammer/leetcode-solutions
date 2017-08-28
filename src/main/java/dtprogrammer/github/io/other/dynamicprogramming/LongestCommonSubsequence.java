package dtprogrammer.github.io.other.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given two sequences, find the length of longest subsequence present in both of them. Both the strings are of uppercase.
 * <p>
 * Input:
 * First line of the input contains no of test cases  T,the T test cases follow.
 * Each test case consist of 2 space separated integers A and B denoting the size of string str1 and str2 respectively
 * The next two lines contains the 2 string str1 and str2 .
 * <p>
 * <p>
 * Output:
 * For each test case print the length of longest  common subsequence of the two strings .
 * <p>
 * <p>
 * Constraints:
 * 1<=T<=200
 * 1<=size(str1),size(str2)<=100
 * <p>
 * <p>
 * Example:
 * Input:
 * 2
 * 6 6
 * ABCDGH
 * AEDFHR
 * 3 2
 * ABC
 * AC
 * <p>
 * Output:
 * 3
 * 2
 * <p>
 * Explanation
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * <p>
 * LCS of "ABC" and "AC" is "AC" of length 2
 * The brute force solution here will take exponential time. This can be solved efficiently through Dynamic Programming
 * Time Complexity: The time complexity is m * n since we spend constant time in calculation.
 * Space complexity: The space complexity is m * n. This can be reduced by just keeping previous row since we don't
 * need the other data to calculate the current row. Although if the the sequence itself had to be known and not just
 * the length then we need to keep the memo.
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        while (numTestCases > 0) {
            // skip the string lengths and the new line following it
            scanner.nextInt();
            scanner.nextInt();
            scanner.nextLine();
            String first = scanner.nextLine();
            String second = scanner.nextLine();
            --numTestCases;

            System.out.println(lcs(first, second));
        }
    }

    private static int lcs(String first, String second) {
        int[][] memo = new int[second.length() + 1][first.length() + 1];

        Arrays.fill(memo[0], 0);

        for (int i = 0; i <= second.length(); i++) {
            memo[i][0] = 0;
        }


        for (int i = 1; i <= second.length(); i++) {
            for (int j = 1; j <= first.length(); j++) {
                if (first.charAt(j - 1) == second.charAt(i - 1)) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        return memo[memo.length - 1][memo[0].length - 1];
    }
}
