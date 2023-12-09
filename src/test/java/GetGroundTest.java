import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GetGroundTest {

    @DisplayName("땅따먹기 테스트")
    @Test
    void mainTest() {
        GetGround getGround = new GetGround();
        int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        int answer = getGround.solution(land);
        System.out.println(answer);
        assertThat(answer).isEqualTo(16);
    }
}
