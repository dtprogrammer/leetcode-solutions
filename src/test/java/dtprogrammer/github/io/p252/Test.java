package dtprogrammer.github.io.p252;

import dtprogrammer.github.io.common.Interval;
import org.junit.Assert;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Interval[] intervals = null;
        Assert.assertTrue(solution.canAttendMeetings(intervals));

        intervals = new Interval[3];
        Assert.assertTrue(solution.canAttendMeetings(intervals));

        intervals[0] = new Interval(0, 30);
        intervals[1] = new Interval(5, 10);
        intervals[2] = new Interval(15, 30);

        Assert.assertFalse(solution.canAttendMeetings(intervals));
    }
}
