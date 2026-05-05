package graphs.portfolio;

import java.util.HashMap;
import java.util.Map;

public class City {
    private String name;
    private Map<City, Integer> roads;

    public City(String name) {
        this.name = name;
        this.roads = new HashMap<>();
    }

    public String getName() { return name; }

    public Map<City, Integer> getRoads() { return roads; }

    public void addRoad(City destination, int km) {
        roads.put(destination, km);
    }
}
