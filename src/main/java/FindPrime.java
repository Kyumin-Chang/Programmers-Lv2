public class FindPrime {
    public boolean isPrime(long n) {
        if (n == 1) {
            return false;
        }
        long a = (long) Math.sqrt(n) + 1;
        for (int i = 2; i < a; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public String[] makeBinList(int n, int k) {
        StringBuilder kBin = new StringBuilder();
        while (n != 0) {
            kBin.insert(0, n % k);
            n /= k;
        }
        return kBin.toString().split("0");
    }

    public int solution(int n, int k) {
        int answer = 0;

        String[] a = makeBinList(n, k);

        for (String b : a) {
            if (b.isEmpty()) {
                continue;
            }
            long c = Long.parseLong(b);
            if (isPrime(c)) {
                answer++;
            }
        }
        return answer;
    }
}
