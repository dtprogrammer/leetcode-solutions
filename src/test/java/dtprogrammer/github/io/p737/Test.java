package dtprogrammer.github.io.p737;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Solution solution = new Solution();

        Assert.assertTrue(solution.areSentencesSimilarTwo(new String[]{"great", "acting", "skills"},
                new String[]{"fine", "drama", "talent"}, new String[][]{{"great", "fine"}, {"acting", "drama"},
                        {"skills", "talent"}}));

        Assert.assertTrue(solution.areSentencesSimilarTwo(new String[]{"great", "acting", "skills"},
                new String[]{"fine", "drama", "talent"}, new String[][]{{"great", "good"}, {"fine", "good"},
                        {"acting", "drama"}, {"skills", "talent"}}));

        Assert.assertTrue(solution.areSentencesSimilarTwo(new String[]{"great", "acting", "skills"},
                new String[]{"fine", "drama", "talent"}, new String[][]{}));

        Assert.assertFalse(solution.areSentencesSimilarTwo(new String[]{"great", "acting", "skills"},
                new String[]{"good", "drama", "talent"}, new String[][]{{"great", "fine"}, {"acting", "drama"},
                        {"skills", "talent"}}));

        Assert.assertTrue(solution.areSentencesSimilarTwo(new String[]{"great", "acting", "skills"},
                new String[]{"fine", "drama", "talent"}, new String[][]{{"great", "fine"}, {"acting", "drama"},
                        {"skills", "trades"}, {"trades", "talent"}}));

        Assert.assertFalse(solution.areSentencesSimilarTwo(new String[]{"great", "acting"},
                new String[]{"fine", "drama", "talent"}, new String[][]{{"great", "fine"}, {"acting", "drama"},
                        {"skills", "talent"}}));

        Assert.assertFalse(solution.areSentencesSimilarTwo(null,
                new String[]{"fine", "drama", "talent"}, new String[][]{{"great", "fine"}, {"acting", "drama"},
                        {"skills", "talent"}}));
    }
}
