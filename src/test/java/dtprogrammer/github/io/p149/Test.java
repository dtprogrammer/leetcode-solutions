package dtprogrammer.github.io.p149;

import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Solution.Point p1 = new Solution.Point(-1, 1);
        Solution.Point p2 = new Solution.Point(0, 0);
        Solution.Point p3 = new Solution.Point(1, 1);
        Solution.Point p4 = new Solution.Point(2, 2);
        Solution.Point p5 = new Solution.Point(3, 3);
        Solution.Point p6 = new Solution.Point(3, 4);

        Assert.assertEquals(4, solution.maxPoints(new Solution.Point[]{p1, p2, p3, p4, p5, p6}));
    }
}
