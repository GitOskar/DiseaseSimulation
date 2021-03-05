package pl.umcs.diseasesimulation.aplication.modelingmethods;

public abstract class MathUtils {
    public static double fractional(double value) {
        return value - Math.floor(value);
    }

    public static double max(double ... numbers) {
        double result = numbers[0];

        for (int i=1 ; i<numbers.length ; i++)
            result = Math.max(result, numbers[i]);

        return result;
    }

    public static double min(double ... numbers) {
        double result = numbers[0];

        for (int i=1 ; i<numbers.length ; i++)
            result = Math.min(result, numbers[i]);

        return result;
    }

    public static double minFractional(double ... numbers) {
        double result = fractional(numbers[0]);

        for (int i=1 ; i<numbers.length ; i++)
            result = Math.min(result, fractional(numbers[i]));

        return result;
    }

    public static double maxFractional(double ... numbers) {
        double result = fractional(numbers[0]);

        for (int i=1; i<numbers.length ; i++)
            result = Math.max(result, fractional(numbers[i]));

        return result;
    }
}
