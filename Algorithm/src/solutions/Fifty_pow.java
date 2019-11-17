package solutions;
//It's not of good performance, but help me figure out many things.
//I'm still wondering why the annotated function runs correctly.
//Why it straightly use -n when n<0, but doesn't encounter Integer.MIN_VALUE problem.
public class Fifty_pow {
    public double myPow(double x, int n) {
        if(n==1) return x;
        if(n==0) return 1d;

        if(n==Integer.MIN_VALUE){
            n+=1;
            double res=(n>=0)?DAC(x,n):(1/DAC(x,-n));
            return (x>0)?res:-res;
        }
        return (n>=0)?DAC(x,n):(1/DAC(x,-n));
        //double res=(n>=0)?DAC(x,n):(1/DAC(x,-n));
        //return Double.isInfinite(res)?0d:res;
    }

    private double DAC(double x, int exponent){
        if(exponent==1) return x;
        else {
            /*
            Comparing to the statement below. It wastes operations for calculating repeatedly.
            return (exponent%2==0)?DAC(x,exponent/2)*DAC(x,exponent/2):DAC(x,exponent/2+1)*DAC(x,exponent/2);
            */
            double y=DAC(x,exponent/2);
            return (exponent%2==0)?y*y:y*y*x;
        }

    }
    /*
    public double myPow(double x, int n) {
        if (x == 1) return x;
        double result = n >= 0 ? pow(x, n) : (1 / pow(x, -n));
        return Double.isInfinite(result) ? 0d : result;
    }
    // odd  y = x^(n-1/2) => y * y * x
    // even y = x^(n/2)   => y * y
    private double pow(double x, int n) {
        if (n == 1) return x;
        if (n == 0) return 1d;
        double y = pow(x, n >>> 1);
        return n % 2 == 0 ? y*y : y*y*x;
    }
    */


}
