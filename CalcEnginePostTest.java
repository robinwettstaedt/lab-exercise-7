import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalcEnginePostTest {
    CalcEnginePost tester;

    @Before
    public void setup(){
        tester = new CalcEnginePost();
    }

    @Test
    public void evaluateTest1() {
    String pfx = "1 2 * 3 +";
    assertEquals(5, tester.evaluate(pfx));
    }

    @Test
    public void evaluateTest2() {
        String pfx = "1 2 2 3 5 * + * 2 * + 3 -";
        assertEquals(66, tester.evaluate(pfx));
    }

    @Test
    public void evaluateTest3() {
        String pfx = "3 5 3 3 * * +";
        assertEquals(48, tester.evaluate(pfx));
    }

    @Test
    public void evaluateTest4() {
        String pfx = "4 6 4 5 + * + 3 5 * -";
        assertEquals(43, tester.evaluate(pfx));
    }

    @Test
    public void evaluateTest5() {
        String pfx = "3 -3 5 - * 4 -3 * +";
        assertEquals(-36, tester.evaluate(pfx));
    }
    @Test
    public void infixToPostfixTest1(){
        String ifx = "3 + 3 * ( 4 - 5 * 6 )";
        assertEquals("3 3 4 5 6 * - * +", tester.infixToPostfix(ifx));
    }

    @Test
    public void infixToPostfixTest2(){
        String ifx = "3 + 6 * ( 3 - 2 * 6 + 5 )";
        assertEquals("3 6 3 2 6 * - 5 + * +", tester.infixToPostfix(ifx));
    }

    @Test
    public void infixToPostfixTest3(){
        String ifx = "9 * 13 - ( 3 * 3 + 2 * 3 )";
        assertEquals("9 13 * 3 3 * 2 3 * + -", tester.infixToPostfix(ifx));
    }

    @Test
    public void infixToPostfixTest4(){
        String ifx = "12 * 45 - 2 + ( 3 + 2 * 3 ) - 3 * 5";
        assertEquals("12 45 * 2 - 3 2 3 * + + 3 5 * -", tester.infixToPostfix(ifx));
    }

    @Test
    public void infixToPostfixTest5(){
        String ifx = "( 3 - 4 * 5 * 6 + 3 ) + 3 * 2 - 4 - 5";
        assertEquals("3 4 5 * 6 * - 3 + 3 2 * + 4 - 5 -", tester.infixToPostfix(ifx));
    }

}