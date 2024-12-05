package model;

public class SeriesCalculator {

    public double calculateExact(double x) {
        return Math.sqrt(1 + x);
    }

    public double calculateSumOfTerms(double x, int n) {
        double sum = 1.0;
        double term = 1.0;

        for (int i = 1; i < n; i++) {
            term *= (x * (1 - 2 * i)) / (2 * i);
            sum += term;
        }
        return sum;
    }

    public double calculateSumAboveE(double x, double e, int[] termCount) {
        double sum = 1.0;
        double term = 1.0;
        termCount[0] = 1;

        int maxIterations = 1000;
        for (int i = 1; i <= maxIterations; i++) {
            term *= (x * (1 - 2 * i)) / (2 * i);
            if (Math.abs(term) <= e) {
                break;
            }
            sum += term;
            termCount[0]++;
        }

        if (termCount[0] >= maxIterations) {
            throw new IllegalArgumentException("Series did not converge within the maximum iterations.");
        }

        return sum;
    }
}
