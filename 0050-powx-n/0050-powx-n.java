class Solution {
    public double myPow(double x, int n) {
        long m = n;
        if (n == 0)
            return 1;
        if (n > 0)
            return pow(x, m);
        else
            return 1 / pow(x, -m);
    }

    public double pow(double x, long n) {
        if (n == 1)
            return x;
        if (n % 2 == 0) {
            double half = pow(x,n/2);
            return half * half;
        } else {
            double half = pow(x, (n - 1) / 2);
            return x * half * half;
        }
    }
}