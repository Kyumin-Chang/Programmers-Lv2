import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FunctionDevelopmentTest {

    @DisplayName("메인 테스트")
    @Test
    void mainTest() {
        FunctionDevelopment functionDevelopment = new FunctionDevelopment();
        int[] progress = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] answer = {1, 3, 2};
        assertThat(functionDevelopment.solution(progress, speeds)).isEqualTo(answer);
    }
}
