import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParkFeeTest {
    ParkFeeCalculator parkFeeCalculator = new ParkFeeCalculator();
    String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
            "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

    int[] fees = {180, 5000, 10, 600};

    @DisplayName("입차 자동차 정렬 테스트")
    @Test
    void inCarSortedTest() {
        List<String> inCars;
        inCars = parkFeeCalculator.getInCars(records);
        System.out.println(inCars);
        assertThat(inCars).isNotNull();
    }

    @DisplayName("출차 자동차 정렬 테스트")
    @Test
    void OutCarSortedTest() {
        List<String> outCars;
        outCars = parkFeeCalculator.getOutCars(records);
        System.out.println(outCars);
        assertThat(outCars).isNotNull();
    }

    @DisplayName("자동차 출차 계산 테스트")
    @Test
    void parkFeeTest() {
        Map<String, Integer> carsFee;
        List<String> inCars;
        List<String> outCars;
        inCars = parkFeeCalculator.getInCars(records);
        outCars = parkFeeCalculator.getOutCars(records);
        carsFee = parkFeeCalculator.feeCalculator(inCars, outCars, fees);
        System.out.println(carsFee);
        assertThat(carsFee).isNotNull();
    }

}
