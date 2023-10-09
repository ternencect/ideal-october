package codes.algo.java.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用哈希表，可以将寻找 target - x 的时间复杂度降低从 O(N) 降低到 O(1)。
 *
 * 创建一个哈希表，对于每一个 x, 首先查询哈希表中是否存在 target - x，然后将 x 插入到哈希表中，即可保证不会让 x 和自己匹配。
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashTable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashTable.containsKey(target - nums[i])) {
                return new int[]{hashTable.get(target - nums[i]), i};
            }
            hashTable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        TwoSum sum = new TwoSum();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = sum.twoSum(nums, target);
        System.out.println("result = " + Arrays.toString(result));
    }
}
