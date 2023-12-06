public class SkillTree {
    /*
    "CBD"	["BACDE", "CBADF", "AECB", "BDA"]
     */
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skillTree : skill_trees) {
            String tmp = skillTree.replaceAll("[^" + skill + " ]", "");
            if (tmp.isEmpty()) {
                answer++;
                continue;
            }
            for (int j = 1; j <= skill.length(); j++) {
                if (skill.substring(0, j).equals(tmp)) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
