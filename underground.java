class underground{

    // id -> (station, time)
    private Map<Integer, Pair<String, Integer>> checkInMap;

    // route -> (totalTime, count)
    private Map<String, Pair<Integer, Integer>> travelMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {

        Pair<String, Integer> checkIn = checkInMap.get(id);

        String startStation = checkIn.getKey();
        int startTime = checkIn.getValue();

        String route = startStation + "->" + stationName;
        int travelTime = t - startTime;

        Pair<Integer, Integer> data =
                travelMap.getOrDefault(route, new Pair<>(0, 0));

        int totalTime = data.getKey() + travelTime;
        int count = data.getValue() + 1;

        travelMap.put(route, new Pair<>(totalTime, count));

        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {

        String route = startStation + "->" + endStation;

        Pair<Integer, Integer> data = travelMap.get(route);

        return (double) data.getKey() / data.getValue();
    }
}