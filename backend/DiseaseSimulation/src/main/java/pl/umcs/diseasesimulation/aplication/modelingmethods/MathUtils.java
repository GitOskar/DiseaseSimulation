package pl.umcs.diseasesimulation.aplication.modelingmethods;

public abstract class MathUtils {
    public static double fractional(double value) {
        return value - Math.floor(value);
    }

    public static double maxFractional(double ... numbers) {
        double result = fractional(numbers[0]);

        for (int i=1; i<numbers.length ; i++)
            result = Math.max(result, fractional(numbers[i]));

        return result;
    }
}
