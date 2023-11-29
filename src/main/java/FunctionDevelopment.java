import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FunctionDevelopment {
    /*
    [93, 30, 55]	            [1, 30, 5]	        [2, 1]
    [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
     */
    public int[] solution(int[] progresses, int[] speeds) {
        int j = 0;
        int[] answer = new int[speeds.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = progresses.length - 1; i >= 0; i--) {
            stack.push(progresses[i]);
        }
        while (!stack.isEmpty()) {
            for (int i = stack.size() - 1; i >= 0; i--) {
                stack.set(i, progresses[speeds.length - i - 1] + speeds[speeds.length - i - 1]);
                progresses[speeds.length - i - 1] = progresses[speeds.length - i - 1] + speeds[speeds.length - i - 1];
            }
            if (stack.peek() < 100) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() >= 100) {
                stack.pop();
                answer[j]++;
            }
            j++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] != 0) {
                result.add(answer[i]);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
