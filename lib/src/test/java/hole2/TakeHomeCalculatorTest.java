package hole2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class TakeHomeCalculatorTest {

    @Test
    public void canCalculateTax() throws Exception {
        Integer first = new TakeHomeCalculator(10).netAmount(new TakeHomeCalculator.Pair<>(40, "GBP"), new TakeHomeCalculator.Pair<>(50, "GBP"), new TakeHomeCalculator.Pair<>(60, "GBP")).first;
        assertEquals(135, first.intValue());
    }

    @Test
    public void cannotSumDifferentCurrencies() throws Exception {
        assertThrows(Incalculable.class, () -> {
            new TakeHomeCalculator(10).netAmount(new TakeHomeCalculator.Pair<>(4, "GBP"), new TakeHomeCalculator.Pair<>(5, "USD"));
        });
    }
}