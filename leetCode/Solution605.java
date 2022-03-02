package leetCode;

// Can Place Flowers
public class Solution605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        if (n == 0) return true;

        if (flowerbed.length == 1) {
            return (flowerbed[0] == 0 ? 1 : 0) == n;
        }

        for (int i = 0; i < flowerbed.length; ++i) {
            int prev = i - 1;
            int next = i + 1;

            if (i == 0) {
                if (flowerbed[i] == 0 && flowerbed[next] == 0) {
                    flowerbed[i] = 1;
                    ++count;
                }
            } else if (i == flowerbed.length - 1) {
                if (flowerbed[i] == 0 && flowerbed[prev] == 0) {
                    flowerbed[i] = 1;
                    ++count;
                }
            } else if ((flowerbed[prev] == 0 && flowerbed[next] == 0) && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                ++count;
            }

            if (count == n) return true;
        }

        return false;
    }

    public static boolean canPlaceFlowersV2(int[] flowerbed, int n) {
        int count = 0;

        for (int i = 0; i < flowerbed.length; ++i) {
            if (flowerbed[i] != 0) continue;

            boolean isLeftEmpty = (i == 0) || (flowerbed[i - 1] == 0);
            boolean isRightEmpty = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

            if (isLeftEmpty && isRightEmpty) {
                flowerbed[i] = 1;
                ++count;
            }

            if (count >= n) return true;
        }

        return count >= n;
    }

}
