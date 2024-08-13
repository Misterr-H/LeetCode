class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalgas = 0;
        int totalcost = 0;

        for(int i=0;i<cost.length;i++) {
            totalcost+=cost[i];
            totalgas+=gas[i];
        }

        if(totalcost>totalgas) return -1;

        int total=0;
        int start=0;
        for(int i=0;i<cost.length;i++) {
            total+=(gas[i]-cost[i]);
            if(total<0) {
                total=0;
                start=i+1;
            }
        }

        return start;
    }
}