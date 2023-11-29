import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Process {
    /*
    [2, 1, 3, 2]	    2	1
    [1, 1, 9, 1, 1, 1]	0	5
     */
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> order = new LinkedList<>();
        List<Integer> execute = new ArrayList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(priorities[i]);
            order.offer(i);
        }

        while (queue.peek() != null) {
            int value = queue.poll();
            int orderValue = order.poll();

            if (queue.stream().noneMatch(number -> value < number)) {
                execute.add(orderValue);
            } else {
                queue.offer(value);
                order.offer(orderValue);
            }
        }
        return execute.indexOf(location) + 1;
    }
}
