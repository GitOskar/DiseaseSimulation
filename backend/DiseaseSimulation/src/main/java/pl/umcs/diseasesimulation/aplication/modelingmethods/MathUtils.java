package pl.umcs.diseasesimulation.aplication.modelingmethods;

public abstract class MathUtils {
    public static double fractional(double value) {
        return value - Math.floor(value);
    }

    public static double max(double a, double b, double c) {
        return Math.max(a, Math.max(b, c));
    }

    public static double min(double a, double b, double c) {
        return Math.min(a, Math.min(b, c));
    }

    public static double maxFractional(double a, double b, double c) {
        return max(fractional(a), fractional(b), fractional(c));
    }

    public static double minFractional(double a, double b, double c) {
        return min(fractional(a), fractional(b), fractional(c));
    }
}
