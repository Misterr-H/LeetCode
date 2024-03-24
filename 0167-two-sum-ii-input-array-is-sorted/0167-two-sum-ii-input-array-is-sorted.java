class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        int point1 = numbers[index1];
        int point2 = numbers[index2];
        while(point1 + point2 != target) {
            if (point1 + point2 > target) {
                index2--;
                point2 = numbers[index2];
            } else {
                index1++;
                point1 = numbers[index1];
            }
        }
        return new int[] {index1+1, index2+1};
    }
}