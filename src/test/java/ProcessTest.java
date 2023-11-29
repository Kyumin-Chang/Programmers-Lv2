import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProcessTest {

    @DisplayName("프로세스 테스트")
    @Test
    void mainTest() {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        Process process = new Process();
        int answer = 5;
        System.out.println(answer);
        assertThat(process.solution(priorities, location)).isEqualTo(answer);
    }
}
