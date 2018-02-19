package dtprogrammer.github.io.p657;

/**
 * 657. Judge Route Circle
 */
public class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;

        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U':
                    y--;
                    break;
                case 'D':
                    y++;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
        return x == 0 && y == 0;
    }
}
