class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            int left = i + 1;
            int right = numbers.length - 1;
            int index = binarySearch(numbers, left, right, complement);
            if (index != -1) {
                return new int[] {i + 1, index + 1};
            }
        }
        return new int[] {-1, -1};
    }

    private int binarySearch(int[] numbers, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}