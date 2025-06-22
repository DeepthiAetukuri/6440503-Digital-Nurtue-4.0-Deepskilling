public class FinancialForecast {
    public static double forecastRecursive(double initialValue, double growthRate, int years) {
        if (years == 0) {
            return initialValue; 
        }
        return forecastRecursive(initialValue, growthRate, years - 1) * (1 + growthRate / 100);
    }
    public static double forecastTailRecursive(double value, double rate, int years) {
        return forecastTailHelper(value, rate, years);
    }

    private static double forecastTailHelper(double value, double rate, int years) {
        if (years == 0) return value;
        return forecastTailHelper(value * (1 + rate / 100), rate, years - 1);
    }
    public static double forecastIterative(double initialValue, double rate, int years) {
        double result = initialValue;
        for (int i = 1; i <= years; i++) {
            result *= (1 + rate / 100);
        }
        return result;
    }
    public static void main(String[] args) {
        double initialValue = 10000;  
        double annualGrowthRate = 5; 
        int years = 5;
        double forecast = forecastRecursive(initialValue, annualGrowthRate, years);
        System.out.println("Forecast using recursion for " + years + " years: RS." + forecast);
        double optimizedForecast = forecastTailRecursive(initialValue, annualGrowthRate, years);
        System.out.println("Forecast using tail recursion: RS." + optimizedForecast);
        double iterativeForecast = forecastIterative(initialValue, annualGrowthRate, years);
        System.out.println("Forecast using iteration: Rs." + iterativeForecast);
    }
}
