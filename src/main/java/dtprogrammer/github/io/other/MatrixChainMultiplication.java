package dtprogrammer.github.io.other;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given a sequence of matrices, find the most efficient way to multiply these matrices together. The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications. There are many options to multiply a chain of matrices because matrix multiplication is associative i.e. no matter how one parenthesize the product, the result will be the same.
 * <p>
 * Example:
 * if you had four matrices A, B, C, and D, you would have:
 * <p>
 * (ABC)D = (AB)(CD) = A(BCD) = ....
 * However, the order in which one parenthesize the product affects the number of simple arithmetic operations needed to compute the product, or the efficiency.
 * <p>
 * For example:
 * <p>
 * A: 10 × 30 matrix
 * B : 30 × 5 matrix
 * C : 5 × 60 matrix
 * Then,
 * (AB)C = (10×30×5) + (10×5×60)
 * = 1500 + 3000
 * = 4500 operations
 * A(BC) = (30×5×60) + (10×30×60)
 * = 9000 + 18000
 * = 27000 operations.
 * Given an array arr[] which represents the chain of matrices such that the ith matrix Ai is of dimension arr[i-1] x arr[i]. Your task is to write a function that should print the minimum number of multiplications needed to multiply the chain.
 * <p>
 * Input: p[] = {40, 20, 30, 10, 30}
 * Output: 26000
 * There are 4 matrices of dimensions 40x20,
 * 20x30, 30x10 and 10x30. Let the input 4
 * matrices be A, B, C and D.  The minimum
 * number of multiplications are obtained
 * by putting parenthesis in following way
 * (A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30
 * <p>
 * Input: p[] = {10, 20, 30, 40, 30}
 * Output: 30000
 * There are 4 matrices of dimensions 10x20,
 * 20x30, 30x40 and 40x30. Let the input 4
 * matrices be A, B, C and D.  The minimum
 * number of multiplications are obtained by
 * putting parenthesis in following way
 * ((AB)C)D --> 10*20*30 + 10*30*40 + 10*40*30
 * Input:
 * The first line of the input contains an integer T, denoting the number of test cases. Then T test case follows. The first line of each test case contains an integer N, denoting the number of elements in the array.
 * Then next line contains N space separated integers denoting the values of the element in the array.
 * <p>
 * Output:
 * For each test case the print the minimum number of operations needed to multiply the chain.
 * <p>
 * Constraints:
 * 1<=T<=100
 * 2<=N<=100
 * 1<=A[]<=500
 * <p>
 * Example:
 * Input:
 * 2
 * 5
 * 1 2 3 4 5
 * 3
 * 3 3 3
 * Output:
 * 38
 * 27
 * <p>
 * *For More Examples Use Expected Output**
 * The brute for approach has exponential complexity. We can use DP to solve this efficiently.
 * Time Complexity: There are n pow (2) subproblems and we iterate over them once so the complexity is O n pow (3)
 * Space complexity: The space used by the memo array which is n X n
 */
public class MatrixChainMultiplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numTestCases = scanner.nextInt();

        while (numTestCases > 0) {
            int matricesSizes = scanner.nextInt();
            int[] matricesDimensions = new int[matricesSizes];

            for (int i = 0; i < matricesDimensions.length; i++) {
                matricesDimensions[i] = scanner.nextInt();
            }

            int[][] memo = new int[matricesDimensions.length][matricesDimensions.length];
            for (int[] cur : memo) {
                Arrays.fill(cur, Integer.MAX_VALUE);
            }
            System.out.println(matrixChainMultiply(matricesDimensions, 1, matricesDimensions.length - 1, memo));
            --numTestCases;
        }
    }

    private static int matrixChainMultiply(int[] matricesDimensions, int i, int j, int[][] memo) {

        if (memo[i][j] < Integer.MAX_VALUE) {
            return memo[i][j];
        }

        if (i == j) {
            memo[i][j] = 0;
        }

        for (int k = i; k < j; k++) {
            memo[i][j] = Math.min(memo[i][j], matrixChainMultiply(matricesDimensions, i, k, memo) +
                    matrixChainMultiply(matricesDimensions, k + 1, j, memo) +
                    matricesDimensions[i - 1] * matricesDimensions[k] * matricesDimensions[j]);
        }
        return memo[i][j];
    }
}
