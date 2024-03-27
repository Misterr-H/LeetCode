class Solution {
    public int kthFactor(int n, int k) {
        if(k==1)
            return k;
        if(n==1)
            return -1;
        if(n == 2 && k!=2)
            return -1;
        else if (n == 2 && k==2) return 2;
        ArrayList<Integer> factors = new ArrayList<>();
        int count=0;

        for(int i = 1; i*i <= n; i+=1) {
            if(n%i==0) {
                factors.add(i);
                count++;
            }
            if(count==k)
                return i;
        }

        if (k > count*2) return -1;
        for(int i = factors.size() - 1; i>= 0; i--) {
            if (factors.get(i) * factors.get(i) != n) {
                factors.add(n/factors.get(i));
            }
        }
        if(k > factors.size()) return -1;
        return factors.get(k-1);
    }
}