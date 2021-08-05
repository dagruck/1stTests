import org.junit.jupiter.api.Test;

public class solve {


    // вспомогательный метод
    public static double func(double x) {
        return Math.cos(Math.pow(x, 3)) + Math.pow(x, 2) - 5 * x - 3;
    }

    // решить уравнение
    public static double  solve(double start, double end){
        if(end - start <= 0.001){
            return start;
        }

        double x = start + (end - start) / 2;

        if(func(start) * func(x) > 0){
            return solve(x, end);
        } else {
            return solve(start, x);
        }
    }
    public static void main(String[] args) {
        System.out.println(solve(0, 10));
    }


}
