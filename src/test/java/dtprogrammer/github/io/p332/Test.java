package dtprogrammer.github.io.p332;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class Test {
    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();
        List<String> expected = Arrays.asList("JFK", "MUC", "LHR", "SFO", "SJC");
        Assert.assertEquals(expected, solution.findItinerary(new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO",
                "SJC"}, {"LHR", "SFO"}}));

        expected = Arrays.asList("JFK", "ATL", "JFK", "SFO", "ATL", "SFO");
        Assert.assertEquals(expected, solution.findItinerary(new String[][]{{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO",
                "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}}));

        expected = Arrays.asList("JFK","NRT","JFK","KUL");
        Assert.assertEquals(expected, solution.findItinerary(new String[][]{{"JFK","KUL"},{"JFK","NRT"},{"NRT",
                "JFK"}}));
    }
}
