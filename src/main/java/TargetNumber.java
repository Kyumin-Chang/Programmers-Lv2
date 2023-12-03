public class TargetNumber {
    static int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }

    public void dfs(int sum, int idx, int[] numbers, int target) {
        if (sum == target && idx == numbers.length) {
            answer++;
            return;
        }

        if (idx >= numbers.length) {
            return;
        }

        dfs(sum + numbers[idx], idx + 1, numbers, target);
        dfs(sum - numbers[idx], idx + 1, numbers, target);
    }
}
