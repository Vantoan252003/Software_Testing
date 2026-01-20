public class Power {
    public static double calculate(double x, int n) {
        if (n ==0)
            return 1.0;
        else if (n > 0) 
            return x * calculate(x, n -1);
        else 
            return calculate(x, n + 1)/x; 
    }
}