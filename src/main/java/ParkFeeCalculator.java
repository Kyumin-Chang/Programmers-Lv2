import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ParkFeeCalculator {
    /*
    [120, 0, 60, 591]	["16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"]	[0, 591]
     */
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> carFee;
        int[] answer;
        List<String> inCars = getInCars(records);
        List<String> outCars = getOutCars(records);
        List<Integer> answerList = new ArrayList<>();
        carFee = feeCalculator(inCars, outCars, fees);
        for (String k : carFee.keySet()) {
            answerList.add(carFee.get(k));
        }
        answer = answerList.stream()
                .mapToInt(i -> i)
                .toArray();
        return answer;
    }

    public List<String> getInCars(String[] records) {
        List<String> inCars = new ArrayList<>();
        for (String record : records) {
            if (record.contains("IN")) {
                String car = record.substring(6, 10);
                String time = record.substring(0, 6);
                inCars.add(car + " " + time);
            }
        }
        Collections.sort(inCars);
        return inCars;
    }

    public List<String> getOutCars(String[] records) {
        List<String> outCars = new ArrayList<>();
        for (String record : records) {
            if (record.contains("OUT")) {
                String car = record.substring(6, 10);
                String time = record.substring(0, 6);
                outCars.add(car + " " + time);
            }
        }
        Collections.sort(outCars);
        return outCars;
    }

    public Map<String, Integer> feeCalculator(List<String> inCars, List<String> outCars, int[] fees) {
        Map<String, Integer> carsFee = new TreeMap<>();
        long diffMinutes;
        String time_1;
        String time_2;
        for (String inCar : inCars) {
            String car = inCar.substring(0, 4);
            time_1 = inCar.substring(5);
            if (!carsFee.containsKey(car)) {
                carsFee.put(car, 0);
            }
            if (outCars.isEmpty()) {
                outCars.add("0");
            }
            for (int j = 0; j < outCars.size(); j++) {
                if (outCars.get(j).contains(car)) {
                    time_2 = outCars.get(j).substring(5);
                    diffMinutes = calMinutes(time_1, time_2);
                    carsFee.put(car, carsFee.get(car) + (int) diffMinutes);
                    outCars.remove(j);
                    break;
                } else if (j == outCars.size() - 1) {
                    time_2 = "23:59";
                    diffMinutes = calMinutes(time_1, time_2);
                    carsFee.put(car, carsFee.get(car) + (int) diffMinutes);
                }
            }
        }
        carsFee.replaceAll((k, v) -> fee(carsFee.get(k), fees));
        return carsFee;
    }

    public long calMinutes(String time_1, String time_2) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(time_1);
            d2 = format.parse(time_2);
        } catch (ParseException e) {
            System.out.println("잘못된 시간 형식 입니다.");
        }
        assert d1 != null;
        assert d2 != null;
        boolean diffTime = d1.after(d2);
        if (diffTime) {
            return 0;
        }
        long diff = d2.getTime() - d1.getTime();
        return diff / 60000;
    }

    public int fee(long diffMinutes, int[] fees) {
        int money = 0;

        if (diffMinutes <= fees[0]) {
            money = fees[1];
        }
        if (diffMinutes > fees[0]) {
            money = (int) (Math.ceil((double) (diffMinutes - fees[0]) / fees[2]) * fees[3]) + fees[1];
        }
        return money;
    }
}
