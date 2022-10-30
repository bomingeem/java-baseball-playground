package study;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void add() {
        assertThat(5).isEqualTo(calculator.add(2, 3));
    }

    @Test
    public void subtract() {
        assertThat(4).isEqualTo(calculator.subtract(5, 1));
    }

    @Test
    public void multiply() {
        assertThat(10).isEqualTo(calculator.multiply(2, 5));
    }

    @Test
    public void divide() {
        assertThat(5).isEqualTo(calculator.divide(10, 2));
    }

    @Test
    public void calculate() {
        assertThat(10).isEqualTo(calculator.inputAndStart("2 + 3 * 4 / 2"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"#", "$"})
    void wrongOperationType(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    assertThat(10).isEqualTo(calculator.calculate(10, input, "5"));
                });
    }
}
