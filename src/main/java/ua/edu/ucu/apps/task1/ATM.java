package ua.edu.ucu.apps.task1;
import java.util.HashMap;
import java.util.Map;

public class ATM {
    private Section first;

    public ATM() {
        this.first = new Section_500();

        Section_200 section_200 = new Section_200();
        first.setNext(section_200);
    }

    public Map<Integer, Integer> getMeMoney(int amount) {
        if (!isAmountValid(amount)) {
            throw new IllegalArgumentException("Cannot provide the requested amount with available denominations");
        }

        Map<Integer, Integer> result = new HashMap<>();
        first.process(amount, result);
        return result;
    }

    private boolean isAmountValid(int amount) {
        int gcd = gcd(500, 200);
        return amount % gcd == 0;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

