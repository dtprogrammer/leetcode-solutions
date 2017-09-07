package dtprogrammer.github.io.p33;

import org.junit.Assert;

public class Test {

    @org.junit.Test
    public void test() throws Exception {

        Solution soluton = new Solution();
        int[] array = {4, 5, 6, 7, 0, 1, 2};

        Assert.assertEquals(2, soluton.search(array, 6));

        int[] array2 = {3, 1};

        Assert.assertEquals(1, soluton.search(array2, 1));

        int[] array3 = {1, 3, 5};

        Assert.assertEquals(0, soluton.search(array3, 1));

    }
}
