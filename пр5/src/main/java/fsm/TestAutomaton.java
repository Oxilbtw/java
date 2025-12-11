
package fsm;

public class TestAutomaton {

    public enum State {
        S, Q1, Q2, Q3, F
    }

    private State state = State.S;

    public State getState() {
        return state;
    }

    public void step(char ch) {
        switch (state) {
            case S:
                if (ch == 'T') state = State.Q1;
                else state = State.S;
                break;

            case Q1:
                if (ch == 'E') state = State.Q2;
                else if (ch == 'T') state = State.Q1;
                else state = State.S;
                break;

            case Q2:
                if (ch == 'S') state = State.Q3;
                else if (ch == 'T') state = State.Q1;
                else state = State.S;
                break;

            case Q3:
                if (ch == 'T') state = State.F;
                else if (ch == 'E') state = State.Q2;
                else state = State.S;
                break;

            case F:
                state = State.F;
                break;
        }
    }

    public State run(String input) {
        for (char ch : input.toCharArray()) {
            step(ch);
        }
        return state;
    }
}
