import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class NewsClustering {
    public int solution(String str1, String str2) {
        List<String> str1Collect = new ArrayList<>();
        List<String> str2Collect = new ArrayList<>();
        cutStr(str1, str1Collect);
        cutStr(str2, str2Collect);
        return calculate(str1Collect, str2Collect);
    }

    public void cutStr(String s, List<String> sList) {
        s = s.toLowerCase();
        s = s + " ";
        for (int i = 0; i < s.length() - 1; i++) {
            sList.add(s.substring(i, i + 2));
            if (!Pattern.matches("^[a-zA-Z]*$", sList.get(sList.size() - 1))) {
                sList.removeIf(sList.get(sList.size() - 1)::equals);
            }
        }
    }

    public int calculate(List<String> s1, List<String> s2) {
        int cNum;
        int uNum;
        List<String> c = new ArrayList<>();
        List<String> u = new ArrayList<>();

        for (String s : s1) {
            if (s2.contains(s)) {
                c.add(s);
                s2.remove(s);
            }
            u.add(s);
        }
        u.addAll(s2);

        cNum = c.size();
        uNum = u.size();

        if (u.isEmpty()) {
            return 65536;
        }
        return (int) ((double) cNum / uNum * 65536);
    }
}
