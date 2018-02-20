package dtprogrammer.github.io.p399;

import org.junit.Assert;

import java.util.Arrays;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        double[] doubles = solution.calcEquation(new String[][]{{"a", "b"}, {"b", "c"}},
                new double[]{2.0, 3.0}, new String[][]{{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}});
        System.out.println(Arrays.toString(doubles));
        Assert.assertTrue(Arrays.equals(new double[]{6.0, 0.5, -1.0, 1.0, -1.0},
                doubles));
    }
}
