public class wigglesort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 1, 6, 4};
        int[] res = wiggleSort(nums);
        for (int v : res) System.out.print(v + " ");
    }

    public static int[] wiggleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if ((i % 2 == 0 && nums[i] > nums[i + 1]) || (i % 2 == 1 && nums[i] < nums[i + 1])) {
                swap(nums, i, i + 1);
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
