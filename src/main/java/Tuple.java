import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.Stream;

public class Tuple {
    /*
    "{{2},{2,1},{2,1,3},{2,1,3,4}}"	[2, 1, 3, 4]
"{{1,2,3},{2,1},{1,2,4,3},{2}}"	[2, 1, 3, 4]
"{{20,111},{111}}"	[111, 20]
"{{123}}"	[123]
"{{4,2,3},{3},{2,3,4,1},{2,3}}"	[3, 2, 4, 1]
     */
    public int[] solution(String s) {
        s = s.replaceAll("\\{", "");
        String[] sArr = s.substring(0, s.length() - 2).split("\\}\\,");
        Arrays.sort(sArr, Comparator.comparingInt(String::length));

        HashSet<Integer> checkDuplicate = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (String string : sArr) {
            int[] tuple = Stream.of(string.split(",")).mapToInt(Integer::parseInt).toArray();
            for (int num : tuple) {
                if (!checkDuplicate.contains(num)) {
                    result.add(num);
                }
                checkDuplicate.add(num);
            }
        }

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
