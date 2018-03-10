package dtprogrammer.github.io.p273;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Assert.assertEquals("One Hundred Twenty Three", solution.numberToWords(123));
        Assert.assertEquals("Twelve Thousand Three Hundred Forty Five", solution.numberToWords(12345));
        Assert.assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",
                solution.numberToWords(1234567));
        Assert.assertEquals("One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand " +
                        "Eight Hundred Ninety One", solution.numberToWords(1234567891));
        Assert.assertEquals("Fifty Thousand Eight Hundred Sixty Eight", solution.numberToWords(50868));
    }
}
