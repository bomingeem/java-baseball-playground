package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] splitTwoNumbers = "1,2".split(",");
        assertThat(splitTwoNumbers).contains("1", "2");

        String[] splitOneNumber = "1,".split(",");
        assertThat(splitOneNumber).containsExactly("1");
    }

    @Test
    void substring() {
        String str = "(1,2)";
        str.substring(0, str.length() - 1);
        assertThat(str).contains("1,2");
    }

    @Test
    @DisplayName("chatAt()으로 특정 위치 문자 가져오기")
    void chatAt() {
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');

        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    str.charAt(3);
                    throw new Exception("out of range");
                }).withMessageMatching("exception...!");
    }
}
