import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StockPriceTest {
    @DisplayName("주식 가격 테스트")
    @Test
    void mainTest() {
        StockPrice stockPrice = new StockPrice();
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = stockPrice.solution(prices);
        int[] result = {4, 3, 1, 1, 0};
        System.out.println(Arrays.toString(answer));
        assertThat(answer).isEqualTo(result);
    }
}
