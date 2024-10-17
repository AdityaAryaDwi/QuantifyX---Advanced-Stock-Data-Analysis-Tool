import java.util.*;

public class DataAnalyzer {
    public static double calculateSMA(Map<String, Double> data, int period) {
        List<Double> prices = new ArrayList<>(data.values());
        double sum = 0;
        for (int i = 0; i < period; i++) {
            sum += prices.get(i);
        }
        return sum / period;
    }

    public static void displayTrend(Map<String, Double> data) {
        List<Double> prices = new ArrayList<>(data.values());
        if (prices.get(0) > prices.get(prices.size() - 1)) {
            System.out.println("Downtrend detected.");
        } else {
            System.out.println("Uptrend detected.");
        }
    }
}
