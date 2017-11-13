package dtprogrammer.github.io.p218;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> skyline = new ArrayList<>();
        if (buildings == null || buildings.length == 0 || buildings[0] == null || buildings[0].length == 0) {
            return skyline;
        }
        // store all the critical points
        List<int[]> criticalPoints = new ArrayList<>();
        for (int[] building : buildings) {
            criticalPoints.add(new int[]{building[0], 0, building[2]}); // leftEnd, isRightEnd, height
            criticalPoints.add(new int[]{building[1], 1, building[2]}); // rightEnd, isRightEnd, height
        }

        // sort the critical points
        criticalPoints.sort((o1, o2) -> {
            return o1[0] == o2[0]
                    ? (o1[1] == o2[1] ? (o1[1] == 0 ? o2[2] - o1[2] : o1[2] - o2[2]) : o1[1] - o2[1])
                    : (o1[0] - o2[0]); // if the x coordinate are not equal then the one which starts before
        });

        TreeMap<Integer, Integer> currentBuildings = new TreeMap<>();
        for (int[] criticalPoint : criticalPoints) {
            boolean isStart = criticalPoint[1] == 0;
            int top;
            if (isStart) {
                currentBuildings.put(criticalPoint[2], currentBuildings.getOrDefault(criticalPoint[2], 0) + 1);
                top = currentBuildings.lastKey();
                if (top == criticalPoint[2] && currentBuildings.get(criticalPoint[2]) == 1) {
                    skyline.add(new int[]{criticalPoint[0], top});
                }
            } else {
                currentBuildings.put(criticalPoint[2], currentBuildings.get(criticalPoint[2]) - 1);
                if (currentBuildings.get(criticalPoint[2]) == 0) {
                    currentBuildings.remove(criticalPoint[2]);
                }
                if (currentBuildings.isEmpty()) {
                    skyline.add(new int[]{criticalPoint[0], 0});
                } else {
                    top = currentBuildings.lastKey();
                    if (criticalPoint[2] > top) {
                        skyline.add(new int[]{criticalPoint[0], top});
                    }
                }
            }
        }
        return skyline;
    }
}
