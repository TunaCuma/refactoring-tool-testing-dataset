package org.example.long_method.medium;

import java.util.List;

public class NumericAnalyzer {
    public String analyze(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return "No data";
        }

        int sum = 0;
        int product = 1;
        int max = numbers.get(0);
        int min = numbers.get(0);
        int primeCount = 0;

        for (int n : numbers) {
            sum += n;
            product *= n;
            if (n > max) max = n;
            if (n < min) min = n;
            if (isPrime(n)) primeCount++;
        }

        double average = (double) sum / numbers.size();
        int first = numbers.get(0);
        long factorial = 1;
        for (int i = 1; i <= first; i++) {
            factorial *= i;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Sum: ").append(sum).append("\n");
        sb.append("Product: ").append(product).append("\n");
        sb.append("Max: ").append(max).append("\n");
        sb.append("Min: ").append(min).append("\n");
        sb.append("Average: ")
          .append(String.format("%.2f", average)).append("\n");
        sb.append("Primes: ").append(primeCount).append("\n");
        sb.append("Factorial(").append(first).append("): ")
          .append(factorial).append("\n");
        sb.append("Numbers:\n");
        for (int n : numbers) {
            sb.append(n).append("\n");
        }

        return sb.toString();
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}
