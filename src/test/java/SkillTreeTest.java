import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SkillTreeTest {
    @DisplayName("스킬 트리 테스트")
    @Test
    void mainTest() {
        SkillTree skillTree = new SkillTree();
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        int answer = skillTree.solution(skill, skill_trees);
        System.out.println(answer);
        assertThat(answer).isEqualTo(2);
    }
}
