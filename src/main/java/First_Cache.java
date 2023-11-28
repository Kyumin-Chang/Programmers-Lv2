import java.util.LinkedList;
import java.util.List;

public class First_Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        List<String> cache = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {
            String cityName = cities[i].toLowerCase();
            if (!(cache.contains(cityName))) {
                answer += 5;
                if (cache.size() >= cacheSize) {
                    cache.remove(0);
                }
                cache.add(cityName);
                continue;
            }
            if (cache.contains(cityName)) {
                cache.remove(cityName);
                cache.add(cityName);
                answer += 1;
            }
        }
        return answer;
    }

}
