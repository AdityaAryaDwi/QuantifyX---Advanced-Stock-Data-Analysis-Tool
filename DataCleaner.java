import org.json.JSONObject;
import org.json.JSONException;
import java.util.HashMap;
import java.util.Map;

public class DataCleaner {
    public static Map<String, Double> cleanData(JSONObject rawData) {
        Map<String, Double> cleanedData = new HashMap<>();
        try {
            JSONObject timeSeries = rawData.getJSONObject("Time Series (Daily)");
            for (String date : timeSeries.keySet()) {
                JSONObject dayData = timeSeries.getJSONObject(date);
                double closePrice = dayData.getDouble("4. close");
                cleanedData.put(date, closePrice);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return cleanedData;
    }
}
