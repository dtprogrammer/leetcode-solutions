package dtprogrammer.github.io.p273;

/**
 * 273. Integer to English Words
 */
public class Solution {
    private static final String[] UNDER_TEN = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
            "Nine"};
    private static final String[] UNDER_TWENTY = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] UNDER_HUNDRED = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        return numberToWordsHelper(num);
    }

    private String numberToWordsHelper(int num) {
        String result = "";
        if (num < 10) result = UNDER_TEN[num];
        else if (num < 20) result = UNDER_TWENTY[num - 10];
        else if (num < 100) result = UNDER_HUNDRED[num / 10] + " " + numberToWordsHelper(num % 10);
        else if (num < 1000) result = numberToWordsHelper(num / 100) + " Hundred " + numberToWordsHelper(num % 100);
        else if (num < 1000000)
            result = numberToWordsHelper(num / 1000) + " Thousand " + numberToWordsHelper(num % 1000);
        else if (num < 1000000000)
            result = numberToWordsHelper(num / 1000000) + " Million " + numberToWordsHelper(num % 1000000);
        else result = numberToWordsHelper(num / 1000000000) + " Billion " + numberToWordsHelper(num % 1000000000);
        return result.trim();
    }
}
