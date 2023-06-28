import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ArrayCombinations {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, -4, -6, -2, 8};
        int target = 4;

        // Find combinations for the target value
        List<int[]> combinations = findCombinations(nums, target);
        System.out.println("First Combination For \"" + target + "\": " + combinationsToString(combinations));

        // Merge the array into a single array
        int[] mergedArray = mergeArray(nums);
        System.out.println("Merge Into a single Array: " + Arrays.toString(mergedArray));

        // Double the target value and find combinations again
        int doubleTarget = target * 2;
        List<int[]> doubleCombinations = findCombinationsForDoubleTarget(mergedArray, doubleTarget);
        System.out.println("Second Combination For \"" + doubleTarget + "\": " + combinationsToString(doubleCombinations));
    }

    public static List<int[]> findCombinations(int[] nums, int target) {
        List<int[]> combinations = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int complement = target - num;
            if (map.containsKey(complement)) {
                combinations.add(new int[]{num, complement});
            }
            map.put(num, complement);
        }

        return combinations;
    }

    public static int[] mergeArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

    public static List<int[]> findCombinationsForDoubleTarget(int[] nums, int target) {
        List<int[]> combinations = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int complement = target - num;
            if (map.containsKey(complement)) {
                int[] combination = new int[4];
                combination[0] = num;
                combination[1] = complement;
                combination[2] = num;
                combination[3] = complement;
                combinations.add(combination);
            }
            map.put(num, complement);
        }

        return combinations;
    }

    public static String combinationsToString(List<int[]> combinations) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int[] combination : combinations) {
            sb.append(Arrays.toString(combination));
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(" ]");
        return sb.toString();
    }
}
