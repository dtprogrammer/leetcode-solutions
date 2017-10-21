package dtprogrammer.github.io.p380;

import java.util.*;

public class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> nums;
    Random rand;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        map = new HashMap<>();
        nums = new ArrayList<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        // if this is not the last element then replace the last element with this to delete
        int lastVal = nums.get(nums.size() - 1);
        if (index < nums.size() - 1) {
            map.put(lastVal, index);
            nums.set(index, lastVal);
        }
        map.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
