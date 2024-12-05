package ua.edu.ucu.apps.task1;

import java.util.Map;

public abstract class Section {
    private int denomination;
    private Section next;

    public Section(int denomination) {
        this.denomination = denomination;
    }

    public void setNext(Section next) {
        this.next = next;
    }

    private boolean hasNext() {
        return next != null;
    }

    public void process(int amount, Map<Integer, Integer> result) {
        int count = amount / denomination;
        int left = amount % denomination;

        if (count > 0) {
            result.put(denomination, count);
        }

        if (left != 0) {
            if (hasNext()) {
                next.process(left, result);
            } else {
                throw new IllegalArgumentException("Invalid amount, cannot be processed further.");
            }
        }
    }
}
