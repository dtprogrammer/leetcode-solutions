package dtprogrammer.github.io.ds;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinPQWithDecreaseKeyTest {

    @org.junit.Test
    public void test() {
        MinPQWithDecreaseKey<String> pq = new MinPQWithDecreaseKey<>();
        pq.add("Mango", 4);
        pq.add("Apple", 5);
        pq.add("Guava", 9);
        pq.add("Pineapple", 1);
        pq.add("Grape", 6);
        pq.add("Orange", 7);
        pq.add("Peach", 2);
        List<String> expected = Arrays.asList("Pineapple", "Peach", "Mango", "Apple", "Grape", "Orange", "Guava");

        List<String> result = new ArrayList<>();
        pq.iterator().forEachRemaining(result::add);
        Assert.assertEquals(expected, result);
        Assert.assertEquals(7, pq.size());
        Assert.assertEquals(7, pq.getHeapPositionSize());

        Assert.assertEquals("Pineapple", pq.extractMin());
        Assert.assertEquals(6, pq.size());
        Assert.assertEquals(6, pq.getHeapPositionSize());

        expected = Arrays.asList("Peach", "Mango", "Apple", "Grape", "Orange", "Guava");
        result.clear();
        pq.iterator().forEachRemaining(result::add);
        Assert.assertEquals(expected, result);

        pq.update("Orange", 3);
        expected = Arrays.asList("Peach", "Orange", "Mango", "Apple", "Grape", "Guava");
        result.clear();
        pq.iterator().forEachRemaining(result::add);
        Assert.assertEquals(expected, result);

        pq.delete("Mango");
        expected = Arrays.asList("Peach", "Orange", "Apple", "Grape", "Guava");
        result.clear();
        pq.iterator().forEachRemaining(result::add);
        Assert.assertEquals(expected, result);

        Assert.assertEquals("Peach", pq.extractMin());
        Assert.assertEquals(4, pq.size());
        Assert.assertEquals(4, pq.getHeapPositionSize());
        Assert.assertEquals("Orange", pq.extractMin());
        Assert.assertEquals(3, pq.size());
        Assert.assertEquals(3, pq.getHeapPositionSize());

        expected = Arrays.asList("Apple", "Grape", "Guava");
        result.clear();
        pq.iterator().forEachRemaining(result::add);
        Assert.assertEquals(expected, result);
    }
}
