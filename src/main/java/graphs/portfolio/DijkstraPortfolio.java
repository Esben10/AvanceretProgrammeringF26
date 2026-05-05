package graphs.portfolio;

import java.util.*;
import java.util.stream.Collectors;

public class DijkstraPortfolio {

    public static void main(String[] args) {
        // Dansk vejnet med 10 byer, rettede veje (km)
        City esbjerg    = new City("Esbjerg");
        City kolding    = new City("Kolding");
        City fredericia = new City("Fredericia");
        City odense     = new City("Odense");
        City vejle      = new City("Vejle");
        City horsens    = new City("Horsens");
        City aarhus     = new City("Aarhus");
        City randers    = new City("Randers");
        City aalborg    = new City("Aalborg");
        City koebenhavn = new City("København");

        List<City> allCities = Arrays.asList(
            esbjerg, kolding, fredericia, odense, vejle,
            horsens, aarhus, randers, aalborg, koebenhavn
        );

        esbjerg.addRoad(kolding, 73);
        esbjerg.addRoad(odense, 144);
        kolding.addRoad(fredericia, 24);
        kolding.addRoad(vejle, 47);
        odense.addRoad(fredericia, 50);
        odense.addRoad(koebenhavn, 167);
        fredericia.addRoad(vejle, 21);
        vejle.addRoad(horsens, 36);
        vejle.addRoad(aarhus, 97);
        horsens.addRoad(aarhus, 73);
        horsens.addRoad(randers, 62);
        aarhus.addRoad(randers, 57);
        aarhus.addRoad(aalborg, 119);
        randers.addRoad(aalborg, 98);
        koebenhavn.addRoad(odense, 167);

        findShortestPath(esbjerg, aalborg, allCities);
    }

    public static void findShortestPath(City source, City destination, List<City> allCities) {
        Map<City, City> prev = new HashMap<>();
        Map<City, Integer> dist = new HashMap<>();
        Set<City> visited = new HashSet<>();
        PriorityQueue<CityWithDist> queue = new PriorityQueue<>();

        dist.put(source, 0);
        queue.add(new CityWithDist(source, 0));

        System.out.println("=== Dijkstra: Korteste vej fra " + source.getName() + " til " + destination.getName() + " ===");
        System.out.println("Visualisering viser ved hvert step hvilken by der besøges,");
        System.out.println("og hvad den korteste kendte afstand er til alle andre byer.\n");

        int step = 1;
        while (!queue.isEmpty()) {
            CityWithDist current = queue.poll();

            if (current.city.equals(destination)) {
                System.out.println("Mål nået! " + destination.getName() + " fundet i step " + step + ".\n");
                break;
            }

            if (visited.contains(current.city)) continue;
            visited.add(current.city);

            System.out.println("--- Step " + step++ + ": Besøger " + current.city.getName()
                + " (korteste kendte afstand fra start: " + current.dist + " km) ---");

            for (Map.Entry<City, Integer> entry : current.city.getRoads().entrySet()) {
                City next = entry.getKey();
                int weight = entry.getValue();
                if (visited.contains(next)) continue;

                int newDist = current.dist + weight;
                if (newDist < dist.getOrDefault(next, Integer.MAX_VALUE)) {
                    dist.put(next, newDist);
                    prev.put(next, current.city);
                    queue.add(new CityWithDist(next, newDist));
                }
            }

            printTable(allCities, dist, visited, queue, current.city, prev);
        }

        printResult(destination, dist, prev);
    }

    // Visualisering: tabel der viser alle byers status på et givet tidspunkt.
    // Kolonnen "Via" viser hvilken by vi kom igennem for at opnå den kendte afstand –
    // det er denne kæde af "via"-pejlemærker der til sidst rekonstruerer den korteste vej.
    private static void printTable(List<City> allCities, Map<City, Integer> dist,
                                   Set<City> visited, PriorityQueue<CityWithDist> queue,
                                   City current, Map<City, City> prev) {
        Set<City> inQueue = queue.stream().map(c -> c.city).collect(Collectors.toSet());

        System.out.printf("  %-14s %-14s %-14s %s%n", "By", "Afstand (km)", "Via", "Status");
        System.out.println("  " + "-".repeat(58));
        for (City city : allCities) {
            String distStr  = dist.containsKey(city) ? dist.get(city) + " km" : "∞";
            String via      = prev.containsKey(city) ? prev.get(city).getName() : "-";
            String status;
            if (city.equals(current))        status = "<-- besøger nu";
            else if (visited.contains(city)) status = "færdig";
            else if (inQueue.contains(city)) status = "i prioritetskø";
            else                             status = "ikke opdaget endnu";

            System.out.printf("  %-14s %-14s %-14s %s%n", city.getName(), distStr, via, status);
        }
        System.out.println();
    }

    private static void printResult(City destination, Map<City, Integer> dist, Map<City, City> prev) {
        List<String> path = new ArrayList<>();
        City step = destination;
        while (step != null) {
            path.add(0, step.getName());
            step = prev.get(step);
        }

        System.out.println("=== Resultat ===");
        System.out.println("Korteste rute:  " + String.join(" -> ", path));
        System.out.println("Samlet afstand: " + dist.getOrDefault(destination, -1) + " km");
    }

    private static class CityWithDist implements Comparable<CityWithDist> {
        City city;
        int dist;

        CityWithDist(City city, int dist) {
            this.city = city;
            this.dist = dist;
        }

        @Override
        public int compareTo(CityWithDist other) {
            return Integer.compare(this.dist, other.dist);
        }
    }
}
