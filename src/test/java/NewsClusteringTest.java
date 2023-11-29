import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NewsClusteringTest {

    @DisplayName("문자열 자르기 테스트")
    @Test
    void cutStr() {
        String str1 = "E=M*C^23Ab";
        String str2 = "e=m*c^23wcd";
        List<String> sList1 = new ArrayList<>();
        List<String> sList2 = new ArrayList<>();
        NewsClustering newsClustering = new NewsClustering();
        newsClustering.cutStr(str1, sList1);
        newsClustering.cutStr(str2, sList2);
        System.out.println(sList1);
        System.out.println(sList2);
        assertThat(sList1).contains("ab");
    }

    @DisplayName("뉴스 클러스터링 테스트")
    @Test
    void mainTest() {
        String str1 = "FRANCE";
        String str2 = "french";
        NewsClustering newsClustering = new NewsClustering();
        assertThat(newsClustering.solution(str1, str2)).isEqualTo(16384);
    }
}
