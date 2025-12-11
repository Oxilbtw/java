
package fsm;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestAutomatonTest {

    @ParameterizedTest
    @CsvSource({
            "'abcTESTabc', F",
            "'abcTES', Q3",
            "'TEST', F",
            "'TESXTEST', F",
            "'TETEST', F",
            "'', S"
    })
    void testAutomaton(String input, TestAutomaton.State expected) {
        TestAutomaton fsm = new TestAutomaton();
        assertEquals(expected, fsm.run(input));
    }

    @ParameterizedTest
    @CsvSource({
            "'TESETEST', F"
    })
    void testFixedCase(String input) {
        TestAutomaton fsm = new TestAutomaton();
        assertEquals(TestAutomaton.State.F, fsm.run(input));
    }
}
