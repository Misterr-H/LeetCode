class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int one = 0;
        int zero = 0;
        for(int i : students) {
            if(i == 1) {
                one++;
            }
        }
        zero = students.length - one;
        for(int i: sandwiches) {
            if(i == 0 && zero == 0) {
                return one;
            } else if (i == 1 && one == 0) {
                return zero;
            }
            if (i == 0) {
                zero--;
            } else if (i == 1) {
                one--;
            }
        }
        return 0;
    }
}