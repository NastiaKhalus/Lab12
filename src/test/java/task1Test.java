import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.edu.ucu.apps.task1.ATM;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class task1Test {

    private ATM atm;

    @BeforeEach
    void setUp() {
        atm = new ATM();
    }

    @Test
    void testGetMeMoneyValidAmount500() {
        Map<Integer, Integer> result = atm.getMeMoney(500);
        assertEquals(1, result.get(500));
        assertFalse(result.containsKey(200));
    }

    @Test
    void testGetMeMoneyValidAmount700() {
        Map<Integer, Integer> result = atm.getMeMoney(700);
        assertEquals(1, result.get(500));
        assertEquals(1, result.get(200));
    }

    @Test
    void testGetMeMoneyValidAmount900() {
        Map<Integer, Integer> result = atm.getMeMoney(900);
        assertEquals(1, result.get(500));
        assertEquals(2, result.get(200));
    }

    @Test
    void testGetMeMoneyInvalidAmount() {
        assertThrows(IllegalArgumentException.class, () -> atm.getMeMoney(300));
    }

    @Test
    void testGetMeMoneyZeroAmount() {
        Map<Integer, Integer> result = atm.getMeMoney(0);
        assertTrue(result.isEmpty());
    }


    @Test
    void testGCD() {
        assertEquals(100, atm.gcd(500, 200));
        assertEquals(1, atm.gcd(17, 13));
        assertEquals(5, atm.gcd(15, 10));
    }
}
