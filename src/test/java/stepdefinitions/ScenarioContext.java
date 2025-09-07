package stepdefinitions;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    String url="https://naveenautomationlabs.com/opencart/index.php";
    private Map<String, Object> data = new HashMap<>();

    public void set(String key, Object value) {
        data.put(key, value);
    }

    public Object get(String key) {
        return data.get(key);
    }
}
