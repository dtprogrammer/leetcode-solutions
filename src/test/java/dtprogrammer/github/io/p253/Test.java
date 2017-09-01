package dtprogrammer.github.io.p253;

import dtprogrammer.github.io.common.Interval;
import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        Interval[] intervals = null;
        Assert.assertEquals(0, solution.minMeetingRooms(intervals));

        intervals = new Interval[3];
        Assert.assertEquals(0, solution.minMeetingRooms(intervals));

        intervals[0] = new Interval(0, 30);
        intervals[1] = new Interval(5, 10);
        intervals[2] = new Interval(15, 30);

        Assert.assertEquals(2, solution.minMeetingRooms(intervals));

        intervals = new Interval[5];
        intervals[0] = new Interval(10, 30);
        intervals[1] = new Interval(40, 60);
        intervals[2] = new Interval(70, 90);
        intervals[3] = new Interval(60, 170);
        intervals[4] = new Interval(150, 190);

        Assert.assertEquals(2, solution.minMeetingRooms(intervals));
    }
}
